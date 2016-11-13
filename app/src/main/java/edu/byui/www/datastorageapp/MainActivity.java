package edu.byui.www.datastorageapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textNumber;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textNumber = (TextView) findViewById(R.id.textNumber);
        dbHandler = new MyDBHandler(this, null, null, 1);
        textNumber.setText(dbHandler.getValue());
    }

    //Add a value to the database
    public void saveButtonClicked(View view){
        Integer number = Integer.parseInt(textNumber.getText().toString());
        Values values = new Values(Integer.toString(number));
        dbHandler.addValue(values);
        textNumber.setText(values.get_value());
    }

    //Advance items
    public void advanceButtonClicked (View view){
        Integer newValue = Integer.parseInt(textNumber.getText().toString()) + 1;
        textNumber.setText(Integer.toString(newValue));
    }

}
