package com.exercise.pbd.hellotoast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int initial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initial = 0;
    }

    public void showToast (View view) {
        Toast toast = Toast.makeText(getApplicationContext(), "Hello, World!", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp (View view) {
        initial++;
        TextView number = (TextView) findViewById(R.id.show_count);
        number.setText(Integer.toString(initial));
    }
}
