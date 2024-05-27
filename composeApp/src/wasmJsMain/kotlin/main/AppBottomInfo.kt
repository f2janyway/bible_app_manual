package main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AppBottomInfo() {
    val uriHandler = LocalUriHandler.current
    Column(
        modifier = Modifier.padding(top = 120.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("개역한글 O / 개역개정 X")


        Surface(shape = CircleShape, border = BorderStroke(1.dp, Color.Gray), onClick = {
            uriHandler.openUri("https://github.com/f2janyway/privacy_policy_relate/blob/main/privacy_policy/bible.md")
        }) {
//            Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
                Text("개인정보처리방침",modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
//            }
        }

        Surface(shape = CircleShape, border = BorderStroke(1.dp, Color.Gray), onClick = {
            uriHandler.openUri("https://www.bskorea.or.kr/")
        }) {
//            Box(contentAlignment = Alignment.Center, ) {
                Text("Korean Bible Society 1961",modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
//            }
        }
    }

}