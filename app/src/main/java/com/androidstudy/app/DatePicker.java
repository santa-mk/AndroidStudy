package com.androidstudy.app;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class DatePicker extends ActionBarActivity {
    private Activity mActivity;
    DatePickerDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity = this;
        setContentView(R.layout.activity_date_picker);
        showDialog();
    }


    private void showDialog() {
        DatePickerDialog.OnDateSetListener mListener = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int day) {
                String date = year + "/" + month + "/" + day;
                Toast.makeText(mActivity, date, Toast.LENGTH_LONG).show();
                TextView view = (TextView) findViewById(R.id.text_input);
                view.setText(date);
            }
        };

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(this, mListener, year, month, day);
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.date_picker, menu);
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
