package com.example.delluser.ca2android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity {
    Converter converter = new Converter();
    private RadioButton USD, GBP;
    private TextView converted;
    private EditText euroAmountET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        USD = (RadioButton) findViewById(R.id.USDRadioButton);
        GBP = (RadioButton) findViewById(R.id.GBPRadioButton);
        converted = (TextView) findViewById(R.id.quoteTextView);
        euroAmountET = (EditText) findViewById(R.id.euroEditText);
    }

    public void clear(View v) {
        euroAmountET.setText("");
        USD.setChecked(false);
        GBP.setChecked(false);
    }

    public void convert(View v){
        String amount = euroAmountET.getText().toString();
        Double total;
        try{
            if(USD.isChecked()){
                GBP.setChecked(false);
                total = Double.parseDouble(amount) * converter.GetEurUsdRate();
                converted.setText(total.toString());
            }
            else if(GBP.isChecked()){
                USD.setChecked(false);
                total = Double.parseDouble(amount) * converter.GetEurGbpRate();
                converted.setText(total.toString());
            }
        } catch (Exception ex){
            ex.getMessage();
        }

    }

}