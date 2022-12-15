package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.UnixAppDirs
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class UnixTest : AppDirsTest(::UnixAppDirs) {
    @Test
    fun testRealPathLinuxUserDataDir() {
        assertEquals(
            home + "/.local/share",
            appDirs.getUserDataDir(null, null, null)
        )
    }

    @Test
    fun testRealPathLinuxUserConfigDir() {
        assertEquals(home + "/.config", appDirs.getUserConfigDir(null, null, null))
    }

    @Test
    fun testRealPathLinuxUserCacheDir() {
        assertEquals(home + "/.cache", appDirs.getUserCacheDir(null, null, null))
    }

    @Test
    fun testRealPathLinuxUserLogDir() {
        assertEquals(
            home + "/.cache/logs",
            appDirs.getUserLogDir(null, null, null)
        )
    }

    @Test
    fun testRealPathLinuxSiteDataDir() {
        assertEquals("/usr/local/share", appDirs.getSiteDataDir(null, null, null))
    }

    @Test
    fun testRealPathLinuxSiteConfigDir() {
        assertEquals("/etc/xdg", appDirs.getSiteConfigDir(null, null, null))
    }

    @Test
    fun testRealPathLinuxSharedDir() {
        assertEquals("/srv", appDirs.getSharedDir(null, null, null))
    }
}