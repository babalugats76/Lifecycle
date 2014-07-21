package edu.colestock.cs.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class LifecycleActivity extends Activity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        textView = (TextView) findViewById(R.id.textView);
        textView.append("Create event fired\n");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        textView.append("Destroy event fired\n");
    }

    @Override
    protected void onStart() {
        super.onStart();
        textView.append("Start event fired\n");
    }

    @Override
    protected void onStop() {
        super.onStop();
        textView.append("Stop event fired\n");
    }

    @Override
    protected void onRestart() {
        // Fires for every start event, except the first one, i.e., a "true" restart
        super.onRestart();
        textView.append("Restart event fired\n");
    }

    @Override
    protected void onResume() {
        // In the foreground
        super.onResume();
        textView.append("Resume event fired\n");
    }

    @Override
    protected void onPause() {
        // In the background
        super.onPause();
        textView.append("Pause event fired\n");
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
