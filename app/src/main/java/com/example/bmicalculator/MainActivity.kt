package com.example.bmicalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calBtn.setOnClickListener() {
            try {
                val weight: Double = input_weight.text.toString().toDouble();
                val height: Double = input_height.text.toString().toDouble();
                val bmi: Double = weight / Math.pow(height, 2.0);
                val status: String;
                if (bmi < 18.5) {
                    image.setImageResource(R.drawable.under);
                    status = "Under"
                } else if (bmi > 18.5 && bmi < 24.9) {
                    image.setImageResource(R.drawable.normal);
                    status = "Normal";
                } else {
                    image.setImageResource(R.drawable.over);
                    status = "Over";
                }
                result_txt.text = "BMI: %.2f (%s)".format(bmi, status);
            }catch(ex:Exception){
                val toast: Toast = Toast.makeText(this,"Invalid Input",Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                val v : TextView = toast.view.findViewById<TextView>(android.R.id.message);
                v.setTextColor(Color.RED);
                toast.show();
            }
        }

        reset_btn.setOnClickListener(){
            image.setImageResource(R.drawable.empty);
            result_txt.text = "";
            input_weight.setText("");
            input_height.setText("");
        }
    }
}
