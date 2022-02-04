import kotlinx.css.*
import kotlinx.html.js.onClickFunction
import react.Props
import react.dom.attrs
import react.dom.h3
import react.dom.img
import react.fc
import styled.css
import styled.styledButton
import styled.styledDiv

external interface VideoPlayerProps : Props {
    var video: Video
    var onWatchedButtonPressed: (Video) -> Unit
    var unwatchedVideo: Boolean
}

val videoPlayer = fc<VideoPlayerProps> { props ->
    styledDiv {
        css {
            position = Position.absolute
            top = 10.px
            right = 10.px
        }
        h3 {
            +"${props.video.speaker}: ${props.video.title}"
        }
        styledButton {
            css {
                display = Display.block
                backgroundColor = if (props.unwatchedVideo) Color.lightGreen else Color.red
            }
            attrs {
                onClickFunction = {
                    props.onWatchedButtonPressed(props.video)
                }
            }
            if (props.unwatchedVideo) {
                +"Marks as watched"
            } else {
                +"Mark as unwatched"
            }
        }
        img {
            attrs {
                src = "https://via.placeholder.com/640x360.png?text=Video+Player+Placeholder"
            }
        }
    }
}