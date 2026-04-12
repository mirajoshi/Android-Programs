package com.example.multiautocompletetextview;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    MultiAutoCompleteTextView multiAutoCompleteTextView;
    Button button;
    TextView textView;

    String[] fruits = {
            "Apple", "Banana", "Mango", "Orange",
            "Grapes", "Pineapple", "Strawberry", "Watermelon"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        multiAutoCompleteTextView = findViewById(R.id.multiAutoCompleteTextView);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                fruits
        );

        multiAutoCompleteTextView.setAdapter(adapter);

        // Important: sets comma separator
        multiAutoCompleteTextView.setTokenizer(
                new MultiAutoCompleteTextView.CommaTokenizer()
        );

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String selectedItems = multiAutoCompleteTextView.getText().toString();
                textView.setText("Selected: " + selectedItems);
            }
        });
    }
}