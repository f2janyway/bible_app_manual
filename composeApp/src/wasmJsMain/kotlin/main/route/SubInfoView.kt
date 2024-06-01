package main.route

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextGeometricTransform
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import main.route.FontType.*

@Composable
fun SubInfoView() {

    val text = annotatedStringExplainSubInfoBottom(Color.Black)
    Text(text, modifier = Modifier.padding(horizontal = 16.dp))
}

private val textGeometricTransform = TextGeometricTransform(skewX = -1.0f)
private val offsetOrigin = Offset(.3f, .3f)
private val offsetName = Offset(1f, 1f)
private enum class FontType {
    ORIGIN,NAME,AREA
}
private fun AnnotatedString.Builder.withStyleType(text:String, type: FontType){
    when(type){
        ORIGIN -> {
            withStyle(spanStyleOrigin()){
                append(text)
            }
        }
        NAME -> withStyle(
            spanStyleName()
        ){
            append(text)
        }
        AREA -> withStyle(spanStyleArea()){
            append(text)
        }
    }
}
private fun spanStyleOrigin() = SpanStyle(
    shadow = Shadow(
        color = Color.Black,
        offset = offsetOrigin
    ),
    textGeometricTransform = textGeometricTransform,
    fontStyle = FontStyle.Italic
)

private fun spanStyleName() = SpanStyle(
    shadow = Shadow(
        color = Color.Black,
        offset = offsetName
    )
)

private fun spanStyleArea() = SpanStyle(
    fontStyle = FontStyle.Italic
)


private fun annotatedStringExplainSubInfoBottom(textColor: Color?): AnnotatedString = buildAnnotatedString {

    fun etc(value: String? = null) {
        append(" 등")
        value?.let {
            append("; $value")
        }
        appendLine()
        appendLine()
    }

    fun comma() = append(",")

    append("* 설정 창에서 해당 기능 (적용, 미적용) 선택할 수 있습니다.")
    appendLine()
    appendLine()
    //지명
    append("지역:")
    withStyleType("에덴", type = AREA)
    comma()
    withStyleType("예루살렘", type = AREA)

    etc("기울임")

    //인명
    append("인명:")
    withStyleType("아브라함",NAME)
    comma()
    withStyleType("다윗",NAME)
    etc("굵음1")

    //origin (영어 원문
    append("기타 원어 단어:")
    withStyleType("바알",ORIGIN)
    comma()
    withStyleType("세겔",ORIGIN)
    comma()
    withStyleType("우림",ORIGIN)
    etc("굵음0.5+기울임")

    //comment
    withStyle(
        SpanStyle(
            textDecoration = TextDecoration.Underline
        )
    ) {
        append("밑줄은 ")
    }
    append("클릭 가능한 부분;\n기타정보 또는 연관 장 이동")

    appendLine()


//    appendLine("위의 항목이 중복될수 있습니다")
}

