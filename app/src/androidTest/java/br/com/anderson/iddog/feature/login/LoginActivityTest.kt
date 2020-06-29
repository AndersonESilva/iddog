package br.com.anderson.iddog.feature.login

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import br.com.anderson.iddog.R
import br.com.anderson.iddog.R.id.btnLogin
import br.com.anderson.iddog.data.request.SignupRequest
import br.com.anderson.iddog.feature.BaseInstrumentTest
import br.com.anderson.iddog.feature.login.activity.LoginActivity
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by anderson on 28/06/2020.
 */
@LargeTest
@RunWith(JUnit4::class)
class LoginActivityTest : BaseInstrumentTest(){

    @get:Rule
    val rule = ActivityTestRule(LoginActivity::class.java, false, false)

    @Test
    fun shouldDisplayTitle() {
        val intent = Intent()
        rule.launchActivity(intent)

        val expectedTitle = application.getString(R.string.app_name)

        onView(withText(expectedTitle)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldShowInvalidateEmail() {
        val intent = Intent()
        rule.launchActivity(intent)

        val msgError = application.getString(R.string.login_email_invalido)

        onView(withId(btnLogin)).perform(click())
        onView(withId(R.id.textError)).check(matches(withText(msgError)))
    }

}