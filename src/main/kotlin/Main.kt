import kotlinx.browser.document
import react.dom.render

fun main() {
    render(document.getElementById("root")) {
        child(app)
    }
}


data class Video(val id: Int, val title: String, val speaker: String, val videoUrl: String)

const val VIDEO_URL = "https://youtu.be/PsaFVLr8t4E"

val unwatchedVideos = listOf(
    Video(1, "Building and breaking things", "John Doe", VIDEO_URL),
    Video(2, "The development process", "Jane Smith", VIDEO_URL),
    Video(3, "The Web 7.0", "Matt Miller", VIDEO_URL),
)

val watchedVideos = listOf(
    Video(4, "Mouseless development", "Tom Jerry", VIDEO_URL),
)