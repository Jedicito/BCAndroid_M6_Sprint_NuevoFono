package chl.ancud.m6_sprint_nuevofono.data

import chl.ancud.m6_sprint_nuevofono.data.local.TelefonoListadoEntity
import chl.ancud.m6_sprint_nuevofono.data.remote.TelefonoAPI
import chl.ancud.m6_sprint_nuevofono.data.remote.TelefonoListado
import retrofit2.Response

class Repositorio(private val telefonoAPI: TelefonoAPI) {

    suspend fun getTelefonos(): List<TelefonoListado> {
        val response: Response<List<TelefonoListado>> = telefonoAPI.getData()
        val resp: List<TelefonoListado>? = response.body()
        var retorno: List<TelefonoListado>
        if (resp.isNullOrEmpty()) {
            retorno = emptyList()
        } else {
          retorno = resp
        }
        return retorno
}

fun TelefonoListado.transformar(): TelefonoListadoEntity = TelefonoListadoEntity(
    this.id,
    this.name,
    this.price,
    this.image
)