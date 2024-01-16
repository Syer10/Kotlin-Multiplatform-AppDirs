package ca.gosyer.appdirs.impl

import android.app.Application
import android.content.Context
import ca.gosyer.appdirs.AppDirsException
import java.lang.ref.WeakReference

internal actual fun home(): String {
    throw UnsupportedOperationException()
}

internal actual fun pathSeparator(): String = "/"

internal actual fun fileSeparator(): String = ":"

private var _Context: WeakReference<Context>? = null
internal val ContextRef: Context get() {
    return _Context?.get() ?: throw AppDirsException("In android target, please call Application#attachAppDirs() first!")
}

fun Application.attachAppDirs() {
    _Context = WeakReference(this)
}
