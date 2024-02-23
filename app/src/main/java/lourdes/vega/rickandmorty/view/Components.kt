package lourdes.vega.rickandmorty.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DescriptionComponent(first: String = "", second: String = "", modifier: Modifier){
    Row(modifier =  modifier) {
        Text(
            text = first,
            color = Color.Gray,
            fontWeight = FontWeight.Bold,
            style = TextStyle(fontSize = 14.sp)
        )
        Text(
            text = second,
            color = Color.Gray,
            style = TextStyle(fontSize = 14.sp)
        )
    }
}

@Composable
fun TitleComponent(text : String = "", modifier: Modifier){
    Text(
        modifier = modifier
            .padding(top = 16.dp),
        color = Color.Gray,
        text = text,
        style = MaterialTheme.typography.titleLarge
    )
}

@Composable
fun SubtitleComponent(text: String = "", modifier: Modifier){
    Text(
        modifier = modifier,
        text = text,
        color = Color.Gray
    )
}

