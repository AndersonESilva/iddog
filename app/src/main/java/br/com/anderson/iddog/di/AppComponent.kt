package br.com.anderson.iddog.di

import android.app.Application
import br.com.anderson.iddog.App
import br.com.anderson.iddog.di.build.ActivityBuilder
import br.com.anderson.iddog.di.build.ViewModelBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by anderson on 24/06/2020.
 */
@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidSupportInjectionModule::class,
        ActivityBuilder::class,
        ViewModelBuilder::class
    ]
)
interface AppComponent {

    fun inject(application: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}