package com.coderdojo.andchat;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;




public class DisplayMessageActivity extends Activity {

	List<String> messages = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);
		
		// Show the Up button in the action bar.
		setupActionBar();
		
		// Get the message from the intent
//	    Intent intent = getIntent();
//	    String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
//
//	    // Create the text view
//	    TextView textView = new TextView(this);
//	    textView.setTextSize(40);
//	    textView.setText(message);
//
//	    // Set the text view as the activity layout
//	    setContentView(textView);

	    getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_message, menu);
		return true;
	}
	
	public void sendMessage(View view) {
		EditText editText = (EditText) findViewById(R.id.sendMessage);
    	String message = editText.getText().toString();
    	editText.setText("");
    	ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
        									messages);
        ListView listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(adapter);
        
    	messages.add(new String(message));
    	adapter.notifyDataSetChanged();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}