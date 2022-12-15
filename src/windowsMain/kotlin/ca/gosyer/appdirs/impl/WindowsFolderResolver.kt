package ca.gosyer.appdirs.impl

interface WindowsFolderResolver {
    fun resolveFolder(folderId: WindowsAppDirs.FolderId): String
}