package ramble.sokol.inversesesc.authentication_and_splash.model.utils

import com.google.gson.JsonObject
import ramble.sokol.inversesesc.authentication_and_splash.model.models.ResponseAuth
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface APIauth {

    @POST("users/auth/token/login/")
    fun getToken(@Body body: JsonObject): Call<ResponseAuth>

}