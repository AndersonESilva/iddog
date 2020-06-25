package br.com.anderson.iddog.di.build

import br.com.anderson.iddog.di.Activity
import br.com.anderson.iddog.feature.login.activity.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by anderson on 24/06/2020.
 */
@Module
abstract class ActivityBuilder {

    // Login
    @Activity
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): LoginActivity
}