package ramble.sokol.inversesesc.authentication_and_splash.view.screens

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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay
import ramble.sokol.inversesesc.R
import ramble.sokol.inversesesc.authentication_and_splash.view.components.ButtonForEntry
import ramble.sokol.inversesesc.destinations.BeforeTestScreenDestination
import ramble.sokol.inversesesc.destinations.LoginScreenDestination
import ramble.sokol.inversesesc.destinations.ProfileScreenDestination
import ramble.sokol.inversesesc.ui.theme.ColorDescriptionText
import ramble.sokol.inversesesc.ui.theme.ColorTitle
import ramble.sokol.sberafisha.authentication_and_splash.view.components.TextInputNameEntry
import ramble.sokol.sberafisha.authentication_and_splash.view.components.TextInputPasswordEntry

private lateinit var login: MutableState<String>
private lateinit var password: MutableState<String>

@Composable
@Destination
fun LoginScreen(
    navigator: DestinationsNavigator
){

    val mContext = LocalContext.current

    login = remember {
        mutableStateOf("")
    }

    password = remember {
        mutableStateOf("")
    }

    val transition = rememberInfiniteTransition(label = "")
    val alpha by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 2000
            ),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    LaunchedEffect(
        key1 = true
    ) {
        delay(2000L)
    }

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

        Spacer(modifier = Modifier.padding(top = 8.dp))

        TextInputPasswordEntry(
            text = password.value,
            onValueChange ={
                password.value = it
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
        
        Spacer(modifier = Modifier.padding(top = 8.dp))
        
        ButtonForEntry(text = stringResource(id = R.string.text_to_login)) {
            navigator.popBackStack()
            navigator.navigate(BeforeTestScreenDestination)
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