package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.home
import kotlin.test.BeforeTest

abstract class AppDirsTest(os: OS) {
    lateinit var home: String

    @BeforeTest
    open fun init() {
        home = home()
    }

    enum class OS {
        WINDOWS,
        MACOS,
        LINUX,
    }

    val isCurrentOs: Boolean = os == getOS()
}

expect fun getOS(): AppDirsTest.OS