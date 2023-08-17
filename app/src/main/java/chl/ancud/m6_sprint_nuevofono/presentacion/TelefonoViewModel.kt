package chl.ancud.m6_sprint_nuevofono.presentacion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import chl.ancud.m6_sprint_nuevofono.data.Repositorio
import chl.ancud.m6_sprint_nuevofono.data.local.TelefonoDatabase
import chl.ancud.m6_sprint_nuevofono.data.remote.TelefonoRetrofit
import kotlinx.coroutines.launch

class TelefonoViewModel(application: Application): AndroidViewModel(application) {
    private val repositorio: Repositorio

    init {
        val api = TelefonoRetrofit.getRetrofitTelefono()
        val telefonoDatabase = TelefonoDatabase.getDatabase(application).getITelefonoDao()
        repositorio = Repositorio(api, telefonoDatabase)
    }

    fun getAllTelefonos() = viewModelScope.launch {
        repositorio.getTelefonos()
    }

    fun telefonosLiveData() = repositorio.obtenerTelefonosLiveData()

}