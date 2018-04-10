package com.example.delluser.celciustofahrenheit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Convert celsius to fahrenheit or vice versa depending on which edit text has a value
    public void convert(View v){
        EditText celsiusET = (EditText) findViewById(R.id.celsiusEditText);
        String celsius = celsiusET.getText().toString().trim();

        EditText fahrenheitET = (EditText) findViewById(R.id.fahrenheitEditText);
        String fahrenheit = fahrenheitET.getText().toString().trim();

        if(celsius.length() != 0){
            fahrenheitET.setText(((Double.parseDouble(celsius) * (9.0/5.0)) + 32) + "");
        }
        else{
            if(fahrenheit.length() != 0){
                celsiusET.setText(((Double.parseDouble(fahrenheit) - 32) * (5.0/9.0)) + "");
            }
        }
    }

}
