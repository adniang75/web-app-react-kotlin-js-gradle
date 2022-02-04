import kotlinx.html.js.onClickFunction
import react.Props
import react.dom.attrs
import react.dom.p
import react.fc
import react.useState

val videoList = fc<VideoListProps> { props ->
    var selectedVideo: Video? by useState(null)
    for (video in props.videos) {
        p {
            key = video.id.toString()
            attrs {
                onClickFunction = {
                    selectedVideo = video
                }
            }
            if (video == selectedVideo) {
                +"▶ "
            }
            +"${video.speaker}: ${video.title}"
        }
    }
}

external interface VideoListProps : Props {
    var videos: List<Video>
}