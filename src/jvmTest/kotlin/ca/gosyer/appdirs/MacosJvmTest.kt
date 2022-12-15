package ca.gosyer.appdirs

import org.junit.jupiter.api.condition.DisabledIfSystemProperty
import org.junit.jupiter.api.condition.DisabledOnOs
import org.junit.jupiter.api.condition.OS

@DisabledOnOs(OS.WINDOWS, OS.LINUX)
class MacosJvmTest : MacosTest()