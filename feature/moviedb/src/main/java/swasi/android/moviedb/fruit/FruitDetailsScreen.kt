package swasi.android.moviedb.fruit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.gson.Gson
import swasi.android.ui.components.AppButton
import swasi.android.ui.components.AppText
import swasi.android.ui.theme.ComposePlaygroundTheme

/**
 * Created by Sibaprasad Mohanty on 20/03/2023.
 * siba.x.prasad@gmail.com
 */

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FruitDetailsScreen(
    fruitDataInJson: String?,
    popBackStack: () -> Unit,
    popUpToLogin: () -> Unit
) {

    val fruitData = Gson().fromJson(fruitDataInJson, FruitData::class.java)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(
                            "Fruit Details",
                            color = Color.White
                        )
                    }
                })
        },
        content = {

            ComposePlaygroundTheme(darkTheme = false) {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it),
                    color = Color.White
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                            .padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        AppButton(
                            text = "Back",
                            onClick = popBackStack
                        )

                        AppButton(
                            text = "Log Out",
                            onClick = popUpToLogin
                        )

                        Image(
                            painter = painterResource(fruitData.image),
                            contentDescription = fruitData.fruitName,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .fillMaxSize(0.5F)
                        )
                        AppText(
                            text = fruitData.fruitName,
                            size = 20.sp,
                            textColor = Color.Blue
                        )
                    }
                }
            }
        })
}