import java.util.Properties

plugins {
    kotlin("multiplatform") version "1.8.10"
    id("com.vanniktech.maven.publish") version "0.25.1"
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
    mingwX64()

    
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
    }
}

// Read in the signing.properties file if it is exists
val signingPropsFile = rootProject.file("release/signing.properties")
if (signingPropsFile.exists()) {
    Properties().apply {
        signingPropsFile.inputStream().use {
            load(it)
        }
    }.forEach { key1, value1 ->
        val key = key1.toString()
        val value = value1.toString()
        if (key == "signing.secretKeyRingFile") {
            // If this is the key ring, treat it as a relative path
            project.ext.set(key, rootProject.file(value).absolutePath)
        } else {
            project.ext.set(key, value)
        }
    }
}