package ramble.sokol.inversesesc.authentication_and_splash.model.models

import com.google.gson.annotations.SerializedName

data class ResponseClassTest(

    @SerializedName("id")
    var id: Int,

    @SerializedName("number")
    var number: Int,

    @SerializedName("litera")
    var litera: String,

    @SerializedName("faculty")
    var faculty: String

)
