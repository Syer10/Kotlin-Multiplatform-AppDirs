package ca.gosyer.appdirs

import org.junit.jupiter.api.condition.DisabledIfSystemProperty
import org.junit.jupiter.api.condition.DisabledOnOs
import org.junit.jupiter.api.condition.OS

@DisabledOnOs(OS.MAC, OS.WINDOWS)
class LinuxJvmTest : UnixTest()