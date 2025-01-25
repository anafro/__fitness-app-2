package ru.anafro.fitnessapp.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Header
import ru.anafro.fitnessapp.models.User

interface ApiService {

    @POST("api/auth/register")
    suspend fun register(@Body user: User): Response<AuthResponse>

    @POST("api/auth/login")
    suspend fun login(@Body user: User): Response<AuthResponse>

    @POST("api/auth/logout")
    suspend fun logout(@Header("Authorization") authHeader: String): Response<Unit>

    @GET("api/auth/profile")
    suspend fun getProfile(@Header("Authorization") authHeader: String): Response<User>
}

data class AuthResponse(
    val token: String
)
