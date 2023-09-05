package ramble.sokol.inversesesc.specialists.view.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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


@Composable
fun ButtonGoTeMessage(
    onClick: () -> Unit
)
{
    Button(
        modifier = Modifier
            .background(
                color = White,
                shape = RoundedCornerShape(size = 12.dp)
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = White
        ),
        onClick = onClick

    ){
        Image(
            painter = painterResource(id = R.drawable.image_go_to_message),
            contentDescription = "go message"
        )
    }
}