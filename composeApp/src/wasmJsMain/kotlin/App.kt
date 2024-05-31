import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import bible_app_manual.composeapp.generated.resources.Res
import bible_app_manual.composeapp.generated.resources.notosans_kr_m

import main.AppRoot
import main.TabRoutEnum

@Composable
fun App() {

    MaterialTheme {
        val tabList by remember {
            mutableStateOf(
                listOf(
                    (TabRoutEnum.SUB_INFO),
                    (TabRoutEnum.Tab),
//                    (TabRoutEnum.BOOKMARK),
                    (TabRoutEnum.HIGHLIGHT),
                    (TabRoutEnum.BASIC_SETTING),
                    TabRoutEnum.SEARCH,
                    TabRoutEnum.ETC,

                    )
            )
        }
        var selectedTabEnum by remember {
            mutableStateOf(TabRoutEnum.SUB_INFO)
        }

        val font = org.jetbrains.compose.resources.Font(Res.font.notosans_kr_m)
        CompositionLocalProvider(LocalTextStyle provides LocalTextStyle.current.copy(fontFamily = FontFamily(font))) {
            AppRoot(tabList = tabList, selectedTabEnum = selectedTabEnum, onClickTab = { selectedIndex ->
                selectedTabEnum = tabList[selectedIndex]
            })
        }
    }
}

