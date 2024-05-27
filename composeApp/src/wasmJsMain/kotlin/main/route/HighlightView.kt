package main.route

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asComposeImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.platform.LocalWindowInfo
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


val heightImage = 600.dp

@OptIn(InternalResourceApi::class, ExperimentalFoundationApi::class)
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
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(images) { item ->
                Image(
                    painter = painterResource(item),
                    contentDescription = null,
                    modifier = Modifier.height(heightImage)
                )
            }
        }
        Text(
            buildAnnotatedString {
                append("1. 해당 절을 좌 or 우 로 드래그")
                appendLine()
                append("1-1. 이전에 저장되어 있으면 삭제")
                appendLine()
                append("1-2. 이전에 저장되어 있지않으면 하이라이트")
                appendLine()
                appendLine()
                append("2. 앱 시작화면 \"하이라이트\"탭에서 시간순으로 저장")
                appendLine()
                append("2-1. \"하이라이트\"탭에서 해당장 클릭시 이동")
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