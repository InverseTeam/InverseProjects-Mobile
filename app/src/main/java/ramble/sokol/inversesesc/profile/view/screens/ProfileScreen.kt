package ramble.sokol.inversesesc.profile.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import ramble.sokol.inversesesc.R
import ramble.sokol.inversesesc.profile.view.components.MoreInformationBlock
import ramble.sokol.inversesesc.ui.theme.ColorTitle

@Destination
@Composable
fun ProfileScreen(){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 33.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        
        Spacer(modifier = Modifier.padding(top = 17.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.text_profile),
            style = TextStyle(
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
                fontWeight = FontWeight(700),
                color = ColorTitle,
                letterSpacing = 0.24.sp,
                textAlign = TextAlign.Start
            )
        )
        
        Spacer(modifier = Modifier.padding(top = 32.dp))

        Box(
            modifier = Modifier.fillMaxWidth(0.45f),
            contentAlignment = Alignment.Center
        ){

            Image(
                painter = painterResource(id = R.drawable.image_add_photo),
                contentDescription = "image add photo"
            )

        }

        
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

        MoreInformationBlock(text = stringResource(id = R.string.text_frequent_questions_one))

        Spacer(modifier = Modifier.padding(top = 8.dp))

        MoreInformationBlock(text = stringResource(id = R.string.text_frequent_questions_two))

        Spacer(modifier = Modifier.padding(top = 8.dp))

        MoreInformationBlock(text = stringResource(id = R.string.text_frequent_questions_three))



        Spacer(modifier = Modifier.padding(top = 32.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.text_general_information),
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.lab_grotesque_medium)),
                fontWeight = FontWeight(500),
                color = ColorTitle,
                letterSpacing = 0.18.sp,
            ),
            textAlign = TextAlign.Start
        )

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

        Spacer(modifier = Modifier.padding(top = 32.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.text_experience_in_projects),
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.lab_grotesque_medium)),
                fontWeight = FontWeight(500),
                color = ColorTitle,
                letterSpacing = 0.18.sp,
            ),
            textAlign = TextAlign.Start
        )

    }

}