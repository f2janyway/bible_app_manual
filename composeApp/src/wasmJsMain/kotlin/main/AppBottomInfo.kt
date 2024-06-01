package main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp

// FIXME: error if put just column at item of lazycolum so wrap as row 
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AppBottomInfo() {
    val uriHandler = LocalUriHandler.current
    Row {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text("개역한글 O / 개역개정 X")

            TextRound("개인정보처리방침", onClick = {
                uriHandler.openUri("https://github.com/f2janyway/privacy_policy_relate/blob/main/privacy_policy/bible.md")
            })
            TextRound("플레이스토어", onClick = {
                uriHandler.openUri("https://play.google.com/store/apps/details?id=com.box.bible")
            })
            TextRound("Korean Bible Society 1961", onClick = {
                uriHandler.openUri("https://www.bskorea.or.kr/")
            })
//
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun TextRound(text:String,onClick: () -> Unit,modifier: Modifier = Modifier) {
    Surface(shape = CircleShape, border = BorderStroke(1.dp, Color.Gray), onClick = {
        onClick.invoke()
    }) {
        Text(text, modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
    }

}

//TODO error when using on deploy Surface(onClick = ){}
@Composable
fun CircleBox(
    border: BorderStroke = BorderStroke(1.dp, Color.Gray),
    onClick: () -> Unit,
    contents: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.clip(CircleShape).border(border).clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        contents()
    }
}