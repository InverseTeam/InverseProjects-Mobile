package ramble.sokol.inversesesc.profile.model.models

import com.google.gson.annotations.SerializedName

data class ResponseUserClass(

    @SerializedName("id")
    var id: Int,

    @SerializedName("number")
    var number: Int,

    @SerializedName("litera")
    var litera: String,

    @SerializedName("faculty")
    var faculty: String

)
