package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.LinuxEnvResolver
import ca.gosyer.appdirs.impl.UnixAppDirs

fun AppDirs(): AppDirs {
    return UnixAppDirs(LinuxEnvResolver())
}