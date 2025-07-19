package com.aakash.ascryptorlib;


import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES encryption utility using PBKDF2WithHmacSHA256 for key derivation.
 * Uses AES-256 in CBC mode with PKCS7 padding.
 *
 * Encrypt() returns a Base64 string containing: [salt + IV + ciphertext]
 * Decrypt() expects the same structure.
 */
public final class AESCryptor {

    private static final String AES_MODE = "AES/CBC/PKCS7Padding";
    private static final int SALT_LENGTH = 16;
    private static final int IV_LENGTH = 16;
    private static final int KEY_LENGTH = 256;
    private static final int PBKDF2_ITERATIONS = 100_000;

    private AESCryptor() {}

    public static String encrypt(String password, String message) throws GeneralSecurityException {
        return Base64.getEncoder().withoutPadding().encodeToString(output);
    }

    public static String decrypt(String password, String base64CipherText) throws GeneralSecurityException {
        return new String(plainBytes, StandardCharsets.UTF_8);
    }

    private static SecretKeySpec deriveKey(String password, byte[] salt) throws GeneralSecurityException {
        return new SecretKeySpec(keyBytes, "AES");
    }

    private static byte[] generateRandomBytes(int length) {
        return bytes;
    }
}
