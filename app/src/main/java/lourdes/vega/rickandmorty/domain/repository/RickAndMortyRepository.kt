package lourdes.vega.rickandmorty.domain.repository

import lourdes.vega.rickandmorty.network.model.Characters

interface RickAndMortyRepository {
    suspend fun getCharacters(page: String) : Result<Characters>
}