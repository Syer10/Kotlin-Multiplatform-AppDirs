package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.UnixAppDirs
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class UnixTest : AppDirsTest({ UnixAppDirs(UnixTestEnvResolver(emptyMap())) }) {
    @Test
    fun testRealPathLinuxUserDataDir() {
        assertEquals(
            "$home/.local/share",
            appDirs.getUserDataDir(null, null, null)
        )
    }

    @Test
    fun testRealPathLinuxUserConfigDir() {
        assertEquals("$home/.config", appDirs.getUserConfigDir(null, null, null))
    }

    @Test
    fun testRealPathLinuxUserCacheDir() {
        assertEquals("$home/.cache", appDirs.getUserCacheDir(null, null, null))
    }

    @Test
    fun testRealPathLinuxUserLogDir() {
        assertEquals(
            "$home/.cache/logs",
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

    @Test
    fun testGetUserDataDir() {
        assertEquals(
            "$home/.local/share",
            appDirs.getUserDataDir(null, null, null)
        )
        assertEquals(
            "$home/.local/share",
            appDirs.getUserDataDir(null, null, null, true)
        )
        assertEquals(
            "$home/.local/share/myapp",
            appDirs.getUserDataDir("myapp", null, null)
        )
        assertEquals(
            "$home/.local/share/myapp",
            appDirs.getUserDataDir("myapp", null, null, true)
        )
        assertEquals(
            "$home/.local/share/myapp/1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", null)
        )
        assertEquals(
            "$home/.local/share/myapp/1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", null, true)
        )
        assertEquals(
            "$home/.local/share/myapp/1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", "syer")
        )
        assertEquals(
            "$home/.local/share/myapp/1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", "syer", true)
        )
    }

    @Test
    fun testGetUserConfigDir() {
        assertEquals(
            "$home/.config",
            appDirs.getUserConfigDir(null, null, null)
        )
        assertEquals(
            "$home/.config",
            appDirs.getUserConfigDir(null, null, null, true)
        )
        assertEquals(
            "$home/.config/myapp",
            appDirs.getUserConfigDir("myapp", null, null)
        )
        assertEquals(
            "$home/.config/myapp",
            appDirs.getUserConfigDir("myapp", null, null, true)
        )
        assertEquals(
            "$home/.config/myapp/1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", null)
        )
        assertEquals(
            "$home/.config/myapp/1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", null, true)
        )
        assertEquals(
            "$home/.config/myapp/1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", "syer")
        )
        assertEquals(
            "$home/.config/myapp/1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", "syer", true)
        )
    }

    @Test
    fun testGetUserCacheDir() {
        assertEquals(
            "$home/.cache",
            appDirs.getUserCacheDir(null, null, null)
        )
        assertEquals(
            "$home/.cache/myapp",
            appDirs.getUserCacheDir("myapp", null, null)
        )
        assertEquals(
            "$home/.cache/myapp/1.2.3",
            appDirs.getUserCacheDir("myapp", "1.2.3", null)
        )
        assertEquals(
            "$home/.cache/myapp/1.2.3",
            appDirs.getUserCacheDir("myapp", "1.2.3", "syer")
        )
    }

    @Test
    fun testGetUserLogDir() {
        assertEquals(
            "$home/.cache/logs",
            appDirs.getUserLogDir(null, null, null)
        )
        assertEquals(
            "$home/.cache/myapp/logs",
            appDirs.getUserLogDir("myapp", null, null)
        )
        assertEquals(
            "$home/.cache/myapp/logs/1.2.3",
            appDirs.getUserLogDir("myapp", "1.2.3", null)
        )
        assertEquals(
            "$home/.cache/myapp/logs/1.2.3",
            appDirs.getUserLogDir("myapp", "1.2.3", "syer")
        )
    }

    @Test
    fun testSiteDataDir() {
        assertEquals("/usr/local/share", appDirs.getSiteDataDir(null, null, null))
        assertEquals(
            "/usr/local/share:/usr/share",
            appDirs.getSiteDataDir(null, null, null, true)
        )
        assertEquals(
            "/usr/local/share/myapp",
            appDirs.getSiteDataDir("myapp", null, null)
        )
        assertEquals(
            "/usr/local/share/myapp:/usr/share/myapp",
            appDirs.getSiteDataDir("myapp", null, null, true)
        )
        assertEquals(
            "/usr/local/share/myapp/1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", null)
        )
        assertEquals(
            "/usr/local/share/myapp/1.2.3:/usr/share/myapp/1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", null, true)
        )
        assertEquals(
            "/usr/local/share/myapp/1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", "syer")
        )
        assertEquals(
            "/usr/local/share/myapp/1.2.3:/usr/share/myapp/1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", "syer", true)
        )
    }

    @Test
    fun testSiteConfigDir() {
        assertEquals("/etc/xdg", appDirs.getSiteConfigDir(null, null, null))
        assertEquals("/etc/xdg", appDirs.getSiteConfigDir(null, null, null, true))
        assertEquals(
            "/etc/xdg/myapp",
            appDirs.getSiteConfigDir("myapp", null, null)
        )
        assertEquals(
            "/etc/xdg/myapp",
            appDirs.getSiteConfigDir("myapp", null, null, true)
        )
        assertEquals(
            "/etc/xdg/myapp/1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", null)
        )
        assertEquals(
            "/etc/xdg/myapp/1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", null, true)
        )
        assertEquals(
            "/etc/xdg/myapp/1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", "syer")
        )
        assertEquals(
            "/etc/xdg/myapp/1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", "syer", true)
        )
    }

    @Test
    fun testEnvironmentVariables() {
        val appDirs = UnixAppDirs(
            UnixTestEnvResolver(
                mapOf(
                    UnixAppDirs.XDG_DATA_HOME to "/data_home",
                    UnixAppDirs.XDG_CONFIG_HOME to "/config_home",
                    UnixAppDirs.XDG_CACHE_HOME to "/cache_home",
                    UnixAppDirs.XDG_DATA_DIRS to "/data_dir:/opt/data_dir",
                    UnixAppDirs.XDG_CONFIG_DIRS to "/config_dir:/opt/config_dir"
                )
            )
        )
        assertEquals(
            "/data_home/myapp/1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", "syer", true)
        )
        assertEquals(
            "/config_home/myapp/1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", "syer", true)
        )
        assertEquals(
            "/cache_home/myapp/1.2.3",
            appDirs.getUserCacheDir("myapp", "1.2.3", "syer")
        )
        assertEquals(
            "/cache_home/myapp/logs/1.2.3",
            appDirs.getUserLogDir("myapp", "1.2.3", "syer")
        )
        assertEquals(
            "/data_dir/myapp/1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", null)
        )
        assertEquals(
            "/data_dir/myapp/1.2.3:/opt/data_dir/myapp/1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", null, true)
        )
        assertEquals(
            "/config_dir/myapp/1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", null)
        )
        assertEquals(
            "/config_dir/myapp/1.2.3:/opt/config_dir/myapp/1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", "syer", true)
        )
    }

    @Test
    fun testgetSharedDir() {
        assertEquals("/srv", appDirs.getSharedDir(null, null, null))
        assertEquals("/srv/myapp", appDirs.getSharedDir("myapp", null, null))
        assertEquals(
            "/srv/myapp/1.2.3",
            appDirs.getSharedDir("myapp", "1.2.3", null)
        )
        assertEquals(
            "/srv/myapp/1.2.3",
            appDirs.getSharedDir("myapp", "1.2.3", "syer")
        )
    }
}