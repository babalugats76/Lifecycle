package edu.colestock.cs.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.util.Date;

public class LifecycleActivity extends Activity {

    private final static String TEXT_VIEW_KEY = "textView";
    private final static String EVENT_COUNTER_KEY = "eventCounter";

    private TextView textView;
    private int eventCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        textView = (TextView) findViewById(R.id.textView);
        if(savedInstanceState != null) {
            textView.setText(savedInstanceState.getCharSequence(LifecycleActivity.TEXT_VIEW_KEY));
            eventCounter = savedInstanceState.getInt(LifecycleActivity.EVENT_COUNTER_KEY);
        }
        recordEvent("Create");
    }

    // Event responsible for appending to screen the event that happened, when, in which order, etc.
    private void recordEvent(String eventName) {
        eventCounter++;
        textView.setText("#" + String.valueOf(eventCounter) + " " + eventName.toUpperCase() + " EVENT FIRED: " + new Date().toString() + "\n" + textView.getText());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        recordEvent("Destroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        recordEvent("Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        recordEvent("Stop");
    }

    @Override
    protected void onRestart() {
        // Fires for every start event, except the first one, i.e., a "true" restart
        super.onRestart();
        recordEvent("Restart");
    }

    @Override
    protected void onResume() {
        // In the foreground
        super.onResume();
        recordEvent("Resume");
    }

    @Override
    protected void onPause() {
        // In the background
        super.onPause();
        recordEvent("Pause");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Add current value of TextView and int, used to record events, to the key and save its current contents...
        outState.putCharSequence(LifecycleActivity.TEXT_VIEW_KEY, textView.getText());
        outState.putInt(LifecycleActivity.EVENT_COUNTER_KEY, eventCounter);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.lifecycle, menu);
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
