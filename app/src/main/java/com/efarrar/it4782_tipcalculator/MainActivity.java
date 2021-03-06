package com.efarrar.it4782_tipcalculator;

/*
    Emmanuel Farrar
    Date Created: February 8, 2020
    Date Last modified: February 9, 2020
    Title: IT4782 - Tip Calculator
    Description: This is complete rebuild of U03A? assignment where for U04A1 I have rebuilt the
        Tip Calculator from scratch in order to get practice building apps from the start.
        This app is to function as a tip calculator in accordance with the syllabus for IT4782. In
        this app no variation from the instructions was made however if I do decided to make an addition
        tip calculator app I will label it as IT4782_TipCalc_ExtraPractice


 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    //VARIABLES
    private EditText etbillAmount;
    private EditText etTipPercent;
    private TextView tvTotalBill;
    private TextView tvTotalTip;
    private Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instantiating var as elements from activity_main.xml
        etbillAmount = findViewById(R.id.etBillAmount);
        etTipPercent = findViewById(R.id.etTipPercent);
        tvTotalBill = findViewById(R.id.tvTotalBillAmount);
        tvTotalTip = findViewById(R.id.tvTotalTipAmount);
        btnCalc = findViewById(R.id.btnCalc);


        //Onclick listener for btnCalc to call calculation(s) methods
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTotal();           //method that calculates totals
            }
        });
    }

    /*Purpose of the calculateTotal()
    The methods purpose is to do all calculations for the tip calculator.
    As I developed the method I needed to add a means of dealing with the
    edit text fields when they were empty, this resulted in the if statement.
    Throughout the method there is a lot of casting from string to double and back,
    as well as formatting so the output would show as 0.00. Finally, the function sets the
    the textViews with the results of the calculations.

     */
    private void calculateTotal() {

        //if statement to check if field is empty to prevent app from crashing
        if (etbillAmount.getText().toString().isEmpty()){
            tvTotalBill.setText("");
            tvTotalTip.setText("");
            return;
        }

        //get input from users
        String billString = etbillAmount.getText().toString();
        String tipString = etTipPercent.getText().toString();
        DecimalFormat df2 = new DecimalFormat("0.00");      //will use to format output.

        // convert billString into a double and tipString to Int
        double bill = Double.parseDouble(billString);
        double tip = Double.parseDouble(tipString);

        //formulas for tipAmount and totalBill
        double tipAmount = bill * (tip/100);
        double totalBill = bill + tipAmount;

        //assigning calculated numbers to elements so user can see them
        tvTotalBill.setText(df2.format(totalBill));
        tvTotalTip.setText(df2.format(tipAmount));

    }// end of calculateTotal()
}
