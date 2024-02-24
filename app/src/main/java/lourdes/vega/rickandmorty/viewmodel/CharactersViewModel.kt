package lourdes.vega.rickandmorty.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import lourdes.vega.rickandmorty.usecase.CharacterUseCases
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import lourdes.vega.rickandmorty.model.Character
import lourdes.vega.rickandmorty.view.characters.SearchEvent
import lourdes.vega.rickandmorty.view.characters.SearchState

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val characterUseCases: CharacterUseCases
):ViewModel(){

    var state by mutableStateOf(SearchState())
        private set
    var character : Character ? = null
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
            characterUseCases
                .getCharacters(
                    "character/${
                        characterUseCases.getPagination(
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