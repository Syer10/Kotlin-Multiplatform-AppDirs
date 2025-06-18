package ca.gosyer.appdirs

actual fun getOS(): AppDirsTest.OS {
    val os = System.getProperty("os.name").lowercase()
    return if (os.startsWith("mac os x")) {
        AppDirsTest.OS.MACOS
    } else if (os.startsWith("windows")) {
        AppDirsTest.OS.WINDOWS
    } else {
        AppDirsTest.OS.LINUX
    }
}