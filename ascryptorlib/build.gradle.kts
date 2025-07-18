plugins {
    id("com.android.library")
    id("maven-publish")
}

group = "com.github.aakashsakhalkar"
version = "1.0.0"

android {
    namespace = "com.aakash.ascryptorlib"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

publishing {
    singleVariant("release")
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.github.aakashsakhalkar"
                artifactId = "AESCryptorLib"
                version = "1.0.0"
            }
        }
    }
}
