package com.androidstudy.app;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static android.provider.ContactsContract.CommonDataKinds;
import static android.provider.ContactsContract.CommonDataKinds.*;


public class ContentProviderActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);

        ListView lview = (ListView) findViewById(R.id.listView_content_provider);
        loadAddressData(lview);
    }

    private void loadAddressData(ListView listView) {
        // get cursor
        Cursor cursor = getContentResolver().query(Phone.CONTENT_URI,null, null, null, null);
        startManagingCursor(cursor);

        // get line number
        int contact_id = cursor.getColumnIndexOrThrow(Phone.CONTACT_ID);
        int display_name = cursor.getColumnIndexOrThrow(Phone.DISPLAY_NAME);
        int phone_number = cursor.getColumnIndexOrThrow(Phone.DATA);

        // get data and display
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        while(cursor.moveToNext()) {
            String row = String.format("[%s] %s \n%s", cursor.getString(contact_id), cursor.getString(display_name), cursor.getString(phone_number));
            adapter.add(row);
        }
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.content, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
