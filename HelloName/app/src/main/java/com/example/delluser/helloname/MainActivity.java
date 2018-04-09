package com.example.delluser.helloname;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sayHello(View v){
        // read name
        String name = ((EditText) findViewById(R.id.nameEditText)).getText().toString();

        // display a 'toast' message with a greeting to the name
        Context context = getApplicationContext();
        CharSequence text = "Hello there " + name;
        int duration = Toast.LENGTH_LONG;
        Toast.makeText(context, text, duration).show();

        // write debug message to LogCat
        Log.d("Hello Name", "message displayed: " + text);
    }
}
