package lourdes.vega.rickandmorty.domain.usecase

import lourdes.vega.rickandmorty.domain.repository.RickAndMortyRepository
import lourdes.vega.rickandmorty.network.model.Characters


class GetCharactersUseCase (
    private val rickAndMortyRepository: RickAndMortyRepository
    ){

    suspend operator fun invoke(page: String) : Result<Characters> = rickAndMortyRepository.getCharacters(page)

}