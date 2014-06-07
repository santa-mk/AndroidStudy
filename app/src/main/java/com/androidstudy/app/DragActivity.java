package com.androidstudy.app;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static android.view.DragEvent.*;


public class DragActivity extends ActionBarActivity {
    private static final String TAG = DragActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag);

        initialize();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drag, menu);
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

    void initialize() {
        TextView textView1 = (TextView) findViewById(R.id.textView_drag1);
        setDragListener(textView1);

        TextView textView2 = (TextView) findViewById(R.id.textView_drag2);
        setDragListener(textView2);

    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setDragListener(TextView textView) {
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ClipData clip = ClipData.newPlainText("clip", "clip");
                view.startDrag(clip, new View.DragShadowBuilder(view), view, 0);
                return true;
            }
        });
        textView.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                boolean result = false;
                String str = (String) ((TextView)view).getText();
                switch(dragEvent.getAction()) {
                    case ACTION_DRAG_STARTED:
                        Log.i(TAG, str + " : " + "ACTION_DRAG_STARTED");
                        view.setBackgroundColor(Color.BLUE);
                        result = getResult();
                        break;
                    case ACTION_DRAG_ENDED:
                        Log.i(TAG, str + " : " + "ACTION_DRAG_ENDED");
                        // view.setBackgroundColor(Color.CYAN);
                        break;
                    case ACTION_DRAG_LOCATION:
                        Log.i(TAG, str + " : " + "ACTION_DRAG_LOCATION");
                        view.setBackgroundColor(Color.DKGRAY);
                        result = getResult();
                        break;
                    case ACTION_DROP:
                        Log.i(TAG, str + " : " + "ACTION_DROP");
                        view.setBackgroundColor(Color.YELLOW);
                        result = getResult();
                        break;
                    case ACTION_DRAG_ENTERED:
                        Log.i(TAG, str + " : " + "ACTION_DRAG_ENTERED");
                        view.setBackgroundColor(Color.GREEN);
                        result = getResult();
                        break;
                    case ACTION_DRAG_EXITED:
                        Log.i(TAG, str + " : " + "ACTION_DRAG_EXITED");
                        view.setBackgroundColor(Color.RED);
                        result = getResult();
                        break;
                    default:
                        Log.i(TAG, str + " : " + dragEvent.getAction());
                        view.setBackgroundColor(Color.MAGENTA);
                        result = getResult();
                        break;
                }

                return result;
            }
        });
    }

    private boolean getResult() {
        return true;
    }
}
