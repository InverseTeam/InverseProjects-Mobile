package ramble.sokol.inversesesc.authentication_and_splash.view.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ramble.sokol.inversesesc.ui.theme.ColorBackgroundButton

@Composable
fun ProgressBarAuth(){
    CircularProgressIndicator(
        modifier = Modifier
            .size(45.dp),
        color = ColorBackgroundButton
    )
}