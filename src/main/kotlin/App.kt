import react.Props
import react.dom.div
import react.dom.h1
import react.dom.h3
import react.fc
import react.useState

val app = fc<Props> {
    var currentVideo: Video? by useState(null)
    var unwatchedVideos: List<Video> by useState(listOf(
        Video(1, "Building and breaking things", "John Doe", VIDEO_URL),
        Video(2, "The development process", "Jane Smith", VIDEO_URL),
        Video(3, "The Web 7.0", "Matt Miller", VIDEO_URL)
    ))
    var watchedVideos: List<Video> by useState(listOf(
        Video(4, "Mouseless development", "Tom Jerry", VIDEO_URL)
    ))
    h1 {
        +"KotlinConf Explorer"
    }
    div {
        h3 { +"Videos to watch" }
        child(videoList) {
            attrs {
                videos = unwatchedVideos
                selectedVideo = currentVideo
                onSelectVideo = { video ->
                    currentVideo = video
                }
            }
        }
        h3 { +"Videos watched" }
        child(videoList) {
            attrs {
                videos = watchedVideos
                selectedVideo = currentVideo
                onSelectVideo = { video ->
                    currentVideo = video
                }
            }
        }
    }
    currentVideo?.let { curr ->
        child(videoPlayer) {
            attrs {
                video = curr
                unwatchedVideo = curr in unwatchedVideos
                onWatchedButtonPressed = {
                    if (video in unwatchedVideos) {
                        unwatchedVideos = unwatchedVideos - video
                        watchedVideos = watchedVideos + video
                    } else {
                        watchedVideos = watchedVideos - video
                        unwatchedVideos = unwatchedVideos + video
                    }
                }
            }
        }
    }
}