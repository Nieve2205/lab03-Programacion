package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // Llama a cada función de contenedor o control que desees visualizar
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    DisplayComponents()
                }
            }
        }
    }
}

@Composable
fun DisplayComponents() {
    Column(modifier = Modifier.padding(16.dp)) {
        TopAppBarExample()
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumnExample()
        Spacer(modifier = Modifier.height(16.dp))
        LazyRowExample()
        Spacer(modifier = Modifier.height(16.dp))
        GridExample()
        Spacer(modifier = Modifier.height(16.dp))
        CardExample()
        Spacer(modifier = Modifier.height(16.dp))
        FloatingActionButtonExample()
        Spacer(modifier = Modifier.height(16.dp))
        AlertDialogExample()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarExample() {
    CenterAlignedTopAppBar(
        title = { Text("Ejemplo de Barra") },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.Green)
    )
}

@Composable
fun LazyColumnExample() {
    LazyColumn {
        items(4) { index ->
            Text(text = "Item $index", modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun LazyRowExample() {
    LazyRow {
        items(5) { index ->
            Text(text = "Item $index", modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun GridExample() {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(5) { index ->
            Card(
                modifier = Modifier.padding(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Text(text = "Item $index", modifier = Modifier.padding(16.dp))
            }
        }
    }
}

@Composable
fun CardExample() {
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = "Carta", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun FloatingActionButtonExample() {
    FloatingActionButton(onClick = {}) {
        Icon(Icons.Filled.Favorite, contentDescription = null)
    }
}

@Composable
fun AlertDialogExample() {
    val openDialog = remember { mutableStateOf(false) }

    Button(onClick = { openDialog.value = true }) {
        Text("Boton de Alerta")
    }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text("Alerta") },
            text = { Text("Texto de alerta.") },
            confirmButton = {
                Button(onClick = { openDialog.value = false }) {
                    Text("Confirmar")
                }
            },
            dismissButton = {
                Button(onClick = { openDialog.value = false }) {
                    Text("Denegar")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        DisplayComponents()
    }
}
