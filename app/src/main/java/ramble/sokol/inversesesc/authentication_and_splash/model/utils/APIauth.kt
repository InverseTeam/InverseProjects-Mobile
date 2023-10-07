package ramble.sokol.inversesesc.authentication_and_splash.model.utils

import com.google.gson.JsonObject
import ramble.sokol.inversesesc.authentication_and_splash.model.models.ResponseAuth
import ramble.sokol.inversesesc.authentication_and_splash.model.models.ResponseInfoTest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface APIauth {

    @POST("users/auth/token/login/")
    fun getToken(@Body body: JsonObject): Call<ResponseAuth>

    @GET("users/auth/users/me/")
    fun getInfoForTest(@Header("Authorization") token: String): Call<ResponseInfoTest>

}