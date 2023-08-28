package ramble.sokol.inversesesc.authentication_and_splash.view.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import ramble.sokol.inversesesc.ui.theme.ColorTitle

@Composable
@Destination
fun LoginScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 31.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

        Text(
            text = stringResource(id = R.string.text_login),
            style = TextStyle(
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
                fontWeight = FontWeight(900),
                color = ColorTitle,
                letterSpacing = 0.12.sp,
            )
        )

    }
}