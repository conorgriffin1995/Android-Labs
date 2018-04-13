package com.example.delluser.lottogameapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateTitleTextView();
    }

    // update title textview to display lottery info i.e. how many numbers to pick
    // and max number that can be picked
    protected void updateTitleTextView()
    {
        TextView title = ((TextView) findViewById(R.id.titleTextView));
        String output = "Pick " + ((EditText) findViewById(R.id.howManyEditText)).getText()
                + " numbers from 1 to " + ((EditText) findViewById(R.id.maxEditText)).getText();
        title.setText(output);
    }

    // pick button clicked
    public void pickButtonClicked(View v)
    {
        try
        {
            // get hooks to widgets
            TextView tv = (TextView) findViewById(R.id.picksTextView);
            EditText howManyEditTest = ((EditText) findViewById(R.id.howManyEditText));
            EditText maxEditTest = ((EditText) findViewById(R.id.maxEditText));
            tv.setText("");

            // read and parse how many e.g. 6
            int howMany = 0;
            try
            {
                String input = howManyEditTest.getText().toString();
                howMany = Integer.parseInt(input);
            }
            catch (NumberFormatException nfe)
            {
                howManyEditTest.setError("must be a number");
                return;
            }

            // read and parse max e.g. 45
            int max = 0;
            try
            {
                String input = maxEditTest.getText().toString();
                max = Integer.parseInt(input);
            }
            catch (NumberFormatException nfe)
            {
                maxEditTest.setError("must be a number");
                return;
            }

            if (max < howMany)
            {
                maxEditTest.setError("too small");
                return;
            }

            // pick the numbers
            int[] picks = Lottery.pickNumbers(howMany, max);

            // display the numbers
            String data = "";
            for (int number: picks)
            {
                data = data + number + " ";
            }
            tv.setText(data);
            updateTitleTextView();
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
