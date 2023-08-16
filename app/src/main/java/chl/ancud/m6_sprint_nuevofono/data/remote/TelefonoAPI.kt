package chl.ancud.m6_sprint_nuevofono.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface TelefonoAPI {

    @GET("products")
    suspend fun getData(): Response<List<TelefonoListado>>
}