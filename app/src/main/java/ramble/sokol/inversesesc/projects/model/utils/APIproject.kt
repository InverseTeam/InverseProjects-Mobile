package ramble.sokol.inversesesc.profile.model.utils

import ramble.sokol.inversesesc.projects.model.models.ResponseProject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface APIproject {

    @GET("users/auth/users/me/")
    fun getUserInformation(@Header("Authorization") token: String): Call<List<ResponseProject>>

}