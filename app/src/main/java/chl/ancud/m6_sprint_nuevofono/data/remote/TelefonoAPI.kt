package chl.ancud.m6_sprint_nuevofono.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TelefonoAPI {

    @GET("products")
    suspend fun getData(): Response<List<TelefonoListado>>

    @GET("details/{id}")
    suspend fun getTelefonoDetalle(@Path("id") id: String): Response<TelefonoDetalle>
}