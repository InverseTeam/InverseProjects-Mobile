package ramble.sokol.inversesesc.main.bottom_navbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.annotation.Destination
import ramble.sokol.inversesesc.R
import ramble.sokol.inversesesc.profile.view.screens.ProfileScreen
import ramble.sokol.inversesesc.projects.view.screens.ProjectsScreen
import ramble.sokol.inversesesc.specialists.view.screens.SpecialistsScreen
import ramble.sokol.inversesesc.ui.theme.ColorBackgroundButton
import ramble.sokol.inversesesc.ui.theme.ColorDescriptionText

@Destination
@Composable
fun BottomMenuScreen(
    navigator: DestinationsNavigator
){
    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BottomNavigation (
            modifier = Modifier
                .wrapContentSize()
                .clip(RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp)),
            elevation = 4.dp,
            backgroundColor = White,
        ){

            BottomNavigationItem(
                selected = selectedItem == 0,
                onClick = {
                    selectedItem = 0
                },
                icon = {
                    Icon(
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp),
                        painter = painterResource(id = R.drawable.icon_projects),
                        contentDescription = "Poster",
                        tint = if (selectedItem == 0) ColorBackgroundButton else ColorDescriptionText
                    )
                }
            )
            BottomNavigationItem(
                selected = selectedItem == 1,
                onClick = {
                    selectedItem = 1
                },
                icon = {
                    Icon(
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp),
                        painter = painterResource(id = R.drawable.icon_specialists),
                        contentDescription = "Route",
                        tint = if (selectedItem == 1) ColorBackgroundButton else ColorDescriptionText
                    )
                }
            )
            BottomNavigationItem(
                selected = selectedItem == 2,
                onClick = {
                    selectedItem = 2
                },
                icon = {
                    Icon(
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp),
                        painter = painterResource(id = R.drawable.icon_profile),
                        contentDescription = "Actually",
                        tint = if (selectedItem == 2) ColorBackgroundButton else ColorDescriptionText
                    )
                }
            )
        }
    }

    when (selectedItem){
        0 -> ProjectsScreen(navigator)
        1 -> SpecialistsScreen(navigator)
        2 -> ProfileScreen(navigator)
    }
}

