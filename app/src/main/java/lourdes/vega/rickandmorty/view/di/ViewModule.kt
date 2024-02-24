package lourdes.vega.rickandmorty.view.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import lourdes.vega.rickandmorty.view.usecase.GetPaginationUseCase

@Module
@InstallIn(ViewModelComponent::class)
object ViewModule {
    @ViewModelScoped
    @Provides
    fun provideGetPaginationUseCase() = GetPaginationUseCase()
}