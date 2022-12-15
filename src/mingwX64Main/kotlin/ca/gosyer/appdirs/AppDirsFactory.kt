package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.ShellFolderResolver
import ca.gosyer.appdirs.impl.WindowsAppDirs

fun AppDirs() : AppDirs {
    return WindowsAppDirs(ShellFolderResolver())
}