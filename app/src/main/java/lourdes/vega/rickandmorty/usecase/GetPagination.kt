package lourdes.vega.rickandmorty.usecase

class GetPagination {
    companion object {
        const val ROUTE_CHARACTER = "https://rickandmortyapi.com/api/character"
    }

    operator fun invoke(query: String, page: String?) : String {
        return if(query.isEmpty() && page.isNullOrEmpty() ||
            (page?.isNotEmpty() == true && !page.contains(ROUTE_CHARACTER))) ""
        else if (page?.isNotEmpty() == true) page.substringAfter(ROUTE_CHARACTER)
        else  "/?name=${query}"
    }

}