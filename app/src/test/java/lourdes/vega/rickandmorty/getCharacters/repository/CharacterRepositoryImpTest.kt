package lourdes.vega.rickandmorty.getCharacters.repository

import kotlinx.coroutines.runBlocking
import lourdes.vega.rickandmorty.getCharacters.remote.invalidCharacterResponse
import lourdes.vega.rickandmorty.getCharacters.remote.validCharacterResponse
import lourdes.vega.rickandmorty.network.ApiService
import lourdes.vega.rickandmorty.network.repository.RickAndMortyRepositoryImp
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import com.google.common.truth.Truth.assertThat


class CharacterRepositoryImpTest {

    private lateinit var repositoryImp: RickAndMortyRepositoryImp
    private lateinit var mockWebServer : MockWebServer
    private lateinit var okHttpClient: OkHttpClient
    private lateinit var api: ApiService

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        okHttpClient = OkHttpClient.Builder()
            .writeTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .connectTimeout(1, TimeUnit.SECONDS)
            .build()
        api = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(mockWebServer.url("/"))
            .build()
            .create(ApiService::class.java)

        repositoryImp = RickAndMortyRepositoryImp(
            api
        )
    }

    @After
    fun tearDown(){
        mockWebServer.shutdown()
    }

    @Test
    fun `Search characters, valid json response, returns results`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(validCharacterResponse)
        )
        val result = repositoryImp.getCharacters("character/?page=20")

        assertThat(result.isSuccess).isTrue()
    }

    @Test
    fun `Search characters, invalid json response, returns failure`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(403)
                .setBody(validCharacterResponse)
        )
        val result = repositoryImp.getCharacters("character/?page=20")

        assertThat(result.isFailure).isTrue()
    }

    @Test
    fun `Search characters, malformed json response, returns failure`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setBody(invalidCharacterResponse)
        )
        val result = repositoryImp.getCharacters("character/?page=20")

        assertThat(result.isFailure).isTrue()
    }


}