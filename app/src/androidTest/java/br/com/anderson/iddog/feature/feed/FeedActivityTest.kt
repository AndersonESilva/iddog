package br.com.anderson.iddog.feature.feed

import android.content.Intent
import android.os.Looper
import androidx.test.annotation.UiThreadTest
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import br.com.anderson.iddog.R
import br.com.anderson.iddog.data.response.UserResponse
import br.com.anderson.iddog.feature.BaseInstrumentTest
import br.com.anderson.iddog.feature.feed.activity.FeedActivity
import br.com.anderson.iddog.util.Constants
import br.com.anderson.iddog.util.RecyclerViewMatchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.concurrent.CountDownLatch

/**
 * Created by anderson on 28/06/2020.
 */
@LargeTest
@RunWith(JUnit4::class)
class FeedActivityTest : BaseInstrumentTest(){

    @get:Rule
    val rule = ActivityTestRule(FeedActivity::class.java, false, false)

    private lateinit var intent: Intent

    override fun initTest(){
        intent = Intent()
        val user = UserResponse("testeaaaa@gmail.com","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJpZGRvZy1zZXJ2aWNlIiwic3ViIjoiNWVmNDEzYmFlYmJlNGVkMjUxOTg5MGJmIiwiaWF0IjoxNTkzMDU0MTM4LCJleHAiOjE1OTQzNTAxMzh9.53hVE0UdtMhhLanhT6yvJfA5CPItnvsUQ3Cyq_R3mP0")
        intent.putExtra(Constants.INTENT_USER, user)
        rule.launchActivity(intent)
    }

    @Test
    fun shouldDisplayTitle() {
        val expectedTitle = application.getString(R.string.title_activity_feed)
        onView(withText(expectedTitle)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldDisplayListItem() {
        RecyclerViewMatchers.checkRecyclerViewItem(R.id.recyclerView,0, isDisplayed())
    }

}
