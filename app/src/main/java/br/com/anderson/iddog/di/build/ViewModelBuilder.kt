package br.com.anderson.iddog.di.build

import androidx.lifecycle.ViewModelProvider
import br.com.anderson.iddog.di.provider.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

/**
 * Created by anderson on 24/06/2020.
 */
@Module
abstract class ViewModelBuilder {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}