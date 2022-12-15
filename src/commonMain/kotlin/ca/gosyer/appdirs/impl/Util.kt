package ca.gosyer.appdirs.impl

internal expect fun home(): String

internal expect fun fileSeparator() : String

internal expect fun pathSeparator() : String

internal fun buildPath(vararg elems: String?): String {
    return buildString {
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
}

internal fun joinPaths(vararg paths: String): String {
    val separator = pathSeparator()
    val buffer = StringBuilder()
    paths.forEach { path ->
        if (buffer.isNotEmpty()) {
            buffer.append(separator)
        }
        buffer.append(path)
    }
    return buffer.toString()
}

internal fun splitPaths(paths: String): Array<String> {
    return paths.split(pathSeparator()).dropLastWhile { it.isEmpty() }.toTypedArray()
}