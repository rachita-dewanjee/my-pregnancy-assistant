package com.example.momchildcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        final EditText height,weight;
        final TextView txtenter,txtres;
        Button button_result,reset,recommended;

        weight=(EditText)findViewById(R.id.weight);
        height=(EditText)findViewById(R.id.height);
        txtenter=(TextView)findViewById(R.id.txtenter);
        txtres=(TextView)findViewById(R.id.txtres);
        button_result=(Button)findViewById(R.id.btn_result);
        reset=(Button)findViewById(R.id.reset);
        recommended=(Button) findViewById(R.id.recommended);
        recommended.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Calculate.this,Recommended.class);
                startActivity(intent);
            }
        });

        button_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strweight=weight.getText().toString();
                String strheight=height.getText().toString();

                if(strweight.equals(" "))
                {
                    weight.setError("Please enter your weight");
                    weight.requestFocus();
                    return;
                }
                if(strheight.equals(" "))
                {
                    height.setError("Please enter your height");
                    height.requestFocus();
                    return;
                }
                float wei=Float.parseFloat(strweight);
                float hei=Float.parseFloat(strheight)/100;

                float bmiValue=BMICalculate(wei,hei);
                txtenter.setText(interpreteBMI(bmiValue));
                txtres.setText("BMI= "+bmiValue);

            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                height.setText("");
                weight.setText("");
                txtenter.setText("");
                txtres.setText("");

            }
        });

    }

    public float BMICalculate(float weight,float height)
    {
        return weight/(height*height);
    }
    public String interpreteBMI(float BmiValue)
    {
        if(BmiValue<18.5) {
            return "UnderWeight";
        }
        else if(BmiValue<25) {
            return "Normal";
        }
        else if(BmiValue<30) {
            return "OverWeight";
        }
        else
            return "Obese";

    }

}
