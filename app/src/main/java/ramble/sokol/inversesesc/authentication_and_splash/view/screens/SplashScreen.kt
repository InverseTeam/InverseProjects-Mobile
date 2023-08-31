package ramble.sokol.inversesesc.authentication_and_splash.view.screens

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay
import ramble.sokol.inversesesc.R
import ramble.sokol.inversesesc.destinations.LoginScreenDestination

@Destination(start = true)
@Composable
fun SplashScreen(
    navigator: DestinationsNavigator
) {
    val transition = rememberInfiniteTransition(label = "")
    val alpha by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 2000
            ),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )
    val alpha2 by transition.animateFloat(
        initialValue = 0.0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 2100
            ),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    LaunchedEffect(
        key1 = true
    ) {
        delay(4000L)
        navigator.popBackStack()
        navigator.navigate(LoginScreenDestination)
    }

    Box (modifier = Modifier.fillMaxSize()){

        Image(
            modifier = Modifier
                .fillMaxSize()
                .alpha(alpha = alpha2),
            painter = painterResource(R.drawable.image_background_splash),
            contentDescription = "backgroundSplashScreen",
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 60.dp)
                    .alpha(alpha = alpha),
                painter = painterResource(R.drawable.image_splash),
                contentDescription = "TextSplashScreen"
            )
        }

    }

}