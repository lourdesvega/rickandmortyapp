package lourdes.vega.rickandmorty.usecase

import lourdes.vega.rickandmorty.model.Character

class GetListCharacters {
    operator fun invoke(firstList: List<Character>, secondList: List<Character>) =
        (firstList + secondList).distinctBy { it.id }.sortedBy { it.id }
}