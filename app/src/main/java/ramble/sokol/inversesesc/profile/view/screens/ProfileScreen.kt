package ramble.sokol.inversesesc.profile.view.screens

import DropDownSpecializationProfile
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import ramble.sokol.inversesesc.authentication_and_splash.view.components.ButtonForEntry
import ramble.sokol.inversesesc.destinations.EditProfileScreenDestination
import ramble.sokol.inversesesc.profile.view.components.ButtonForContactsProfile
import ramble.sokol.inversesesc.profile.view.components.ButtonGoTeMessageProfile
import ramble.sokol.inversesesc.profile.view.components.ItemBottomSheetContacts
import ramble.sokol.inversesesc.profile.view.components.ItemExperienceProjectsProfile
import ramble.sokol.inversesesc.profile.view.components.ItemMoreInformation
import ramble.sokol.inversesesc.profile.view.components.ItemSkillsProfile
import ramble.sokol.inversesesc.profile.view.components.MoreInformationBlock
import ramble.sokol.inversesesc.specialists.view.components.ButtonGoTeMessage
import ramble.sokol.inversesesc.ui.theme.ColorBoldText
import ramble.sokol.inversesesc.ui.theme.ColorCheckBox
import ramble.sokol.inversesesc.ui.theme.ColorTextHint
import ramble.sokol.inversesesc.ui.theme.ColorTextSpec
import ramble.sokol.inversesesc.ui.theme.ColorTitle
import ramble.sokol.sberafisha.authentication_and_splash.view.components.InputTextEntry
import ramble.sokol.sberafisha.authentication_and_splash.view.components.MultiLineInputTextEntry
import ramble.sokol.sberafisha.authentication_and_splash.view.components.TextInputNameEntry

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Destination
@Composable
fun ProfileScreen(
    navigator: DestinationsNavigator
) {

    val sheetState = rememberModalBottomSheetState()
    var sheetIsOpen by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp, bottom = 57.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = stringResource(id = R.string.text_profile),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
                    fontWeight = FontWeight(700),
                    color = ColorTitle,
                    letterSpacing = 0.24.sp,
                )
            )

            Icon(
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp)
                    .clickable {
                        navigator.popBackStack()
                        navigator.navigate(EditProfileScreenDestination)
                    },
                painter = painterResource(id = R.drawable.icon_edit_profile),
                contentDescription = "icon_edit_profile"
            )

        }

        Spacer(modifier = Modifier.padding(top = 20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            Icon(
                modifier = Modifier.fillMaxWidth(0.25f),
                painter = painterResource(id = R.drawable.image_add_photo),
                contentDescription = "image_add_photo"
            )

            Spacer(modifier = Modifier.padding(start = 8.dp))

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    text = "Сокерин Артём",
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 19.8.sp,
                        fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
                        fontWeight = FontWeight(700),
                        color = ColorBoldText,
                    )
                )

                Text(
                    text = "Дизайнер",
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 19.8.sp,
                        fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
                        fontWeight = FontWeight(700),
                        color = ColorTextSpec,
                    )
                )

            }

        }

        Spacer(modifier = Modifier.padding(top = 15.dp))

        Text(
            text = "Меня зовут Вика , я Junior UX/UI Designer с 1,5 летним опытом. Начинала изучать дизайн по роликам на Youtube, а также спустя время для структуризации знаний прошла курс дизайна от UPROCK. Путь работы дизайнером я начинала с фриланса, брала небольшие заказы на разрабтку лэндингов ",
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.lab_grotesque_regular)),
                fontWeight = FontWeight(500),
                color = ColorTextHint,
            )
        )

        Spacer(modifier = Modifier.padding(top = 16.dp))

        val skills = listOf("Java", "Kotlin", "ООП", "Android developer", "Python", "ML", "PyTorch")

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            content = {
                items(skills.size) { it ->
                    ItemSkillsProfile(text = skills[it])
                }
            })

        Spacer(modifier = Modifier.padding(top = 16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier.fillMaxWidth(0.8f),
                contentAlignment = Alignment.CenterStart
            ) {
                ButtonForContactsProfile(text = stringResource(id = R.string.text_contacts)) {
                    sheetIsOpen = true
                }
            }

            if (sheetIsOpen) {
                ModalBottomSheet(
                    sheetState = sheetState,
                    containerColor = Color.White,
                    onDismissRequest = { sheetIsOpen = false }
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Spacer(modifier = Modifier.padding(top = 25.dp))

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 32.dp),
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            ItemBottomSheetContacts(
                                idPaint = R.drawable.image_number_profile,
                                text = "+79527381099"
                            )

                            Spacer(modifier = Modifier.padding(top = 8.dp))

                            ItemBottomSheetContacts(
                                idPaint = R.drawable.image_email,
                                text = "rambletot@gmail.com"
                            )

                            Spacer(modifier = Modifier.padding(top = 8.dp))

                            ItemBottomSheetContacts(
                                idPaint = R.drawable.image_telegram,
                                text = "@RambleTOT"
                            )

                            Spacer(modifier = Modifier.padding(top = 30.dp))
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.padding(start = 8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                ButtonGoTeMessageProfile {

                }
            }

        }

        Spacer(modifier = Modifier.padding(top = 32.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.text_experience_in_projects),
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.lab_grotesque_medium)),
                fontWeight = FontWeight(500),
                color = ColorTitle,
                letterSpacing = 0.18.sp,
            ),
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.padding(top = 8.dp))

        val listName = listOf("Inverse", "Svetozavr", "Afisha")
        val listDesc =
            listOf("Ed-tech · 2019 - 2021", "Ed-tech · 2019 - 2021", "Ed-tech · 2019 - 2021")

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(listName.size) { it ->
                ItemExperienceProjectsProfile(
                    nameProjects = listName[it], descProjects = listDesc[it]
                )

                Spacer(modifier = Modifier.padding(top = 8.dp))

            }
        }

    }

}