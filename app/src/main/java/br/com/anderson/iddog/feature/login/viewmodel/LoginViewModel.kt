package br.com.anderson.iddog.feature.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations.map
import br.com.anderson.iddog.data.response.Resouce
import br.com.anderson.iddog.data.response.SignupResponse
import br.com.anderson.iddog.feature.base.BaseViewModel
import br.com.anderson.iddog.service.repository.LoginRepository
import javax.inject.Inject

/**
 * Created by anderson on 24/06/2020.
 */
class LoginViewModel @Inject constructor(private var repository: LoginRepository): BaseViewModel(){

    fun signup(email: String): LiveData<Resouce<SignupResponse>>{
        return map(repository.signup(email)){
            return@map it
        }
    }

}