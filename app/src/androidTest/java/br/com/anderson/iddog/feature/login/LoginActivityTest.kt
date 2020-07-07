package br.com.anderson.iddog.feature.login

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import br.com.anderson.iddog.R
import br.com.anderson.iddog.R.id.btnLogin
import br.com.anderson.iddog.R.id.editEmail
import br.com.anderson.iddog.feature.BaseInstrumentTest
import br.com.anderson.iddog.feature.login.activity.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by anderson on 28/06/2020.
 */
@RunWith(JUnit4::class)
class LoginActivityTest : BaseInstrumentTest(){

    @get:Rule
    val rule = ActivityTestRule(LoginActivity::class.java, false, false)

    override fun initTest(){
        val intent = Intent()
        rule.launchActivity(intent)
    }

    @Test
    fun shouldDisplayTitle() {
        val expectedTitle = application.getString(R.string.app_name)
        onView(withText(expectedTitle)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldShowInvalidateEmail() {
        val msgError = application.getString(R.string.login_email_invalido)
        onView(withId(btnLogin)).perform(click())
        onView(withId(R.id.textError)).check(matches(withText(msgError)))
    }

    @Test
    fun shouldShowNextScreen() {
        onView(withId(editEmail)).perform(typeText("testeaaaa@gmail.com"))
        onView(withId(btnLogin)).perform(click())
        Thread.sleep(15000)
        onView(withId(R.id.constFeed)).check(matches(isDisplayed()))
    }

}