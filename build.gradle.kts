// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // val nav_version = "2.5.3"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")
        classpath ("com.google.gms:google-services:4.3.10")
    }
}

plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
}