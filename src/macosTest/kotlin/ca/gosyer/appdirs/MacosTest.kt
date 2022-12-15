package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.MacOSXAppDirs
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class MacosTest : AppDirsTest(::MacOSXAppDirs) {
    @Test
    fun testRealPathMacUserDataDir() {
        assertEquals(
            home + "/Library/Application Support",
            appDirs.getUserDataDir(null, null, null)
        )
    }

    @Test
    fun testRealPathMacUserConfigDir() {
        assertEquals(
            home + "/Library/Preferences",
            appDirs.getUserConfigDir(null, null, null)
        )
    }

    @Test
    fun testRealPathMacUserCacheDir() {
        assertEquals(
            home + "/Library/Caches",
            appDirs.getUserCacheDir(null, null, null)
        )
    }

    @Test
    fun testRealPathMacUserLogDir() {
        assertEquals(
            home + "/Library/Logs",
            appDirs.getUserLogDir(null, null, null)
        )
    }

    @Test
    fun testRealPathMacSiteDataDir() {
        assertEquals(
            "/Library/Application Support",
            appDirs.getSiteDataDir(null, null, null)
        )
    }

    @Test
    fun testRealPathMacSiteConfigDir() {
        assertEquals(
            "/Library/Preferences",
            appDirs.getSiteConfigDir(null, null, null)
        )
    }

    @Test
    fun testRealPathMacSharedDir() {
        assertEquals(
            "/Users/Shared/Library/Application Support",
            appDirs.getSharedDir(null, null, null)
        )
    }

    @Test
    open fun testGetUserDataDir() {
        assertEquals(
            "$home/Library/Application Support",
            appDirs.getUserDataDir(null, null, null)
        )
        assertEquals(
            "$home/Library/Application Support",
            appDirs.getUserDataDir(null, null, null, true)
        )
        assertEquals(
            "$home/Library/Application Support/myapp",
            appDirs.getUserDataDir("myapp", null, null)
        )
        assertEquals(
            "$home/Library/Application Support/myapp",
            appDirs.getUserDataDir("myapp", null, null, true)
        )
        assertEquals(
            "$home/Library/Application Support/myapp/1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", null)
        )
        assertEquals(
            "$home/Library/Application Support/myapp/1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", null, true)
        )
        assertEquals(
            "$home/Library/Application Support/myapp/1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", "syer")
        )
        assertEquals(
            "$home/Library/Application Support/myapp/1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", "syer", true)
        )
    }

    @Test
    open fun testGetUserConfigDir() {
        assertEquals(
            "$home/Library/Preferences",
            appDirs.getUserConfigDir(null, null, null)
        )
        assertEquals(
            "$home/Library/Preferences",
            appDirs.getUserConfigDir(null, null, null, true)
        )
        assertEquals(
            "$home/Library/Preferences/myapp",
            appDirs.getUserConfigDir("myapp", null, null)
        )
        assertEquals(
            "$home/Library/Preferences/myapp",
            appDirs.getUserConfigDir("myapp", null, null, true)
        )
        assertEquals(
            "$home/Library/Preferences/myapp/1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", null)
        )
        assertEquals(
            "$home/Library/Preferences/myapp/1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", null, true)
        )
        assertEquals(
            "$home/Library/Preferences/myapp/1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", "syer")
        )
        assertEquals(
            "$home/Library/Preferences/myapp/1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", "syer", true)
        )
    }

    @Test
    open fun testGetUserCacheDir() {
        assertEquals(
            "$home/Library/Caches",
            appDirs.getUserCacheDir(null, null, null)
        )
        assertEquals(
            "$home/Library/Caches/myapp",
            appDirs.getUserCacheDir("myapp", null, null)
        )
        assertEquals(
            "$home/Library/Caches/myapp/1.2.3",
            appDirs.getUserCacheDir("myapp", "1.2.3", null)
        )
        assertEquals(
            "$home/Library/Caches/myapp/1.2.3",
            appDirs.getUserCacheDir("myapp", "1.2.3", "syer")
        )
    }

    @Test
    open fun testGetUserLogDir() {
        assertEquals(
            "$home/Library/Logs",
            appDirs.getUserLogDir(null, null, null)
        )
        assertEquals(
            "$home/Library/Logs/myapp",
            appDirs.getUserLogDir("myapp", null, null)
        )
        assertEquals(
            "$home/Library/Logs/myapp/1.2.3",
            appDirs.getUserLogDir("myapp", "1.2.3", null)
        )
        assertEquals(
            "$home/Library/Logs/myapp/1.2.3",
            appDirs.getUserLogDir("myapp", "1.2.3", "syer")
        )
    }

    @Test
    open fun testSiteDataDir() {
        assertEquals(
            "/Library/Application Support",
            appDirs.getSiteDataDir(null, null, null)
        )
        assertEquals(
            "/Library/Application Support",
            appDirs.getSiteDataDir(null, null, null, true)
        )
        assertEquals(
            "/Library/Application Support/myapp",
            appDirs.getSiteDataDir("myapp", null, null)
        )
        assertEquals(
            "/Library/Application Support/myapp",
            appDirs.getSiteDataDir("myapp", null, null, true)
        )
        assertEquals(
            "/Library/Application Support/myapp/1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", null)
        )
        assertEquals(
            "/Library/Application Support/myapp/1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", null, true)
        )
        assertEquals(
            "/Library/Application Support/myapp/1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", "syer")
        )
        assertEquals(
            "/Library/Application Support/myapp/1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", "syer", true)
        )
    }

    @Test
    open fun testSiteConfigDir() {
        assertEquals(
            "/Library/Preferences",
            appDirs.getSiteConfigDir(null, null, null)
        )
        assertEquals(
            "/Library/Preferences",
            appDirs.getSiteConfigDir(null, null, null, true)
        )
        assertEquals(
            "/Library/Preferences/myapp",
            appDirs.getSiteConfigDir("myapp", null, null)
        )
        assertEquals(
            "/Library/Preferences/myapp",
            appDirs.getSiteConfigDir("myapp", null, null, true)
        )
        assertEquals(
            "/Library/Preferences/myapp/1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", null)
        )
        assertEquals(
            "/Library/Preferences/myapp/1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", null, true)
        )
        assertEquals(
            "/Library/Preferences/myapp/1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", "syer")
        )
        assertEquals(
            "/Library/Preferences/myapp/1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", "syer", true)
        )
    }

    @Test
    open fun testgetSharedDir() {
        assertEquals(
            "/Users/Shared/Library/Application Support",
            appDirs.getSharedDir(null, null, null)
        )
        assertEquals(
            "/Users/Shared/Library/Application Support/myapp",
            appDirs.getSharedDir("myapp", null, null)
        )
        assertEquals(
            "/Users/Shared/Library/Application Support/myapp/1.2.3",
            appDirs.getSharedDir("myapp", "1.2.3", null)
        )
        assertEquals(
            "/Users/Shared/Library/Application Support/myapp/1.2.3",
            appDirs.getSharedDir("myapp", "1.2.3", "syer")
        )
    }
}