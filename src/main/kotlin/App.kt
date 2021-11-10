import kotlinx.coroutines.async
import kotlinx.css.*
import react.*
import react.dom.*
import kotlinx.browser.window
import kotlinx.coroutines.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import styled.css
import styled.styledDiv

val app = fc<Props> {
    h1 {
        +"KotlinConf Explorer"
    }
    div {
        h3 {
            +"Videos to watch"
        }
        child(videoList) {
            attrs {
                videos = unwatchedVideos
            }
        }

        h3 {
            +"Videos watched"
        }
        child(videoList) {
            attrs {
                videos = watchedVideos
            }
        }
    }
    styledDiv {
        css {
            position = Position.absolute
            top = 10.px
            right = 10.px
        }
        h3 {
            +"John Doe: Building and breaking things"
        }
        img {
            attrs {
                src = "https://via.placeholder.com/640x360.png?text=Video+Player+Placeholder"
            }
        }
    }

}