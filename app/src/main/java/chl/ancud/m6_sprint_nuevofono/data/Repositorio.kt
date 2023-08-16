package chl.ancud.m6_sprint_nuevofono.data

import androidx.lifecycle.LiveData
import chl.ancud.m6_sprint_nuevofono.data.local.TelefonoDao
import chl.ancud.m6_sprint_nuevofono.data.local.TelefonoListadoEntity
import chl.ancud.m6_sprint_nuevofono.data.remote.TelefonoAPI
import chl.ancud.m6_sprint_nuevofono.data.remote.TelefonoListado
import retrofit2.Response

class Repositorio(private val telefonoAPI: TelefonoAPI, private val telefonoDao: TelefonoDao) {

    fun obtenerTelefonos(): LiveData<List<TelefonoListadoEntity>> = telefonoDao.getTelefonos()


    suspend fun getTelefonos() {
        val response: Response<List<TelefonoListado>> = telefonoAPI.getData()
        if (response.isSuccessful) {
            val resp: List<TelefonoListado>? = response.body()
            resp?.let {
                val telefonoListadoEntity = it.map {
                    it.transformar()
                }
                telefonoDao.insertTelefono(telefonoListadoEntity)
            }
        }
    }
}


fun TelefonoListado.transformar(): TelefonoListadoEntity = TelefonoListadoEntity(
    this.id,
    this.name,
    this.price,
    this.image
)