package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.home
import kotlin.test.BeforeTest

abstract class AppDirsTest {
    lateinit var home: String

    @BeforeTest
    open fun init() {
        home = home()
    }
}