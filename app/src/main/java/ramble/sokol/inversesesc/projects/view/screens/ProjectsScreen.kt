package ramble.sokol.inversesesc.projects.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import ramble.sokol.inversesesc.R
import ramble.sokol.inversesesc.profile.view.screens.ProfileScreen
import ramble.sokol.inversesesc.specialists.view.screens.SpecialistsScreen
import ramble.sokol.inversesesc.ui.theme.ColorBackgroundButton
import ramble.sokol.inversesesc.ui.theme.ColorBackgroundTextField
import ramble.sokol.inversesesc.ui.theme.ColorDescriptionText
import ramble.sokol.inversesesc.ui.theme.ColorTextSpec
import ramble.sokol.inversesesc.ui.theme.ColorTitle

@Destination
@Composable
fun ProjectsScreen(
    navigator: DestinationsNavigator
){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(top = 17.dp, start = 32.dp, end = 32.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.text_projects),
            style = TextStyle(
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
                fontWeight = FontWeight(700),
                color = ColorTitle,
                letterSpacing = 0.24.sp,
            ),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.padding(top = 17.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box (
                modifier = Modifier.fillMaxWidth(0.4f),
                contentAlignment = Alignment.CenterStart
            ){

                Box(modifier = Modifier
                    .background(
                        color = ColorBackgroundButton,
                        shape = RoundedCornerShape(size = 15.dp)
                    )
                    .padding(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 12.dp)){

                    Text(
                        text = stringResource(id = R.string.text_all_projects),
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 15.4.sp,
                            fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
                            fontWeight = FontWeight(700),
                            color = White,
                        )
                    )

                }

            }

            Spacer(modifier = Modifier.padding(top = 8.dp))

            Box (
                modifier = Modifier.fillMaxWidth(0.4f),
                contentAlignment = Alignment.CenterStart
                ){

                Box(
                    modifier = Modifier
                        .background(
                            color = ColorBackgroundTextField,
                            shape = RoundedCornerShape(size = 15.dp)
                        )
                        .padding(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 12.dp)
                ){

                    Text(
                        text = stringResource(id = R.string.text_my_projects),
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 15.4.sp,
                            fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
                            fontWeight = FontWeight(700),
                            color = ColorTextSpec,
                        )
                    )

                }

            }

            Spacer(modifier = Modifier.padding(top = 8.dp))

            Box (
                modifier = Modifier.fillMaxWidth(0.2f),
                contentAlignment = Alignment.CenterStart
            ){

                Box(modifier = Modifier
                    .background(color = ColorBackgroundTextField, shape = RoundedCornerShape(size = 15.dp))
                    .padding(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 12.dp)
                ){

                    Image(
                        modifier = Modifier
                            .fillMaxWidth(),
                        painter = painterResource(id = R.drawable.icon_favorite),
                        contentDescription = "icon_favorite"
                    )

                }

            }
        }

    }

}