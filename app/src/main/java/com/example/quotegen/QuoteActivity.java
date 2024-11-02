package com.example.quotegen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;

public class QuoteActivity extends AppCompatActivity {
    private Button previousButton;
    private boolean isPreviousButtonVisible = false;
    private TextView quoteText;
    private Button nextButton, shareButton;
    private ArrayList<String> quotes;
    private int currentQuoteIndex = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        // Initialize UI elements
        quoteText = findViewById(R.id.quoteText);
        nextButton = findViewById(R.id.nextButton);
        previousButton = findViewById(R.id.previousButton);
        shareButton = findViewById(R.id.shareButton);

        // Initially hide the previous button
        previousButton.setVisibility(View.INVISIBLE);

        // Load fade-in animation
        final Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        // Retrieve the category passed from MainActivity
        String category = getIntent().getStringExtra("category");
        loadQuotes(category);

        // Display the first quote
        updateQuote();


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuoteIndex++;
                if (currentQuoteIndex >= quotes.size()) {
                    currentQuoteIndex = 0; // Loop back to the first quote
                }
                updateQuote();

                // Show previous button with animation if not already visible
                if (!isPreviousButtonVisible) {
                    previousButton.setVisibility(View.VISIBLE);
                    previousButton.startAnimation(fadeIn);
                    isPreviousButtonVisible = true; // Set the flag to true
                }
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuoteIndex--;
                if (currentQuoteIndex < 0) {
                    currentQuoteIndex = quotes.size() - 1; // Loop back to the last quote
                }
                updateQuote();

                // Check if the current quote index is 0 to hide the previous button
                if (currentQuoteIndex == 0) {
                    previousButton.setVisibility(View.GONE);
                    isPreviousButtonVisible = false; // Reset the flag
                }
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareQuote();
            }
        });
    }


    // Method to load quotes based on the category
    private void loadQuotes(String category) {
        quotes = new ArrayList<>();

        switch (category) {
            case "Life":
                quotes.add("Life is beautiful.");
                quotes.add("Live in the moment.");
                quotes.add("Life is a journey, not a destination.");
                quotes.add("Some people never go crazy. What truly horrible lives they must lead.");
                quotes.add("In the end, it’s not the years in your life that count, it’s the life in your years.");
                quotes.add("The purpose of life is not to be happy. It is to be useful.");
                quotes.add("Life is short, and it is up to you to make it sweet.");
                quotes.add("Good friends, good books, and a sleepy conscience: this is the ideal life.");
                break;

            case "Motivational":
                quotes.add("Stay motivated!");
                quotes.add("Push yourself.");
                quotes.add("The best time to start was yesterday. The second best time is now.");
                quotes.add("Stay hungry, stay foolish.");
                quotes.add("Don’t let yesterday take up too much of today.");
                quotes.add("Push yourself, because no one else is going to do it for you.");
                quotes.add("Great things never come from comfort zones.");
                quotes.add("The way to get started is to quit talking and begin doing.");
                break;

            case "Inspirational":
                quotes.add("You can achieve anything.");
                quotes.add("Inspire others.");
                quotes.add("Believe in yourself.");
                quotes.add("The only way to do great work is to love what you do.");
                quotes.add("You are never too old to set another goal or to dream a new dream.");
                quotes.add("Act as if what you do makes a difference. It does.");
                quotes.add("Everything you’ve ever wanted is on the other side of fear.");
                quotes.add("Start where you are. Use what you have. Do what you can.");
                break;

            case "Love":
                quotes.add("Love conquers all.");
                quotes.add("Spread love.");
                quotes.add("To love and be loved is to feel the sun from both sides.");
                quotes.add("Love is not about how much you say 'I love you,' but how much you can prove that it’s true.");
                quotes.add("Love isn’t something you find. Love is something that finds you");
                quotes.add("Love is composed of a single soul inhabiting two bodies.");
                quotes.add("The best thing to hold onto in life is each other.");
                quotes.add("Love recognizes no barriers. It jumps hurdles, leaps fences, penetrates walls to arrive at its destination full of hope.");
                break;

            case "Success":
                quotes.add("Success is not the key to happiness. Happiness is the key to success.");
                quotes.add("Success usually comes to those who are too busy to be looking for it.");
                quotes.add("Don’t be afraid to give up the good to go for the great.");
                quotes.add("Success is walking from failure to failure with no loss of enthusiasm.");
                quotes.add("Success is not in what you have, but who you are.");
                quotes.add("The way to get started is to quit talking and begin doing.");
                quotes.add("Success doesn’t come to you, you go to it.");
                quotes.add("Hard work beats talent when talent doesn’t work hard.");
                break;

            case "Happiness":
                quotes.add("Happiness is not something ready-made. It comes from your own actions.");
                quotes.add("The purpose of our lives is to be happy.");
                quotes.add("Happiness depends upon ourselves.");
                quotes.add("Happiness is a direction, not a place.");
                quotes.add("For every minute you are angry, you lose sixty seconds of happiness.");
                quotes.add("Happiness is not a goal...it's a by-product of a life well lived.");
                quotes.add("Happiness is a warm puppy.");
                quotes.add("The most simple things can bring the most happiness.");
                break;

            case "Mindfulness":
                quotes.add("Mindfulness is a way of befriending ourselves and our experience.");
                quotes.add("Feelings come and go like clouds in a windy sky. Conscious breathing is my anchor.");
                quotes.add("Mindfulness isn’t difficult. We just need to remember to do it.");
                quotes.add("Do every act of your life as though it were the very last act of your life.");
                quotes.add("The present moment is the only time over which we have dominion.");
                quotes.add("Mindfulness means being awake. It means knowing what you are doing.");
                quotes.add("Walk as if you are kissing the earth with your feet.");
                quotes.add("Awareness is the greatest agent for change.");
                break;

            default:
                quotes.add("No quotes found for this category.");
                break;
        }
        Collections.shuffle(quotes);
    }


    // Update the displayed quote
    private void updateQuote() {
        if (!quotes.isEmpty()) {
            quoteText.setText(quotes.get(currentQuoteIndex));
        }
    }

    // Method to share the current quote
    private void shareQuote() {
        if (!quotes.isEmpty()) {
            String quoteToShare = quotes.get(currentQuoteIndex);
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, quoteToShare);
            startActivity(Intent.createChooser(shareIntent, "Share Quote via"));
        } else {
            Toast.makeText(this, "No quote to share!", Toast.LENGTH_SHORT).show();
        }
    }
}
