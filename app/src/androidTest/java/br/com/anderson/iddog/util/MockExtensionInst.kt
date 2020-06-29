package br.com.anderson.iddog.util

import androidx.test.platform.app.InstrumentationRegistry
import java.io.IOException

/**
 * Created by anderson on 28/06/2020.
 */
fun String.loadResponse(featurePath: String = ""): String {
    try {
        val pathFormatted = if(featurePath.isNotEmpty()) "$featurePath/" else featurePath
        val stream = InstrumentationRegistry.getInstrumentation()
            .context
            .resources
            .assets
            .open("mockResponses/$pathFormatted$this")

        val size = stream.available()
        val buffer = ByteArray(size)
        stream.read(buffer)
        stream.close()
        return String(buffer)
    } catch (e: IOException) {
        throw e
    }
}