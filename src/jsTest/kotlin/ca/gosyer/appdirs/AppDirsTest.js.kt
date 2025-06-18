package ca.gosyer.appdirs

import node.process.Platform
import node.process.process

actual fun getOS(): AppDirsTest.OS {
    val os = process.platform
    return if (os == Platform.darwin) {
        AppDirsTest.OS.MACOS
    } else if (os == Platform.win32) {
        AppDirsTest.OS.WINDOWS
    } else {
        AppDirsTest.OS.LINUX
    }
}