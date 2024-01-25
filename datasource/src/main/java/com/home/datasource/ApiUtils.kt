package com.home.datasource

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Classe utilizada para a configuração do Retrofit e
 * e funções utilitárias para consumo de API
 * @author Yago H Pereira <yago.henriquep@gmail.com>
 * @since 23/01/2024
 * @version 1.0.0
 */
class ApiUtils {
    companion object {
        private fun getAuthenticationInterceptorClient(): OkHttpClient {
            val httpClient = OkHttpClient.Builder()
                .addInterceptor {
                    val original: Request = it.request()

                    //TODO check if it is possible to use a singleton for user-agent and token
                    val accessToken: String = getAccessToken() ?: ""
                    val userAgent = getEncryptedUserAgent()
                    val request = original.newBuilder()
                        .addHeader("Authorization", "Bearer $accessToken")
                        .addHeader("user-agent", userAgent)
                        .addHeader("Accept", "application/json")
                        .addHeader("Content-type", "application/json")
                        .addHeader("origin", "app-mobile")
                        .build()
                    return@addInterceptor it.proceed(request)
                }
            return httpClient.build()
        }

        private fun getAccessToken(): String? {
//            val tokenHexHash: String? = Hawk.get("cred")
//            try {
//                val encryptedBytes = tokenHexHash?.let { AES256Cipher.hexStringToByteArray(it) }
//                val decrypted: ByteArray = AES256Cipher.decrypt(
//                    "j54xyunkzne59sxg".toByteArray(),
//                    "d41d8cd98f00b204e9800998ecf8427e".toByteArray(),
//                    encryptedBytes
//                )
//                val json = String(decrypted)
//                val credentials = Gson().fromJson(json, Credentials::class.java)
//                return credentials.token
//            } catch (ex: Exception) {
//                Log.d("getAccessToken", "Exception: $ex")
//            }
            return null
        }

        private fun getEncryptedUserAgent(): String {
//            val dev = Device(
//                "123",
//                BuildConfig.VERSION_CODE.toString(),
//                Build.VERSION.RELEASE,
//                Build.VERSION.SDK_INT.toString(),
//                Build.BRAND,
//                Build.MODEL,
//                Build.FINGERPRINT
//            )
//
//            val gson = GsonBuilder().create()
//            val jsonBytes = gson.toJson(dev).toByteArray()
//
//            val encrypted : ByteArray = AES256Cipher.encrypt(
//                "j54xyunkzne59sxg".toByteArray(),
//                "d41d8cd98f00b204e9800998ecf8427e".toByteArray(),
//                jsonBytes)
//            return AES256Cipher.byteArrayToHexString(encrypted)
            return ""
        }

        /**
         * Adquire uma instância do retrofit através de seu Builder
         * @param path Base URL da API
         */
       // @SuppressLint("HardwareIds")
        fun getRetrofitInstance(path: String) : Retrofit {
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getAuthenticationInterceptorClient())
                .build()
        }
    }
}