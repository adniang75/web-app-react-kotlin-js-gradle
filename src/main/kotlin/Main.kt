import kotlinx.browser.document
import kotlinx.serialization.Serializable
import react.dom.render

fun main() {
    render(document.getElementById("root")) {
        child(app)
    }
}


@Serializable
data class Video(val id: Int, val title: String, val speaker: String, val videoUrl: String)

const val VIDEO_URL = "https://youtu.be/PsaFVLr8t4E"