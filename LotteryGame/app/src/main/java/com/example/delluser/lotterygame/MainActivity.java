package com.example.delluser.lotterygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateTitleTextView();
    }

    public void updateTitleTextView(){
        TextView title = ((TextView) findViewById(R.id.titleTextView));
        String output = "Pick " + ((EditText) findViewById(R.id.editHowMany)).getText()
                + " numbers from 1 to " + ((EditText) findViewById(R.id.editMax)).getText();
        title.setText(output);
    }

    // generate button clicked
    public void generateButtonClicked(View v){
        try{
            // get hooks to widgets
            TextView numberPicks = ((TextView) findViewById(R.id.displayTextView));
            EditText editHowMany = ((EditText) findViewById(R.id.editHowMany));
            EditText editMax = ((EditText) findViewById(R.id.editMax));
            numberPicks.setText("");

            // read and parse editHowMany
            int howMany = 0;
            try{
                String input = editHowMany.getText().toString();
                howMany = Integer.parseInt(input);
            }
            catch(NumberFormatException nfe){
                editHowMany.setError("Must be a number");
                return;
            }

            // read and parse editMax
            int max = 0;
            try{
                String input = editMax.getText().toString();
                max = Integer.parseInt(input);
            }
            catch(NumberFormatException nfe){
                editMax.setError("Must be a number");
            }

            if(max < howMany){
                editMax.setError("too small");
            }

            // pick the numbers
            int[] picks = Lottery.GetNumbers(howMany, max);
            String data = "";
            for(int number: picks){
                data = data + number + " ";
            }

            numberPicks.setText(data);
            updateTitleTextView();
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}
