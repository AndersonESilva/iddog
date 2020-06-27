package br.com.anderson.iddog.feature.feed.activity

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.anderson.iddog.R
import br.com.anderson.iddog.data.enum.CategoryEnum
import br.com.anderson.iddog.data.response.DogResponse
import br.com.anderson.iddog.data.response.UserResponse
import br.com.anderson.iddog.databinding.ActivityFeedBinding
import br.com.anderson.iddog.feature.base.BaseActivity
import br.com.anderson.iddog.feature.feed.adapter.DogListAdapter
import br.com.anderson.iddog.feature.feed.viewmodel.FeedViewModel
import br.com.anderson.iddog.util.Constants
import java.util.*

/**
 * Created by anderson on 25/06/2020.
 */
class FeedActivity : BaseActivity<ActivityFeedBinding, FeedViewModel>(){

    override fun getLayoutId(): Int = R.layout.activity_feed

    override fun getViewModelClass(): Class<FeedViewModel> = FeedViewModel::class.java

    private lateinit var user: UserResponse

    override fun init() {
        bind.viewModel = viewModel

        user = intent.getParcelableExtra(Constants.INTENT_USER)
        initFilter()
    }

    private fun initFilter(){
        val adapter = ArrayAdapter<CategoryEnum>(this, android.R.layout.simple_spinner_item, CategoryEnum.values())
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        bind.spinnerCategory.adapter = adapter
        bind.spinnerCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                getCategory(CategoryEnum.values()[position].category)
            }

        }
    }

    private fun initListView(dogResponse: DogResponse){
        var adapter = DogListAdapter(dogResponse.listUrl)

        bind.recyclerView.adapter = adapter
        bind.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun getCategory(category: String){
        user.token?.let {
            viewModel.feed(it, category).observe(this, Observer {request ->
                if(request.data != null){
                    initListView(request.data)
                }else{
                    // bind.textError.visibility = View.VISIBLE
                    // bind.textError.text = getString(R.string.login_email_error)
                }
                // bind.progressBar.visibility = View.INVISIBLE
            })
        }
    }
}
