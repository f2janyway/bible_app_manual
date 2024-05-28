package main.route

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun RowImages(list: List<DrawableResource>, modifier: Modifier = Modifier) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp), ) {
        itemsIndexed(list) { idx, item ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("${idx + 1}/${list.count()}", modifier = modifier.padding(top = 16.dp))
                Image(
                    painter = painterResource(item),
//                    imageVector = Icons.Default.Done,
                    contentDescription = null,
                    modifier = Modifier.width(heightImage /2.3f).height(heightImage)
                )
            }
        }

    }
}