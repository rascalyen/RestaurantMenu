package com.example.restaurantmenu;

import java.util.List;
import org.json.JSONException;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnDownloadListener {

	private EditText ed;
	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	

		ed = (EditText) findViewById(R.id.edit_search);
	    lv = (ListView) findViewById(R.id.list);
	}

	public void search(View view) throws JSONException {
		switch (view.getId()) {
		
		case R.id.button:    
			if (this.ed.getText().toString().equals("")) {
				showToast("Text can't be empty !");
				break;
			}
			else {
				MyRestClientUsage client = new MyRestClientUsage();
				String s = "/?method=menuSearch&search=" + this.ed.getText().toString();
				client.getMenuItems(s, this);
				break;
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onDownloadSuccess(List<MenuItem> items) {
		MyListAdapter adapter = new MyListAdapter(this, items);
		lv.setAdapter(adapter);	
	}

	private void showToast(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}

}
