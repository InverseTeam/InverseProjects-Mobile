package ramble.sokol.inversesesc.profile.view.screens

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import ramble.sokol.inversesesc.model_project.RetrofitHelper
import ramble.sokol.inversesesc.model_project.TokenManager
import ramble.sokol.inversesesc.profile.model.models.ResponseUserInfo
import ramble.sokol.inversesesc.profile.model.utils.APIprofile
import ramble.sokol.inversesesc.profile.model.utils.APIproject
import ramble.sokol.inversesesc.profile.view.components.ButtonForContactsProfile
import ramble.sokol.inversesesc.profile.view.components.ItemBottomSheetContacts
import ramble.sokol.inversesesc.ui.theme.ColorBoldText
import ramble.sokol.inversesesc.ui.theme.ColorTextHint
import ramble.sokol.inversesesc.ui.theme.ColorTextSpec
import ramble.sokol.inversesesc.ui.theme.ColorTitle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private lateinit var apiProfile: APIprofile
private lateinit var tokenManager: TokenManager
private lateinit var fullName: MutableState<String>
private lateinit var cover: MutableState<String>
private lateinit var bio: MutableState<String>
private lateinit var speciality: MutableState<String>
private lateinit var email: MutableState<String>
private lateinit var telegram: MutableState<String>
private lateinit var schoolСlass: MutableState<String>
private lateinit var phoneNumber: MutableState<String>
private lateinit var public: MutableState<Boolean>

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Destination
@Composable
fun ProfileScreen(
    navigator: DestinationsNavigator
) {

    val context = LocalContext.current

    tokenManager = TokenManager(context)

    apiProfile = RetrofitHelper.getInstance().create(APIprofile::class.java)


    val sheetState = rememberModalBottomSheetState()
    var sheetIsOpen by rememberSaveable {
        mutableStateOf(false)
    }

    fullName = remember {
        mutableStateOf("")
    }

    cover = remember {
        mutableStateOf("")
    }

    bio = remember {
        mutableStateOf("")
    }

    speciality = remember {
        mutableStateOf("")
    }

    email = remember {
        mutableStateOf("")
    }

    telegram = remember {
        mutableStateOf("")
    }

    schoolСlass = remember {
        mutableStateOf("")
    }

    phoneNumber = remember {
        mutableStateOf("")
    }

    public = remember {
        mutableStateOf(false)
    }

    getInfoData(context)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp, bottom = 57.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.padding(top = 17.dp))
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 15.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//
//            Text(
//                text = stringResource(id = R.string.text_profile),
//                style = TextStyle(
//                    fontSize = 24.sp,
//                    fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
//                    fontWeight = FontWeight(700),
//                    color = ColorTitle,
//                    letterSpacing = 0.24.sp,
//                )
//            )
//
//            Icon(
//                modifier = Modifier
//                    .width(32.dp)
//                    .height(32.dp)
//                    .clickable {
//                        navigator.popBackStack()
//                        navigator.navigate(EditProfileScreenDestination)
//                    },
//                painter = painterResource(id = R.drawable.icon_edit_profile),
//                contentDescription = "icon_edit_profile"
//            )
//
//        }

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.text_profile),
            style = TextStyle(
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
                fontWeight = FontWeight(700),
                color = ColorTitle,
                letterSpacing = 0.24.sp,
                ),
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.padding(top = 20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            Icon(
                modifier = Modifier.fillMaxWidth(0.25f),
                painter = painterResource(id = R.drawable.image_add_photo), // cover need
                contentDescription = "image_add_photo"
            )

            Spacer(modifier = Modifier.padding(start = 8.dp))

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    text = fullName.value,
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 19.8.sp,
                        fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
                        fontWeight = FontWeight(700),
                        color = ColorBoldText,
                    )
                )

                Text(
                    text = speciality.value,
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
            text = bio.value,
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.lab_grotesque_regular)),
                fontWeight = FontWeight(500),
                color = ColorTextHint,
            )
        )

        Spacer(modifier = Modifier.padding(top = 16.dp))

//        val skills = listOf("Java", "Kotlin", "ООП", "Android developer", "Python", "ML", "PyTorch")
//
//        LazyVerticalGrid(
//            columns = GridCells.Fixed(3),
//            content = {
//                items(skills.size) { it ->
//                    ItemSkillsProfile(text = skills[it])
//                }
//            })
//
//        Spacer(modifier = Modifier.padding(top = 16.dp))

        ButtonForContactsProfile(text = stringResource(id = R.string.text_contacts)) {
            sheetIsOpen = true
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
                            text = phoneNumber.value
                        )

                        Spacer(modifier = Modifier.padding(top = 8.dp))
                         ItemBottomSheetContacts(
                             idPaint = R.drawable.image_email,
                             text = email.value
                         )

                        Spacer(modifier = Modifier.padding(top = 8.dp))

                        ItemBottomSheetContacts(
                            idPaint = R.drawable.image_telegram,
                            text = telegram.value
                        )

                        Spacer(modifier = Modifier.padding(top = 30.dp))
                    }
                }
            }
        }

