package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.lang.reflect.Array
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    private lateinit var firstIn : EditText
    private lateinit var secondIn : EditText
    private lateinit var btnCalc : Button
    private lateinit var resultTxt : TextView
    private lateinit var operatorTxt: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        btnCalc.setOnClickListener {
            if(firstIn.text.toString() != "" && secondIn.text.toString() !=""
                && operatorTxt.text.toString() !="") {
                var firstNum: Float = firstIn.text.toString().toFloat()
                var secondNum: Float = secondIn.text.toString().toFloat()
                resultTxt.text = calculate(firstNum, secondNum, operatorTxt.text.toString())
            }
            else
                Toast.makeText(this,"Fill the fields!", Toast.LENGTH_LONG).show()

        }
    }

    private fun calculate(num1: Float, num2: Float, opr: String): String{
        return  when(opr) {
            "+" -> (num1 + num2).toString()
            "-" -> (num1 - num2).toString()
            "*" -> (num1 * num2).toString()
            "/" -> (num1 / num2).toString()
            else -> "Enter a valid operator!"
        }
    }
    private fun initView(){
        firstIn = findViewById(R.id.first_in)
        secondIn = findViewById(R.id.second_in)
        btnCalc = findViewById(R.id.btn_calc)
        resultTxt = findViewById(R.id.txt_result)
        operatorTxt = findViewById(R.id.operator_txt)
    }
}