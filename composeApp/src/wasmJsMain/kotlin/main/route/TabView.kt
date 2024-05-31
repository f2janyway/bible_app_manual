package main.route

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp

@Composable
fun TabView() {
    val text = buildAnnotatedString {
        appendLine("버전 4.24.0531.122(24/05/31) 이후 추가")
        appendLine()
        appendLine()
        appendLine("브라우저의 탭과 비슷한 기능")
        appendLine()
        appendLine("탭 클릭 > 해당 화면(장) 저장")
        appendLine("탭화면에서 다른 탭(장) 누르면 이동")
        appendLine("x 누르면 삭제")
        appendLine("화면 닫기: 스마트폰 뒤로 가기 or (<- 클릭)")
        appendLine()
        appendLine("우선 20개로 제한")
    }

    Text(
        text,
        modifier = Modifier.padding(start = 16.dp)
    )
}