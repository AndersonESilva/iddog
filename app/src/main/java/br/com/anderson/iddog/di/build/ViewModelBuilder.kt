package br.com.anderson.iddog.di.build

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.anderson.iddog.di.ViewModelKey
import br.com.anderson.iddog.di.provider.ViewModelProviderFactory
import br.com.anderson.iddog.feature.login.viewmodel.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by anderson on 24/06/2020.
 */
@Module
abstract class ViewModelBuilder {

    // Login
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: LoginViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}