package com.androidstudy.app;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;


public class DatePicker extends ActionBarActivity implements View.OnClickListener{
    private static final String TAG = DatePicker.class.getSimpleName();
    private Activity mActivity;
    android.widget.DatePicker mDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity = this;
        mDatePicker = (android.widget.DatePicker) findViewById(R.id.datePicker);
        setContentView(R.layout.activity_date_picker);
        setListeners();
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

    private void setListeners() {
        ToggleButton toggleCalendar = (ToggleButton) findViewById(R.id.toggle_calendar);
        toggleCalendar.setOnClickListener(this);
        ToggleButton toggleSpinner = (ToggleButton) findViewById(R.id.toggle_spinner);
        toggleSpinner.setOnClickListener(this);
    }

    // TODO: mDatePicker is now null.
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.toggle_spinner:
                // mDatePicker.setSpinnersShown(((ToggleButton)v).isChecked());
                break;
            case R.id.toggle_calendar:
                // mDatePicker.setCalendarViewShown(((ToggleButton)v).isChecked());
                break;
            default:
                break;
        }
    }
}
