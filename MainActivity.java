package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends AppCompatActivity {
    private Integer counter = 0;
    int scaling = 1;
    int limit = 10;
    public static final String TAG = "StartActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate()", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onCreate");
    }
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null &&
                savedInstanceState.containsKey("count")) {
            counter = savedInstanceState.getInt("count");
        }
        Log.d(TAG, "onRestoreInstanceState");
    }
    public void onRestart(){
        super.onRestart();
        Log.d(TAG, "onRestart");
    }
    public void onStart(){
        super.onStart();
        Log.d(TAG, "onStart");
        resetUI();
    }
    public void onResume(){
        super.onResume();
        Log.d(TAG, "onResume");
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", counter);
        Log.d(TAG, "onSaveInstanceState");
    }
    public void onPause(){
        super.onPause();
        Log.d(TAG, "onPause");
    }
    public void onStop(){
        super.onStop();
        Log.d(TAG, "onStop");
    }
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Destroye");
    }
    private void resetUI() {
        ((TextView) findViewById(R.id.textView)).setText(counter.toString());
        Log.d(TAG, "resetUI");
    }
    public void onButtonAdd(View view){
        counter = counter + 1*scaling;
        TextView counterView = (TextView) findViewById(R.id.textView);
        TextView FigureOval = (TextView) findViewById(R.id.textView2);
        if (counter >= limit){
            ViewGroup.LayoutParams ovalparams = counterView.getLayoutParams();
            ovalparams.width = (FigureOval.getWidth() + 25);
            ovalparams.height = (FigureOval.getHeight() + 25);
            FigureOval.setLayoutParams(ovalparams);
            limit *= 10;
        }
        counterView.setText(Integer.toString(counter));
    }


}