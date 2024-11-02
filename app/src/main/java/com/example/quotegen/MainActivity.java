package com.example.quotegen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FrameLayout lifeCategory = findViewById(R.id.frameLife);
        FrameLayout motivationalCategory = findViewById(R.id.frameMotivational);
        FrameLayout inspirationalCategory = findViewById(R.id.frameInspirational);
        FrameLayout loveCategory = findViewById(R.id.frameLove);
        FrameLayout successCategory = findViewById(R.id.frameSuccess);
        FrameLayout happinessCategory = findViewById(R.id.frameHappiness);
        FrameLayout mindfulnessCategory = findViewById(R.id.frameMindfulness);

        //  onClickListener for Life category
        lifeCategory.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, QuoteActivity.class);
            intent.putExtra("category", "Life");
            startActivity(intent);
        });

        //  onClickListener for Motivational category
        motivationalCategory.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, QuoteActivity.class);
            intent.putExtra("category", "Motivational");
            startActivity(intent);
        });

        //  onClickListener for Inspirational category
        inspirationalCategory.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, QuoteActivity.class);
            intent.putExtra("category", "Inspirational");
            startActivity(intent);
        });

        //  onClickListener for Love category
        loveCategory.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, QuoteActivity.class);
            intent.putExtra("category", "Love");
            startActivity(intent);
        });

        //  onClickListener for Success category
        successCategory.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, QuoteActivity.class);
            intent.putExtra("category", "Success");
            startActivity(intent);
        });

        //  onClickListener for Happiness category
        happinessCategory.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, QuoteActivity.class);
            intent.putExtra("category", "Happiness");
            startActivity(intent);
        });

        //  onClickListener for Mindfulness category
        mindfulnessCategory.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, QuoteActivity.class);
            intent.putExtra("category", "Mindfulness");
            startActivity(intent);
        });
    }
}
