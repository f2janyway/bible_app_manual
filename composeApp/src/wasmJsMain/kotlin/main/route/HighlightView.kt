package main.route

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asComposeImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import bible_app_manual.composeapp.generated.resources.*
import bible_app_manual.composeapp.generated.resources.Res
import bible_app_manual.composeapp.generated.resources.h1
import bible_app_manual.composeapp.generated.resources.h6
import kotlinx.browser.document
import kotlinx.coroutines.await
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.getResourceUri
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.skia.Bitmap
import org.jetbrains.skia.Codec
import org.jetbrains.skia.Data
import org.khronos.webgl.ArrayBuffer
import org.khronos.webgl.Int8Array
import org.w3c.dom.Node
import org.w3c.dom.url.URL
import org.w3c.fetch.Response

@Composable
fun BaseImage(painter: Painter, modifier: Modifier = Modifier) {
    Surface(shape = RoundedCornerShape(20.dp)) {
        Image(painter = painter, modifier = modifier.height(100.dp), contentDescription = null)
    }
}

@OptIn(InternalResourceApi::class)
@Composable
fun HighlightView() {
    Column {
//        Image(painter = painterResource(Res.drawable.hl), contentDescription = null)
        val images = listOf(
            Res.drawable.h1,
            Res.drawable.h2,
            Res.drawable.h3,
            Res.drawable.h4,
            Res.drawable.h5,
            Res.drawable.h6,
        )
        var index by remember {
            mutableStateOf(0)
        }
        LaunchedEffect(Unit) {
            repeat(10000) {
                delay(2000)
                index += 1
            }
        }
        BaseImage(painter = painterResource(images[index % 6]))
        Text(
            buildAnnotatedString {
                append("1. 해당 절을 좌 or 우 로 드래그")
                appendLine()
                appendLine()
                append("1-1. 이전에 저장되어 있으면 삭제")
                appendLine()
                appendLine()
                append("1-2. 이전에 저장되어 있지않으면 하이라이트")
                appendLine()
                appendLine()
                append("2. 앱 시작화면 \"하이라이트\"탭에서 시간순으로 저장")
            }
        )
    }
//    val codec = remember {
//            Codec.makeFromData(Data.makeFromBytes(bytes))
//    }
//    GifAnimation(codec, Modifier.size(100.dp))
    val bytes = remember {
        mutableStateOf<ByteArray?>(null)
    }
//    LaunchedEffect(Unit) {
//    }
    bytes.value?.let {
        Codec.makeFromData(Data.makeFromBytes(it))
    }
}


@Composable
fun GifAnimation(codec: Codec, modifier: Modifier) {
    val transition = rememberInfiniteTransition()
    val frameIndex by transition.animateValue(
        initialValue = 0,
        targetValue = codec.frameCount - 1,
        Int.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 0
                for ((index, frame) in codec.framesInfo.withIndex()) {
                    index at durationMillis
                    durationMillis += frame.duration
                }
            }
        )
    )

    val bitmap = remember { Bitmap().apply { allocPixels(codec.imageInfo) } }
    Canvas(modifier) {
        codec.readPixels(bitmap, frameIndex)
        drawImage(bitmap.asComposeImageBitmap())
    }
}