//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//
//            Box(
//                modifier = Modifier.fillMaxWidth(0.8f),
//                contentAlignment = Alignment.CenterStart
//            ) {
//                ButtonForContactsProfile(text = stringResource(id = R.string.text_contacts)) {
//                    sheetIsOpen = true
//                }
//            }
//
//            if (sheetIsOpen) {
//                ModalBottomSheet(
//                    sheetState = sheetState,
//                    containerColor = Color.White,
//                    onDismissRequest = { sheetIsOpen = false }
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .background(Color.White),
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//
//                        Spacer(modifier = Modifier.padding(top = 25.dp))
//
//                        Column(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(horizontal = 32.dp),
//                            verticalArrangement = Arrangement.Top,
//                            horizontalAlignment = Alignment.CenterHorizontally
//                        ) {
//
//                            ItemBottomSheetContacts(
//                                idPaint = R.drawable.image_number_profile,
//                                text = "+79527381099"
//                            )
//
//                            Spacer(modifier = Modifier.padding(top = 8.dp))
//
//                            ItemBottomSheetContacts(
//                                idPaint = R.drawable.image_email,
//                                text = "rambletot@gmail.com"
//                            )
//
//                            Spacer(modifier = Modifier.padding(top = 8.dp))
//
//                            ItemBottomSheetContacts(
//                                idPaint = R.drawable.image_telegram,
//                                text = "@RambleTOT"
//                            )
//
//                            Spacer(modifier = Modifier.padding(top = 30.dp))
//                        }
//                    }
//                }
//            }
//
//            Spacer(modifier = Modifier.padding(start = 8.dp))
//
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth(),
//                contentAlignment = Alignment.CenterEnd
//            ) {
//                ButtonGoTeMessageProfile {
//
//                }
//            }
//
//        }

//        Spacer(modifier = Modifier.padding(top = 32.dp))
//
//        Text(
//            modifier = Modifier.fillMaxWidth(),
//            text = stringResource(id = R.string.text_experience_in_projects),
//            style = TextStyle(
//                fontSize = 18.sp,
//                fontFamily = FontFamily(Font(R.font.lab_grotesque_medium)),
//                fontWeight = FontWeight(500),
//                color = ColorTitle,
//                letterSpacing = 0.18.sp,
//            ),
//            textAlign = TextAlign.Start
//        )
//
//        Spacer(modifier = Modifier.padding(top = 8.dp))
//
//        val listName = listOf("Inverse", "Svetozavr", "Afisha")
//        val listDesc =
//            listOf("Ed-tech · 2019 - 2021", "Ed-tech · 2019 - 2021", "Ed-tech · 2019 - 2021")
//
//        LazyColumn(
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            items(listName.size) { it ->
//                ItemExperienceProjectsProfile(
//                    nameProjects = listName[it], descProjects = listDesc[it]
//                )
//
//                Spacer(modifier = Modifier.padding(top = 8.dp))
//
//            }
//        }

    }

}

fun getInfoData(context: Context) {

    val token = tokenManager.getToken()

    val call = apiProfile.getUserInformation("Token $token")

    call.enqueue(object : Callback<ResponseUserInfo> {
        override fun onResponse(call: Call<ResponseUserInfo>, response: Response<ResponseUserInfo>) {
            if (response.isSuccessful) {

                val responseBody = response.body()
                bio.value = responseBody!!.bio
                cover.value = responseBody.cover
                speciality.value = responseBody.speciality.name
                fullName.value = "${responseBody.firstname} ${responseBody.lastname}"
                email.value = responseBody.email
                telegram.value = responseBody.telegram
                phoneNumber.value = responseBody.phone_number
                public.value = responseBody.public
                schoolСlass.value = "${responseBody.schoolClass.number}${responseBody.schoolClass.litera}"
            } else {
                Toast.makeText(context, R.string.text_error_request_profile, Toast.LENGTH_SHORT).show()
            }
        }

        override fun onFailure(call: Call<ResponseUserInfo>, t: Throwable) {
            Toast.makeText(context, R.string.text_toast_no_internet, Toast.LENGTH_SHORT).show()
            Log.d("MyLog", t.message.toString())
        }
    })
}