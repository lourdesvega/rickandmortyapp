package lourdes.vega.rickandmorty.view.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import lourdes.vega.rickandmorty.R
import lourdes.vega.rickandmorty.view.DescriptionComponent
import lourdes.vega.rickandmorty.view.SubtitleComponent
import lourdes.vega.rickandmorty.view.TitleComponent
import lourdes.vega.rickandmorty.viewmodel.CharactersViewModel

@Composable
fun CharacterScreen(
    viewModel: CharactersViewModel
) {
    val character = remember {
        viewModel.character
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TitleComponent(modifier = Modifier.align(Alignment.CenterHorizontally),
            text = character?.name ?: ""
        )

        Spacer(modifier = Modifier.padding(top = 24.dp))




        AsyncImage(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clip(RoundedCornerShape(24.dp))
                .aspectRatio(1f / 0.5f),
            model = character?.image ?: "",
            contentDescription = "Character description"
        )

        Spacer(modifier = Modifier.padding(top = 24.dp))

        ElevatedCard(
            modifier = Modifier
                .background(Color.White)
                .padding(horizontal = 12.dp)
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            )
        ) {
            Row(
                modifier = Modifier.padding(top = 12.dp, start = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DescriptionComponent(
                    modifier = Modifier
                        .weight(1f),
                    first = stringResource(id = R.string.status),
                    second = character?.status ?: "",
                )

                DescriptionComponent(
                    modifier = Modifier
                        .weight(1f),
                    first = stringResource(id = R.string.species),
                    second = character?.species ?: "",
                )
            }

            Row(
                modifier = Modifier.padding(top = 12.dp, start = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DescriptionComponent(
                    modifier = Modifier
                        .weight(1f),
                    first = stringResource(id = R.string.type),
                    second = character?.type ?: "",
                )

                DescriptionComponent(
                    modifier = Modifier
                        .weight(1f),
                    first = stringResource(id = R.string.gender),
                    second = character?.gender ?: "",
                )
            }

            SubtitleComponent(
                modifier = Modifier.padding(top = 24.dp, start = 6.dp),
                text = stringResource(
                    id = R.string.origin_title
                )
            )

            DescriptionComponent(
                modifier = Modifier.padding(top = 6.dp, start = 6.dp),
                first = stringResource(id = R.string.name),
                second = character?.origin?.name ?: "",
            )

            SubtitleComponent(
                modifier = Modifier.padding(top = 24.dp, start = 6.dp),
                text = stringResource(
                    id = R.string.location_title
                )
            )

            DescriptionComponent(
                modifier = Modifier.padding(top = 6.dp, start = 6.dp),
                first = stringResource(id = R.string.name),
                second = character?.location?.name ?: "",
            )

            DescriptionComponent(
                modifier = Modifier
                    .padding(top = 36.dp, end = 6.dp)
                    .align(Alignment.End),
                first = stringResource(id = R.string.created),
                second = character?.created ?: "",
            )

        }

    }
}
