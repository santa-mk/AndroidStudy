package com.androidstudy.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Date;


public class Preference extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        showPreBootedTime();
    }

    private void showPreBootedTime() {
        SharedPreferences sPref = getSharedPreferences("config", Context.MODE_PRIVATE);
        String preBootTime = sPref.getString("PRE_BOOT", new Date().toString());
        TextView view = (TextView) findViewById(R.id.preBootTime);
        view.setText(preBootTime);

        // record current Boot TIme to Preference
        String curBootTime = new Date().toString();
        SharedPreferences.Editor editor = sPref.edit();
        editor.putString("PRE_BOOT", curBootTime);
        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.preference, menu);
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
