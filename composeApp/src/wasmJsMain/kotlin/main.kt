import androidx.compose.foundation.layout.Box
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.delay
import kotlinx.dom.createElement
import org.w3c.dom.Element
import org.w3c.dom.ElementCreationOptions
import org.w3c.dom.Node
import org.w3c.dom.events.Event

fun printJs(msg:String): Unit = js("""{
    console.log(msg)
}""")

@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    ComposeViewport(document.body!!) {
        val showLoading = remember { mutableStateOf(true) }

        DisposableEffect(Unit) {

            val onLoadListener: (Event) -> Unit = {
                showLoading.value = false
                println("Page load complete")
            }
            val onDomContentLoadedListener: (Event) -> Unit = {
                showLoading.value = false
                println("DOM content loaded")
            }
            println("Page load started")

            window.addEventListener("load", onLoadListener)
            document.addEventListener("DOMContentLoaded", onDomContentLoadedListener)

            // Initial check in case the document is already loaded
            if (document.readyState.toString() == "complete" || document.readyState.toString() == "interactive") {
                showLoading.value = false
                println("Initial check: Page already loaded")
            }

            // Clean up the event listeners when the composable is disposed
            onDispose {
                window.removeEventListener("load", onLoadListener)
                document.removeEventListener("DOMContentLoaded", onDomContentLoadedListener)
            }        }

        App()
        if (showLoading.value) {
            Box(contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
//        val versionNameDiv = document.createElement("div")
//        versionNameDiv.id = "versionName"
//        document.body!!.appendChild(versionNameDiv)
//        val link = document.createElement("a")
//        link.href = "https://example.com"; // Set the URL you want the link to point to (optional)
//        appendVersionName()
        appendVersionName()
        // Append the link element to the versionNameDiv
//        versionNameDiv.appendChild(link)
    }
}
const val latestAppVersion = "1.2.3"

fun appendVersionName(): Unit =         js("""{
        if( document.getElementById('version_root') != null){
            return
        }
        var div = document.createElement("div");
        div.id = "version_root"

        div.style.position = "fixed"
        div.style.bottom = "0"
        div.style.left = "0"
        div.style.right = "0"
        div.style.textAlign = "center"
        div.style.padding = "10px"
        div.style.backgroundColor = "#f1f1f1"
        div.style.borderTop = "1px solid #ccc"
        div.style.textDecoration = "none"
        div.style.color = "#000"
        div.style.fontSize = "16px"
            
       document.body.appendChild(div); 
       
       var divPlay = document.createElement("div"); 
       var divMy = document.createElement("div");
       divPlay.id = "latest_version_name"
       divMy.id = "my_version_name"
//       divPlay.innerText = "최신버전:${latestAppVersion}";
       divMy.innerText = "내 앱 버전";
       
       div.appendChild(divPlay);
       div.appendChild(divMy);
       
       var a = document.createElement("a");
       a.target = "_blank";
       a.href = "https://play.google.com/store/apps/details?id=com.box.bible";
       a.innerText = "스토어 가기";
       
       div.appendChild(a);
        
        }""")
