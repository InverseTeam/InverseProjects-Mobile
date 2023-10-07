package ramble.sokol.inversesesc.profile.model.utils

import ramble.sokol.inversesesc.profile.model.models.ResponseUserInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface APIprofile {

    @GET("users/auth/users/me/")
    fun getUserInformation(@Header("Authorization") token: String): Call<ResponseUserInfo>

}