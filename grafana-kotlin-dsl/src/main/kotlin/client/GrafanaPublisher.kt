package client

import dashboard.DashBoardWrapper
import datasource.DataSource
import folder.Folder
import okhttp3.Headers
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.util.Base64

class GrafanaPublisher(val baseUrl: String = "http://localhost:3000", val token: String = "", val authType: AuthType = AuthType.Bearer) {

    private val client = OkHttpClient()

    fun createHeaders(): Headers {
        val builder = Headers.Builder().add("Content-Type", "application/json")
        if (authType == AuthType.Basic) builder.add("Authorization", "Basic ${Base64.getEncoder().encodeToString(token.toByteArray())}")
        else builder.add("Authorization", "Bearer $token")
        return builder.build()
    }

    fun publish(dashBoard: DashBoardWrapper) {
        println(dashBoard.node.toPrettyString())
        postJson("$baseUrl/api/dashboards/db", dashBoard.node.toPrettyString())
    }

    fun publish(folder: Folder) {
        postPut("$baseUrl/api/folders", folder.node.get("uid").asText(), folder.node.toPrettyString())
    }

    fun publish(dataSource: DataSource) {
        postPut("$baseUrl/api/datasources", dataSource.node.get("uid").asText(), dataSource.node.toPrettyString())
    }

    fun postPut(url: String, uid: String, json: String) {
        val request = Request.Builder().url("$url/$uid").headers(createHeaders()).build()

        client.newCall(request).execute().use { response ->
            val request = if (response.isSuccessful) Request.Builder().url("$url/$uid").headers(createHeaders()).put(json.toRequestBody(JSON)).build()
            else Request.Builder().url(url).headers(createHeaders()).post(json.toRequestBody(JSON)).build()

            client.newCall(request).execute().use {
                println("" + it.code + it.message)
            }
        }
    }

    fun postJson(url: String, json: String) {

        val request = Request.Builder()
            .url(url).headers(createHeaders()).post(json.toRequestBody(JSON)).build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) println("POST SUCCESS " + response.code)
        }
    }

    companion object {
        val JSON: MediaType = "application/json; charset=utf-8".toMediaType()
    }

    enum class AuthType {
        Basic, Bearer
    }
}