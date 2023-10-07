package ramble.sokol.inversesesc.authentication_and_splash.view.screens

import DropDownSpecializationProfile
import android.content.Context
import android.media.session.MediaSession.Token
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.gson.JsonObject
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import ramble.sokol.inversesesc.R
import ramble.sokol.inversesesc.authentication_and_splash.model.models.ResponseAuth
import ramble.sokol.inversesesc.authentication_and_splash.model.models.ResponseInfoTest
import ramble.sokol.inversesesc.authentication_and_splash.model.utils.APIauth
import ramble.sokol.inversesesc.authentication_and_splash.view.components.ButtonForEntry
import ramble.sokol.inversesesc.destinations.AfterTestScreenDestination
import ramble.sokol.inversesesc.destinations.BeforeTestScreenDestination
import ramble.sokol.inversesesc.model_project.RetrofitHelper
import ramble.sokol.inversesesc.model_project.TokenManager
import ramble.sokol.inversesesc.profile.view.components.ItemMoreInformation
import ramble.sokol.inversesesc.profile.view.components.MoreInformationBlock
import ramble.sokol.inversesesc.ui.theme.ColorBackgroundButton
import ramble.sokol.inversesesc.ui.theme.ColorBackgroundTextField
import ramble.sokol.inversesesc.ui.theme.ColorCheckBox
import ramble.sokol.inversesesc.ui.theme.ColorDescriptionText
import ramble.sokol.inversesesc.ui.theme.ColorTextHint
import ramble.sokol.inversesesc.ui.theme.ColorTitle
import ramble.sokol.sberafisha.authentication_and_splash.view.components.InputTextEntry
import ramble.sokol.sberafisha.authentication_and_splash.view.components.MultiLineInputTextEntry
import ramble.sokol.sberafisha.authentication_and_splash.view.components.TextInputStatic
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

lateinit var currentScreen: MutableState<Int>
private lateinit var email: MutableState<String>
private lateinit var telegram: MutableState<String>
private lateinit var checked: MutableState<Boolean>
private lateinit var aboutMe: MutableState<String>
private lateinit var phone: MutableState<String>
private lateinit var firstname: MutableState<String>
private lateinit var lastname: MutableState<String>
private lateinit var userClass: MutableState<String>
private lateinit var apiAuth: APIauth
private lateinit var tokenManager: TokenManager

