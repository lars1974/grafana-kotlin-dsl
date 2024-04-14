import client.GrafanaPublisher
import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

import java.util.*

object TestTokens {
    private var token: String? = null

    fun getToken() = token ?: generateToken().also { token = it }


    fun generateToken(): String {
        val existsReq = Request.Builder().url("http://localhost:3000/api/serviceaccounts/2").headers(createHeader()).build()

        OkHttpClient().newCall(existsReq).execute().use { response ->
            if (response.code != 200) {
                val req = Request.Builder().url("http://localhost:3000/api/serviceaccounts").headers(createHeader())
                    .post("{\"name\":\"test8\", \"role\": \"Admin\"}".toRequestBody(GrafanaPublisher.JSON)).build()
                OkHttpClient().newCall(req).execute()
            }
        }

        val tokenReq = Request.Builder()
            .url("http://localhost:3000/api/serviceaccounts/2/tokens")
            .headers(createHeader())
            .post("{\"name\":\"test-token${System.currentTimeMillis()}\"}".toRequestBody(GrafanaPublisher.JSON))
            .build()

        OkHttpClient().newCall(tokenReq).execute().use { response ->
            return ObjectMapper().readTree(response.body?.string()).get("key").asText()
        }
    }

    fun createHeader(): Headers {
        val encoded = Base64.getEncoder().encodeToString("admin:test".toByteArray())
        return Headers.Builder()
            .add("Content-Type", "application/json")
            .add("Authorization", "Basic $encoded").build()

    }

}