package com.carsekyx.bearattack;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.RadioButton;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.text.TextUtils;
/**
 * Created by Nick on 16/07/13.
 */
public class DisplayMessageActivity extends Activity {

        /* Added a new TextView in the src/main/res/layout/activity_display_message.xml*/

        TextView messageTextView;
        //@SuppressLint("NewApi")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_display_message);


            // Get the message from the intent
            Intent intent = getIntent();
            String name = intent.getStringExtra("name");
            //String bear_type = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
            //boolean checked = ((RadioButton) view).isChecked();

            // Find the text view
            messageTextView = (TextView) findViewById(R.id.messageTextView);

            
            name = name.toLowerCase();

            // Test for various conditions
            if(name.equals("nick") || name.equals("carsekyx")) {
                messageTextView.setText("I'd love to but he's just too good to look at");
            } else if(name.equals("sean") || name.equals("sail")){
                messageTextView.setText("Gross, too much hair gel and feminism");
            } else if(name.equals("")) {
                messageTextView.setText("You didn't enter a name. Go back and try again");
            } else {
                name = name.substring(0, 1).toUpperCase() + name.substring(1);
                messageTextView.setText("I ate " + name + " and #{gender_title} was delicious");
            }

            // Set the text view as the activity layout
            //setContentView(textView);
            //textView.setText(bear_type);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case android.R.id.home:
                    NavUtils.navigateUpFromSameTask(this);
                    return true;
            }
            return super.onOptionsItemSelected(item);
        }
}