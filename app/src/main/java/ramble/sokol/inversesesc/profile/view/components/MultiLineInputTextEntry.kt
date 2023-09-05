@file:OptIn(ExperimentalMaterial3Api::class)

package ramble.sokol.sberafisha.authentication_and_splash.view.components

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ramble.sokol.inversesesc.R
import ramble.sokol.inversesesc.ui.theme.ColorBackgroundTextField
import ramble.sokol.inversesesc.ui.theme.ColorTextHint
import ramble.sokol.inversesesc.ui.theme.ColorTextInput

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MultiLineInputTextEntry(
    text: String,
    idText: Int,
    onValueChange: (String) -> Unit,
    borderWidth: Int = 1,
    color: Color = Color.Transparent,
    interactionSource: MutableInteractionSource
){
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .border(width = borderWidth.dp, color = color, shape = RoundedCornerShape(15.dp)),
        shape = RoundedCornerShape(15.dp),
        value = text,
        textStyle = TextStyle(
            fontSize = 16.sp,
            lineHeight = 24.sp,
            fontFamily = FontFamily(Font(R.font.lab_grotesque_regular)),
            fontWeight = FontWeight(700),
            color = ColorTextInput,
        ),
        interactionSource = interactionSource,
        onValueChange = onValueChange,
        label = {
            Text(
                stringResource(id = idText),
                style = TextStyle(
                    color = ColorTextHint,
                    fontFamily = FontFamily(Font(R.font.lab_grotesque_regular)),
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(700)
                )
            ) },
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = ColorTextInput,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            containerColor = ColorBackgroundTextField
        )
    )
}