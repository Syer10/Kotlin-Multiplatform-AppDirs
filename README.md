Kotlin Multiplatform AppDirs
=======

## Overview

__Kotlin Multiplatform AppDirs__ is a small library which provides a path to the platform dependent special folder/directory.

For example, here are the common paths of the folder/directory that is used to store application specific user data on each platform.

On Mac OS X : ```/Users/<Account>/Library/Application Support/<AppName>```  
On Windows XP : ```C:\Documents and Settings\<Account>\Application Data\Local Settings\<AppAuthor>\<AppName>```  
On Windows 7 : ```C:\Users\<Account>\AppData\<AppAuthor>\<AppName>```  
On Unix/Linux : ```/home/<account>/.local/share/<AppName>```  
On Android (internal) : ```/data/user/<uid>/<packageName>```  
On Android (external) : ```/storage/emulated/<storageId>/Android/data/<packageName>```  

With __Kotlin Multiplatform AppDirs__, you can get the path depending on the runtime platform with the following code.

```kotlin
val appDirs = AppDirs("<AppName>", "<AppAuthor>")
appDirs.getUserDataDir()
```
__Kotlin Multiplatform AppDirs__ is a fork/kotlin multiplatform rewrite of the Java library [__AppDirs__](https://github.com/harawata/appdirs).

__AppDirs__ is loosely based on [a python module](https://github.com/ActiveState/appdirs) with the same name.  
Please use the issue tracker for bug reports or suggestions.

## Quickstart
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/ca.gosyer/kotlin-multiplatform-appdirs/badge.svg)](https://maven-badges.herokuapp.com/maven-central/ca.gosyer/kotlin-multiplatform-appdirs)
```kotlin
kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("ca.gosyer:kotlin-multiplatform-appdirs:1.1.1")
            }
        }
    }
}
```

## Supported directories

Currently, __Kotlin Multiplatform AppDirs__ has the following methods.

- getUserDataDir
- getUserConfigDir
- getUserCacheDir
- getUserLogDir
- getSiteDataDir
- getSiteConfigDir
- getSharedDir

Here is a test program and the output on some platforms.

```kotlin
import ca.gosyer.appdirs.AppDirs

fun main() {
    val appDirs = AppDirs("myapp", "syer", "1.2.3")
    println("User data dir: " + appDirs.getUserDataDir())
    println("User data dir (roaming): " + appDirs.getUserDataDir(roaming = true))
    println("User config dir: " + appDirs.getUserConfigDir())
    println("User config dir (roaming): " + appDirs.getUserConfigDir(roaming = true))
    println("User cache dir: " + appDirs.getUserCacheDir())
    println("User log dir: " + appDirs.getUserLogDir())
    println("Site data dir: " + appDirs.getSiteDataDir())
    println("Site data dir (multi path): " + appDirs.getSiteDataDir(multiPath = true))
    println("Site config dir: " + appDirs.getSiteConfigDir())
    println("Site config dir (multi path): " + appDirs.getSiteConfigDir(multiPath = true))
    println("Shared dir: " + appDirs.getSharedDir())
}
```

### Output on Mac OS X (username = ave)

```
User data dir: /Users/ave/Library/Application Support/syer myapp/1.2.3
User data dir (roaming): /Users/ave/Library/Application Support/syer myapp/1.2.3
User config dir: /Users/ave/Library/Preferences/syer myapp/1.2.3
User config dir (roaming): /Users/ave/Library/Preferences/syer myapp/1.2.3
User cache dir: /Users/ave/Library/Caches/syer myapp/1.2.3
User log dir: /Users/ave/Library/Logs/syer myapp/1.2.3
Site data dir: /Library/Application Support/syer myapp/1.2.3
Site data dir (multi path): /Library/Application Support/syer myapp/1.2.3
Site config dir: /Library/Preferences/syer myapp/1.2.3
Site config dir (multi path): /Library/Preferences/syer myapp/1.2.3
Shared dir: /Users/Shared/Library/Application Support/syer myapp/1.2.3
```
- _roaming_ and _multiPath_ parameters have no effect on Mac OS X.

### Output on Windows 7 (username = ave)
```
User data dir: C:\Users\ave\AppData\Local\syer\myapp\1.2.3
User data dir (roaming): C:\Users\ave\AppData\Roaming\syer\myapp\1.2.3
User config dir: C:\Users\ave\AppData\Local\syer\myapp\1.2.3
User config dir (roaming): C:\Users\ave\AppData\Roaming\syer\myapp\1.2.3
User cache dir: C:\Users\ave\AppData\Local\syer\myapp\Cache\1.2.3
User log dir: C:\Users\ave\AppData\Local\syer\myapp\Logs\1.2.3
Site data dir: C:\ProgramData\syer\myapp\1.2.3
Site data dir (multi path): C:\ProgramData\syer\myapp\1.2.3
Site config dir: C:\ProgramData\syer\myapp\1.2.3
Site config dir (multi path): C:\ProgramData\syer\myapp\1.2.3
Shared dir: C:\ProgramData\syer\myapp\1.2.3
```
- Internally calls [SHGetFolderPath](http://msdn.microsoft.com/en-us/library/bb762181%28VS.85%29.aspx), either by Kotlin Native or via [Java Native Access (JNA)](https://github.com/twall/jna) on the JVM.
- Returns CSIDL_LOCAL_APPDATA or CSIDL_APPDATA for user directories.
- Returns CSIDL_COMMON_APPDATA for site directories.
- _multiPath_ parameter has no effect on Windows.

### Output on Linux (username = ave, with no XDG environment variables defined)
```
User data dir: /home/ave/.local/share/myapp/1.2.3
User data dir (roaming): /home/ave/.local/share/myapp/1.2.3
User config dir: /home/ave/.config/myapp/1.2.3
User config dir (roaming): /home/ave/.config/myapp/1.2.3
User cache dir: /home/ave/.cache/myapp/1.2.3
User log dir: /home/ave/.cache/myapp/logs/1.2.3
Site data dir: /usr/local/share/myapp/1.2.3
Site data dir (multi path): /usr/local/share/myapp/1.2.3:/usr/share/myapp/1.2.3
Site config dir: /etc/xdg/myapp/1.2.3
Site config dir (multi path): /etc/xdg/myapp/1.2.3
Shared dir: /srv/myapp/1.2.3
```

- __AppDirs__ respects [XDG Base Directory Specification](http://standards.freedesktop.org/basedir-spec/basedir-spec-latest.html) if variables are defined.
- Returns XDG_DATA_HOME for user data directory.
- Returns XDG_CONFIG_HOME for user config directory.
- Returns XDG_CACHE_HOME for user cache directory.
- Returns XDG_DATA_DIRS for site data directory.
- Returns XDG_CONFIG_DIRS for site config directory.
- _appAuthor_ parameter is not used on Unix/Linux.
- _roaming_ parameter has no effect on Unix/Linux.

### Output on Android (packageName = ca.gosyer.appdirsm, uid = 0)
```
User data dir: /data/user/0/ca.gosyer.appdirsm/app_data/1.2.3
User data dir (roaming): /data/user/0/ca.gosyer.appdirsm/app_data/1.2.3
User config dir: /data/user/0/ca.gosyer.appdirsm/app_config/1.2.3
User config dir (roaming): /data/user/0/ca.gosyer.appdirsm/app_config/1.2.3
User cache dir: /data/user/0/ca.gosyer.appdirsm/cache/1.2.3
User log dir: /data/user/0/ca.gosyer.appdirsm/app_logs/1.2.3
Site data dir: /storage/emulated/0/Android/data/ca.gosyer.appdirsm/files/data/1.2.3
Site data dir (multi path): /storage/emulated/0/Android/data/ca.gosyer.appdirsm/files/data/1.2.3
Site config dir: /storage/emulated/0/Android/data/ca.gosyer.appdirsm/files/config/1.2.3
Site config dir (multi path): /storage/emulated/0/Android/data/ca.gosyer.appdirsm/files/config/1.2.3
Shared dir: /storage/emulated/0/Android/data/ca.gosyer.appdirsm/files/shared/1.2.3
```

- __AppDirs__ respects [Scoped storage](https://source.android.com/docs/core/storage/scoped) and only accesses the application private directory.

## Bug report, feature request, question

Please create an issue on the [tracker](https://github.com/Syer10/Kotlin-Multiplatform-AppDirs/issues).

## License

__Kotlin Multiplatform AppDirs__ is released under Apache Software License 2.0, the same license of __AppDirs__.
