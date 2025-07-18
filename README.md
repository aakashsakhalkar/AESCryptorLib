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
```
### Then add the dependency in `build.gradle.kts` (app-level):

```kotlin
implementation("com.github.aakashsakhalkar:AESCryptorLib:v1.0.0")
```
### For Old Projects (Groovy)
In project-level build.gradle:
```kotlin
allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```
### Then add this to app-level build.gradle:
```kotlin
implementation 'com.github.aakashsakhalkar:AESCryptorLib:v1.0.0'
```

## ✍️ Java Usage Example
```kotlin

import com.aakash.ascryptorlib.AESCryptor;

try {
    String password = "secret123";
    String message = "Hello, World!";

    String encrypted = AESCryptor.encrypt(password, message);
    System.out.println("Encrypted: " + encrypted);

    String decrypted = AESCryptor.decrypt(password, encrypted);
    System.out.println("Decrypted: " + decrypted);
} catch (Exception e) {
    e.printStackTrace();
}
```
## 📁 File Structure
```text
AESCryptorProject/
├── ascryptorlib/
│   ├── build.gradle.kts
│   └── src/main/java/com/aakash/ascryptorlib/AESCryptor.java
├── app/
│   └── (Your app that uses the library)
└── settings.gradle.kts
```
## 🧠 How It Works
16-byte random salt

16-byte random IV

PBKDF2 with HMAC SHA256 and 10,000 iterations

Generates a 256-bit AES key

Output format:
```kotlin
Base64( salt + IV + ciphertext )
```
🔐 Every encryption is unique, even for the same password/message combo — thanks to the random salt & IV.

## ✅ Compatibility
Android 5.0 (API 21) and above

Works in both Java and Kotlin

Requires no external dependencies

## 🚀 How to Publish New Versions (for Maintainers)
Make your changes

Tag a version like v1.0.1

Push tags to GitHub

Go to JitPack

Search your repo and click Build on the new version

## 📝 License
### MIT License

Free to use, modify, and redistribute.
Give credit if you fork or extend the library.



