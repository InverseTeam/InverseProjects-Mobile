package ramble.sokol.inversesesc.authentication_and_splash.view.components

import android.view.MotionEvent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.unit.dp

@Composable
fun StatusTestLayout(
    color: Color,
    width: Float
){

    Box(
        modifier = Modifier
            .fillMaxWidth(width)
            .height(8.dp)
            .background(
                color = color ,
                shape = RoundedCornerShape(size = 24.dp)
            )
    )
}