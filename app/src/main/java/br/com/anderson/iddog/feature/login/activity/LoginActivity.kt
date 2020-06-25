package br.com.anderson.iddog.feature.login.activity

import android.view.View
import androidx.lifecycle.Observer
import br.com.anderson.iddog.R
import br.com.anderson.iddog.databinding.ActivityLoginBinding
import br.com.anderson.iddog.feature.base.BaseActivity
import br.com.anderson.iddog.feature.login.viewmodel.LoginViewModel
import br.com.anderson.iddog.util.validateEmailFormat

/**
 * Created by anderson on 24/06/2020.
 */
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {

    override fun getLayoutId(): Int = R.layout.activity_login

    override fun getViewModelClass(): Class<LoginViewModel> = LoginViewModel::class.java

    override fun init() {
        bind.viewModel = viewModel

        bind.btnLogin.setOnClickListener{
            if(bind.editEmail.text.toString().validateEmailFormat()){
                viewModel.signup(bind.editEmail.text.toString()).observe(this, Observer {
                    if(it.data != null){

                    }else{
                        bind.textError.visibility = View.VISIBLE
                        bind.textError.text = getString(R.string.login_email_error)
                    }
                })
            }else{
                bind.textError.visibility = View.VISIBLE
                bind.textError.text = getString(R.string.login_email_invalido)
            }
        }
    }
}
