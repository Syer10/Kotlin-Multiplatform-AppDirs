package ca.gosyer.appdirs

import kotlin.test.Test
import kotlin.test.assertEquals

abstract class WindowsTest : AppDirsTest(OS.WINDOWS) {

    @Test
    fun testRealPathWinUserDataDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home\\AppData\\Local",
            AppDirs { appName = null }.getUserDataDir()
        )
    }

    @Test
    fun testRealPathWinUserConfigDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home\\AppData\\Local",
            AppDirs { appName = null }.getUserConfigDir()
        )
    }

    @Test
    fun testRealPathWinUserCacheDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home\\AppData\\Local\\Cache",
            AppDirs { appName = null }.getUserCacheDir()
        )
    }

    @Test
    fun testRealPathWinUserLogDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home\\AppData\\Local\\Logs",
            AppDirs { appName = null }.getUserLogDir()
        )
    }

    @Test
    fun testRealPathWinSiteDataDir() {
        if (!isCurrentOs) return
        assertEquals("C:\\ProgramData", AppDirs { appName = null }.getSiteDataDir())
    }

    @Test
    fun testRealPathWinSiteConfigDir() {
        if (!isCurrentOs) return
        assertEquals("C:\\ProgramData", AppDirs { appName = null }.getSiteConfigDir())
    }

    @Test
    fun testRealPathWinSharedDir() {
        if (!isCurrentOs) return
        assertEquals("C:\\ProgramData", AppDirs { appName = null }.getSharedDir())
    }

    @Test
    open fun testGetUserDataDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home\\AppData\\Local",
            AppDirs { appName = null }.getUserDataDir()
        )
        assertEquals(
            "$home\\AppData\\Roaming",
            AppDirs { appName = null }.getUserDataDir(true)
        )
        assertEquals(
            "$home\\AppData\\Local\\myapp",
            AppDirs { appName = "myapp" }.getUserDataDir()
        )
        assertEquals(
            "$home\\AppData\\Roaming\\myapp",
            AppDirs { appName = "myapp" }.getUserDataDir(true)
        )
        assertEquals(
            "$home\\AppData\\Local\\myapp\\1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getUserDataDir()
        )
        assertEquals(
            "$home\\AppData\\Roaming\\myapp\\1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getUserDataDir(true)
        )
        assertEquals(
            "$home\\AppData\\Local\\syer\\myapp\\1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getUserDataDir()
        )
        assertEquals(
            "$home\\AppData\\Roaming\\syer\\myapp\\1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getUserDataDir(true)
        )
    }

    @Test
    open fun testGetUserConfigDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home\\AppData\\Local",
            AppDirs { appName = null }.getUserConfigDir()
        )
        assertEquals(
            "$home\\AppData\\Roaming",
            AppDirs { appName = null }.getUserConfigDir(true)
        )
        assertEquals(
            "$home\\AppData\\Local\\myapp",
            AppDirs { appName = "myapp" }.getUserConfigDir()
        )
        assertEquals(
            "$home\\AppData\\Roaming\\myapp",
            AppDirs { appName = "myapp" }.getUserConfigDir(true)
        )
        assertEquals(
            "$home\\AppData\\Local\\myapp\\1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getUserConfigDir()
        )
        assertEquals(
            "$home\\AppData\\Roaming\\myapp\\1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getUserConfigDir(true)
        )
        assertEquals(
            "$home\\AppData\\Local\\syer\\myapp\\1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getUserConfigDir()
        )
        assertEquals(
            "$home\\AppData\\Roaming\\syer\\myapp\\1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getUserConfigDir(true)
        )
    }

    @Test
    open fun testGetUserCacheDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home\\AppData\\Local\\Cache",
            AppDirs { appName = null }.getUserCacheDir()
        )
        assertEquals(
            "$home\\AppData\\Local\\myapp\\Cache",
            AppDirs { appName = "myapp" }.getUserCacheDir()
        )
        assertEquals(
            "$home\\AppData\\Local\\myapp\\Cache\\1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getUserCacheDir()
        )
        assertEquals(
            "$home\\AppData\\Local\\syer\\myapp\\Cache\\1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getUserCacheDir()
        )
    }

    @Test
    open fun testGetUserLogDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home\\AppData\\Local\\Logs",
            AppDirs { appName = null }.getUserLogDir()
        )
        assertEquals(
            "$home\\AppData\\Local\\myapp\\Logs",
            AppDirs { appName = "myapp" }.getUserLogDir()
        )
        assertEquals(
            "$home\\AppData\\Local\\myapp\\Logs\\1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getUserLogDir()
        )
        assertEquals(
            "$home\\AppData\\Local\\syer\\myapp\\Logs\\1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getUserLogDir()
        )
    }

    @Test
    open fun testSiteDataDir() {
        if (!isCurrentOs) return
        assertEquals(
            "C:\\ProgramData",
            AppDirs { appName = null }.getSiteDataDir()
        )
        assertEquals(
            "C:\\ProgramData",
            AppDirs { appName = null }.getSiteDataDir(true)
        )
        assertEquals(
            "C:\\ProgramData\\myapp",
            AppDirs { appName = "myapp" }.getSiteDataDir()
        )
        assertEquals(
            "C:\\ProgramData\\myapp",
            AppDirs { appName = "myapp" }.getSiteDataDir(true)
        )
        assertEquals(
            "C:\\ProgramData\\myapp\\1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getSiteDataDir()
        )
        assertEquals(
            "C:\\ProgramData\\myapp\\1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getSiteDataDir(true)
        )
        assertEquals(
            "C:\\ProgramData\\syer\\myapp\\1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getSiteDataDir()
        )
        assertEquals(
            "C:\\ProgramData\\syer\\myapp\\1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getSiteDataDir(true)
        )
    }

    @Test
    open fun testSiteConfigDir() {
        if (!isCurrentOs) return
        assertEquals(
            "C:\\ProgramData",
            AppDirs { appName = null }.getSiteConfigDir()
        )
        assertEquals(
            "C:\\ProgramData",
            AppDirs { appName = null }.getSiteConfigDir(true)
        )
        assertEquals(
            "C:\\ProgramData\\myapp",
            AppDirs { appName = "myapp" }.getSiteConfigDir()
        )
        assertEquals(
            "C:\\ProgramData\\myapp",
            AppDirs { appName = "myapp" }.getSiteConfigDir(true)
        )
        assertEquals(
            "C:\\ProgramData\\myapp\\1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getSiteConfigDir()
        )
        assertEquals(
            "C:\\ProgramData\\myapp\\1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getSiteConfigDir(true)
        )
        assertEquals(
            "C:\\ProgramData\\syer\\myapp\\1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getSiteConfigDir()
        )
        assertEquals(
            "C:\\ProgramData\\syer\\myapp\\1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getSiteConfigDir(true)
        )
    }

    @Test
    open fun testgetSharedDir() {
        if (!isCurrentOs) return
        assertEquals(
            "C:\\ProgramData",
            AppDirs { appName = null }.getSharedDir()
        )
        assertEquals(
            "C:\\ProgramData\\myapp",
            AppDirs { appName = "myapp" }.getSharedDir()
        )
        assertEquals(
            "C:\\ProgramData\\myapp\\1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getSharedDir()
        )
        assertEquals(
            "C:\\ProgramData\\syer\\myapp\\1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getSharedDir()
        )
    }
}