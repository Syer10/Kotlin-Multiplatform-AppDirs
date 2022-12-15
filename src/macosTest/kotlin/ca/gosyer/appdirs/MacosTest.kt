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
}