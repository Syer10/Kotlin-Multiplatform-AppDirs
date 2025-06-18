package ca.gosyer.appdirs.impl

import android.content.Context
import ca.gosyer.appdirs.AppDirs
import ca.gosyer.appdirs.AppDirsConfig
import java.io.File

class AndroidAppDirs(
    private val context: Context,
    appDirsConfig: AppDirsConfig,
): AppDirs {
    private val extras = appDirsConfig.extras.joinToString(pathSeparator())

    override fun getUserDataDir(roaming: Boolean): String {
        return getUserDir("data")
    }

    override fun getUserCacheDir(): String {
        return File(context.cacheDir, extras).canonicalPath
    }

    override fun getUserConfigDir(roaming: Boolean): String {
        return getUserDir("config")
    }

    override fun getUserLogDir(): String {
        return getUserDir("logs")
    }

    private fun getUserDir(type: String, mode: Int = Context.MODE_PRIVATE): String {
        return File(context.getDir(type, mode), extras).canonicalPath
    }

    override fun getSiteDataDir(multiPath: Boolean): String {
        return context.getExternalFilesDir("data")!!.canonicalPath
    }

    override fun getSiteConfigDir(multiPath: Boolean): String {
        return context.getExternalFilesDir("config")!!.canonicalPath
    }

    override fun getSharedDir(): String {
        return context.getExternalFilesDir("shared")!!.canonicalPath
    }
}