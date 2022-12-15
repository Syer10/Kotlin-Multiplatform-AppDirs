package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.home
import kotlin.test.BeforeTest

abstract class AppDirsTest(private val initAppDirs: () -> AppDirs) {
    lateinit var appDirs: AppDirs
    lateinit var home: String

    @BeforeTest
    open fun init() {
        appDirs = initAppDirs()
        home = home()
    }
}