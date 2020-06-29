package br.com.anderson.iddog.feature

import androidx.test.platform.app.InstrumentationRegistry
import br.com.anderson.iddog.App
import br.com.anderson.iddog.util.loadResponse
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.After
import org.junit.Before
import java.util.concurrent.TimeUnit

/**
 * Created by anderson on 28/06/2020.
 */
abstract class BaseInstrumentTest{

    val application: App by lazy { InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as App }

    val mockServer = MockWebServer()

    @Before
    fun setup(){
        mockServer.dispatcher = object : Dispatcher() {
            @Throws(InterruptedException::class)
            override fun dispatch(request: RecordedRequest): MockResponse {
                return when (request.path) {
                    "/signup" -> successResponseSignup
                    "/feed?category=husky" -> successResponseFeed
                    else -> errorResponse
                }
            }
        }

        mockServer.start(serverPort)
        initTest()
    }

    open fun initTest(){}

    @After
    fun after(){
        mockServer.shutdown()
    }

    companion object {
        private const val serverPort = 8080

        private val successResponseSignup by lazy {
            val body: String = "login_signup.json".loadResponse()
            MockResponse()
                .setResponseCode(200)
                .setBody(body).setBodyDelay(2, TimeUnit.SECONDS)
        }

        private val successResponseFeed by lazy {
            val body: String = "feed_husky.json".loadResponse()
            MockResponse()
                .setResponseCode(200)
                .setBody(body).setBodyDelay(2, TimeUnit.SECONDS)
        }

        private val errorResponse by lazy { MockResponse().setResponseCode(404) }
    }
}
