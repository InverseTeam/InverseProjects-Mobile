package ramble.sokol.inversesesc.profile.model.models

import com.google.gson.annotations.SerializedName

data class ResponseUserInfo(

    @SerializedName("id")
    var id: Int,

    @SerializedName("username")
    var username: String,

    @SerializedName("cover")
    var cover: String,

    @SerializedName("firstname")
    var firstname: String,

    @SerializedName("lastname")
    var lastname: String,

    @SerializedName("bio")
    var bio: String,

    @SerializedName("speciality")
    var speciality: ResponseSpeciality,

    @SerializedName("email")
    var email: String,

    @SerializedName("telegram")
    var telegram: String,

    @SerializedName("phone_number")
    var phone_number: String,

    @SerializedName("school_class")
    var schoolClass: ResponseUserClass,

    @SerializedName("organization")
    var organization: String,

    @SerializedName("public")
    var public: Boolean
)
