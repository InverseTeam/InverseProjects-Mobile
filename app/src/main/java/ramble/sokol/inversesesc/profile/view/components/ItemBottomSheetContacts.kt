package ramble.sokol.inversesesc.profile.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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

@Composable
fun ItemBottomSheetContacts(
    idPaint: Int,
    text: String
){
    
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = ColorBackgroundTextField,
                shape = RoundedCornerShape(size = 15.dp)
            ),
        contentAlignment = Alignment.Center
    ){

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 27.dp, vertical = 32.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            Image(
                painter = painterResource(id = idPaint),
                contentDescription = "paint contacts",
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp)
            )
            
            Spacer(modifier = Modifier.padding(start = 24.dp))

            Text(
                text = text,
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 22.sp,
                    fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
                    fontWeight = FontWeight(700),
                    color = ColorBoldText,
                )
            )

        }

    }
    
}