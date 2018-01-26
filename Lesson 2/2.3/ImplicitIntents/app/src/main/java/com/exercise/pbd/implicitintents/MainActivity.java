package com.exercise.pbd.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText webeditText;
    private EditText loceditText;
    private EditText shareeditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webeditText = (EditText) findViewById(R.id.website_edittext);
        loceditText = (EditText) findViewById(R.id.location_edittext);
        shareeditText = (EditText) findViewById(R.id.share_edittext);
    }

    public void openWebsite(View view) {
        String url = webeditText.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("Implicit Intents", "Can't handle this");
        }
    }

    public void openLocation(View view) {
        String loc = loceditText.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("Implicit Intents", "Can't handle this");
        }

    }

    public void shareText(View view) {
        String text = shareeditText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder.from(this).setType(mimeType).setChooserTitle("Share this text with:").setText(text).startChooser();
    }
}
