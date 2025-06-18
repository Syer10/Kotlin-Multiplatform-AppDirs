package ca.gosyer.appdirs

import org.junit.jupiter.api.condition.EnabledOnOs
import org.junit.jupiter.api.condition.OS

@EnabledOnOs(OS.WINDOWS)
class WindowsJvmTest : WindowsTest()