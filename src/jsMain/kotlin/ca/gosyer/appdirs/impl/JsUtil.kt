package ca.gosyer.appdirs.impl

internal actual fun home() = os.homedir()

internal actual fun fileSeparator() = path.sep

internal actual fun pathSeparator() = path.delimiter

@JsModule("os")
external val os: OS

@JsModule("os")
sealed external interface OS {
    fun homedir(): String
}

@JsModule("node:path")
external val path: Path

@JsModule("node:path")
sealed external interface Path {
    val delimiter: String
    val sep: String
}