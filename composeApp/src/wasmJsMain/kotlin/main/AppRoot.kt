package main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import main.route.*

@Composable
fun AppRoot(
    tabList: List<TabRoutEnum>,
    selectedTabEnum: TabRoutEnum,
    onClickTab: (index: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(verticalArrangement = Arrangement.Center) {
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
            Divider(color = Color.LightGray)
            Spacer(modifier = modifier.height(8.dp))
            AppBottomInfo()
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
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
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
        TabRoutEnum.SEARCH -> SearchView()
        TabRoutEnum.ETC -> EtcView()
        TabRoutEnum.Tab -> TabView()
    }
}

