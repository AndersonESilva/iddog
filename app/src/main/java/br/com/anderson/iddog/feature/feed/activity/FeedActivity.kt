package br.com.anderson.iddog.feature.feed.activity

import android.app.Dialog
import android.content.DialogInterface
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.view.Window.FEATURE_NO_TITLE
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.anderson.iddog.R
import br.com.anderson.iddog.data.enum.CategoryEnum
import br.com.anderson.iddog.data.response.DogResponse
import br.com.anderson.iddog.data.response.UserResponse
import br.com.anderson.iddog.databinding.ActivityFeedBinding
import br.com.anderson.iddog.feature.base.BaseActivity
import br.com.anderson.iddog.feature.base.CellClickListener
import br.com.anderson.iddog.feature.feed.adapter.DogListAdapter
import br.com.anderson.iddog.feature.feed.viewmodel.FeedViewModel
import br.com.anderson.iddog.util.Constants
import br.com.anderson.iddog.util.Constants.Companion.DIALOG_HEIGNT
import br.com.anderson.iddog.util.Constants.Companion.DIALOG_WIGTH
import br.com.anderson.iddog.util.ImageUtil


/**
 * Created by anderson on 25/06/2020.
 */
class FeedActivity : BaseActivity<ActivityFeedBinding, FeedViewModel>(), CellClickListener{

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

    private fun getCategory(category: String){
        bind.progressBarFeed.visibility = View.VISIBLE
        user.token?.let {
            viewModel.feed(it, category).observe(this, Observer {request ->
                if(request.data != null){
                    initListView(request.data)
                }else{
                    showError()
                }
                bind.progressBarFeed.visibility = View.INVISIBLE
            })
        }
    }

    private fun initListView(dogResponse: DogResponse){
        var adapter = DogListAdapter(dogResponse.listUrl, this)

        bind.recyclerView.adapter = adapter
        bind.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun <String> onCellClickListener(data: String) {
        showImage(data.toString())
    }

    fun showImage(urlImage: String) {
        val builder = Dialog(this)
        builder.requestWindowFeature(FEATURE_NO_TITLE)
        builder.setOnDismissListener(DialogInterface.OnDismissListener {
            //nothing;
        })

        val imageView = ImageView(this)
        ImageUtil.setPicassoImage(imageView, urlImage)
        builder.addContentView(
            imageView, RelativeLayout.LayoutParams(
                DIALOG_WIGTH,
                DIALOG_HEIGNT
            )
        )
        builder.show()
    }
}
