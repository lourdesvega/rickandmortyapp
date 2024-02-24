package lourdes.vega.rickandmorty.view.ui.characters

import lourdes.vega.rickandmorty.network.model.Character
import lourdes.vega.rickandmorty.network.model.Info

data class SearchState(
    val query: String = "",
    val isHintVisible: Boolean = false,
    val isSearching: Boolean = false,
    val characters: List<Character> = listOf(),
    val pagination: Info? = null

)
