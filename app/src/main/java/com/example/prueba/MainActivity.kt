@file:OptIn(ExperimentalLayoutApi::class)

package com.example.prueba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.ChipDefaults

import com.example.prueba.ui.theme.PruebaTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PruebaTheme {

            //Llamaremos a nuestras funciones
//                LazyColumnExample()
//                LazyRowExample()
//                LazyVerticalGridExample()
//                ScaffoldExample()
//                SurfaceExample()
//                FlowsExample()
//                AlertaExample()
//                CardExample()
                CheckboxExample()



                }
            }
        }
    }


@Composable
fun LazyColumnExample() {
    LazyColumn {
        items(50) { numbers ->
            Text(text = "Item #$numbers")
        }
    }
}
@Composable
fun LazyRowExample() {
    LazyRow {
        items(50) { index ->
            Text(text = "Item #$index",)
        }
    }
}
@Composable
fun LazyVerticalGridExample(){
    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        items(9) { index ->
            Text("Item $index", modifier = Modifier.padding(16.dp))
        }
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample(){
    Scaffold(
        topBar = { TopAppBar(title = { Text("My App") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Text("Content goes here")
        }
    }

}


@Composable
fun SurfaceExample(){
    Surface(
            modifier = Modifier
                .size(100.dp)
                .padding(12.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(Color.Red)
                .then(Modifier.shadow(100.dp)),
    ) {
        Text("Elevated Surface")
    }
}
@Composable
fun FlowsExample(){
    FlowRow {
        for (i in 1..10) {
            Text("Item $i", modifier = Modifier.padding(end = 8.dp, bottom = 8.dp))
        }
    }
}
@Composable
fun AlertaExample(){
    AlertDialog(
        onDismissRequest = { },
        title = { Text("Peligro") },
        text = { Text("Estas siendo hackeado") },
        confirmButton = { TextButton(onClick = { }) { Text("OK") } }
    )
}
@Composable
fun CardExample(){
    Card(
        modifier = Modifier
            .size(200.dp)
            .fillMaxSize() // Ocupa todo el espacio disponible
            .wrapContentSize(Alignment.Center), // Centra el contenido en el espacio disponible
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Primera Card", style = MaterialTheme.typography.headlineLarge)
            Text("Card content goes here", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
@Composable
fun CheckboxExample(){
    var checked by remember { mutableStateOf(false) }
    Checkbox(
        checked = checked,
        onCheckedChange = { checked = it }
    )
}