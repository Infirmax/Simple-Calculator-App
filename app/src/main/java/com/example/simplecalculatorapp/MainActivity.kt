package com.example.simplecalculatorapp

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.simplecalculatorapp.ui.theme.SimpleCalculatorAppTheme
import java.lang.Exception


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        val num1: EditText = findViewById(R.id.num1) as EditText
        val num2: EditText = findViewById(R.id.num2) as EditText
        val spinner: Spinner = findViewById(R.id.operator_spinner)
        val calculateButton: Button = findViewById(R.id.calculate_button)
        val answer: TextView = findViewById(R.id.answer)


// Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter.createFromResource(
            this,
            R.array.operator_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
            spinner.adapter = adapter
        }



        calculateButton.setOnClickListener {
            val num1_answer = num1.text.toString().toDouble()
            val num2_answer = num2.text.toString().toDouble()
            val selectedOperator: String = spinner.selectedItem.toString()

            when (selectedOperator){
                "+" -> {
                    answer.text = (num1_answer + num2_answer).toString()
                }
                "-" -> {
                    answer.text = (num1_answer - num2_answer).toString()
                }
                "*" -> {
                    answer.text = (num1_answer * num2_answer).toString()
                }
                "/" -> {
                    if(num2_answer == 0.0){
                        answer.text = "Cannot Divide By 0"
                        throw Exception("DIVIDE BY ZERO ERROR")

                    } else {
                        answer.text = (num1_answer / num2_answer).toString()
                    }
                }
                "%" -> {
                    answer.text = (num1_answer % num2_answer).toString()
                }
            }

            answer.visibility = View.VISIBLE



        }

//        setContent {
//            SimpleCalculatorAppTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
//            }
//        }

    }
}


