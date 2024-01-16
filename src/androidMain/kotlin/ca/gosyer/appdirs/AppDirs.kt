package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.AndroidAppDirs
import ca.gosyer.appdirs.impl.ContextRef

actual fun AppDirs(
    appName: String?,
    appAuthor: String?,
    vararg extra: String
): AppDirs = AndroidAppDirs(
    context = ContextRef,
    extra = extra,
)