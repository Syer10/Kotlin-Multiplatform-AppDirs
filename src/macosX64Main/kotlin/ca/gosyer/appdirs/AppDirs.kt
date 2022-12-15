package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.MacOSXAppDirs

fun AppDirs(): AppDirs {
    return MacOSXAppDirs()
}