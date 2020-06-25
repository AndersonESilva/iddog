package br.com.anderson.iddog.di

import android.app.Application
import android.content.Context
import br.com.anderson.iddog.BuildConfig
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
    fun providePicPayService(): IdwallService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
            .create(IdwallService::class.java)
    }
}