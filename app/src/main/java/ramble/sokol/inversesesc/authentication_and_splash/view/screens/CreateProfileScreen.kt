package ramble.sokol.inversesesc.authentication_and_splash.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
import ramble.sokol.inversesesc.R
import ramble.sokol.inversesesc.authentication_and_splash.view.components.ButtonForEntry
import ramble.sokol.inversesesc.ui.theme.ColorBackgroundButton
import ramble.sokol.inversesesc.ui.theme.ColorBackgroundTextField
import ramble.sokol.inversesesc.ui.theme.ColorDescriptionText
import ramble.sokol.inversesesc.ui.theme.ColorTitle

lateinit var currentScreen: MutableState<Int>

@Destination
@Composable
fun CreateProfileScreen(
    navigator: DestinationsNavigator
){

    currentScreen = remember {
        mutableIntStateOf(1)
    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 13.dp, bottom = 37.dp, start = 32.dp, end = 32.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (currentScreen.value == 1){
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
                            color = if (currentScreen.value < 4) ColorBackgroundButton else ColorBackgroundTextField,
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
                            color = if (currentScreen.value < 3) ColorBackgroundButton else ColorBackgroundTextField,
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
                            color = if (currentScreen.value < 2) ColorBackgroundButton else ColorBackgroundTextField,
                            shape = RoundedCornerShape(size = 24.dp)
                        )
                )
            }

            Spacer(modifier = Modifier.padding(top = 8.dp))

            ButtonForEntry(text = stringResource(id = R.string.text_continue)) {
                currentScreen.value++
            }

        }

    }

}