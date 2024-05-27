package main.route

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import bible_app_manual.composeapp.generated.resources.*
import bible_app_manual.composeapp.generated.resources.Res
import bible_app_manual.composeapp.generated.resources.etc0
import bible_app_manual.composeapp.generated.resources.setting0
import bible_app_manual.composeapp.generated.resources.setting1
import org.jetbrains.compose.resources.painterResource

@Composable
fun BasicSettingView() {
    val images = listOf(
        Res.drawable.setting0,
        Res.drawable.setting1,
    )
    ImageRows(images)
}