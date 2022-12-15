package ca.gosyer.appdirs.impl

import ca.gosyer.appdirs.AppDirsException
import ca.gosyer.appdirs.impl.WindowsAppDirs.FolderId
import kotlinx.cinterop.alloc
import kotlinx.cinterop.cValue
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.toKStringFromUtf16
import kotlinx.cinterop.value
import platform.posix.GUID
import platform.windows.CSIDL_APPDATA
import platform.windows.CSIDL_COMMON_APPDATA
import platform.windows.CSIDL_LOCAL_APPDATA
import platform.windows.FOLDERID_LocalAppData
import platform.windows.FOLDERID_ProgramData
import platform.windows.FOLDERID_RoamingAppData
import platform.windows.KNOWNFOLDERID
import platform.windows.LPWSTRVar
import platform.windows.PWSTRVar
import platform.windows.SHGetFolderPathW
import platform.windows.SHGetKnownFolderPath

internal class ShellFolderResolver : WindowsFolderResolver {
    override fun resolveFolder(folderId: FolderId): String {
        return try {
            memScoped {
                val result = alloc<PWSTRVar>()
                check(SHGetKnownFolderPath(convertFolderIdToGuid(folderId).ptr, 0, null, result.ptr) >= 0)
                result.value!!.toKStringFromUtf16()
            }
        } catch (e: NullPointerException) {
            throw AppDirsException(
                "SHGetKnownFolderPath returns an error: " + e.message
            )
        } catch (e: Exception) {
            // Fallback for pre-vista OSes. #5
            try {
                memScoped {
                    val result = alloc<LPWSTRVar>()
                    check(SHGetFolderPathW(null, convertFolderIdToCsidl(folderId), null, 0, result.value) >= 0)
                    result.value!!.toKStringFromUtf16()
                }
            } catch (e2: Exception) {
                throw AppDirsException(
                    "SHGetFolderPath returns an error: " + e2.message
                )
            }
        }
    }

    private fun convertFolderIdToGuid(folderId: FolderId): GUID {
        return when (folderId) {
            FolderId.APPDATA -> FOLDERID_RoamingAppData
            FolderId.LOCAL_APPDATA -> FOLDERID_LocalAppData
            FolderId.COMMON_APPDATA -> FOLDERID_ProgramData
        }
    }

    private fun convertFolderIdToCsidl(folderId: FolderId): Int {
        return when (folderId) {
            FolderId.APPDATA -> CSIDL_APPDATA
            FolderId.LOCAL_APPDATA -> CSIDL_LOCAL_APPDATA
            FolderId.COMMON_APPDATA -> CSIDL_COMMON_APPDATA
        }
    }
}