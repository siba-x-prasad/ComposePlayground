package com.swasi.composeplayground.youtubeTutor.list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swasi.composeplayground.R

class ListExampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var visibleWidget by remember { mutableStateOf("") }

            Column(
                Modifier
                    .fillMaxSize()
            ) {

                Column(Modifier.weight(0.2f)) {
                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center

                    ) {
                        Button(onClick = { visibleWidget = "Row" }) {
                            Text(text = "Row")
                        }

                        Button(onClick = { visibleWidget = "LazyRow" }) {
                            Text(text = "LazyRow")
                        }
                        Button(onClick = { visibleWidget = "CustomLazyRow" }) {
                            Text(text = "CustomLazyRow")
                        }
                    }

                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(onClick = { visibleWidget = "Column" }) {
                            Text(text = "Column")
                        }

                        Button(onClick = { visibleWidget = "LazyColumn" }) {
                            Text(text = "LazyColumn")
                        }
                        Button(onClick = { visibleWidget = "CustomLazyColumn" }) {
                            Text(text = "Custom LazyColumn")
                        }
                    }
                }

                Column(Modifier.weight(0.9f)) {
                    when (visibleWidget) {
                        "Row" -> {
                            RowColumnView(visibleWidget)
                        }
                        "Column" -> {
                            RowColumnView(visibleWidget)
                        }
                        "LazyRow" -> {
                            ListView(visibleWidget)
                        }
                        "LazyColumn" -> {
                            ListView(visibleWidget)
                        }
                        "CustomLazyRow" -> {
                            CustomListView("Custom Row")
                        }
                        "CustomLazyColumn" -> {
                            CustomListView("Custom Column")
                        }
                        else -> {

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RowColumnView(type: String) {

    val scrollState = rememberScrollState()

    if (type == "Column") {
        Column(Modifier.verticalScroll(scrollState)) {
            for (i in 1..50) {
                Text(
                    text = "Item $i",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp)
                )
            }
        }
    } else {
        Row(Modifier.horizontalScroll(scrollState)) {
            for (i in 1..50) {
                Text(
                    text = "Item $i",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp)
                )
            }
        }
    }
}

@Composable
fun ListView(type: String) {
    val countryList =
        mutableListOf(
            "India",
            "Pakistan",
            "Bangladesh",
            "Sri Lanka",
            "Afganistan",
            "Myanmar",
            "Japan",
            "Myalesi",
            "Indonesia",
            "Singapore",
            "Taiwan",
            "Philipines"
        )

    val listModifier = Modifier
        .fillMaxSize()
        .background(Color.Gray)
        .padding(10.dp)

    val textStyle = TextStyle(fontSize = 20.sp, color = Color.White)

    if (type == "Simple Row") {
        LazyRow(
            modifier = listModifier.padding(15.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(countryList) { country ->
                Text(text = country, style = textStyle)
            }
        }
    } else {
        LazyColumn(
            modifier = listModifier.padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(countryList) { country ->
                Text(text = country, style = textStyle)
            }
        }
    }
}

@Composable
fun CustomListView(type: String) {

    val fruitsList = mutableListOf<FruitModel>()

    fruitsList.add(FruitModel("Apple", R.drawable.apple))
    fruitsList.add(FruitModel("Orange", R.drawable.orange))
    fruitsList.add(FruitModel("Banana", R.drawable.banana))
    fruitsList.add(FruitModel("Strawberry", R.drawable.strawberry))
    fruitsList.add(FruitModel("Mango", R.drawable.mango))
    fruitsList.add(FruitModel("pomegranate", R.drawable.pomegranate))
    fruitsList.add(FruitModel("Grapes", R.drawable.grapes))
    fruitsList.add(FruitModel("Avocado", R.drawable.avocado))
    fruitsList.add(FruitModel("Pears", R.drawable.pears))
    fruitsList.add(FruitModel("Kiwi", R.drawable.kiwi))
    fruitsList.add(FruitModel("Jack fruit", R.drawable.jackfruit))
    fruitsList.add(FruitModel("Pine Apple", R.drawable.pineapple))

    if (type == "Custom Row") {
        LazyRow(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(fruitsList) { index, model ->
                ListColumn(model = model)
            }
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(fruitsList) { model ->
                ListRow(model = model)
            }
        }
    }
}

data class FruitModel(val name: String, val image: Int)

@Composable
fun ListRow(model: FruitModel) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(colorResource(id = R.color.col_063041))
    ) {
        Image(
            painter = painterResource(id = model.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
        )
        Text(
            text = model.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }
}

@Composable
fun ListColumn(model: FruitModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(colorResource(id = R.color.col_063041))
    ) {
        Image(
            painter = painterResource(id = model.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
        )
        Text(
            text = model.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }
}