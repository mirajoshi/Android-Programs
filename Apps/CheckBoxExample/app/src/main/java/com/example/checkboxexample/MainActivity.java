package com.example.checkboxexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox check1, check2, check3;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder result = new StringBuilder("Selected: ");

                if (check1.isChecked()) {
                    result.append("Pizza ");
                }
                if (check2.isChecked()) {
                    result.append("Burger ");
                }
                if (check3.isChecked()) {
                    result.append("Pasta ");
                }

                textView.setText(result.toString());

                Toast.makeText(MainActivity.this,
                        result.toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}