package main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.UrlAnnotation
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import main.route.BasicSettingView
import main.route.HighlightView
import main.route.SubInfoView

@Composable
fun AppRoot(
    tabList: List<TabRoutEnum>,
    selectedTabEnum: TabRoutEnum,
    onClickTab: (index: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn() {
        item {

            FlowTabLayout(tabList = tabList, selectedTabEnum = selectedTabEnum, onClickTab)
            Spacer(modifier = modifier.height(8.dp))
            Divider(color = Color.LightGray)
            Spacer(modifier = modifier.height(8.dp))
        }
        item {
            selectedTabEnum.MakeView()
        }

        item {
            AppBottomInfo()
        }
    }
}

@Composable
fun AppBottomInfo() {
    val uriHandler = LocalUriHandler.current
    Column(modifier = Modifier.padding(top = 120.dp)) {
        Surface(shape = CircleShape, border = BorderStroke(1.dp, Color.Gray), modifier = Modifier.clickable {
            uriHandler.openUri("https://www.bskorea.or.kr/")
        }) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(16.dp)) {
                Text("Korean Bible Society 1961")
            }
        }
    }

}
//@OptIn(ExperimentalTextApi::class)
//fun sourceLink():AnnotatedString = buildAnnotatedString {
//    val text =
//    append(text)
//    addUrlAnnotation(UrlAnnotation(),0,text.length)
//}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowTabLayout(
    tabList: List<TabRoutEnum>,
    selectedTabEnum: TabRoutEnum,
    onClickTab: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        tabList.forEachIndexed { idx, tab ->
            Tab(item = tab, selected = selectedTabEnum == tab, onClick = { onClickTab(idx) })
        }
    }
}

@Composable
fun TabRoutEnum.MakeView() {
    when (this) {
        TabRoutEnum.SUB_INFO -> SubInfoView()
//        TabRoutEnum.BOOKMARK -> BookMarkView()
        TabRoutEnum.HIGHLIGHT -> HighlightView()
        TabRoutEnum.BASIC_SETTING -> BasicSettingView()
    }
}

