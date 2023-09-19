package ramble.sokol.inversesesc.profile.view.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ramble.sokol.inversesesc.R
import ramble.sokol.inversesesc.ui.theme.ColorBackgroundButton
import ramble.sokol.inversesesc.ui.theme.ColorBackgroundTextField


@Composable
fun ButtonGoTeMessageProfile(
    onClick: () -> Unit
)
{
    Button(
        modifier = Modifier
            .background(
                color = ColorBackgroundTextField,
                shape = RoundedCornerShape(size = 12.dp)
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = ColorBackgroundTextField
        ),
        onClick = onClick,
        contentPadding = PaddingValues(
            start = 0.dp,
            top = 0.dp,
            end = 0.dp,
            bottom = 0.dp,
        )
    ){

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(id = R.drawable.svg_go_to_message),
                contentDescription = "go message"
            )
        }

    }
}