package ramble.sokol.inversesesc.profile.model.models

import com.google.gson.annotations.SerializedName

data class ResponseSpeciality(

    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String

)
