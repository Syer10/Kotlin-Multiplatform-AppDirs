package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.UnixAppDirs
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class UnixTest : AppDirsTest(OS.LINUX) {
    private fun AppDirs(
        appName: String?,
        appAuthor: String?,
        vararg extra: String,
    ): AppDirs {
        return UnixAppDirs(
            AppDirsConfig().apply {
                this.appName = appName
                this.appAuthor = appAuthor
                this.extras = extra
            },
            envResolver = UnixTestEnvResolver(emptyMap())
        )
    }

    @Test
    fun testRealPathLinuxUserDataDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home/.local/share",
            AppDirs { appName = null }.getUserDataDir()
        )
    }

    @Test
    fun testRealPathLinuxUserConfigDir() {
        if (!isCurrentOs) return
        assertEquals("$home/.config", AppDirs { appName = null }.getUserConfigDir())
    }

    @Test
    fun testRealPathLinuxUserCacheDir() {
        if (!isCurrentOs) return
        assertEquals("$home/.cache", AppDirs { appName = null }.getUserCacheDir())
    }

    @Test
    fun testRealPathLinuxUserLogDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home/.cache/logs",
            AppDirs { appName = null }.getUserLogDir()
        )
    }

    @Test
    fun testRealPathLinuxSiteDataDir() {
        if (!isCurrentOs) return
        assertEquals("/usr/local/share", AppDirs { appName = null }.getSiteDataDir())
    }

    @Test
    fun testRealPathLinuxSiteConfigDir() {
        if (!isCurrentOs) return
        assertEquals("/etc/xdg", AppDirs { appName = null }.getSiteConfigDir())
    }

    @Test
    fun testRealPathLinuxSharedDir() {
        if (!isCurrentOs) return
        assertEquals("/srv", AppDirs { appName = null }.getSharedDir())
    }

    @Test
    fun testGetUserDataDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home/.local/share",
            AppDirs { appName = null }.getUserDataDir()
        )
        assertEquals(
            "$home/.local/share",
            AppDirs { appName = null }.getUserDataDir(true)
        )
        assertEquals(
            "$home/.local/share/myapp",
            AppDirs { appName = "myapp" }.getUserDataDir()
        )
        assertEquals(
            "$home/.local/share/myapp",
            AppDirs { appName = "myapp" }.getUserDataDir(true)
        )
        assertEquals(
            "$home/.local/share/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getUserDataDir()
        )
        assertEquals(
            "$home/.local/share/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getUserDataDir(true)
        )
        assertEquals(
            "$home/.local/share/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getUserDataDir()
        )
        assertEquals(
            "$home/.local/share/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getUserDataDir(true)
        )
    }

    @Test
    fun testGetUserConfigDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home/.config",
            AppDirs { appName = null }.getUserConfigDir()
        )
        assertEquals(
            "$home/.config",
            AppDirs { appName = null }.getUserConfigDir(true)
        )
        assertEquals(
            "$home/.config/myapp",
            AppDirs { appName = "myapp" }.getUserConfigDir()
        )
        assertEquals(
            "$home/.config/myapp",
            AppDirs { appName = "myapp" }.getUserConfigDir(true)
        )
        assertEquals(
            "$home/.config/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getUserConfigDir()
        )
        assertEquals(
            "$home/.config/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getUserConfigDir(true)
        )
        assertEquals(
            "$home/.config/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getUserConfigDir()
        )
        assertEquals(
            "$home/.config/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getUserConfigDir(
                true
            )
        )
    }

    @Test
    fun testGetUserCacheDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home/.cache",
            AppDirs { appName = null }.getUserCacheDir()
        )
        assertEquals(
            "$home/.cache/myapp",
            AppDirs { appName = "myapp" }.getUserCacheDir()
        )
        assertEquals(
            "$home/.cache/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getUserCacheDir()
        )
        assertEquals(
            "$home/.cache/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getUserCacheDir()
        )
    }

    @Test
    fun testGetUserLogDir() {
        if (!isCurrentOs) return
        assertEquals(
            "$home/.local/state/logs",
            AppDirs { appName = null }.getUserLogDir()
        )
        assertEquals(
            "$home/.local/state/myapp/logs",
            AppDirs { appName = "myapp" }.getUserLogDir()
        )
        assertEquals(
            "$home/.local/state/myapp/logs/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getUserLogDir()
        )
        assertEquals(
            "$home/.local/state/myapp/logs/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getUserLogDir()
        )
    }

    @Test
    fun testSiteDataDir() {
        if (!isCurrentOs) return
        assertEquals("/usr/local/share", AppDirs { appName = null }.getSiteDataDir())
        assertEquals(
            "/usr/local/share:/usr/share",
            AppDirs { appName = null }.getSiteDataDir(true)
        )
        assertEquals(
            "/usr/local/share/myapp",
            AppDirs { appName = "myapp" }.getSiteDataDir()
        )
        assertEquals(
            "/usr/local/share/myapp:/usr/share/myapp",
            AppDirs { appName = "myapp" }.getSiteDataDir(true)
        )
        assertEquals(
            "/usr/local/share/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getSiteDataDir()
        )
        assertEquals(
            "/usr/local/share/myapp/1.2.3:/usr/share/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getSiteDataDir(true)
        )
        assertEquals(
            "/usr/local/share/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getSiteDataDir()
        )
        assertEquals(
            "/usr/local/share/myapp/1.2.3:/usr/share/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getSiteDataDir(true)
        )
    }

    @Test
    fun testSiteConfigDir() {
        if (!isCurrentOs) return
        assertEquals("/etc/xdg", AppDirs { appName = null }.getSiteConfigDir())
        assertEquals("/etc/xdg", AppDirs { appName = null }.getSiteConfigDir(true))
        assertEquals(
            "/etc/xdg/myapp",
            AppDirs { appName = "myapp" }.getSiteConfigDir()
        )
        assertEquals(
            "/etc/xdg/myapp",
            AppDirs { appName = "myapp" }.getSiteConfigDir(true)
        )
        assertEquals(
            "/etc/xdg/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getSiteConfigDir()
        )
        assertEquals(
            "/etc/xdg/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getSiteConfigDir(true)
        )
        assertEquals(
            "/etc/xdg/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getSiteConfigDir()
        )
        assertEquals(
            "/etc/xdg/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getSiteConfigDir(
                true
            )
        )
    }

    @Test
    fun testEnvironmentVariables() {
        if (!isCurrentOs) return
        fun AppDirs(
            appName: String?,
            appAuthor: String?,
            vararg extra: String,
        ) = UnixAppDirs(
            AppDirsConfig().apply {
                this.appName = appName
                this.appAuthor = appAuthor
                this.extras = extra
            },
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
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getUserDataDir(true)
        )
        assertEquals(
            "/config_home/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getUserConfigDir(
                true
            )
        )
        assertEquals(
            "/cache_home/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getUserCacheDir()
        )
        assertEquals(
            "/cache_home/myapp/logs/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getUserLogDir()
        )
        assertEquals(
            "/data_dir/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getSiteDataDir()
        )
        assertEquals(
            "/data_dir/myapp/1.2.3:/opt/data_dir/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getSiteDataDir(true)
        )
        assertEquals(
            "/config_dir/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getSiteConfigDir()
        )
        assertEquals(
            "/config_dir/myapp/1.2.3:/opt/config_dir/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getSiteConfigDir(
                true
            )
        )
    }

    @Test
    fun testgetSharedDir() {
        if (!isCurrentOs) return
        assertEquals("/srv", AppDirs { appName = null }.getSharedDir())
        assertEquals("/srv/myapp", AppDirs { appName = "myapp" }.getSharedDir())
        assertEquals(
            "/srv/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = null; extras("1.2.3"); }.getSharedDir()
        )
        assertEquals(
            "/srv/myapp/1.2.3",
            AppDirs { appName = "myapp"; appAuthor = "syer"; extras("1.2.3"); }.getSharedDir()
        )
    }
}