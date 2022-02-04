import kotlinx.browser.document
import kotlinx.css.*
import react.dom.*
import styled.css
import styled.styledDiv

fun main() {
    render(document.getElementById("root")) {
        h1 {
            +"KotlinConf Explorer"
        }
        div {
            h3 { +"Videos to watch" }
            for (video in unwatchedVideos) {
                p {
                    +"${video.speaker}: ${video.title}"
                }
            }
            h3 { +"Videos watched" }
            for (video in watchedVideos) {
                p {
                    +"${video.speaker}: ${video.title}"
                }
            }
        }
        styledDiv {
            css {
                position = Position.absolute
                top = 10.px
                right = 10.px
            }
            h3 { +"John Doe: Building and breaking things" }
            img {
                attrs {
                    src = "https://via.placeholder.com/640x360.png?text=Video+Player+Placeholder"
                }
            }
        }
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