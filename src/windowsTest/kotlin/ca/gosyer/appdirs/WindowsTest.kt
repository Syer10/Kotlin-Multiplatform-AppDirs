package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.WindowsAppDirs
import ca.gosyer.appdirs.impl.WindowsFolderResolver
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class WindowsTest(windowsFolderResolver: () -> WindowsFolderResolver) : AppDirsTest({ WindowsAppDirs(windowsFolderResolver()) }) {

    @Test
    fun testRealPathWinUserDataDir() {
        assertEquals(
            "$home\\AppData\\Local",
            appDirs.getUserDataDir(null, null, null)
        )
    }

    @Test
    fun testRealPathWinUserConfigDir() {
        assertEquals(
            "$home\\AppData\\Local",
            appDirs.getUserConfigDir(null, null, null)
        )
    }

    @Test
    fun testRealPathWinUserCacheDir() {
        assertEquals(
            "$home\\AppData\\Local\\Cache",
            appDirs.getUserCacheDir(null, null, null)
        )
    }

    @Test
    fun testRealPathWinUserLogDir() {
        assertEquals(
            "$home\\AppData\\Local\\Logs",
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

    @Test
    open fun testGetUserDataDir() {
        assertEquals(
            "$home\\AppData\\Local",
            appDirs.getUserDataDir(null, null, null)
        )
        assertEquals(
            "$home\\AppData\\Roaming",
            appDirs.getUserDataDir(null, null, null, true)
        )
        assertEquals(
            "$home\\AppData\\Local\\myapp",
            appDirs.getUserDataDir("myapp", null, null)
        )
        assertEquals(
            "$home\\AppData\\Roaming\\myapp",
            appDirs.getUserDataDir("myapp", null, null, true)
        )
        assertEquals(
            "$home\\AppData\\Local\\myapp\\1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", null)
        )
        assertEquals(
            "$home\\AppData\\Roaming\\myapp\\1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", null, true)
        )
        assertEquals(
            "$home\\AppData\\Local\\syer\\myapp\\1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", "syer")
        )
        assertEquals(
            "$home\\AppData\\Roaming\\syer\\myapp\\1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", "syer", true)
        )
    }

    @Test
    open fun testGetUserConfigDir() {
        assertEquals(
            "$home\\AppData\\Local",
            appDirs.getUserConfigDir(null, null, null)
        )
        assertEquals(
            "$home\\AppData\\Roaming",
            appDirs.getUserConfigDir(null, null, null, true)
        )
        assertEquals(
            "$home\\AppData\\Local\\myapp",
            appDirs.getUserConfigDir("myapp", null, null)
        )
        assertEquals(
            "$home\\AppData\\Roaming\\myapp",
            appDirs.getUserConfigDir("myapp", null, null, true)
        )
        assertEquals(
            "$home\\AppData\\Local\\myapp\\1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", null)
        )
        assertEquals(
            "$home\\AppData\\Roaming\\myapp\\1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", null, true)
        )
        assertEquals(
            "$home\\AppData\\Local\\syer\\myapp\\1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", "syer")
        )
        assertEquals(
            "$home\\AppData\\Roaming\\syer\\myapp\\1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", "syer", true)
        )
    }

    @Test
    open fun testGetUserCacheDir() {
        assertEquals(
            "$home\\AppData\\Local\\Cache",
            appDirs.getUserCacheDir(null, null, null)
        )
        assertEquals(
            "$home\\AppData\\Local\\myapp\\Cache",
            appDirs.getUserCacheDir("myapp", null, null)
        )
        assertEquals(
            "$home\\AppData\\Local\\myapp\\Cache\\1.2.3",
            appDirs.getUserCacheDir("myapp", "1.2.3", null)
        )
        assertEquals(
            "$home\\AppData\\Local\\syer\\myapp\\Cache\\1.2.3",
            appDirs.getUserCacheDir("myapp", "1.2.3", "syer")
        )
    }

    @Test
    open fun testGetUserLogDir() {
        assertEquals(
            "$home\\AppData\\Local\\Logs",
            appDirs.getUserLogDir(null, null, null)
        )
        assertEquals(
            "$home\\AppData\\Local\\myapp\\Logs",
            appDirs.getUserLogDir("myapp", null, null)
        )
        assertEquals(
            "$home\\AppData\\Local\\myapp\\Logs\\1.2.3",
            appDirs.getUserLogDir("myapp", "1.2.3", null)
        )
        assertEquals(
            "$home\\AppData\\Local\\syer\\myapp\\Logs\\1.2.3",
            appDirs.getUserLogDir("myapp", "1.2.3", "syer")
        )
    }

    @Test
    open fun testSiteDataDir() {
        assertEquals(
            "C:\\ProgramData",
            appDirs.getSiteDataDir(null, null, null)
        )
        assertEquals(
            "C:\\ProgramData",
            appDirs.getSiteDataDir(null, null, null, true)
        )
        assertEquals(
            "C:\\ProgramData\\myapp",
            appDirs.getSiteDataDir("myapp", null, null)
        )
        assertEquals(
            "C:\\ProgramData\\myapp",
            appDirs.getSiteDataDir("myapp", null, null, true)
        )
        assertEquals(
            "C:\\ProgramData\\myapp\\1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", null)
        )
        assertEquals(
            "C:\\ProgramData\\myapp\\1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", null, true)
        )
        assertEquals(
            "C:\\ProgramData\\syer\\myapp\\1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", "syer")
        )
        assertEquals(
            "C:\\ProgramData\\syer\\myapp\\1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", "syer", true)
        )
    }

    @Test
    open fun testSiteConfigDir() {
        assertEquals(
            "C:\\ProgramData",
            appDirs.getSiteConfigDir(null, null, null)
        )
        assertEquals(
            "C:\\ProgramData",
            appDirs.getSiteConfigDir(null, null, null, true)
        )
        assertEquals(
            "C:\\ProgramData\\myapp",
            appDirs.getSiteConfigDir("myapp", null, null)
        )
        assertEquals(
            "C:\\ProgramData\\myapp",
            appDirs.getSiteConfigDir("myapp", null, null, true)
        )
        assertEquals(
            "C:\\ProgramData\\myapp\\1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", null)
        )
        assertEquals(
            "C:\\ProgramData\\myapp\\1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", null, true)
        )
        assertEquals(
            "C:\\ProgramData\\syer\\myapp\\1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", "syer")
        )
        assertEquals(
            "C:\\ProgramData\\syer\\myapp\\1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", "syer", true)
        )
    }

    @Test
    open fun testgetSharedDir() {
        assertEquals(
            "C:\\ProgramData",
            appDirs.getSharedDir(null, null, null)
        )
        assertEquals(
            "C:\\ProgramData\\myapp",
            appDirs.getSharedDir("myapp", null, null)
        )
        assertEquals(
            "C:\\ProgramData\\myapp\\1.2.3",
            appDirs.getSharedDir("myapp", "1.2.3", null)
        )
        assertEquals(
            "C:\\ProgramData\\syer\\myapp\\1.2.3",
            appDirs.getSharedDir("myapp", "1.2.3", "syer")
        )
    }
}