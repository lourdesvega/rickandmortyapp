package lourdes.vega.rickandmorty.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import lourdes.vega.rickandmorty.repository.RickAndMortyRepository
import lourdes.vega.rickandmorty.usecase.CharacterUseCases
import lourdes.vega.rickandmorty.usecase.GetCharacters
import lourdes.vega.rickandmorty.usecase.GetPagination

@Module
@InstallIn(ViewModelComponent::class)
object CharactersDomain {
    @ViewModelScoped
    @Provides
    fun provideCharacterUseCases(
        repository: RickAndMortyRepository
    ) =
        CharacterUseCases(
            getCharacters = GetCharacters(repository),
            getPagination = GetPagination()
        )
}