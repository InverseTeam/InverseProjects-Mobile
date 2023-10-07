package ramble.sokol.inversesesc.authentication_and_splash.view.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import kotlinx.coroutines.delay
import ramble.sokol.inversesesc.R
import ramble.sokol.inversesesc.authentication_and_splash.model.models.ResponseAuth
import ramble.sokol.inversesesc.authentication_and_splash.model.utils.APIauth
import ramble.sokol.inversesesc.authentication_and_splash.view.components.ButtonForEntry
import ramble.sokol.inversesesc.authentication_and_splash.view.components.ProgressBarAuth
import ramble.sokol.inversesesc.destinations.BeforeTestScreenDestination
import ramble.sokol.inversesesc.destinations.BottomMenuScreenDestination
import ramble.sokol.inversesesc.destinations.LoginScreenDestination
import ramble.sokol.inversesesc.destinations.ProfileScreenDestination
import ramble.sokol.inversesesc.model_project.FirstEntryManager
import ramble.sokol.inversesesc.model_project.RetrofitHelper
import ramble.sokol.inversesesc.model_project.TokenManager
import ramble.sokol.inversesesc.ui.theme.ColorDescriptionText
import ramble.sokol.inversesesc.ui.theme.ColorError
import ramble.sokol.inversesesc.ui.theme.ColorTitle
import ramble.sokol.sberafisha.authentication_and_splash.view.components.TextInputNameEntry
import ramble.sokol.sberafisha.authentication_and_splash.view.components.TextInputPasswordEntry
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private lateinit var login: MutableState<String>
private lateinit var password: MutableState<String>
private lateinit var tokenManager: TokenManager
private lateinit var firstEntryManager: FirstEntryManager
private lateinit var incorrectData: MutableState<Boolean>
private lateinit var progressEntryState: MutableState<Boolean>
private lateinit var apiAuth: APIauth

@Composable
@Destination
fun LoginScreen(
    navigator: DestinationsNavigator
){

    val mContext = LocalContext.current

    tokenManager = TokenManager(mContext)

    firstEntryManager = FirstEntryManager(mContext)

    apiAuth = RetrofitHelper.getInstance().create(APIauth::class.java)

    incorrectData = remember {
        mutableStateOf(false)
    }

    progressEntryState = remember {
        mutableStateOf(false)
    }

    login = remember {
        mutableStateOf("")
    }

    password = remember {
        mutableStateOf("")
    }

    var nameError by remember {
        mutableStateOf(false)
    }

    var passwordError by remember {
        mutableStateOf(false)
    }

//    val transition = rememberInfiniteTransition(label = "")
//    val alpha by transition.animateFloat(
//        initialValue = 0f,
//        targetValue = 1f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(
//                durationMillis = 2000
//            ),
//            repeatMode = RepeatMode.Reverse
//        ), label = ""
//    )
//
//    LaunchedEffect(
//        key1 = true
//    ) {
//        delay(2000L)
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 31.dp)
            //.alpha(alpha = alpha),
                ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.text_login),
            style = TextStyle(
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
                fontWeight = FontWeight(900),
                color = ColorTitle,
                letterSpacing = 0.12.sp,
                textAlign = TextAlign.Start
            )
        )

        Spacer(modifier = Modifier.padding(top = 23.dp))
        
        TextInputNameEntry(
            text = login.value,
            onValueChange = {
                login.value = it
                nameError = false
                passwordError = false
                incorrectData.value = false
            },
            borderWidth = if (nameError) 1 else 0,
            color = if (nameError) ColorError else Color.Transparent,
            interactionSource = remember { MutableInteractionSource() }
                .also { interactionSource ->
                    LaunchedEffect(interactionSource) {
                        interactionSource.interactions.collect {
                            if (it is PressInteraction.Release) {
                                nameError = false
                                passwordError = false
                                incorrectData.value = false
                            }
                        }
                    }
                }
        )

        Spacer(modifier = Modifier.padding(top = 8.dp))

        TextInputPasswordEntry(
            text = password.value,
            onValueChange ={
                password.value = it
                nameError = false
                passwordError = false
                incorrectData.value = false
            },
            borderWidth = if (passwordError) 1 else 0,
            color = if (passwordError) ColorError else Color.Transparent,
            interactionSource = remember { MutableInteractionSource() }
                .also { interactionSource ->
                    LaunchedEffect(interactionSource) {
                        interactionSource.interactions.collect {
                            if (it is PressInteraction.Release) {
                                nameError = false
                                passwordError = false
                                incorrectData.value = false
                            }
                        }
                    }
                }
        )

        if (incorrectData.value){
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, top = 8.dp)){

                Text(
                    text = stringResource(id = R.string.text_incorrect_data_entry),
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 16.sp,
                        fontFamily = FontFamily(Font(R.font.lab_grotesque_regular)),
                        fontWeight = FontWeight(400),
                        color = ColorError,
                        textAlign = TextAlign.Center,
                    )
                )
            }
        }
        
        Spacer(modifier = Modifier.padding(top = 8.dp))

        if (progressEntryState.value){

            Box(
                modifier = Modifier.fillMaxWidth().height(52.dp),
                contentAlignment = Alignment.Center
            ){
                ProgressBarAuth()
            }
        }else{
            ButtonForEntry(text = stringResource(id = R.string.text_to_login)) {
                if (password.value.isEmpty()){
                    passwordError = true
                }
                if (login.value.isEmpty()){
                    nameError = true
                }
                if (login.value.isNotEmpty() && password.value.isNotEmpty()) {
                    progressEntryState.value = true
                    entry(mContext, navigator, login.value, password.value)
                }
            }
        }


        
        Spacer(modifier = Modifier.padding(top = 16.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.text_hint_login),
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Font(R.font.lab_grotesque_regular)),
                fontWeight = FontWeight(400),
                color = ColorDescriptionText,
                textAlign = TextAlign.Center,
            )
        )

    }
}

private fun entry(context: Context, navigator: DestinationsNavigator, email: String, password: String){

    val body = JsonObject().apply {
        addProperty("username", email)
        addProperty("password", password)
    }
    val call = apiAuth.getToken(body)

    call.enqueue(object : Callback<ResponseAuth> {
        override fun onResponse(call: Call<ResponseAuth>, response: Response<ResponseAuth>) {
            if (response.isSuccessful) {

                val responseBody = response.body()
                tokenManager.saveToken(responseBody!!.authToken)
                firstEntryManager.saveFirstEntry(true)
                progressEntryState.value = false
                Toast.makeText(context, R.string.text_successful_entry, Toast.LENGTH_SHORT).show()
                navigator.popBackStack()
                navigator.navigate(BeforeTestScreenDestination)
            } else {
                progressEntryState.value = false
                incorrectData.value = true
            }
        }

        override fun onFailure(call: Call<ResponseAuth>, t: Throwable) {
            Toast.makeText(context, R.string.text_toast_no_internet, Toast.LENGTH_SHORT).show()
            progressEntryState.value = false
        }
    })


}
