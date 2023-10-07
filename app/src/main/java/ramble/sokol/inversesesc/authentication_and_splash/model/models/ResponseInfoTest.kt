package ramble.sokol.inversesesc.authentication_and_splash.model.models

import com.google.gson.annotations.SerializedName

data class ResponseInfoTest(

    @SerializedName("firstname")
    var firstname: String,

    @SerializedName("lastname")
    var lastname: String,

    @SerializedName("school_class")
    var schoolClass: ResponseClassTest

)

