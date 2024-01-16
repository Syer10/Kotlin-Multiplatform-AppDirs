import java.util.Properties

plugins {
    kotlin("multiplatform") version "1.9.21"
    id("com.vanniktech.maven.publish") version "0.25.1"
    id("com.android.library") version "8.2.1"
}

group = "ca.gosyer"
version = "1.1.0"

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

    androidTarget()

    @OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
    applyHierarchyTemplate {
        common {
            group("macosNative") {
                withMacosX64()
                withMacosArm64()
            }
            group("mingwNative") {
                withMingwX64()
            }
            group("linuxNative") {
                withLinuxX64()
                withLinuxArm64()
            }
        }
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        // Mac OS
        val macosMain by creating {
            dependsOn(commonMain)
        }
        val macosTest by creating {
            dependsOn(commonTest)
        }

        // Unix
        val unixMain by creating {
            dependsOn(commonMain)
        }
        val unixTest by creating {
            dependsOn(commonTest)
        }

        // Windows
        val windowsMain by creating {
            dependsOn(commonMain)
        }
        val windowsTest by creating {
            dependsOn(commonTest)
        }

        // Native
        val nativeMain by creating {
            dependsOn(commonMain)
        }
        val nativeTest by creating {
            dependsOn(commonTest)
        }

        // JVM
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

        // Mac OS Native
        getByName("macosNativeMain") {
            dependsOn(nativeMain)
            dependsOn(macosMain)
        }
        getByName("macosNativeTest") {
            dependsOn(nativeTest)
            dependsOn(macosTest)
        }

        // Linux
        getByName("linuxNativeMain") {
            dependsOn(nativeMain)
            dependsOn(unixMain)
        }
        getByName("linuxNativeTest") {
            dependsOn(nativeTest)
            dependsOn(unixTest)
        }

        // Mingw
        getByName("mingwNativeMain") {
            dependsOn(nativeMain)
            dependsOn(windowsMain)
        }
        getByName("mingwNativeTest") {
            dependsOn(nativeTest)
            dependsOn(windowsTest)
        }

        // android
        val androidMain by getting {
            dependsOn(commonMain)
        }
        val androidInstrumentedTest by getting {
            dependsOn(commonTest)
            dependencies {
                implementation("androidx.test.ext:junit-ktx:1.1.5")
                implementation("androidx.test.espresso:espresso-core:3.5.1")
                implementation("androidx.test:runner:1.5.2")
            }
        }
    }
}

// Read in the signing.properties file if it exists
val signingPropsFile: File = rootProject.file("release/signing.properties")
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

android {
    namespace = "ca.gosyer"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        compileSdk = 34
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
