package main.route

import androidx.compose.runtime.Composable
import bible_app_manual.composeapp.generated.resources.Res
import bible_app_manual.composeapp.generated.resources.setting0
import bible_app_manual.composeapp.generated.resources.setting1

@Composable
fun BasicSettingView() {
    val images = listOf(
        Res.drawable.setting0,
        Res.drawable.setting1,
    )
    RowImages(images)
}