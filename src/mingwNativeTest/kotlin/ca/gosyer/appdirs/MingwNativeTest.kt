package ca.gosyer.appdirs

import ca.gosyer.appdirs.impl.ShellFolderResolver

class MingwNativeTest : WindowsTest(::ShellFolderResolver)