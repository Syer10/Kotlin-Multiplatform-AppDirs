package ca.gosyer.appdirs.impl

import ca.gosyer.appdirs.AppDirsException
import ca.gosyer.appdirs.impl.WindowsAppDirs.FolderId
import com.sun.jna.platform.win32.Guid.GUID
import com.sun.jna.platform.win32.KnownFolders
import com.sun.jna.platform.win32.Shell32Util
import com.sun.jna.platform.win32.ShlObj
import com.sun.jna.platform.win32.Win32Exception

internal class ShellFolderResolver : WindowsFolderResolver {
    override fun resolveFolder(folderId: FolderId): String {
        return try {
            Shell32Util.getKnownFolderPath(convertFolderIdToGuid(folderId))
        } catch (e: Win32Exception) {
            throw AppDirsException(
                "SHGetKnownFolderPath returns an error: " + e.errorCode
            )
        } catch (e: UnsatisfiedLinkError) {
            // Fallback for pre-vista OSes. #5
            try {
                val folder = convertFolderIdToCsidl(folderId)
                Shell32Util.getFolderPath(folder)
            } catch (e2: Win32Exception) {
                throw AppDirsException(
                    "SHGetFolderPath returns an error: " + e2.errorCode
                )
            }
        }
    }

    private fun convertFolderIdToGuid(folderId: FolderId): GUID {
        return when (folderId) {
            FolderId.APPDATA -> KnownFolders.FOLDERID_RoamingAppData
            FolderId.LOCAL_APPDATA -> KnownFolders.FOLDERID_LocalAppData
            FolderId.COMMON_APPDATA -> KnownFolders.FOLDERID_ProgramData
        }
    }

    private fun convertFolderIdToCsidl(folderId: FolderId): Int {
        return when (folderId) {
            FolderId.APPDATA -> ShlObj.CSIDL_APPDATA
            FolderId.LOCAL_APPDATA -> ShlObj.CSIDL_LOCAL_APPDATA
            FolderId.COMMON_APPDATA -> ShlObj.CSIDL_COMMON_APPDATA
        }
    }
}