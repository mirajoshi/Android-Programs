package com.example.progressbar;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Button button;
    TextView textView;

    int progress = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(v -> {
            progress = 0;
            progressBar.setProgress(progress);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (progress < 100) {
                        progress += 10;
                        progressBar.setProgress(progress);
                        textView.setText("Progress: " + progress + "%");
                        handler.postDelayed(this, 300);
                    }
                }
            }, 300);
        });
    }
}