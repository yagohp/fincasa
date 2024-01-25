package com.home.fincasa.basics

import android.content.ContentValues
import android.content.Context
import android.security.KeyPairGeneratorSpec
import android.util.Base64
import android.util.Log

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.lang.Exception
import java.math.BigInteger
import java.nio.charset.Charset

import java.security.KeyPairGenerator
import java.security.KeyStore
import java.security.KeyStoreException
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey
import java.util.*

import javax.crypto.Cipher
import javax.crypto.CipherInputStream
import javax.crypto.CipherOutputStream
import javax.security.auth.x500.X500Principal

class KeyStoreHelper {
    private val keyStore: KeyStore? = null
    private var keyAliases: ArrayList<String>? = null

    init {
        this.refreshKeys()
    }

    fun encryptString(alias: String?, text: String): String {
        return try {
            val privateKeyEntry = keyStore!!.getEntry(alias, null) as KeyStore.PrivateKeyEntry
            val publicKey = privateKeyEntry.certificate.publicKey as RSAPublicKey

            // Encrypt the text
            val input = Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidOpenSSL")
            input.init(Cipher.ENCRYPT_MODE, publicKey)
            val outputStream = ByteArrayOutputStream()
            val cipherOutputStream = CipherOutputStream(
                outputStream, input
            )
            cipherOutputStream.write(text.toByteArray(charset("UTF-8")))
            cipherOutputStream.close()
            val vals = outputStream.toByteArray()
            Base64.encodeToString(vals, Base64.DEFAULT)
        } catch (e: Exception) {
            Log.e(ContentValues.TAG, Log.getStackTraceString(e))
            text
        }
    }

    private fun refreshKeys() {
        keyAliases = ArrayList()
        try {
            val aliases = keyStore!!.aliases()
            while (aliases.hasMoreElements()) {
                keyAliases?.add(aliases.nextElement())
            }
        } catch (e: Exception) {
        }
    }

    fun decryptString(alias: String, encryptedText: String?): String {
        return try {
            val privateKeyEntry = keyStore!!.getEntry(alias, null) as KeyStore.PrivateKeyEntry
            val privateKey = privateKeyEntry.privateKey as RSAPrivateKey
            val output = Cipher.getInstance("RSA/ECB/PKCS1Padding", "AndroidOpenSSL")
            output.init(Cipher.DECRYPT_MODE, privateKey)
            val cipherInputStream = CipherInputStream(
                ByteArrayInputStream(Base64.decode(encryptedText, Base64.DEFAULT)), output
            )
            val values = ArrayList<Byte>()
            var nextByte: Int
            while (cipherInputStream.read().also { nextByte = it } != -1) {
                values.add(nextByte.toByte())
            }
            val bytes = ByteArray(values.size)
            for (i in bytes.indices) {
                bytes[i] = values[i]
            }
            return String(bytes, 0, bytes.size, Charset.defaultCharset())
        } catch (e: Exception) {
            Log.e(ContentValues.TAG, Log.getStackTraceString(e))
            alias
        }
    }

    fun createNewKeys(ctx: Context?, alias: String?) {
        try {
            if (!keyStore!!.containsAlias(alias)) {
                val start = Calendar.getInstance()
                val end = Calendar.getInstance()
                end.add(Calendar.YEAR, 1)
                val spec = KeyPairGeneratorSpec.Builder(ctx!!)
                    .setAlias(alias!!)
                    .setSubject(X500Principal("CN=Sample Name, O=Android Authority"))
                    .setSerialNumber(BigInteger.ONE)
                    .setStartDate(start.time)
                    .setEndDate(end.time)
                    .build()
                val generator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore")
                generator.initialize(spec)
                val keyPair = generator.generateKeyPair()
            }
        } catch (e: Exception) {
            Log.e(ContentValues.TAG, Log.getStackTraceString(e))
        }
        refreshKeys()
    }

    fun deleteKey(alias: String?) {
        try {
            keyStore!!.deleteEntry(alias)
            refreshKeys()
        } catch (e: KeyStoreException) {
            Log.e(ContentValues.TAG, Log.getStackTraceString(e))
        }
    }

    init {
        try {
            val ks = KeyStore.getInstance(KeyStore.getDefaultType())
        } catch (e: KeyStoreException) {
            e.printStackTrace()
        }
    }
}
