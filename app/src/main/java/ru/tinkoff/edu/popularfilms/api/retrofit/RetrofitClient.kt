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

    @OptIn(ExperimentalSerializationApi::class)
    fun getClient(baseUrl: String, okHttpClient: OkHttpClient): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(Json.asConverterFactory(contentType))
                .client(okHttpClient)
                .build()
        }
        return retrofit!!
    }
}