@Destination
@Composable
fun CreateProfileScreen(
    navigator: DestinationsNavigator
){

    val context = LocalContext.current

    tokenManager = TokenManager(context)

    currentScreen = remember {
        mutableIntStateOf(1)
    }

    apiAuth = RetrofitHelper.getInstance().create(APIauth::class.java)

    var clickItemOne by remember {
        mutableStateOf(false)
    }

    val iconItemOne: Int =
        if (clickItemOne)
            R.drawable.icon_hide_content
        else
            R.drawable.icon_plus

    var clickItemTwo by remember {
        mutableStateOf(false)
    }

    val iconItemTwo: Int =
        if (clickItemTwo)
            R.drawable.icon_hide_content
        else
            R.drawable.icon_plus

    var clickItemThree by remember {
        mutableStateOf(false)
    }

    val iconItemThree: Int =
        if (clickItemThree)
            R.drawable.icon_hide_content
        else
            R.drawable.icon_plus


    email = remember {
        mutableStateOf("")
    }

    telegram = remember {
        mutableStateOf("")
    }

    checked = remember {
        mutableStateOf(false)
    }

    aboutMe = remember {
        mutableStateOf("")
    }

    phone = remember {
        mutableStateOf("")
    }

    firstname = remember {
        mutableStateOf("")
    }

    lastname = remember {
        mutableStateOf("")
    }

    userClass = remember {
        mutableStateOf("")
    }

    getInfoData(context)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(bottom = 37.dp, start = 32.dp, end = 32.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        when (currentScreen.value) {
            1 -> {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 13.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){

                    Spacer(modifier = Modifier.padding(top = 13.dp))

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = R.string.text_acquaintance),
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
                            fontWeight = FontWeight(700),
                            color = ColorTitle,
                            letterSpacing = 0.24.sp,
                        ),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.padding(top = 32.dp))

                    Box(
                        modifier = Modifier.fillMaxWidth(0.45f),
                        contentAlignment = Alignment.BottomEnd
                    ){

                        Image(
                            painter = painterResource(id = R.drawable.image_add_photo),
                            contentDescription = "image add photo"
                        )

                        Box(
                            modifier = Modifier.fillMaxWidth(0.4f),
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.icon_add_photo),
                                contentDescription = "image add photo"
                            )
                        }

                    }

                    Spacer(modifier = Modifier.padding(top = 26.dp))

                    TextInputStatic(text = firstname.value,
                        textHint = stringResource(id = R.string.text_name),
                        onValueChange = {})

                    Spacer(modifier = Modifier.padding(top = 8.dp))

                    TextInputStatic(text = lastname.value,
                        textHint = stringResource(id = R.string.text_surname),
                        onValueChange = {})

                    Spacer(modifier = Modifier.padding(top = 8.dp))

                    TextInputStatic(text = userClass.value,
                        textHint = stringResource(id = R.string.text_class),
                        onValueChange = {})

                    Spacer(modifier = Modifier.padding(top = 32.dp))

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = R.string.text_frequent_questions),
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.lab_grotesque_medium)),
                            fontWeight = FontWeight(500),
                            color = ColorTitle,
                            letterSpacing = 0.18.sp,
                        ),
                        textAlign = TextAlign.Start
                    )

                    Spacer(modifier = Modifier.padding(top = 8.dp))

                    MoreInformationBlock(
                        text = stringResource(id = R.string.text_frequent_questions_two),
                        idPainter = iconItemTwo
                    ) {
                        clickItemTwo = !clickItemTwo
                    }

                    if (clickItemTwo){

                        Spacer(modifier = Modifier.padding(top = 8.dp))

                        ItemMoreInformation(
                            textTitle = stringResource(id = R.string.text_frequent_questions_two),
                            textDescription = stringResource(id = R.string.text_frequent_questions_description_two)
                        )

                    }

                    Spacer(modifier = Modifier.padding(top = 8.dp))

                    MoreInformationBlock(
                        text = stringResource(id = R.string.text_frequent_questions_one),
                        idPainter = iconItemOne
                    ) {
                        clickItemOne = !clickItemOne
                    }

                    if (clickItemOne){

                        Spacer(modifier = Modifier.padding(top = 8.dp))

                        ItemMoreInformation(
                            textTitle = stringResource(id = R.string.text_full_out_profile),
                            textDescription = stringResource(id = R.string.text_frequent_questions_description_one),
                            isImage = true
                        )

                    }

                }

                Spacer(Modifier.padding(top = 25.dp))

            }
            2 -> {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){

                    Spacer(modifier = Modifier.padding(top = 13.dp))

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = R.string.text_acquaintance),
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
                            fontWeight = FontWeight(700),
                            color = ColorTitle,
                            letterSpacing = 0.24.sp,
                        ),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.padding(top = 32.dp))

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = R.string.text_contacts),
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.lab_grotesque_medium)),
                            fontWeight = FontWeight(500),
                            color = ColorTitle,
                            letterSpacing = 0.18.sp,
                        ),
                        textAlign = TextAlign.Start
                    )

                    Spacer(modifier = Modifier.padding(top = 8.dp))

                    InputTextEntry(
                        text = phone.value,
                        onValueChange = {
                            phone.value = it
                        },
                        idText = R.string.text_phone_number,
                        interactionSource = remember { MutableInteractionSource() }
                            .also { interactionSource ->
                                LaunchedEffect(interactionSource) {
                                    interactionSource.interactions.collect {
                                        if (it is PressInteraction.Release) {

                                        }
                                    }
                                }
                            }
                    )

                    Spacer(modifier = Modifier.padding(top = 8.dp))

                    InputTextEntry(
                        text = email.value,
                        onValueChange = {
                            email.value = it
                        },
                        idText = R.string.text_email,
                        interactionSource = remember { MutableInteractionSource() }
                            .also { interactionSource ->
                                LaunchedEffect(interactionSource) {
                                    interactionSource.interactions.collect {
                                        if (it is PressInteraction.Release) {

                                        }
                                    }
                                }
                            }
                    )

                    Spacer(modifier = Modifier.padding(top = 8.dp))

                    InputTextEntry(
                        text = telegram.value,
                        idText = R.string.text_telegram,
                        onValueChange = {
                            telegram.value = it
                        },
                        interactionSource = remember { MutableInteractionSource() }
                            .also { interactionSource ->
                                LaunchedEffect(interactionSource) {
                                    interactionSource.interactions.collect {
                                        if (it is PressInteraction.Release) {

                                        }
                                    }
                                }
                            }
                    )

                    Spacer(modifier = Modifier.padding(top = 17.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ){

                        Checkbox(
                            modifier = Modifier
                                .width(24.dp)
                                .height(24.dp),
                            checked = checked.value,
                            onCheckedChange = { checked_ ->
                                checked.value = checked_
                            },
                            colors = CheckboxDefaults.colors(
                                checkedColor = ColorCheckBox
                            )
                        )

                        Spacer(modifier = Modifier.padding(start = 8.dp))

                        Text(
                            text = stringResource(id = R.string.text_view_data_checkbox),
                            style = TextStyle(
                                fontSize = 18.sp,
                                lineHeight = 16.sp,
                                fontFamily = FontFamily(Font(R.font.lab_grotesque_medium)),
                                fontWeight = FontWeight(400),
                                color = ColorTextHint,
                            )
                        )

                    }
                }

                Spacer(Modifier.padding(top = 25.dp))

            }
            3 -> {

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.padding(top = 13.dp))

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = R.string.text_acquaintance),
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
                            fontWeight = FontWeight(700),
                            color = ColorTitle,
                            letterSpacing = 0.24.sp,
                        ),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.padding(top = 32.dp))

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = R.string.text_frequent_questions),
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.lab_grotesque_medium)),
                            fontWeight = FontWeight(500),
                            color = ColorTitle,
                            letterSpacing = 0.18.sp,
                        ),
                        textAlign = TextAlign.Start
                    )

                    Spacer(modifier = Modifier.padding(top = 8.dp))

                    MoreInformationBlock(
                        text = stringResource(id = R.string.text_frequent_questions_three),
                        idPainter = iconItemThree
                    ) {
                        clickItemThree = !clickItemThree
                    }

                    if (clickItemThree){

                        Spacer(modifier = Modifier.padding(top = 8.dp))

                        ItemMoreInformation(
                            textTitle = stringResource(id = R.string.text_frequent_questions_three),
                            textDescription = stringResource(id = R.string.text_frequent_questions_description_three)
                        )

                    }

                    Spacer(modifier = Modifier.padding(top = 32.dp))

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = R.string.text_about_me),
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.lab_grotesque_medium)),
                            fontWeight = FontWeight(500),
                            color = ColorTitle,
                            letterSpacing = 0.18.sp,
                        ),
                        textAlign = TextAlign.Start
                    )

                    Spacer(modifier = Modifier.padding(top = 8.dp))

                    DropDownSpecializationProfile()

                    Spacer(modifier = Modifier.padding(top = 8.dp))

                    MultiLineInputTextEntry(
                        text = aboutMe.value,
                        idText = R.string.text_about_me,
                        onValueChange = {
                            aboutMe.value = it
                        },
                        interactionSource = remember { MutableInteractionSource() }
                            .also { interactionSource ->
                                LaunchedEffect(interactionSource) {
                                    interactionSource.interactions.collect {
                                        if (it is PressInteraction.Release) {

                                        }
                                    }
                                }
                            })

                    Spacer(modifier = Modifier.padding(top = 8.dp))

                }

            }
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .weight(0.33f)
                        .background(
                            color = if (currentScreen.value > 0) ColorBackgroundButton else ColorBackgroundTextField,
                            shape = RoundedCornerShape(size = 24.dp)
                        )
                )
                Spacer(modifier = Modifier.padding(start = 8.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .weight(0.33f)
                        .background(
                            color = if (currentScreen.value > 1) ColorBackgroundButton else ColorBackgroundTextField,
                            shape = RoundedCornerShape(size = 24.dp)
                        )
                )
                Spacer(modifier = Modifier.padding(start = 8.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .weight(0.33f)
                        .background(
                            color = if (currentScreen.value > 2) ColorBackgroundButton else ColorBackgroundTextField,
                            shape = RoundedCornerShape(size = 24.dp)
                        )
                )
            }

            Spacer(modifier = Modifier.padding(top = 8.dp))

            ButtonForEntry(text = stringResource(id = R.string.text_continue)) {
                if (currentScreen.value == 3){
                    navigator.popBackStack()
                    navigator.navigate(AfterTestScreenDestination)
                }
                currentScreen.value++
            }

        }

    }

}

fun getInfoData(context: Context) {

    val token = tokenManager.getToken()

    val call = apiAuth.getInfoForTest("Token $token")

    call.enqueue(object : Callback<List<ResponseInfoTest>> {
        override fun onResponse(call: Call<List<ResponseInfoTest>>, response: Response<List<ResponseInfoTest>>) {
            if (response.isSuccessful) {

                val responseBody = response.body()
                firstname.value = responseBody?.get(0)!!.firstname
                lastname.value = responseBody[0].lastname
                userClass.value = "${responseBody[0].schoolClass.number}${responseBody[0].schoolClass.litera}"
            } else {
                // что то должно быть
            }
        }

        override fun onFailure(call: Call<List<ResponseInfoTest>>, t: Throwable) {
            Toast.makeText(context, R.string.text_toast_no_internet, Toast.LENGTH_SHORT).show()
            Log.d("MyLog", t.message.toString())
        }
    })



}
