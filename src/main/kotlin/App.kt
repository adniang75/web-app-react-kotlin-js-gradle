import kotlinx.browser.window
import kotlinx.coroutines.*
import kotlinx.css.padding
import kotlinx.css.px
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import react.Props
import react.dom.div
import react.dom.h3
import react.fc
import react.useEffectOnce
import react.useState
import styled.css
import styled.styledDiv

val mainScope = MainScope()

val app = fc<Props> {
    var currentVideo: Video? by useState(null)
    var unwatchedVideos: List<Video> by useState(emptyList())
    var watchedVideos: List<Video> by useState(emptyList())
    useEffectOnce {
        mainScope.launch { unwatchedVideos = fetchVideos() }
    }
    div {
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
        styledDiv {
            css {
                padding(all = 10.px)
            }
        }
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
}

suspend fun fetchVideo(id: Int): Video {
    val response = window
        .fetch("https://my-json-server.typicode.com/adniang75/kotlinconf-json/videos/$id")
        .await()
        .text()
        .await()
    return Json.decodeFromString(response)
}

suspend fun fetchVideos(): List<Video> = coroutineScope {
    (1..25).map { id ->
        async {
            fetchVideo(id)
        }
    }.awaitAll()
}