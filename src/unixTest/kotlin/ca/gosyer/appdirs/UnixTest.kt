package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.UnixAppDirs
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class UnixTest : AppDirsTest() {
    fun AppDirs(
        appName: String?,
        appAuthor: String?,
        vararg extra: String,
    ): AppDirs {
        return UnixAppDirs(appName, appAuthor, *extra, envResolver = UnixTestEnvResolver(emptyMap()))
    }

    @Test
    fun testRealPathLinuxUserDataDir() {
        assertEquals(
            "$home/.local/share",
            AppDirs(null).getUserDataDir()
        )
    }

    @Test
    fun testRealPathLinuxUserConfigDir() {
        assertEquals("$home/.config", AppDirs(null).getUserConfigDir())
    }

    @Test
    fun testRealPathLinuxUserCacheDir() {
        assertEquals("$home/.cache", AppDirs(null).getUserCacheDir())
    }

    @Test
    fun testRealPathLinuxUserLogDir() {
        assertEquals(
            "$home/.cache/logs",
            AppDirs(null).getUserLogDir()
        )
    }

    @Test
    fun testRealPathLinuxSiteDataDir() {
        assertEquals("/usr/local/share", AppDirs(null).getSiteDataDir())
    }

    @Test
    fun testRealPathLinuxSiteConfigDir() {
        assertEquals("/etc/xdg", AppDirs(null).getSiteConfigDir())
    }

    @Test
    fun testRealPathLinuxSharedDir() {
        assertEquals("/srv", AppDirs(null).getSharedDir())
    }

    @Test
    fun testGetUserDataDir() {
        assertEquals(
            "$home/.local/share",
            AppDirs(null).getUserDataDir()
        )
        assertEquals(
            "$home/.local/share",
            AppDirs(null).getUserDataDir(true)
        )
        assertEquals(
            "$home/.local/share/myapp",
            AppDirs("myapp").getUserDataDir()
        )
        assertEquals(
            "$home/.local/share/myapp",
            AppDirs("myapp").getUserDataDir(true)
        )
        assertEquals(
            "$home/.local/share/myapp/1.2.3",
            AppDirs("myapp", null, "1.2.3").getUserDataDir()
        )
        assertEquals(
            "$home/.local/share/myapp/1.2.3",
            AppDirs("myapp", null, "1.2.3").getUserDataDir(true)
        )
        assertEquals(
            "$home/.local/share/myapp/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getUserDataDir()
        )
        assertEquals(
            "$home/.local/share/myapp/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getUserDataDir(true)
        )
    }

    @Test
    fun testGetUserConfigDir() {
        assertEquals(
            "$home/.config",
            AppDirs(null).getUserConfigDir()
        )
        assertEquals(
            "$home/.config",
            AppDirs(null).getUserConfigDir(true)
        )
        assertEquals(
            "$home/.config/myapp",
            AppDirs("myapp").getUserConfigDir()
        )
        assertEquals(
            "$home/.config/myapp",
            AppDirs("myapp").getUserConfigDir(true)
        )
        assertEquals(
            "$home/.config/myapp/1.2.3",
            AppDirs("myapp", null, "1.2.3").getUserConfigDir()
        )
        assertEquals(
            "$home/.config/myapp/1.2.3",
            AppDirs("myapp", null, "1.2.3").getUserConfigDir(true)
        )
        assertEquals(
            "$home/.config/myapp/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getUserConfigDir()
        )
        assertEquals(
            "$home/.config/myapp/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getUserConfigDir(true)
        )
    }

    @Test
    fun testGetUserCacheDir() {
        assertEquals(
            "$home/.cache",
            AppDirs(null).getUserCacheDir()
        )
        assertEquals(
            "$home/.cache/myapp",
            AppDirs("myapp").getUserCacheDir()
        )
        assertEquals(
            "$home/.cache/myapp/1.2.3",
            AppDirs("myapp", null, "1.2.3").getUserCacheDir()
        )
        assertEquals(
            "$home/.cache/myapp/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getUserCacheDir()
        )
    }

    @Test
    fun testGetUserLogDir() {
        assertEquals(
            "$home/.cache/logs",
            AppDirs(null).getUserLogDir()
        )
        assertEquals(
            "$home/.cache/myapp/logs",
            AppDirs("myapp").getUserLogDir()
        )
        assertEquals(
            "$home/.cache/myapp/logs/1.2.3",
            AppDirs("myapp", null, "1.2.3").getUserLogDir()
        )
        assertEquals(
            "$home/.cache/myapp/logs/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getUserLogDir()
        )
    }

    @Test
    fun testSiteDataDir() {
        assertEquals("/usr/local/share", AppDirs(null).getSiteDataDir())
        assertEquals(
            "/usr/local/share:/usr/share",
            AppDirs(null).getSiteDataDir(true)
        )
        assertEquals(
            "/usr/local/share/myapp",
            AppDirs("myapp").getSiteDataDir()
        )
        assertEquals(
            "/usr/local/share/myapp:/usr/share/myapp",
            AppDirs("myapp").getSiteDataDir(true)
        )
        assertEquals(
            "/usr/local/share/myapp/1.2.3",
            AppDirs("myapp", null, "1.2.3").getSiteDataDir()
        )
        assertEquals(
            "/usr/local/share/myapp/1.2.3:/usr/share/myapp/1.2.3",
            AppDirs("myapp", null, "1.2.3").getSiteDataDir(true)
        )
        assertEquals(
            "/usr/local/share/myapp/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getSiteDataDir()
        )
        assertEquals(
            "/usr/local/share/myapp/1.2.3:/usr/share/myapp/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getSiteDataDir(true)
        )
    }

    @Test
    fun testSiteConfigDir() {
        assertEquals("/etc/xdg", AppDirs(null).getSiteConfigDir())
        assertEquals("/etc/xdg", AppDirs(null).getSiteConfigDir(true))
        assertEquals(
            "/etc/xdg/myapp",
            AppDirs("myapp").getSiteConfigDir()
        )
        assertEquals(
            "/etc/xdg/myapp",
            AppDirs("myapp").getSiteConfigDir(true)
        )
        assertEquals(
            "/etc/xdg/myapp/1.2.3",
            AppDirs("myapp", null, "1.2.3").getSiteConfigDir()
        )
        assertEquals(
            "/etc/xdg/myapp/1.2.3",
            AppDirs("myapp", null, "1.2.3").getSiteConfigDir(true)
        )
        assertEquals(
            "/etc/xdg/myapp/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getSiteConfigDir()
        )
        assertEquals(
            "/etc/xdg/myapp/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getSiteConfigDir(true)
        )
    }

    @Test
    fun testEnvironmentVariables() {
        fun AppDirs(
            appName: String?,
            appAuthor: String?,
            vararg extra: String,
        ) = UnixAppDirs(
            appName, appAuthor, *extra,
            envResolver = UnixTestEnvResolver(
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
            AppDirs("myapp", "syer", "1.2.3").getUserDataDir(true)
        )
        assertEquals(
            "/config_home/myapp/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getUserConfigDir(true)
        )
        assertEquals(
            "/cache_home/myapp/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getUserCacheDir()
        )
        assertEquals(
            "/cache_home/myapp/logs/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getUserLogDir()
        )
        assertEquals(
            "/data_dir/myapp/1.2.3",
            AppDirs("myapp", null, "1.2.3").getSiteDataDir()
        )
        assertEquals(
            "/data_dir/myapp/1.2.3:/opt/data_dir/myapp/1.2.3",
            AppDirs("myapp", null, "1.2.3").getSiteDataDir(true)
        )
        assertEquals(
            "/config_dir/myapp/1.2.3",
            AppDirs("myapp", null, "1.2.3").getSiteConfigDir()
        )
        assertEquals(
            "/config_dir/myapp/1.2.3:/opt/config_dir/myapp/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getSiteConfigDir(true)
        )
    }

    @Test
    fun testgetSharedDir() {
        assertEquals("/srv", AppDirs(null).getSharedDir())
        assertEquals("/srv/myapp", AppDirs("myapp").getSharedDir())
        assertEquals(
            "/srv/myapp/1.2.3",
            AppDirs("myapp", null, "1.2.3").getSharedDir()
        )
        assertEquals(
            "/srv/myapp/1.2.3",
            AppDirs("myapp", "syer", "1.2.3").getSharedDir()
        )
    }
}