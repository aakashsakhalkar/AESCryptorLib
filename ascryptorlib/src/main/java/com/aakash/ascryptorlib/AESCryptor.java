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
    private static final int PBKDF2_ITERATIONS = 10_000;

    private AESCryptor() {}

    public static String encrypt(String password, String message) throws GeneralSecurityException {
        byte[] salt = generateRandomBytes(SALT_LENGTH);
        byte[] iv = generateRandomBytes(IV_LENGTH);
        SecretKeySpec key = deriveKey(password, salt);

        Cipher cipher = Cipher.getInstance(AES_MODE);
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
        byte[] cipherText = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));

        // Prepend salt + IV to ciphertext
        byte[] output = new byte[salt.length + iv.length + cipherText.length];
        System.arraycopy(salt, 0, output, 0, salt.length);
        System.arraycopy(iv, 0, output, salt.length, iv.length);
        System.arraycopy(cipherText, 0, output, salt.length + iv.length, cipherText.length);

        return Base64.getEncoder().withoutPadding().encodeToString(output);
    }

    public static String decrypt(String password, String base64CipherText) throws GeneralSecurityException {
        byte[] input = Base64.getDecoder().decode(base64CipherText);

        byte[] salt = new byte[SALT_LENGTH];
        byte[] iv = new byte[IV_LENGTH];
        byte[] cipherText = new byte[input.length - SALT_LENGTH - IV_LENGTH];

        System.arraycopy(input, 0, salt, 0, SALT_LENGTH);
        System.arraycopy(input, SALT_LENGTH, iv, 0, IV_LENGTH);
        System.arraycopy(input, SALT_LENGTH + IV_LENGTH, cipherText, 0, cipherText.length);

        SecretKeySpec key = deriveKey(password, salt);
        Cipher cipher = Cipher.getInstance(AES_MODE);
        cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
        byte[] plainBytes = cipher.doFinal(cipherText);

        return new String(plainBytes, StandardCharsets.UTF_8);
    }

    private static SecretKeySpec deriveKey(String password, byte[] salt) throws GeneralSecurityException {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, PBKDF2_ITERATIONS, KEY_LENGTH);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] keyBytes = factory.generateSecret(spec).getEncoded();
        return new SecretKeySpec(keyBytes, "AES");
    }

    private static byte[] generateRandomBytes(int length) {
        byte[] bytes = new byte[length];
        new SecureRandom().nextBytes(bytes);
        return bytes;
    }
}
