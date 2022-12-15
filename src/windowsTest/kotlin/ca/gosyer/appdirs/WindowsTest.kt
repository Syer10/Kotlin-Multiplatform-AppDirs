package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.WindowsAppDirs
import ca.gosyer.appdirs.impl.WindowsFolderResolver
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class WindowsTest(windowsFolderResolver: () -> WindowsFolderResolver) : AppDirsTest({ WindowsAppDirs(windowsFolderResolver()) }) {

    @Test
    fun testRealPathWinUserDataDir() {
        assertEquals(
            home + "\\AppData\\Local",
            appDirs.getUserDataDir(null, null, null)
        )
    }

    @Test
    fun testRealPathWinUserConfigDir() {
        assertEquals(
            home + "\\AppData\\Local",
            appDirs.getUserConfigDir(null, null, null)
        )
    }

    @Test
    fun testRealPathWinUserCacheDir() {
        assertEquals(
            home + "\\AppData\\Local\\Cache",
            appDirs.getUserCacheDir(null, null, null)
        )
    }

    @Test
    fun testRealPathWinUserLogDir() {
        assertEquals(
            home + "\\AppData\\Local\\Logs",
            appDirs.getUserLogDir(null, null, null)
        )
    }

    @Test
    fun testRealPathWinSiteDataDir() {
        assertEquals("C:\\ProgramData", appDirs.getSiteDataDir(null, null, null))
    }

    @Test
    fun testRealPathWinSiteConfigDir() {
        assertEquals("C:\\ProgramData", appDirs.getSiteConfigDir(null, null, null))
    }

    @Test
    fun testRealPathWinSharedDir() {
        assertEquals("C:\\ProgramData", appDirs.getSharedDir(null, null, null))
    }
}