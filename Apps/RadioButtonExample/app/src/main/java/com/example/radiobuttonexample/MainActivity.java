package com.example.radiobuttonexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    textView.setText("No option selected");
                    return;
                }

                String selectedText = "";

                if (selectedId == R.id.radio1) {
                    selectedText = "Male";
                } else if (selectedId == R.id.radio2) {
                    selectedText = "Female";
                } else if (selectedId == R.id.radio3) {
                    selectedText = "Other";
                }

                textView.setText("Selected: " + selectedText);

                Toast.makeText(MainActivity.this,
                        "You selected: " + selectedText,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}