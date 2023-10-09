package com.example.t_convert;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class C_and_K extends AppCompatActivity {

    Button b1,b2;

    EditText e;

    TextView t;

    RadioButton r1,r2;

    Double x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cand_k);

        b1 = findViewById(R.id.button6);

        b2 = findViewById(R.id.button7);

        e = findViewById(R.id.editTextText2);

        t = findViewById(R.id.textView2);

        r1 = findViewById(R.id.radioButton3);

        r2 = findViewById(R.id.radioButton4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e.getText().toString().isEmpty()){
                    t.setText("Please give Temperature");
                } else {
                    x = Double.parseDouble(String.valueOf(e.getText()));
                    if (r1.isChecked()){
                        x = Convert_c_k(x);
                        x = Double.parseDouble(new DecimalFormat("##.###").format(x));
                        t.setText(String.valueOf(x) + " K ");
                    } else if (r2.isChecked()) {
                        x = Convert_k_c(x);
                        x = Double.parseDouble(new DecimalFormat("##.###").format(x));
                        t.setText(String.valueOf(x) + " deg C");
                    }
                    else{
                        t.setText("Please select any option!");
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e.setText("");
                t.setText("0.0");
                r1.setChecked(false);
                r2.setChecked(false);
            }
        });




    }

    public static double Convert_c_k(Double d){
        d = d + 273.15 ;
        return d;
    }

    public static double Convert_k_c(Double d){
        d = d - 273.15;
        return d;
    }
}