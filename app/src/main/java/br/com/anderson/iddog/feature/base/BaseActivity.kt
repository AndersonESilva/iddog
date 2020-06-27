package br.com.anderson.iddog.feature.base

import android.content.DialogInterface
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import br.com.anderson.iddog.R
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * Created by anderson on 24/06/2020.
 */
abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : AppCompatActivity() {

    lateinit var viewModel: V
    lateinit var bind: T

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    protected abstract fun getViewModelClass(): Class<V>

    protected abstract fun init()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        bind = DataBindingUtil.setContentView(this, getLayoutId())
        viewModel = ViewModelProvider(this,this.viewModelProvider).get(getViewModelClass())

        init()
    }

    fun showError(){
        val builder = AlertDialog.Builder(this)
        builder.setMessage(R.string.generic_error)
            .setPositiveButton(R.string.OK,
                DialogInterface.OnClickListener { dialog, id ->
                    // OK
                })
        builder.create().show()
    }
}