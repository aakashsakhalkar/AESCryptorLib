AESCryptorLib 🔐
A lightweight, secure AES encryption/decryption library for Android. It uses PBKDF2WithHmacSHA256 for password-based key derivation and AES-256 in CBC mode with PKCS7 padding.

Use it when you want to encrypt strings safely using a password — perfect for local data, message encryption, or secure configuration.

Features
✅ AES-256 CBC encryption with PKCS7 padding

✅ Password-based key derivation (PBKDF2WithHmacSHA256)

✅ Automatically handles salt and IV

✅ No external dependencies

🔧 Installation
1. Add JitPack to your project
New Gradle (Kotlin DSL)
settings.gradle.kts:
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

Legacy Gradle (Groovy)
build.gradle (project-level):
allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
2. Add the dependency
Kotlin:
implementation("com.github.aakashsakhalkar:AESCryptorLib:v1.0.0")
Groovy:
implementation 'com.github.aakashsakhalkar:AESCryptorLib:v1.0.0'
✍️ Example
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
Your library should live inside its own module like this:
AESCryptorProject/
│
├── ascryptorlib/
│   ├── build.gradle.kts
│   └── src/main/java/com/aakash/ascryptorlib/AESCryptor.java
│
└── app/
    └── (Your actual app consuming the library)
📦 What’s Going On Under the Hood
16-byte random salt

16-byte random IV

PBKDF2 with 10,000 iterations to generate a 256-bit AES key

Output is: Base64( salt + IV + ciphertext )

Each encryption is unique — even if the message and password are the same — thanks to the random salt and IV.
✅ Compatibility
Android 5.0 (API 21) and above

Works with both Java and Kotlin

No external libraries required

🚀 Publishing New Versions (for Maintainers)
Commit your changes

Tag a new release like v1.0.1

Push tags to GitHub

Visit JitPack → Look Up your repo

Click Build on your new version

📝 License
MIT License — Free to use, modify, and redistribute.
Give credit if you fork or extend the library.
