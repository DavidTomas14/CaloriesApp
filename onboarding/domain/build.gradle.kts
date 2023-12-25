plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply(from = "$rootDir/base-module.gradle")

android {
    namespace = "com.davidtomas.domain"
}

dependencies {
    implementation(project(Modules.core))
}