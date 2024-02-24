package lourdes.vega.rickandmorty.usecase

import lourdes.vega.rickandmorty.model.Characters
import lourdes.vega.rickandmorty.repository.RickAndMortyRepository

class GetCharacters (
    private val rickAndMortyRepository: RickAndMortyRepository
    ){

    suspend operator fun invoke(page: String) : Result<Characters> = rickAndMortyRepository.getCharacters(page)

}