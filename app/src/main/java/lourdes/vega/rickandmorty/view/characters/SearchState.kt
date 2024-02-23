package lourdes.vega.rickandmorty.view.characters

import lourdes.vega.rickandmorty.model.Character
import lourdes.vega.rickandmorty.model.Info

data class SearchState(
    val query: String = "",
    val isHintVisible: Boolean = false,
    val isSearching: Boolean = false,
    val characters: List<Character> = listOf(),
    val pagination: Info? = null

)
