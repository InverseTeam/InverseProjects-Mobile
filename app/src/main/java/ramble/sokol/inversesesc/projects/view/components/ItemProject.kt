package ramble.sokol.inversesesc.projects.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ramble.sokol.inversesesc.R
import ramble.sokol.inversesesc.ui.theme.ColorBackProject
import ramble.sokol.inversesesc.ui.theme.ColorBackgroundTextField
import ramble.sokol.inversesesc.ui.theme.ColorBoldText
import ramble.sokol.inversesesc.ui.theme.ColorTextHint
import ramble.sokol.inversesesc.ui.theme.ColorTextSpec

@Preview
@Composable
fun ItemProject(){

    Card (
        modifier = Modifier
            .fillMaxWidth()
            .background(color = ColorBackProject, shape = RoundedCornerShape(size = 12.dp))){

        Column (
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
            ){

                Image(
                    modifier = Modifier.background(color = Color.White, shape = RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp)),
                    painter = painterResource(id = R.drawable.image_background_splash),
                    contentDescription = "image project",
                    contentScale = ContentScale.Crop
                )

            }

            Spacer(modifier = Modifier.padding(top = 10.dp))

            Column (modifier = Modifier.padding(horizontal = 27.dp)) {

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Агрегатор всего",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 17.6.sp,
                        fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
                        fontWeight = FontWeight(700),
                        color = ColorBoldText,
                    ),
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.padding(top = 6.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Ed-tech",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 13.2.sp,
                        fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
                        fontWeight = FontWeight(700),
                        color = ColorTextSpec,
                    ),
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.padding(top = 6.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Описание нашего проекта это умный агрегатор всего, что бы вы могли найти все что вам нужно в одном месте. Панируем расширение нашего продукта",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        fontFamily = FontFamily(Font(R.font.lab_grotesque_medium)),
                        fontWeight = FontWeight(500),
                        color = ColorTextHint,
                    ),
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.padding(top = 18.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "UX UI designer · Front-end · Back-end",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 13.2.sp,
                        fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
                        fontWeight = FontWeight(700),
                        color = ColorTextSpec,
                    ),
                    textAlign = TextAlign.Start
                )
                
                Spacer(modifier = Modifier.padding(top = 28.dp))

            }

        }

    }

}