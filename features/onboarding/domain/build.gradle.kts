plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.davidtomas.domain"
}

apply(from = "$rootDir/base-module.gradle")

dependencies {
    implementation(project(Modules.core))
}