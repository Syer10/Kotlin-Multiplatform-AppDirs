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
    override operator fun get(folderId: FolderId): String {
        return try {
            memScoped {
                val result = alloc<PWSTRVar>()
                val hResult = SHGetKnownFolderPath(convertFolderIdToGuid(folderId).ptr, 0, null, result.ptr)
                if (hResult < 0) {
                    throw AppDirsException(
                        "SHGetKnownFolderPath returns an error: $hResult"
                    )
                }
                result.value!!.toKStringFromUtf16()
            }
        } catch (e: Exception) {
            if (e is AppDirsException) throw e
            // Fallback for pre-vista OSes. #5
            try {
                memScoped {
                    val result = alloc<LPWSTRVar>()
                    val hResult = SHGetFolderPathW(null, convertFolderIdToCsidl(folderId), null, 0, result.value)
                    if (hResult < 0) {
                        throw AppDirsException(
                            "SHGetKnownFolderPath returns an error: $hResult"
                        )
                    }
                    result.value!!.toKStringFromUtf16()
                }
            } catch (e2: Exception) {
                if (e2 is AppDirsException) throw e2
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