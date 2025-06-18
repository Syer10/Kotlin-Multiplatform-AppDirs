package ca.gosyer.appdirs

import kotlin.test.Test
import kotlin.test.assertEquals

abstract class WindowsTest : AppDirsTest(OS.WINDOWS) {

    @Test
    fun testRealPathWinUserDataDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home\\AppData\\Local",
            AppDirs(null).getUserDataDir()
        )
    }

    @Test
    fun testRealPathWinUserConfigDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home\\AppData\\Local",
            AppDirs(null).getUserConfigDir()
        )
    }

    @Test
    fun testRealPathWinUserCacheDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home\\AppData\\Local\\Cache",
            AppDirs(null).getUserCacheDir()
        )
    }

    @Test
    fun testRealPathWinUserLogDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home\\AppData\\Local\\Logs",
            AppDirs(null).getUserLogDir()
        )
    }

    @Test
    fun testRealPathWinSiteDataDir() {
        if (!isCurrentOs) return
        assertEquals("C:\\ProgramData", AppDirs(null).getSiteDataDir())
    }

    @Test
    fun testRealPathWinSiteConfigDir() {
        if (!isCurrentOs) return
        assertEquals("C:\\ProgramData", AppDirs(null).getSiteConfigDir())
    }

    @Test
    fun testRealPathWinSharedDir() {
        if (!isCurrentOs) return
        assertEquals("C:\\ProgramData", AppDirs(null).getSharedDir())
    }

    @Test
    open fun testGetUserDataDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home\\AppData\\Local",
            AppDirs(null).getUserDataDir()
        )
        assertEquals(
            "$home\\AppData\\Roaming",
            AppDirs(null).getUserDataDir(true)
        )
        assertEquals(
            "$home\\AppData\\Local\\myapp",
            AppDirs("myapp").getUserDataDir()
        )
        assertEquals(
            "$home\\AppData\\Roaming\\myapp",
            AppDirs("myapp").getUserDataDir(true)
        )
        assertEquals(
            "$home\\AppData\\Local\\myapp\\1.2.3",
            AppDirs("myapp", null, "1.2.3").getUserDataDir()
        )
        assertEquals(
            "$home\\AppData\\Roaming\\myapp\\1.2.3",
            AppDirs("myapp", null, "1.2.3").getUserDataDir(true)
        )
        assertEquals(
            "$home\\AppData\\Local\\syer\\myapp\\1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getUserDataDir()
        )
        assertEquals(
            "$home\\AppData\\Roaming\\syer\\myapp\\1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getUserDataDir(true)
        )
    }

    @Test
    open fun testGetUserConfigDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home\\AppData\\Local",
            AppDirs(null).getUserConfigDir()
        )
        assertEquals(
            "$home\\AppData\\Roaming",
            AppDirs(null).getUserConfigDir(true)
        )
        assertEquals(
            "$home\\AppData\\Local\\myapp",
            AppDirs("myapp").getUserConfigDir()
        )
        assertEquals(
            "$home\\AppData\\Roaming\\myapp",
            AppDirs("myapp").getUserConfigDir(true)
        )
        assertEquals(
            "$home\\AppData\\Local\\myapp\\1.2.3",
            AppDirs("myapp", null, "1.2.3").getUserConfigDir()
        )
        assertEquals(
            "$home\\AppData\\Roaming\\myapp\\1.2.3",
            AppDirs("myapp", null, "1.2.3").getUserConfigDir(true)
        )
        assertEquals(
            "$home\\AppData\\Local\\syer\\myapp\\1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getUserConfigDir()
        )
        assertEquals(
            "$home\\AppData\\Roaming\\syer\\myapp\\1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getUserConfigDir(true)
        )
    }

    @Test
    open fun testGetUserCacheDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home\\AppData\\Local\\Cache",
            AppDirs(null).getUserCacheDir()
        )
        assertEquals(
            "$home\\AppData\\Local\\myapp\\Cache",
            AppDirs("myapp").getUserCacheDir()
        )
        assertEquals(
            "$home\\AppData\\Local\\myapp\\Cache\\1.2.3",
            AppDirs("myapp", null, "1.2.3").getUserCacheDir()
        )
        assertEquals(
            "$home\\AppData\\Local\\syer\\myapp\\Cache\\1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getUserCacheDir()
        )
    }

    @Test
    open fun testGetUserLogDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home\\AppData\\Local\\Logs",
            AppDirs(null).getUserLogDir()
        )
        assertEquals(
            "$home\\AppData\\Local\\myapp\\Logs",
            AppDirs("myapp").getUserLogDir()
        )
        assertEquals(
            "$home\\AppData\\Local\\myapp\\Logs\\1.2.3",
            AppDirs("myapp", null, "1.2.3").getUserLogDir()
        )
        assertEquals(
            "$home\\AppData\\Local\\syer\\myapp\\Logs\\1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getUserLogDir()
        )
    }

    @Test
    open fun testSiteDataDir() {
        if (!isCurrentOs) return
        assertEquals(
            "C:\\ProgramData",
            AppDirs(null).getSiteDataDir()
        )
        assertEquals(
            "C:\\ProgramData",
            AppDirs(null).getSiteDataDir(true)
        )
        assertEquals(
            "C:\\ProgramData\\myapp",
            AppDirs("myapp").getSiteDataDir()
        )
        assertEquals(
            "C:\\ProgramData\\myapp",
            AppDirs("myapp").getSiteDataDir(true)
        )
        assertEquals(
            "C:\\ProgramData\\myapp\\1.2.3",
            AppDirs("myapp", null, "1.2.3").getSiteDataDir()
        )
        assertEquals(
            "C:\\ProgramData\\myapp\\1.2.3",
            AppDirs("myapp", null, "1.2.3").getSiteDataDir(true)
        )
        assertEquals(
            "C:\\ProgramData\\syer\\myapp\\1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getSiteDataDir()
        )
        assertEquals(
            "C:\\ProgramData\\syer\\myapp\\1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getSiteDataDir(true)
        )
    }

    @Test
    open fun testSiteConfigDir() {
        if (!isCurrentOs) return
        assertEquals(
            "C:\\ProgramData",
            AppDirs(null).getSiteConfigDir()
        )
        assertEquals(
            "C:\\ProgramData",
            AppDirs(null).getSiteConfigDir(true)
        )
        assertEquals(
            "C:\\ProgramData\\myapp",
            AppDirs("myapp").getSiteConfigDir()
        )
        assertEquals(
            "C:\\ProgramData\\myapp",
            AppDirs("myapp").getSiteConfigDir(true)
        )
        assertEquals(
            "C:\\ProgramData\\myapp\\1.2.3",
            AppDirs("myapp", null, "1.2.3").getSiteConfigDir()
        )
        assertEquals(
            "C:\\ProgramData\\myapp\\1.2.3",
            AppDirs("myapp", null, "1.2.3").getSiteConfigDir(true)
        )
        assertEquals(
            "C:\\ProgramData\\syer\\myapp\\1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getSiteConfigDir()
        )
        assertEquals(
            "C:\\ProgramData\\syer\\myapp\\1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getSiteConfigDir(true)
        )
    }

    @Test
    open fun testgetSharedDir() {
        if (!isCurrentOs) return
        assertEquals(
            "C:\\ProgramData",
            AppDirs(null).getSharedDir()
        )
        assertEquals(
            "C:\\ProgramData\\myapp",
            AppDirs("myapp").getSharedDir()
        )
        assertEquals(
            "C:\\ProgramData\\myapp\\1.2.3",
            AppDirs("myapp", null, "1.2.3").getSharedDir()
        )
        assertEquals(
            "C:\\ProgramData\\syer\\myapp\\1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getSharedDir()
        )
    }
}