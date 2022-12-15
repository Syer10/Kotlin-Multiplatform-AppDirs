package ca.gosyer.appdirs.impl

interface WindowsFolderResolver {
    operator fun get(folderId: WindowsAppDirs.FolderId): String
}