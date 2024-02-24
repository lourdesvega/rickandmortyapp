package lourdes.vega.rickandmorty.network.repository

import lourdes.vega.rickandmorty.network.model.Characters
import lourdes.vega.rickandmorty.network.ApiService
import lourdes.vega.rickandmorty.domain.repository.RickAndMortyRepository

class RickAndMortyRepositoryImp constructor(
    private val apiService: ApiService
): RickAndMortyRepository {

    override suspend fun getCharacters(page: String) : Result<Characters> = try {
        val getCharacters = apiService.getCharacters(page)
        Result.success(getCharacters)
    }catch (e: Exception){
        e.printStackTrace()
        Result.failure(e)
    }
}