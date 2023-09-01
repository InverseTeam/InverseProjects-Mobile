package ramble.sokol.inversesesc.profile.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ramble.sokol.inversesesc.R
import ramble.sokol.inversesesc.ui.theme.ColorBackgroundTextField
import ramble.sokol.inversesesc.ui.theme.ColorBoldText

@Composable
fun MoreInformationBlock(
    text: String
) {

    Box (
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = ColorBackgroundTextField,
                shape = RoundedCornerShape(size = 12.dp)
            ),

    ){

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 28.dp, end = 18.dp, top = 23.dp, bottom = 23.dp)){

            Text(
                text = text,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 17.6.sp,
                    fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
                    fontWeight = FontWeight(700),
                    color = ColorBoldText,
                )
            )

            Image(
                painter = painterResource(id = R.drawable.icon_plus),
                contentDescription = "icon plus"
            )

        }

    }

}