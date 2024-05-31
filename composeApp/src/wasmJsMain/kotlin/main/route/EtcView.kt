package main.route

import androidx.compose.runtime.Composable
import bible_app_manual.composeapp.generated.resources.Res
import bible_app_manual.composeapp.generated.resources.*

@Composable
fun EtcView() {
    val images = listOf(
        Res.drawable.etc0,
        Res.drawable.etc1,
    )
    RowImages(images)
}


