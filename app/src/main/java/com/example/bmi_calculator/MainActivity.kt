package com.example.bmi_calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.* // Muutettu täällä
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMICalculatorScreen()
        }
    }
}

@Composable
fun BMICalculatorScreen(viewModel: BMIViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("BMI Calculator", style = MaterialTheme.typography.headlineLarge) // Muutettu
        // Jos käytät Material3:ta, muuttaisi typo-headlineLarge

        TextField(
            value = viewModel.weight.value.toString(),
            onValueChange = { viewModel.updateWeight(it) },
            label = { Text("Weight (kg)") }
        )

        TextField(
            value = viewModel.height.value.toString(),
            onValueChange = { viewModel.updateHeight(it) },
            label = { Text("Height (m)") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { /* Ei tarvita toimintoa tässä */ }) {
            Text("Calculate BMI")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Your BMI is: ${viewModel.bmi.value}")
    }
}


