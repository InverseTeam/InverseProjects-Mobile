package ramble.sokol.inversesesc.profile.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ramble.sokol.inversesesc.ui.theme.ColorBackgroundTextField

@Composable
fun ItemExperienceProjectsProfile(){

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = ColorBackgroundTextField, shape = RoundedCornerShape(size = 16.dp)),
        contentAlignment = Alignment.CenterStart
    ){

    }

}