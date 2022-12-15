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
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    macosX64()
    linuxX64()
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
        val macosX64Main by getting {
            dependsOn(nativeMain)
            dependsOn(macosMain)
        }
        val macosX64Test by getting {
            dependsOn(nativeTest)
            dependsOn(macosTest)
        }
        val linuxX64Main by getting {
            dependsOn(nativeMain)
            dependsOn(unixMain)
        }
        val linuxX64Test by getting {
            dependsOn(nativeTest)
            dependsOn(unixTest)
        }
        val mingwX64Main by getting {
            dependsOn(nativeMain)
            dependsOn(windowsMain)
        }
        val mingwX64Test by getting {
            dependsOn(nativeTest)
            dependsOn(windowsTest)
        }
    }
}
