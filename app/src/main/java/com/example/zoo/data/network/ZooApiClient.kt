package com.example.zoo.data.network

import com.example.zoo.data.model.AnimalTypeModel
import com.example.zoo.data.model.SpecieTypeModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Call

interface ZooApiClient {
    @GET("especie")
    suspend fun getAllSpecie(): Response<List<SpecieTypeModel>>
    
    @GET("especie/tipo")
    suspend fun getAnimalBySpecie(@Query("tipo") tipo: String): Response<List<AnimalTypeModel>>

    @POST ("comentario")
    fun enviarComentario(@Body enviarComentarioDto:EnviaComentarioDto):Call<RespuestaComentario>
    @POST ("calificacion")
    fun enviarCalificacion(@Body enviarCalificacionDto:EnviaCalificacionDto):Call<RespuestaCalificacion>
}
data class EnviaComentarioDto(val content: String)
data class RespuestaComentario(val respuesta: String)
data class EnviaCalificacionDto(val calificacion: Float)
data class RespuestaCalificacion(val respuesta: String)