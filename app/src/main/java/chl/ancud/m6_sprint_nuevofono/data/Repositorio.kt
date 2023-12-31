package chl.ancud.m6_sprint_nuevofono.data

import android.util.Log
import androidx.lifecycle.LiveData
import chl.ancud.m6_sprint_nuevofono.data.local.TelefonoDao
import chl.ancud.m6_sprint_nuevofono.data.local.TelefonoDetalleEntity
import chl.ancud.m6_sprint_nuevofono.data.local.TelefonoListadoEntity
import chl.ancud.m6_sprint_nuevofono.data.remote.TelefonoAPI
import chl.ancud.m6_sprint_nuevofono.data.remote.TelefonoDetalle
import chl.ancud.m6_sprint_nuevofono.data.remote.TelefonoListado
import retrofit2.Response

class Repositorio(private val telefonoAPI: TelefonoAPI, private val telefonoDao: TelefonoDao) {

    fun obtenerTelefonosLiveData(): LiveData<List<TelefonoListadoEntity>> = telefonoDao.getTelefonos()

    fun obtenerTelefonoLiveData(id: Long): LiveData<TelefonoDetalleEntity> = telefonoDao.getTelefonoDetalle(id)


    suspend fun getTelefonos() {
        val response: Response<List<TelefonoListado>> = telefonoAPI.getData()
        if (response.isSuccessful) {
            val resp: List<TelefonoListado>? = response.body()
            resp?.let {
                val telefonoListadoEntity = it.map {
                    it.transformar()
                }
                telefonoDao.insertTelefonos(telefonoListadoEntity)
            }
        }
    }

    suspend fun getTelefonoDetalle(id: Long) {
        try {
            Log.d("repo34", "Llega $id")
            val response = telefonoAPI.getTelefonoDetalle(id.toString()) /// Última línea que ejecuta
            Log.d("repo36", response.isSuccessful.toString())
            if (response.isSuccessful) {
                val resp = response.body()
                Log.d("repo39", resp.toString())
                resp?.let {
                    val telefonoDetalleEntity = it.transformar()
                    telefonoDao.insertTelefonoDetalle(telefonoDetalleEntity)
                }
            }

        }catch (e: Exception) {
            Log.e("repo try", e.toString())
        }
    }
}


/*fun TelefonoListado.transformar(): TelefonoListadoEntity = TelefonoListadoEntity(
    this.id,
    this.name,
    this.price,
    this.image
)*/

/*
fun TelefonoDetalle.transformar(): TelefonoDetalleEntity = TelefonoDetalleEntity(
    this.id,
    this.name,
    this.price,
    this.image,
    this.description,
    this.lastPrice,
    this.credit
)*/
