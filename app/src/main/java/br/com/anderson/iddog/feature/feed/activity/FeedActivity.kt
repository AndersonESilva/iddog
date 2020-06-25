package br.com.anderson.iddog.feature.feed.activity

import br.com.anderson.iddog.R
import br.com.anderson.iddog.databinding.ActivityFeedBinding
import br.com.anderson.iddog.feature.base.BaseActivity
import br.com.anderson.iddog.feature.feed.viewmodel.FeedViewModel

/**
 * Created by anderson on 25/06/2020.
 */
class FeedActivity : BaseActivity<ActivityFeedBinding, FeedViewModel>() {

    override fun getLayoutId(): Int = R.layout.activity_feed

    override fun getViewModelClass(): Class<FeedViewModel> = FeedViewModel::class.java

    override fun init() {
        bind.viewModel = viewModel
    }
}