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

Legacy Gradle (Groovy) — build.gradle (project-level)

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}

Add the dependency
Kotlin DSL:

implementation("com.github.aakashsakhalkar:AESCryptorLib:v1.0.0")

Groovy:

implementation 'com.github.aakashsakhalkar:AESCryptorLib:v1.0.0'

✍️ Example (Java)

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

📁 File Structure

AESCryptorProject/
├── ascryptorlib/
│   ├── build.gradle.kts
│   └── src/main/java/com/aakash/ascryptorlib/AESCryptor.java
├── app/
│   └── (Your app consuming the library)
└── settings.gradle.kts


🧠 What’s Going On Inside
16-byte random salt

16-byte random IV

PBKDF2 with 10,000 iterations → generates a 256-bit AES key

Output format:
Base64( salt + IV + ciphertext )

Each encryption is unique — even for the same message and password — thanks to the random salt and IV.

✅ Compatibility
Android 5.0 (API 21) and above

Works in both Java and Kotlin projects

No third-party dependencies required

🚀 Publishing New Versions (for maintainers)
Commit your changes

Tag a release (e.g. v1.0.1)

Push tags to GitHub

Go to jitpack.io → Look Up your repo

Click Build on the new version

📝 License
MIT License
Free to use, modify, and redistribute.
Give credit if you fork or extend the library.
