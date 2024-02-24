package lourdes.vega.rickandmorty.view.ui


import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import lourdes.vega.rickandmorty.R
import lourdes.vega.rickandmorty.view.navigation.Route
import lourdes.vega.rickandmorty.view.DescriptionComponent
import lourdes.vega.rickandmorty.view.SubtitleComponent
import lourdes.vega.rickandmorty.view.TitleComponent
import lourdes.vega.rickandmorty.view.ui.characters.SearchEvent
import lourdes.vega.rickandmorty.view.ui.characters.SearchState
import lourdes.vega.rickandmorty.view.viewmodel.CharactersViewModel


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun CharactersScreen(
    navController: NavController,
    viewModel: CharactersViewModel
){
    val state : SearchState = viewModel.state
    val scrollState = rememberLazyListState()
    val endOfListReached by remember {
        derivedStateOf {
            scrollState.isScrollInProgress
        }
    }
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(key1 = keyboardController) {
        viewModel.uiEvent.collect { event ->
            Toast.makeText(context, event, Toast.LENGTH_LONG).show()
            keyboardController?.hide()
            }
        }


    LaunchedEffect(Unit) {
        if (state.characters.isEmpty()) {
            viewModel.onEvent(SearchEvent.OnSearch)
        }
    }

    // act when end of list reached
    LaunchedEffect(endOfListReached) {
        if (state.characters.isNotEmpty() && !state.pagination?.next.isNullOrEmpty() && (scrollState.firstVisibleItemIndex + scrollState.layoutInfo.visibleItemsInfo.size >= state.characters.size) ) {
            viewModel.onEvent(SearchEvent.OnSearch)
        }
    }


    Column(
        modifier = Modifier
        .fillMaxSize()
    ) {

        TitleComponent(modifier = Modifier.align(Alignment.CenterHorizontally),
            text = stringResource(id = R.string.app_name)
        )

        SearchField(state,viewModel, keyboardController)

        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxSize(),
            state = scrollState
        ){

            items(state.characters){ character ->
                Spacer(modifier = Modifier.padding(top = 12.dp))
                ElevatedCard(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxWidth(),
                    onClick = {
                        viewModel.onEvent(SearchEvent.OnTrackCharacterClick(character))
                        navController.navigate(Route.CHARACTER_DETAIL)
                    },
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White,
                    )
                ) {
                    Row {
                        AsyncImage(
                            modifier = Modifier
                                .size(90.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .padding(vertical = 6.dp)
                                .align(Alignment.CenterVertically),
                            model = character.image,
                            contentDescription = "Image",
                            contentScale = ContentScale.Fit
                        )
                        Column(
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            SubtitleComponent(
                                text = character.name,
                                modifier = Modifier
                                    .padding(top = 12.dp)
                            )

                            DescriptionComponent(
                                first = stringResource(id = R.string.species),
                                second = character.species,
                                modifier = Modifier.padding(top =6.dp)
                            )
                            DescriptionComponent(
                                first = stringResource(id = R.string.location),
                                second = character.location.name,
                                modifier = Modifier.padding(top =6.dp)
                            )

                        }
                    }
                }

            }
        }

    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when {
            state.isSearching -> CircularProgressIndicator()
            state.characters.isEmpty() -> {
                Text(
                    text = stringResource(id = R.string.no_results),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SearchField(
    state: SearchState,
    viewModel: CharactersViewModel,
    keyboardController: SoftwareKeyboardController?
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TextField(
            value = state.query,
            onValueChange = { viewModel.onEvent(SearchEvent.OnQueryChange(it))},
            modifier = Modifier.weight(1f),
            placeholder = { Text(text = "Search...") },
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    viewModel.onEvent(SearchEvent.CleanEvent)
                    viewModel.onEvent(SearchEvent.OnSearch)
                    keyboardController?.hide()
                    defaultKeyboardAction(ImeAction.Search)
                }
            ),

        )

        IconButton(
            onClick = {
                viewModel.onEvent(SearchEvent.CleanEvent)
                viewModel.onEvent(SearchEvent.OnSearch)
                keyboardController?.hide()
            }
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_search),
                contentDescription = "Search"
            )
        }
    }
}
