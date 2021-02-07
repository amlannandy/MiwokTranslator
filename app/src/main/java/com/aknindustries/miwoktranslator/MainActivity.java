package com.aknindustries.miwoktranslator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView numbersTextView = findViewById(R.id.numbers);
        numbersTextView.setOnClickListener(v -> {
            Intent intent = new Intent(this, NumbersActivity.class);
            startActivity(intent);
        });
        TextView familyTextView = findViewById(R.id.family);
        familyTextView.setOnClickListener(v -> {
            Intent intent = new Intent(this, FamilyActivity.class);
            startActivity(intent);
        });
        TextView colorsTextView = findViewById(R.id.colors);
        colorsTextView.setOnClickListener(v -> {
            Intent intent = new Intent(this, ColorsActivity.class);
            startActivity(intent);
        });
        TextView phrasesTextView = findViewById(R.id.phrases);
        phrasesTextView.setOnClickListener(v -> {
            Intent intent = new Intent(this, PhrasesActivity.class);
            startActivity(intent);
        });
    }

}