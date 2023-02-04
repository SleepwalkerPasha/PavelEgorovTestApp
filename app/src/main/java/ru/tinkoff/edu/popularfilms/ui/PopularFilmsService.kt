package ru.tinkoff.edu.popularfilms.ui

import android.content.Context
import ru.tinkoff.edu.popularfilms.R
import ru.tinkoff.edu.popularfilms.api.KinopoiskAPIServices
import ru.tinkoff.edu.popularfilms.api.okhttp.OkHttpClientCreator
import ru.tinkoff.edu.popularfilms.api.retrofit.RetrofitClient

class PopularFilmsService(context: Context) {

    val api: KinopoiskAPIServices

    init {
        val okHttpClient = OkHttpClientCreator.getClient()
        val retrofitClient = RetrofitClient.getClient(context.getString(R.string.base_url), okHttpClient)
        api = retrofitClient.create(KinopoiskAPIServices::class.java)
    }
}