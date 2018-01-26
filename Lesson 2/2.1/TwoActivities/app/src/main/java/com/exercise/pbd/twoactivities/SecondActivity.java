package com.exercise.pbd.twoactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.exercise.pbd.twoactivities.extra.REPLY";

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = (TextView) findViewById(R.id.text_message);
        textView.setText(message);
    }

    public void returnReply(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        editText = (EditText) findViewById(R.id.editText_second);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_REPLY, message);
        setResult(RESULT_OK, intent);
        finish();

    }
}
