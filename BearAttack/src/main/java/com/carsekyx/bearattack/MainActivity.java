package com.carsekyx.bearattack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    public final static String EXTRA_MESSAGE = "com.carsekyx.bearattack.MESSAGE";
    public final static String EXTRA_BEAR_MESSAGE = "com.carsekyx.bearattack.BEAR";

    private EditText nameEditText;
    private Spinner bearSpinner;
    private Button submitButton;

    private ArrayAdapter<CharSequence> spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        //Spinner code
        bearSpinner = (Spinner) findViewById(R.id.bear_type_spinner);

        // Edit Text Code
        nameEditText = (EditText) findViewById(R.id.name_field);

        // Create an ArrayAdapter using the string array and a default spinner layout
        spinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.bear_type_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Define the Submit Butto, set an on click listener to it.
        submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(this);

        // Apply the adapter to the spinner
        bearSpinner.setAdapter(spinnerAdapter);
        bearSpinner.setOnItemSelectedListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /*public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            String bear_type_string = parent.getItemAtPosition(pos).toString();
            Spinner spinner = (Spinner) findViewById(R.id.bear_type_spinner);
            spinner.setOnItemSelectedListener(this);
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }*/

    public void sendBear(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.name_field);
        String name = editText.getText().toString();
        //Spinner bear_type = (Spinner) findViewById(R.id.bear_type_spinner);
        //intent.putExtra(EXTRA_BEAR_MESSAGE, bear_type_string);
        //startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);
        String name = nameEditText.getText().toString();
        String bearType = spinnerAdapter.getItem(bearSpinner.getSelectedItemPosition()).toString();

        intent.putExtra("bear_type", bearType);
        intent.putExtra("name", name);

        startActivity(intent);
    }
}
