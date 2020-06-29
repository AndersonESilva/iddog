package br.com.anderson.iddog.feature

import androidx.test.platform.app.InstrumentationRegistry
import br.com.anderson.iddog.App
import br.com.anderson.iddog.BuildConfig
import br.com.anderson.iddog.service.IdwallService
import br.com.anderson.iddog.util.loadResponse
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.After
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by anderson on 28/06/2020.
 */
abstract class BaseInstrumentTest{

    val application: App by lazy { InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as App }

    val mockServer = MockWebServer()

    lateinit var mockIdwallService: IdwallService

    @Before
    fun setup(){

        mockServer.dispatcher = object : Dispatcher() {
            @Throws(InterruptedException::class)
            override fun dispatch(request: RecordedRequest): MockResponse {
                return when (request.path) {
                    "/signup" -> successResponseSignup
                    else -> errorResponse
                }
            }
        }

        mockServer.start(serverPort)

        mockIdwallService = Retrofit.Builder()
            .baseUrl(mockServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
            .create(IdwallService::class.java)

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
            val body: String = "login_signup.json.json".loadResponse()
            MockResponse()
                .setResponseCode(200)
                .setBody(body).setBodyDelay(2, TimeUnit.SECONDS)
        }

        private val errorResponse by lazy { MockResponse().setResponseCode(404) }
    }
}
