package com.firman.temperature;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputTxt;
    TextView outputTxt, labelTxt;
    RadioButton celcius, fahrenheit, kelvin;
    Button converBtn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputTxt = (EditText) findViewById(R.id.input_txts);
        outputTxt = (TextView) findViewById(R.id.output_txt);
        labelTxt = (TextView) findViewById(R.id.label_txt);
        celcius = (RadioButton) findViewById(R.id.celcius);
        fahrenheit = (RadioButton) findViewById(R.id.fahrenheit);
        kelvin = (RadioButton) findViewById(R.id.kelvin);
//        converBtn = (Button) findViewById(R.id.convertBtn);

        converBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double input = Double.parseDouble(inputTxt.getText().toString());
                    double output = 0;
                    if (celcius.isChecked()) {
                        labelTxt.setText("Fahrenheit aja");
                        output = input * 9 / 5 + 32;
                    } else if (fahrenheit.isChecked()){
                        labelTxt.setText("Celcius nih");
                        output = (input - 32) * 5 / 9;
                    } else if (kelvin.isChecked()){
                        labelTxt.setText("Celcius oke kok");
                        output = input + 273;
                    }
//                    outputTxt.setText(output + "");
                    outputTxt.setText(output + "");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Toast.makeText(MainActivity.this, "Isi Value Nya", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


//    public void convertBtn(View view) {
//        if (inputTxt.length() >= 0) {
//            Toast.makeText(this, "Please isi angka", Toast.LENGTH_SHORT).show();
//        }
//
//
//
//
//
//    }
}