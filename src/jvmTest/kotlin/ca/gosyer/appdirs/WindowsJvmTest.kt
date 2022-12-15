package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.ShellFolderResolver
import org.junit.jupiter.api.condition.DisabledOnOs
import org.junit.jupiter.api.condition.OS

@DisabledOnOs(OS.MAC, OS.LINUX)
class WindowsJvmTest : WindowsTest(::ShellFolderResolver)