package ca.gosyer.appdirs

import kotlin.test.Test
import kotlin.test.assertEquals

abstract class MacosTest : AppDirsTest(OS.MACOS) {
    @Test
    fun testRealPathMacUserDataDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home/Library/Application Support",
            AppDirs { appName = null }.getUserDataDir()
        )
    }

    @Test
    fun testRealPathMacUserConfigDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home/Library/Preferences",
            AppDirs { appName = null }.getUserConfigDir()
        )
    }

    @Test
    fun testRealPathMacUserCacheDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home/Library/Caches",
            AppDirs { appName = null }.getUserCacheDir()
        )
    }

    @Test
    fun testRealPathMacUserLogDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home/Library/Logs",
            AppDirs { appName = null }.getUserLogDir()
        )
    }

    @Test
    fun testRealPathMacSiteDataDir() {
        if (!isCurrentOs) return
        assertEquals(
            "/Library/Application Support",
            AppDirs { appName = null }.getSiteDataDir()
        )
    }

    @Test
    fun testRealPathMacSiteConfigDir() {
        if (!isCurrentOs) return
        assertEquals(
            "/Library/Preferences",
            AppDirs { appName = null }.getSiteConfigDir()
        )
    }

    @Test
    fun testRealPathMacSharedDir() {
        if (!isCurrentOs) return
        assertEquals(
            "/Users/Shared/Library/Application Support",
            AppDirs { appName = null }.getSharedDir()
        )
    }

    @Test
    open fun testGetUserDataDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home/Library/Application Support",
            AppDirs { appName = null }.getUserDataDir()
        )
        assertEquals(
            "$home/Library/Application Support",
            AppDirs { appName = null }.getUserDataDir(true)
        )
        assertEquals(
            "$home/Library/Application Support/myapp",
            AppDirs { appName = "myapp" }.getUserDataDir()
        )
        assertEquals(
            "$home/Library/Application Support/myapp",
            AppDirs { appName = "myapp" }.getUserDataDir(true)
        )
        assertEquals(
            "$home/Library/Application Support/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getUserDataDir()
        )
        assertEquals(
            "$home/Library/Application Support/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getUserDataDir(true)
        )
        assertEquals(
            "$home/Library/Application Support/syer myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getUserDataDir()
        )
        assertEquals(
            "$home/Library/Application Support/syer myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getUserDataDir(true)
        )
    }

    @Test
    open fun testGetUserConfigDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home/Library/Preferences",
            AppDirs { appName = null }.getUserConfigDir()
        )
        assertEquals(
            "$home/Library/Preferences",
            AppDirs { appName = null }.getUserConfigDir(true)
        )
        assertEquals(
            "$home/Library/Preferences/myapp",
            AppDirs { appName = "myapp" }.getUserConfigDir()
        )
        assertEquals(
            "$home/Library/Preferences/myapp",
            AppDirs { appName = "myapp" }.getUserConfigDir(true)
        )
        assertEquals(
            "$home/Library/Preferences/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getUserConfigDir()
        )
        assertEquals(
            "$home/Library/Preferences/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getUserConfigDir(true)
        )
        assertEquals(
            "$home/Library/Preferences/syer myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getUserConfigDir()
        )
        assertEquals(
            "$home/Library/Preferences/syer myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getUserConfigDir(true)
        )
    }

    @Test
    open fun testGetUserCacheDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home/Library/Caches",
            AppDirs { appName = null }.getUserCacheDir()
        )
        assertEquals(
            "$home/Library/Caches/myapp",
            AppDirs { appName = "myapp" }.getUserCacheDir()
        )
        assertEquals(
            "$home/Library/Caches/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getUserCacheDir()
        )
        assertEquals(
            "$home/Library/Caches/syer myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getUserCacheDir()
        )
    }

    @Test
    open fun testGetUserLogDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home/Library/Logs",
            AppDirs { appName = null }.getUserLogDir()
        )
        assertEquals(
            "$home/Library/Logs/myapp",
            AppDirs { appName = "myapp" }.getUserLogDir()
        )
        assertEquals(
            "$home/Library/Logs/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getUserLogDir()
        )
        assertEquals(
            "$home/Library/Logs/syer myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getUserLogDir()
        )
    }

    @Test
    open fun testSiteDataDir() {
        if (!isCurrentOs) return
        assertEquals(
            "/Library/Application Support",
            AppDirs { appName = null }.getSiteDataDir()
        )
        assertEquals(
            "/Library/Application Support",
            AppDirs { appName = null }.getSiteDataDir(true)
        )
        assertEquals(
            "/Library/Application Support/myapp",
            AppDirs { appName = "myapp" }.getSiteDataDir()
        )
        assertEquals(
            "/Library/Application Support/myapp",
            AppDirs { appName = "myapp" }.getSiteDataDir(true)
        )
        assertEquals(
            "/Library/Application Support/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getSiteDataDir()
        )
        assertEquals(
            "/Library/Application Support/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getSiteDataDir(true)
        )
        assertEquals(
            "/Library/Application Support/syer myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getSiteDataDir()
        )
        assertEquals(
            "/Library/Application Support/syer myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getSiteDataDir(true)
        )
    }

    @Test
    open fun testSiteConfigDir() {
        if (!isCurrentOs) return
        assertEquals(
            "/Library/Application Support/config",
            AppDirs { appName = null }.getSiteConfigDir()
        )
        assertEquals(
            "/Library/Application Support/config",
            AppDirs { appName = null }.getSiteConfigDir(true)
        )
        assertEquals(
            "/Library/Application Support/config/myapp",
            AppDirs { appName = "myapp" }.getSiteConfigDir()
        )
        assertEquals(
            "/Library/Application Support/config/myapp",
            AppDirs { appName = "myapp" }.getSiteConfigDir(true)
        )
        assertEquals(
            "/Library/Application Support/config/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getSiteConfigDir()
        )
        assertEquals(
            "/Library/Application Support/config/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getSiteConfigDir(true)
        )
        assertEquals(
            "/Library/Application Support/config/syer myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getSiteConfigDir()
        )
        assertEquals(
            "/Library/Preferences/syer myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getSiteConfigDir(true)
        )
    }

    @Test
    open fun testgetSharedDir() {
        if (!isCurrentOs) return
        assertEquals(
            "/Users/Shared/Library/Application Support",
            AppDirs { appName = null }.getSharedDir()
        )
        assertEquals(
            "/Users/Shared/Library/Application Support/myapp",
            AppDirs { appName = "myapp" }.getSharedDir()
        )
        assertEquals(
            "/Users/Shared/Library/Application Support/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getSharedDir()
        )
        assertEquals(
            "/Users/Shared/Library/Application Support/syer myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getSharedDir()
        )
    }
}