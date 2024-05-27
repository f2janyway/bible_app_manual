package main.route

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun RowImages(list: List<DrawableResource>, modifier: Modifier = Modifier) {
    val state = rememberLazyListState()
    val count = state.layoutInfo.totalItemsCount
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp), state = state) {
        itemsIndexed(list) { idx, item ->
            Box {
                Image(
                    painter = painterResource(item),
                    contentDescription = null,
                    modifier = Modifier.height(heightImage)
                )
                Text("${idx + 1}/$count", modifier = modifier.align(Alignment.TopCenter).padding(top = 16.dp))
            }
        }

    }
}