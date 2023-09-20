package ramble.sokol.inversesesc.profile.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ramble.sokol.inversesesc.R
import ramble.sokol.inversesesc.ui.theme.ColorBackgroundTextField
import ramble.sokol.inversesesc.ui.theme.ColorBoldText
import ramble.sokol.inversesesc.ui.theme.ColorTextSpec

@Composable
fun ItemExperienceProjectsProfile(
    nameProjects: String,
    descProjects: String
){

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = ColorBackgroundTextField, shape = RoundedCornerShape(size = 16.dp)),
        contentAlignment = Alignment.CenterStart
    ){

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 19.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            Icon(
                modifier = Modifier.fillMaxWidth(0.2f),
                painter = painterResource(id = R.drawable.image_add_photo),
                contentDescription = "image_add_photo")

            Spacer(modifier = Modifier.padding(start = 15.dp))
            
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = nameProjects,
                    style = TextStyle(
                        fontSize = 15.28.sp,
                        lineHeight = 16.81.sp,
                        fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
                        fontWeight = FontWeight(700),
                        color = ColorBoldText,
                    )
                )

                Spacer(modifier = Modifier.padding(top = 6.dp))

                Text(
                    text = descProjects,
                    style = TextStyle(
                        fontSize = 12.73.sp,
                        lineHeight = 14.01.sp,
                        fontFamily = FontFamily(Font(R.font.lab_grotesque_medium)),
                        fontWeight = FontWeight(700),
                        color = ColorTextSpec,
                    )
                )

            }

        }

    }

}