package lourdes.vega.rickandmorty.getPagination

import junit.framework.TestCase.assertEquals
import lourdes.vega.rickandmorty.usecase.GetPagination
import org.junit.Test

class GetPaginationTest {

    private val characterUseCases = GetPagination()

    @Test
    fun `when invoke pagination without query param and without page param return empty result`() {
        val query = ""
        val page = ""
        val result = characterUseCases.invoke(query, page)
        assertEquals(result, "")

    }


    @Test
    fun `when invoke pagination with query param and without page param return empty result`() {
        val query = "summer"
        val page = ""
        val result = characterUseCases.invoke(query, page)
        assertEquals(result, "/?name=summer")
    }


    @Test
    fun `when invoke pagination with query param and with page param return empty result`() {
        val query = "summer"
        val page = "https://rickandmortyapi.com/api/character/?page=20"
        val result = characterUseCases.invoke(query, page)
        assertEquals(result, "/?page=20")
    }


    @Test
    fun `when invoke pagination without query param and with page param return empty result`() {
        val query = ""
        val page = "https://rickandmortyapi.com/api/character/?page=20"
        val result = characterUseCases.invoke(query, page)
        assertEquals(result, "/?page=20")
    }

    @Test
    fun `when invoke pagination without query param and with page param wrong return empty result`() {
        val query = ""
        val page = "https://rickandmortyapi.com/apjjhi/character/?page=20"
        val result = characterUseCases.invoke(query, page)
        assertEquals(result, "")
    }

}