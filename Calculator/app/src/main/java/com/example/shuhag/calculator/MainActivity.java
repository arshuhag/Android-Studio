package com.example.shuhag.calculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button dot;
    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button equal;
    private Button clear;
    private Button back;
    private TextView exp;
    private TextView result;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQU = 0;
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText().toString() + ".");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText().toString() + "0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText().toString() + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText().toString() + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText().toString() + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText().toString() + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText().toString() + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText().toString() + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText().toString() + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText().toString() + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp.setText(exp.getText().toString() + "9");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = ADDITION;
                result.setText(String.valueOf(val1) + "+");
                exp.setText(null);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = SUBTRACTION;
                result.setText(String.valueOf(val1) + "-");
                exp.setText(null);
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = MULTIPLICATION;
                result.setText(String.valueOf(val1) + "*");
                exp.setText(null);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = DIVISION;
                result.setText(String.valueOf(val1) + "/");
                exp.setText(null);
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = EQU;
                result.setText(result.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                //result.setText(String.valueOf(val1));
                exp.setText(null);
            }
        });
        /*clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(exp.getText().length() > 0){
                    CharSequence name = exp.getText().toString();
                    exp.setText(name.subSequence(0, name.length()-1));

                }
                else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    exp.setText(null);
                    result.setText(null);
                }
            }
        });*/
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1 = Double.NaN;
                val2 = Double.NaN;
                exp.setText(null);
                result.setText(null);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(exp.getText().length() > 0){
                    CharSequence name = exp.getText().toString();
                    exp.setText(name.subSequence(0, name.length()-1));

                }
                else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    exp.setText(null);
                    result.setText(null);
                }
            }
        });



    }

    private void setupUIViews(){
        dot = (Button)findViewById(R.id.btnDot);
        zero = (Button)findViewById(R.id.btnZero);
        one = (Button)findViewById(R.id.btnOne);
        two = (Button)findViewById(R.id.btnTwo);
        three = (Button)findViewById(R.id.btnThree);
        four = (Button)findViewById(R.id.btnFour);
        five = (Button)findViewById(R.id.btnFive);
        six = (Button)findViewById(R.id.btnSix);
        seven = (Button)findViewById(R.id.btnSeven);
        eight = (Button)findViewById(R.id.btnEight);
        nine = (Button)findViewById(R.id.btnNine);
        add = (Button)findViewById(R.id.btnPlus);
        sub = (Button)findViewById(R.id.btnMinus);
        mul = (Button)findViewById(R.id.btnMul);
        div = (Button)findViewById(R.id.btnDivide);
        equal = (Button)findViewById(R.id.btnEqual);
        clear = (Button)findViewById(R.id.btnClear);
        back = (Button)findViewById(R.id.btnBack);
        exp = (TextView)findViewById(R.id.tvExp);
        result = (TextView)findViewById(R.id.tvResult);
    }

    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(exp.getText().toString());


            switch(ACTION){
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case EQU:
                    break;
            }
        }
        else {
            val1 = Double.parseDouble(exp.getText().toString());
        }
    }

}
