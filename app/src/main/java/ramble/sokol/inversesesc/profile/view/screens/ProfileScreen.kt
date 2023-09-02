package ramble.sokol.inversesesc.profile.view.screens

import android.util.Log
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import ramble.sokol.inversesesc.profile.view.components.ItemMoreInformation
import ramble.sokol.inversesesc.profile.view.components.MoreInformationBlock
import ramble.sokol.inversesesc.ui.theme.ColorTitle

@Destination
@Composable
fun ProfileScreen(){

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
            text = stringResource(id = R.string.text_frequent_questions_one),
            idPainter = iconItemOne
        ) {
            clickItemOne = !clickItemOne
        }

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