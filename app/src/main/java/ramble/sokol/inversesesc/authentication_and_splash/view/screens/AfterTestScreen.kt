package ramble.sokol.inversesesc.authentication_and_splash.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
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
import ramble.sokol.inversesesc.authentication_and_splash.view.components.ButtonForSkip
import ramble.sokol.inversesesc.destinations.BottomMenuScreenDestination
import ramble.sokol.inversesesc.ui.theme.ColorDescriptionText
import ramble.sokol.inversesesc.ui.theme.ColorTitle

@Destination
@Composable
fun AfterTestScreen(
    navigator: DestinationsNavigator
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 34.dp, top = 15.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
            ){

            Text(
                text = stringResource(id = R.string.text_final_login),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
                    fontWeight = FontWeight(900),
                    color = ColorTitle,
                    letterSpacing = 0.12.sp,
                )
            )

            Spacer(modifier = Modifier.padding(top = 8.dp))

            Text(
                text = stringResource(id = R.string.text_description_final_login),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.lab_grotesque_medium)),
                    fontWeight = FontWeight(500),
                    color = ColorDescriptionText,
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.1.sp,
                )
            )

            Spacer(modifier = Modifier.padding(top = 90.dp))

            Image(
                modifier = Modifier
                    .width(370.685.dp)
                    .height(320.57501.dp),
                painter = painterResource(id = R.drawable.image_final_login),
                contentDescription = "image_final_login",
                contentScale = ContentScale.Crop
            )
            
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            ButtonForEntry(text = stringResource(id = R.string.text_to_app)) {
                navigator.popBackStack()
                navigator.navigate(BottomMenuScreenDestination)
            }

        }

    }
}