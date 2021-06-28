package crabster.rudakov.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {

    TextView textViewResult;
    TextView textViewMark;
    private String results;
    private int rating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewResult = findViewById(R.id.textViewResult);
        results = getIntent().getStringExtra("results".toString());
        textViewResult.setText(results);

        textViewMark = findViewById(R.id.textViewMark);
        rating = getIntent().getIntExtra("rating", 0);
        textViewMark.setText(rating + "%");
    }
}