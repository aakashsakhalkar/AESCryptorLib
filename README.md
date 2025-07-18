# 🔐 AESCryptorLib

A lightweight, secure AES encryption/decryption library for Android.

It uses **PBKDF2WithHmacSHA256** for password-based key derivation and **AES-256 in CBC mode with PKCS7 padding**.

Use it when you want to encrypt strings securely using a password — perfect for local data storage, message encryption, or safe config values.

---

## ✅ Features

- AES-256 encryption with CBC mode and PKCS7 padding  
- Password-based key derivation using PBKDF2WithHmacSHA256  
- Automatically handles salt and IV  
- No external dependencies  
- Works with Java and Kotlin  

---

## 🔧 Installation

### New Gradle (Kotlin DSL) — `settings.gradle.kts`

In `settings.gradle.kts`:

```kotlin
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        maven(url = "https://jitpack.io")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

---

Then add the dependency in build.gradle.kts (app-level):


implementation("com.github.aakashsakhalkar:AESCryptorLib:v1.0.0")

