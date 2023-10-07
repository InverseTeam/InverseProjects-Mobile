package ramble.sokol.inversesesc.specialists.view.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import ramble.sokol.inversesesc.destinations.ProfileScreenDestination
import ramble.sokol.inversesesc.specialists.view.components.ItemSpecialistsCard
import ramble.sokol.inversesesc.ui.theme.ColorTitle

@Destination
@Composable
fun SpecialistsScreen(
    navigator: DestinationsNavigator
){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(start = 32.dp, end = 32.dp, bottom = 57.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.padding(top = 17.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.text_specialists),
            style = TextStyle(
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.lab_grotesque_bold)),
                fontWeight = FontWeight(700),
                color = ColorTitle,
                letterSpacing = 0.24.sp,
            ),
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.padding(top = 32.dp))
        
        ItemSpecialistsCard(){

        }

    }

}