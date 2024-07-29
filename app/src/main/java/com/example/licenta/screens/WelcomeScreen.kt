import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.licenta.R
import com.example.licenta.ResponsiveImage
import com.example.licenta.ui.theme.dimens
import com.google.firebase.Firebase
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.analytics
import kotlin.math.round

@Composable
fun welcomeScreen(navController: NavController){
    val ecran = LocalConfiguration.current.screenWidthDp
    Surface(modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(MaterialTheme.dimens.spacerAboveFitness))///de modificat
            Text(text = "FITNESS", fontSize = 25.sp)
            Spacer(modifier = Modifier.height(MaterialTheme.dimens.spacerBelowFitness))
            Image(
                painterResource(id = R.drawable.imagine1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                   // .height(MaterialTheme.dimens.image1Height)///de modificat
                    /* .weight(0.5f)*/
                    .fillMaxHeight(fraction = 0.5f)

            )

            Spacer(modifier = Modifier.height(MaterialTheme.dimens.spacerAboveMBody))

                Text(
                    text = "Modelate your body", fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(MaterialTheme.dimens.spacerBelowMBody))///
                Text(
                    text = "Welcome to your fitness", fontSize = 17.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.height(MaterialTheme.dimens.textSpace))///de modificat
                Text(
                    text = "Journey! This app is your", fontSize = 17.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.height(MaterialTheme.dimens.textSpace))///de modificat
                Text(
                    text = "personal guide to acheving ", fontSize = 17.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.height(MaterialTheme.dimens.textSpace))///de modificat
                Text(
                    text = "your fitness goal ", fontSize = 17.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.height(MaterialTheme.dimens.spacerAboveButton))///de modificat
                Button(
                    modifier = Modifier.wrapContentSize(),
                    onClick = {
                      Firebase.analytics.logEvent("Succes",null)
                       navController.navigate("SignUpScreen")

                    },
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        "GET STARTED",
                        fontSize = 15.sp
                    )
                }
            }
    }
}
@Preview(showBackground = true)
@Composable
fun showScreenPreview(){
    welcomeScreen(rememberNavController())
}