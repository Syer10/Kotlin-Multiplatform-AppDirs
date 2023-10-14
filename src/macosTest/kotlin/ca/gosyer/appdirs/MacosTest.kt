package ca.gosyer.appdirs

import kotlin.test.Test
import kotlin.test.assertEquals

abstract class MacosTest : AppDirsTest() {
    @Test
    fun testRealPathMacUserDataDir() {
        assertEquals(
            "$home/Library/Application Support",
            AppDirs(null).getUserDataDir()
        )
    }

    @Test
    fun testRealPathMacUserConfigDir() {
        assertEquals(
            "$home/Library/Preferences",
            AppDirs(null).getUserConfigDir()
        )
    }

    @Test
    fun testRealPathMacUserCacheDir() {
        assertEquals(
            "$home/Library/Caches",
            AppDirs(null).getUserCacheDir()
        )
    }

    @Test
    fun testRealPathMacUserLogDir() {
        assertEquals(
            "$home/Library/Logs",
            AppDirs(null).getUserLogDir()
        )
    }

    @Test
    fun testRealPathMacSiteDataDir() {
        assertEquals(
            "/Library/Application Support",
            AppDirs(null).getSiteDataDir()
        )
    }

    @Test
    fun testRealPathMacSiteConfigDir() {
        assertEquals(
            "/Library/Preferences",
            AppDirs(null).getSiteConfigDir()
        )
    }

    @Test
    fun testRealPathMacSharedDir() {
        assertEquals(
            "/Users/Shared/Library/Application Support",
            AppDirs(null).getSharedDir()
        )
    }

    @Test
    open fun testGetUserDataDir() {
        assertEquals(
            "$home/Library/Application Support",
            AppDirs(null).getUserDataDir()
        )
        assertEquals(
            "$home/Library/Application Support",
            AppDirs(null).getUserDataDir(true)
        )
        assertEquals(
            "$home/Library/Application Support/myapp",
            AppDirs("myapp").getUserDataDir()
        )
        assertEquals(
            "$home/Library/Application Support/myapp",
            AppDirs("myapp").getUserDataDir(true)
        )
        assertEquals(
            "$home/Library/Application Support/myapp/1.2.3",
            AppDirs("myapp", null, "1.2.3").getUserDataDir()
        )
        assertEquals(
            "$home/Library/Application Support/myapp/1.2.3",
            AppDirs("myapp", null, "1.2.3").getUserDataDir(true)
        )
        assertEquals(
            "$home/Library/Application Support/syer myapp/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getUserDataDir()
        )
        assertEquals(
            "$home/Library/Application Support/syer myapp/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getUserDataDir(true)
        )
    }

    @Test
    open fun testGetUserConfigDir() {
        assertEquals(
            "$home/Library/Preferences",
            AppDirs(null).getUserConfigDir()
        )
        assertEquals(
            "$home/Library/Preferences",
            AppDirs(null).getUserConfigDir(true)
        )
        assertEquals(
            "$home/Library/Preferences/myapp",
            AppDirs("myapp").getUserConfigDir()
        )
        assertEquals(
            "$home/Library/Preferences/myapp",
            AppDirs("myapp").getUserConfigDir(true)
        )
        assertEquals(
            "$home/Library/Preferences/myapp/1.2.3",
            AppDirs("myapp", null, "1.2.3").getUserConfigDir()
        )
        assertEquals(
            "$home/Library/Preferences/myapp/1.2.3",
            AppDirs("myapp", null, "1.2.3").getUserConfigDir(true)
        )
        assertEquals(
            "$home/Library/Preferences/syer myapp/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getUserConfigDir()
        )
        assertEquals(
            "$home/Library/Preferences/syer myapp/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getUserConfigDir(true)
        )
    }

    @Test
    open fun testGetUserCacheDir() {
        assertEquals(
            "$home/Library/Caches",
            AppDirs(null).getUserCacheDir()
        )
        assertEquals(
            "$home/Library/Caches/myapp",
            AppDirs("myapp").getUserCacheDir()
        )
        assertEquals(
            "$home/Library/Caches/myapp/1.2.3",
            AppDirs("myapp", null, "1.2.3").getUserCacheDir()
        )
        assertEquals(
            "$home/Library/Caches/syer myapp/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getUserCacheDir()
        )
    }

    @Test
    open fun testGetUserLogDir() {
        assertEquals(
            "$home/Library/Logs",
            AppDirs(null).getUserLogDir()
        )
        assertEquals(
            "$home/Library/Logs/myapp",
            AppDirs("myapp").getUserLogDir()
        )
        assertEquals(
            "$home/Library/Logs/myapp/1.2.3",
            AppDirs("myapp", null, "1.2.3").getUserLogDir()
        )
        assertEquals(
            "$home/Library/Logs/syer myapp/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getUserLogDir()
        )
    }

    @Test
    open fun testSiteDataDir() {
        assertEquals(
            "/Library/Application Support",
            AppDirs(null).getSiteDataDir()
        )
        assertEquals(
            "/Library/Application Support",
            AppDirs(null).getSiteDataDir(true)
        )
        assertEquals(
            "/Library/Application Support/myapp",
            AppDirs("myapp").getSiteDataDir()
        )
        assertEquals(
            "/Library/Application Support/myapp",
            AppDirs("myapp").getSiteDataDir(true)
        )
        assertEquals(
            "/Library/Application Support/myapp/1.2.3",
            AppDirs("myapp", null, "1.2.3").getSiteDataDir()
        )
        assertEquals(
            "/Library/Application Support/myapp/1.2.3",
            AppDirs("myapp", null, "1.2.3").getSiteDataDir(true)
        )
        assertEquals(
            "/Library/Application Support/syer myapp/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getSiteDataDir()
        )
        assertEquals(
            "/Library/Application Support/syer myapp/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getSiteDataDir(true)
        )
    }

    @Test
    open fun testSiteConfigDir() {
        assertEquals(
            "/Library/Preferences",
            AppDirs(null).getSiteConfigDir()
        )
        assertEquals(
            "/Library/Preferences",
            AppDirs(null).getSiteConfigDir(true)
        )
        assertEquals(
            "/Library/Preferences/myapp",
            AppDirs("myapp").getSiteConfigDir()
        )
        assertEquals(
            "/Library/Preferences/myapp",
            AppDirs("myapp").getSiteConfigDir(true)
        )
        assertEquals(
            "/Library/Preferences/myapp/1.2.3",
            AppDirs("myapp", null, "1.2.3").getSiteConfigDir()
        )
        assertEquals(
            "/Library/Preferences/myapp/1.2.3",
            AppDirs("myapp", null, "1.2.3").getSiteConfigDir(true)
        )
        assertEquals(
            "/Library/Preferences/syer myapp/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getSiteConfigDir()
        )
        assertEquals(
            "/Library/Preferences/syer myapp/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getSiteConfigDir(true)
        )
    }

    @Test
    open fun testgetSharedDir() {
        assertEquals(
            "/Users/Shared/Library/Application Support",
            AppDirs(null).getSharedDir()
        )
        assertEquals(
            "/Users/Shared/Library/Application Support/myapp",
            AppDirs("myapp").getSharedDir()
        )
        assertEquals(
            "/Users/Shared/Library/Application Support/myapp/1.2.3",
            AppDirs("myapp", null, "1.2.3").getSharedDir()
        )
        assertEquals(
            "/Users/Shared/Library/Application Support/syer myapp/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getSharedDir()
        )
    }
}