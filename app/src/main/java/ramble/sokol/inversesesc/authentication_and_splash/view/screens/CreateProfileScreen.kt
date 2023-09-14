package ramble.sokol.inversesesc.authentication_and_splash.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import ramble.sokol.inversesesc.R
import ramble.sokol.inversesesc.authentication_and_splash.view.components.ButtonForEntry
import ramble.sokol.inversesesc.authentication_and_splash.view.components.StatusTestLayout
import ramble.sokol.inversesesc.ui.theme.ColorBackgroundTextField
import ramble.sokol.inversesesc.ui.theme.ColorDescriptionText

@Destination
@Composable
fun CreateProfileScreen(
    navigator: DestinationsNavigator
){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 13.dp, bottom = 37.dp, start = 32.dp, end = 32.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            
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
                    modifier = Modifier.fillMaxSize(0.4f),
                    contentAlignment = Alignment.BottomEnd
                ){
                    Image(
                        painter = painterResource(id = R.drawable.icon_add_photo),
                        contentDescription = "image add photo"
                    )
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
                StatusTestLayout(color = ColorBackgroundTextField, 0.3f)
                Spacer(modifier = Modifier.padding(start = 8.dp))
                StatusTestLayout(color = ColorBackgroundTextField, 0.3f)
                Spacer(modifier = Modifier.padding(start = 8.dp))
                StatusTestLayout(color = ColorBackgroundTextField, 0.3f)
            }

            Spacer(modifier = Modifier.padding(top = 8.dp))

            ButtonForEntry(text = stringResource(id = R.string.text_continue)) {

            }

        }

    }

}