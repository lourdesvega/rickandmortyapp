package lourdes.vega.rickandmorty.view.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import lourdes.vega.rickandmorty.domain.usecase.GetCharactersUseCase
import lourdes.vega.rickandmorty.network.model.Character
import lourdes.vega.rickandmorty.view.usecase.GetPaginationUseCase
import lourdes.vega.rickandmorty.view.ui.characters.SearchEvent
import lourdes.vega.rickandmorty.view.ui.characters.SearchState

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val getPaginationUseCase: GetPaginationUseCase
):ViewModel(){

    var state by mutableStateOf(SearchState())
        private set
    var character : Character? = null
        private set

    private val _uiEvent = Channel<String>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: SearchEvent){
        when(event){
            is SearchEvent.OnQueryChange -> {
                state = state.copy(query = event.query)
            }
            SearchEvent.OnSearch -> {
                getCharacters()
            }
            is SearchEvent.OnSearchFocusChange -> {}
            is SearchEvent.OnTrackCharacterClick -> {
                character = event.character
            }
            else -> {
                state = state.copy(
                    pagination = null,
                    characters = listOf()
                )
            }
        }
    }

    private fun getCharacters(){
        viewModelScope.launch {
            state = state.copy(
                isSearching = true
            )
            getCharactersUseCase(
                    "character/${
                        getPaginationUseCase(
                            query = state.query, 
                            page = state.pagination?.next
                        )
                    }"
                )
                .onSuccess { response ->
                    state = state.copy(
                        characters = state.characters + response.results,
                        pagination = response.info,
                        isSearching = false,
                        query = ""
                    )
                }
                .onFailure {
                    state = state.copy(isSearching = false)
                    _uiEvent.send("Something went wrong!")
                }

        }
    }

}