package br.com.anderson.iddog.feature

import androidx.test.platform.app.InstrumentationRegistry
import br.com.anderson.iddog.App
import br.com.anderson.iddog.MockServer
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.After
import org.junit.Before

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
                    "/signup" -> MockServer.successResponseSignup
                    "/feed?category=husky" -> MockServer.sucessResponseFeedCategoty(request.path!!)
                    "/feed?category=hound" -> MockServer.sucessResponseFeedCategoty(request.path!!)
                    "/feed?category=pug" -> MockServer.sucessResponseFeedCategoty(request.path!!)
                    "/feed?category=labrador" -> MockServer.sucessResponseFeedCategoty(request.path!!)
                    else -> MockServer.errorResponse
                }
            }
        }

        mockServer.start(MockServer.serverPort)
        initTest()
    }

    open fun initTest(){}

    @After
    fun after(){
        mockServer.shutdown()
    }
}
