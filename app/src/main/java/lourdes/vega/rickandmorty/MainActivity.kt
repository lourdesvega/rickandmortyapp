package lourdes.vega.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import lourdes.vega.rickandmorty.navigation.Route
import lourdes.vega.rickandmorty.ui.theme.RickAndMortyTheme
import lourdes.vega.rickandmorty.view.CharactersScreen
import lourdes.vega.rickandmorty.view.characters.CharacterScreen
import lourdes.vega.rickandmorty.viewmodel.CharactersViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: CharactersViewModel = hiltViewModel()
            RickAndMortyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    ScreenController(viewModel)
                }
            }
        }
    }
}


@Composable
fun ScreenController(viewModel: CharactersViewModel) {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController, 
        startDestination = Route.CHARACTERS_LIST
    ){
        composable( 
            route = Route.CHARACTERS_LIST
        ){
            CharactersScreen(navController, viewModel)
        }
        composable(
            route = Route.CHARACTER_DETAIL
        ){
            CharacterScreen(viewModel)
        }
    }
}


