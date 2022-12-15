plugins {
    kotlin("multiplatform") version "1.7.20"
    id("com.louiscad.complete-kotlin") version "1.1.0"
}

group = "ca.gosyer"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    macosX64()
    macosArm64()
    linuxX64()
    linuxArm64()
    linuxArm32Hfp()
    linuxMips32()
    linuxMipsel32()
    mingwX64()
    mingwX86()

    
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val macosMain by creating {
            dependsOn(commonMain)
        }
        val macosTest by creating {
            dependsOn(commonTest)
        }
        val unixMain by creating {
            dependsOn(commonMain)
        }
        val unixTest by creating {
            dependsOn(commonTest)
        }
        val windowsMain by creating {
            dependsOn(commonMain)
        }
        val windowsTest by creating {
            dependsOn(commonTest)
        }
        val jvmMain by getting {
            dependsOn(macosMain)
            dependsOn(unixMain)
            dependsOn(windowsMain)
            dependencies {
                implementation("net.java.dev.jna:jna-platform:5.12.1")
            }
        }
        val jvmTest by getting {
            dependsOn(macosTest)
            dependsOn(unixTest)
            dependsOn(windowsTest)
        }

        val nativeMain by creating {
            dependsOn(commonMain)
        }
        val nativeTest by creating {
            dependsOn(commonTest)
        }

        val macosNativeMain by creating {
            dependsOn(nativeMain)
            dependsOn(macosMain)
        }
        val macosNativeTest by creating {
            dependsOn(nativeTest)
            dependsOn(macosTest)
        }
        val macosX64Main by getting {
            dependsOn(macosNativeMain)
        }
        val macosX64Test by getting {
            dependsOn(macosNativeTest)
        }
        val macosArm64Main by getting {
            dependsOn(macosNativeMain)
        }
        val macosArm64Test by getting {
            dependsOn(macosNativeTest)
        }

        val linuxNativeMain by creating {
            dependsOn(nativeMain)
            dependsOn(unixMain)
        }
        val linuxNativeTest by creating {
            dependsOn(nativeTest)
            dependsOn(unixTest)
        }
        val linuxX64Main by getting {
            dependsOn(linuxNativeMain)
        }
        val linuxX64Test by getting {
            dependsOn(linuxNativeTest)
        }
        val linuxArm64Main by getting {
            dependsOn(linuxNativeMain)
        }
        val linuxArm64Test by getting {
            dependsOn(linuxNativeTest)
        }
        val linuxArm32HfpMain by getting {
            dependsOn(linuxNativeMain)
        }
        val linuxArm32HfpTest by getting {
            dependsOn(linuxNativeTest)
        }
        val linuxMips32Main by getting {
            dependsOn(linuxNativeMain)
        }
        val linuxMips32Test by getting {
            dependsOn(linuxNativeTest)
        }
        val linuxMipsel32Main by getting {
            dependsOn(linuxNativeMain)
        }
        val linuxMipsel32Test by getting {
            dependsOn(linuxNativeTest)
        }

        val mingwNativeMain by creating {
            dependsOn(nativeMain)
            dependsOn(windowsMain)
        }
        val mingwNativeTest by creating {
            dependsOn(nativeTest)
            dependsOn(windowsTest)
        }
        val mingwX64Main by getting {
            dependsOn(mingwNativeMain)
        }
        val mingwX64Test by getting {
            dependsOn(mingwNativeTest)
        }
        val mingwX86Main by getting {
            dependsOn(mingwNativeMain)
        }
        val mingwX86Test by getting {
            dependsOn(mingwNativeTest)
        }
    }
}
