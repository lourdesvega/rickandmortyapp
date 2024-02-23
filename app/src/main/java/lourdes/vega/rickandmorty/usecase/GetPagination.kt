package lourdes.vega.rickandmorty.usecase

class GetPagination {
    operator fun invoke(query: String, page: String?) : String {
        return if(query.isEmpty() && page.isNullOrEmpty()) "character"
        else if (page?.isNotEmpty() == true) page.substringAfter("https://rickandmortyapi.com/api/")
        else  "character/?name=${query}"
    }

}