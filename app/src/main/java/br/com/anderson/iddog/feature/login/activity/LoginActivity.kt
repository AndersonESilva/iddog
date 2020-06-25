package br.com.anderson.iddog.feature.login.activity

import br.com.anderson.iddog.R
import br.com.anderson.iddog.databinding.ActivityLoginBinding
import br.com.anderson.iddog.feature.base.BaseActivity
import br.com.anderson.iddog.feature.login.viewmodel.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {

    override fun getLayoutId(): Int = R.layout.activity_login

    override fun getViewModelClass(): Class<LoginViewModel> = LoginViewModel::class.java

    override fun init() {
        bind.viewModel = viewModel

        bind.btnLogin.setOnClickListener{
            viewModel.signup(bind.editEmail.text.toString())
        }

    }

}
