package com.home.fincasa.basics

import java.io.UnsupportedEncodingException
import java.security.InvalidAlgorithmParameterException
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import java.security.spec.AlgorithmParameterSpec
import javax.crypto.BadPaddingException
import javax.crypto.Cipher
import javax.crypto.IllegalBlockSizeException
import javax.crypto.NoSuchPaddingException
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec


object AES256Cipher {
    @Throws(
        UnsupportedEncodingException::class,
        NoSuchAlgorithmException::class,
        NoSuchPaddingException::class,
        InvalidKeyException::class,
        InvalidAlgorithmParameterException::class,
        IllegalBlockSizeException::class,
        BadPaddingException::class
    )
    fun encrypt(ivBytes: ByteArray?, keyBytes: ByteArray?, textBytes: ByteArray?): ByteArray {
        val ivSpec: AlgorithmParameterSpec = IvParameterSpec(ivBytes)
        val newKey = SecretKeySpec(keyBytes, "AES")
        val cipher: Cipher? = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher?.init(Cipher.ENCRYPT_MODE, newKey, ivSpec)
        return cipher!!.doFinal(textBytes)
    }

    @Throws(
        UnsupportedEncodingException::class,
        NoSuchAlgorithmException::class,
        NoSuchPaddingException::class,
        InvalidKeyException::class,
        InvalidAlgorithmParameterException::class,
        IllegalBlockSizeException::class,
        BadPaddingException::class
    )
    fun decrypt(ivBytes: ByteArray?, keyBytes: ByteArray?, textBytes: ByteArray?): ByteArray {
        val ivSpec: AlgorithmParameterSpec = IvParameterSpec(ivBytes)
        val newKey = SecretKeySpec(keyBytes, "AES")
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(Cipher.DECRYPT_MODE, newKey, ivSpec)
        return cipher.doFinal(textBytes)
    }

    fun byteArrayToHexString(bytes: ByteArray) : String
    {
        val buffer: StringBuffer = StringBuffer()
        val len = bytes.size
        for(byte in bytes) {
            val b : Int = byte.toInt()
            if((b and 0xff) < 0x10)
                buffer.append("0")

            val j = b and 0xff
            buffer.append(j.toString(16))
        }

        return buffer.toString()
    }

    fun hexStringToByteArray(str: String) : ByteArray
    {
        var i = 0
        var k = 0
        val len = str.length;
        var results: ByteArray = ByteArray(len / 2)
        do{
            results[i] = (Character.digit(str.get(k++), 16).shl(4)).toByte()
            results[i] = Character.digit(str.get(k++), 16).toByte().plus(results[i]).toByte()
            i++
        }while (k < len)

        /*results[i] = (byte)(Character.digit(str.charAt(k++), 16) << 4);
        results[i] += (byte)(Character.digit(str.charAt(k++), 16));
        i++;*/

        return results;
    }
}
