package chl.ancud.m6_sprint_nuevofono.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TelefonoRetrofit {

    companion object {
        private const val URL_BASE = "https://my-json-server.typicode.com/Himuravidal/FakeAPIdata/"

        fun getRetrofitTelefono(): TelefonoAPI {
            val mRetrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return mRetrofit.create(TelefonoAPI::class.java)
        }
    }
}