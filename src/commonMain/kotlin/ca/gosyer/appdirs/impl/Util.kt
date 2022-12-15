package ca.gosyer.appdirs.impl

internal expect fun home(): String

internal expect fun fileSeparator() : String

internal expect fun pathSeparator() : String

internal fun buildPath(vararg elems: String?) = buildString {
    val separator = fileSeparator()
    var lastElem: String? = null
    for (elem in elems) {
        if (elem == null) {
            continue
        }
        if (lastElem == null) {
            append(elem)
        } else if (lastElem.endsWith(separator)) {
            append(if (elem.startsWith(separator)) elem.substring(1) else elem)
        } else {
            if (!elem.startsWith(separator)) {
                append(separator)
            }
            append(elem)
        }
        lastElem = elem
    }
}

internal fun joinPaths(paths: List<String>): String {
    val separator = pathSeparator()
    return buildString {
        paths.forEach { path ->
            if (isNotEmpty()) {
                append(separator)
            }
            append(path)
        }
    }
}

internal fun splitPaths(paths: String): List<String> {
    return paths.split(pathSeparator()).dropLastWhile { it.isEmpty() }
}