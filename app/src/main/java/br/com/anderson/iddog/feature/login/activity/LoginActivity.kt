package br.com.anderson.iddog.feature.login.activity

import android.content.Intent
import android.view.View
import androidx.lifecycle.Observer
import br.com.anderson.iddog.R
import br.com.anderson.iddog.data.response.UserResponse
import br.com.anderson.iddog.databinding.ActivityLoginBinding
import br.com.anderson.iddog.feature.base.BaseActivity
import br.com.anderson.iddog.feature.feed.activity.FeedActivity
import br.com.anderson.iddog.feature.login.viewmodel.LoginViewModel
import br.com.anderson.iddog.util.Constants
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
            bind.progressBar.visibility = View.VISIBLE
            clickSignup()
            bind.progressBar.visibility = View.INVISIBLE
        }
    }

    private fun clickSignup(){
        if(bind.editEmail.text.toString().validateEmailFormat()){
            viewModel.signup(bind.editEmail.text.toString()).observe(this, Observer {
                if(it.data?.user?.token != null){
                    showFeed(it.data.user)
                }else{
                    showError()
                }
            })
        }else{
            showEmailError()
        }
    }

    private fun showFeed(user: UserResponse){
        val intent = Intent(this, FeedActivity::class.java)
        intent.putExtra(Constants.INTENT_USER, user)
        startActivity(intent)
        bind.textError.visibility = View.INVISIBLE
    }

    private fun showEmailError(){
        bind.textError.visibility = View.VISIBLE
        bind.textError.text = getString(R.string.login_email_invalido)
    }
}
