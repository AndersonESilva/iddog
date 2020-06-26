package br.com.anderson.iddog.feature.feed.activity

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import br.com.anderson.iddog.R
import br.com.anderson.iddog.data.enum.CategoryEnum
import br.com.anderson.iddog.databinding.ActivityFeedBinding
import br.com.anderson.iddog.feature.base.BaseActivity
import br.com.anderson.iddog.feature.feed.viewmodel.FeedViewModel
import java.util.*

/**
 * Created by anderson on 25/06/2020.
 */
class FeedActivity : BaseActivity<ActivityFeedBinding, FeedViewModel>(){

    override fun getLayoutId(): Int = R.layout.activity_feed

    override fun getViewModelClass(): Class<FeedViewModel> = FeedViewModel::class.java

    override fun init() {
        bind.viewModel = viewModel

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
                //CategoryEnum.values()[position].category
            }

        }
    }
}
