package br.com.anderson.iddog

import android.app.Activity
import android.app.Application
import br.com.anderson.iddog.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by anderson on 24/06/2020.
 */
open class App : Application(), HasActivityInjector {

    companion object {
        @get:Synchronized
        lateinit var instance: App
    }

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector

    override fun onCreate() {
        super.onCreate()
        instance = this

        initInjector()
    }

    private fun initInjector() {
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

    open fun getUrlBase() = BuildConfig.URL_BASE
}
