package ca.gosyer.appdirs.impl

import ca.gosyer.appdirs.impl.WindowsAppDirs.FolderId
import node.process.process

internal class ShellFolderResolver : WindowsFolderResolver {
    override operator fun get(folderId: FolderId): String {
        return when (folderId) {
            FolderId.APPDATA -> process.env["APPDATA"].unsafeCast<String>()
            FolderId.LOCAL_APPDATA -> process.env["LOCALAPPDATA"].unsafeCast<String>()
            FolderId.COMMON_APPDATA -> process.env["PROGRAMDATA"].unsafeCast<String>()
        }
    }
}