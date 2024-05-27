package main.route

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import bible_app_manual.composeapp.generated.resources.Res
import bible_app_manual.composeapp.generated.resources.setting0
import bible_app_manual.composeapp.generated.resources.setting1
import org.jetbrains.compose.resources.painterResource

@Composable
fun BasicSettingView() {
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        BaseImage(painter = painterResource(Res.drawable.setting0), modifier = Modifier.weight(1f))
        BaseImage(painter = painterResource(Res.drawable.setting1), modifier = Modifier.weight(1f))
    }

}