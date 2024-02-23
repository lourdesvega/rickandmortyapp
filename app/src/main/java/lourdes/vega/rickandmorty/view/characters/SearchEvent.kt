package lourdes.vega.rickandmorty.view.characters

import lourdes.vega.rickandmorty.model.Character


sealed class SearchEvent {
    data class OnQueryChange(val query: String): SearchEvent()
    object OnSearch: SearchEvent()
    object CleanEvent : SearchEvent()
    data class OnTrackCharacterClick(
        val character: Character,
    ): SearchEvent()
    data class OnSearchFocusChange(val isFocused: Boolean): SearchEvent()
}
