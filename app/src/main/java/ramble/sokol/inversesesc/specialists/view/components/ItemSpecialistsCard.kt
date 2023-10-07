package ramble.sokol.inversesesc.specialists.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ramble.sokol.inversesesc.R
import ramble.sokol.inversesesc.profile.view.components.ButtonForContactsProfile
import ramble.sokol.inversesesc.ui.theme.ColorBackgroundTextField
import ramble.sokol.inversesesc.ui.theme.ColorBoldText
import ramble.sokol.inversesesc.ui.theme.ColorTextHint
import ramble.sokol.inversesesc.ui.theme.ColorTextSpec

@Composable
fun ItemSpecialistsCard(
    onClick: () -> Unit
){

    Box (
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = ColorBackgroundTextField,
                shape = RoundedCornerShape(size = 12.dp)
            ),
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 26.dp, bottom = 17.dp, start = 27.dp, end = 27.dp)
        ){

            Text(
                text = "Дмитрий Горбуноф",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 19.8.sp,
                    fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
                    fontWeight = FontWeight(700),
                    color = ColorBoldText,
                )
            )
            
            Spacer(modifier = Modifier.padding(top = 4.dp))

            Text(
                text = "Senior",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 17.6.sp,
                    fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
                    fontWeight = FontWeight(700),
                    color = ColorTextSpec,
                )
            )
            
            Spacer(modifier = Modifier.padding(top = 8.dp))

            Text(
                text = "Умею работать с разными фреймворками, верстать на чистом html и делать красивые сайтики",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    fontFamily = FontFamily(Font(R.font.lab_grotesque_medium)),
                    fontWeight = FontWeight(500),
                    color = ColorTextHint,
                )
            )
            
            Spacer(modifier = Modifier.padding(top = 20.dp))

//            list of skills
//
//            Spacer(modifier = Modifier.padding(top = 8.dp))
//
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically
//                ) {
//
//            }

            ButtonForContactsProfile(text = stringResource(id = R.string.text_invite)) {
                onClick()
            }

        }
    }

}