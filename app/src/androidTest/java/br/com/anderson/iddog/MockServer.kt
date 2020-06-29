package br.com.anderson.iddog

import br.com.anderson.iddog.util.loadResponse
import okhttp3.mockwebserver.MockResponse
import java.util.concurrent.TimeUnit

/**
 * Created by anderson on 29/06/2020.
 */
class MockServer {

    companion object {
        const val serverPort = 8080

        val successResponseSignup by lazy {
            val body: String = "login/login_signup.json".loadResponse()
            MockResponse()
                .setResponseCode(200)
                .setBody(body).setBodyDelay(2, TimeUnit.SECONDS)
        }

        fun sucessResponseFeedCategoty(path: String): MockResponse{
            var body = when (path) {
                "/feed?category=husky" -> "feed/feed_husky.json".loadResponse()
                "/feed?category=hound" -> "feed/feed_hound.json".loadResponse()
                "/feed?category=pug" -> "feed/feed_pug.json".loadResponse()
                "/feed?category=labrador" -> "feed/feed_labrador.json".loadResponse()
                else -> "feed/feed_husky.json".loadResponse()
            }

            return MockResponse()
                .setResponseCode(200)
                .setBody(body).setBodyDelay(2, TimeUnit.SECONDS)
        }

        val errorResponse by lazy { MockResponse().setResponseCode(404) }
    }
}
