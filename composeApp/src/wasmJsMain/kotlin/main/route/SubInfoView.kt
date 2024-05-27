package main.route

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextGeometricTransform
import androidx.compose.ui.text.withStyle

@Composable
fun SubInfoView() {

    val text = annotatedStringExplainSubInfoBottom(Color.Black)
    Text(text)
}
private val textGeometricTransform = TextGeometricTransform(skewX = -0.1f)
private val offsetOrigin = Offset(.3f, .3f)
private val offsetName = Offset(1f, 1f)
fun annotatedStringExplainSubInfoBottom(textColor: Color?): AnnotatedString = buildAnnotatedString {

    fun etc(value: String? = null) {
        append(" 등")
        value?.let {
            append("; $value")
        }
        appendLine()
        appendLine()
    }

    fun comma() = append(",")
    append("특수 표기 정보")
    appendLine()
    appendLine()
    //지명
    append("지명:")
    withStyle(
        SpanStyle(
            textGeometricTransform = textGeometricTransform,
        )
    ) {
        append("에덴")
    }
    comma()
    withStyle(
        SpanStyle(
            textGeometricTransform = textGeometricTransform,
        )
    ) {
        append("예루살렘")
    }
    etc("기울임")

    //인명
    append("인명:")
    withStyle(
        SpanStyle(
            shadow = Shadow(
                color = textColor ?: Color.Black,
                offset = offsetName
            )
        )
    ) {
        append("아브라함")
    }
    comma()
    withStyle(
        SpanStyle(
            shadow = Shadow(
                color = textColor ?: Color.Black,
                offset = offsetName
            )
        )
    ) {
        append("다윗")
    }
    etc("굵음1")
    //origin (영어 원문
    append("기타 원어 단어:")
    withStyle(
        SpanStyle(
            shadow = Shadow(
                color = textColor ?: Color.Black,
                offset = offsetOrigin
            ),
            textGeometricTransform = textGeometricTransform
        )
    ) {
        append("바알")
    }
    comma()
    withStyle(
        SpanStyle(
            shadow = Shadow(
                color = textColor ?: Color.Black,
                offset = offsetOrigin
            ),
            textGeometricTransform = textGeometricTransform
        )
    ) {
        append("세겔")
    }

    comma()
    withStyle(
        SpanStyle(
            shadow = Shadow(
                color = textColor ?: Color.Black,
                offset = offsetOrigin
            ),
            textGeometricTransform = textGeometricTransform
        )
    ) {
        append("우림")
    }

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

