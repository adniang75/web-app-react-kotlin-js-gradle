@file:JsModule("react-youtube-lite")
@file:JsNonModule

import react.ComponentClass
import react.Props

@JsName("ReactYouTubeLite")
external val reactPlayer: ComponentClass<ReactYouTubeProps>

external interface ReactYouTubeProps : Props {
    var url: String
}