package lourdes.vega.rickandmorty.usecase

data class CharacterUseCases(
    val getCharacters: GetCharacters,
    val getListCharacters: GetListCharacters,
    val getPagination: GetPagination
)