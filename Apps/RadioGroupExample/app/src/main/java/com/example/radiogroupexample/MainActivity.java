package com.example.radiogroupexample;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        textView = findViewById(R.id.textView);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {

            RadioButton selectedRadio = findViewById(checkedId);

            if (selectedRadio != null) {
                String selectedText = selectedRadio.getText().toString();
                textView.setText("Selected: " + selectedText);
            }
        });
    }
}