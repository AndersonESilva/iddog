package br.com.anderson.iddog.di

import android.app.Application
import android.content.Context
import br.com.anderson.iddog.App
import br.com.anderson.iddog.service.IdwallService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by anderson on 24/06/2020.
 */
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(app: Application): Context {
        return app.applicationContext
    }

    @Singleton
    @Provides
    fun provideIdwallService(app: Application): IdwallService {
        var appM = app as App
        return Retrofit.Builder()
            .baseUrl(appM.getUrlBase())
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
            .create(IdwallService::class.java)
    }
}