package com.example.bmi_calculator

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class BMIViewModel : ViewModel() {
    var weight = mutableStateOf(0f) // Paino kilogrammoina
    var height = mutableStateOf(0f) // Korkeus metreinä
    var bmi = mutableStateOf(0f) // BMI-tulos

    // Metodi, joka päivittää painon
    fun updateWeight(newWeight: String) {
        weight.value = newWeight.toFloatOrNull() ?: 0f
        calculateBMI()
    }

    // Metodi, joka päivittää korkeuden
    fun updateHeight(newHeight: String) {
        height.value = newHeight.toFloatOrNull() ?: 0f
        calculateBMI()
    }

    // Yksityinen metodi BMI-laskentaan
    private fun calculateBMI() {
        if (height.value > 0) {
            bmi.value = weight.value / (height.value * height.value)
        } else {
            bmi.value = 0f
        }
    }
}

