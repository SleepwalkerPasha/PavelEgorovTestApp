package ru.tinkoff.edu.popularfilms.ui

import ru.tinkoff.edu.popularfilms.api.KinopoiskAPIServices
import ru.tinkoff.edu.popularfilms.api.okhttp.OkHttpClientCreator
import ru.tinkoff.edu.popularfilms.api.retrofit.RetrofitClient

class PopularFilmsService() {

    val api: KinopoiskAPIServices

    private val baseUrl = "https://kinopoiskapiunofficial.tech/"

    init {
        val okHttpClient = OkHttpClientCreator.getClient()
        val retrofitClient = RetrofitClient.getClient(baseUrl, okHttpClient)
        api = retrofitClient.create(KinopoiskAPIServices::class.java)
    }
}