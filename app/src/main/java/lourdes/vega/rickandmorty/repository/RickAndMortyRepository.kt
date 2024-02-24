package lourdes.vega.rickandmorty.repository

import lourdes.vega.rickandmorty.model.Characters
import lourdes.vega.rickandmorty.network.ApiService
import javax.inject.Inject

class RickAndMortyRepository @Inject constructor(
    private val apiService: ApiService
){

    suspend fun getCharacters(page: String) : Result<Characters> = try {
        val getCharacters = apiService.getCharacters(page)
        Result.success(getCharacters)
    }catch (e: Exception){
        e.printStackTrace()
        Result.failure(e)
    }
}