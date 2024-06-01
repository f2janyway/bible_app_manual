package main.route

import androidx.compose.runtime.Composable
import bible_app_manual.composeapp.generated.resources.Res
import bible_app_manual.composeapp.generated.resources.search0
import bible_app_manual.composeapp.generated.resources.search2
import bible_app_manual.composeapp.generated.resources.search3

@Composable
fun SearchView() {
    val images = listOf(
        Res.drawable.search0,
        Res.drawable.search2,
        Res.drawable.search3,
    )
    RowImages(images)
}