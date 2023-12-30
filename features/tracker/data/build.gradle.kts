plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.davidtomas.data"
}

apply(from = "$rootDir/base-module.gradle")


dependencies {
    implementation(project(Modules.core))
    implementation(project(Modules.trackerDomain))

    implementation(Retrofit.okHttp)
    implementation(Retrofit.retrofit)
    implementation(Retrofit.okHttpLoggingInterceptor)
    implementation(Retrofit.moshiConverter)

    "kapt"(Room.roomCompiler)
    implementation(Room.roomKtx)
    implementation(Room.roomRuntime)
}