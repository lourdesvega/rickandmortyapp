package lourdes.vega.rickandmorty.network

import lourdes.vega.rickandmorty.model.Characters
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url


interface ApiService {
    @GET
    suspend fun getCharacters(@Url url: String? = "character/"): Characters

}