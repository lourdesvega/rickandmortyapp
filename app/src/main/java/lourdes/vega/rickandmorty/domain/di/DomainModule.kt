package lourdes.vega.rickandmorty.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import lourdes.vega.rickandmorty.domain.repository.RickAndMortyRepository
import lourdes.vega.rickandmorty.domain.usecase.GetCharactersUseCase

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @ViewModelScoped
    @Provides
    fun provideCharacterUseCases(
        repository: RickAndMortyRepository
    ) =
        GetCharactersUseCase(
            rickAndMortyRepository = repository,
        )
}