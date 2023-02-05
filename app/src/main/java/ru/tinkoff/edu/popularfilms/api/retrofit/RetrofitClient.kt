package ru.tinkoff.edu.popularfilms.api.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

object RetrofitClient {
    private var retrofit: Retrofit? = null

    private val contentType = "application/json".toMediaType()

    private val json1 = Json {
        ignoreUnknownKeys = true
    }

    @OptIn(ExperimentalSerializationApi::class)
    private val json = json1.asConverterFactory(contentType)

    @OptIn(ExperimentalSerializationApi::class)
    fun getClient(baseUrl: String, okHttpClient: OkHttpClient): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(json)
                .client(okHttpClient)
                .build()
        }
        return retrofit!!
    }
}