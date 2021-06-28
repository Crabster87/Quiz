package crabster.rudakov.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button yesBtn;
    private Button noBtn;
    private Button showAnswer;
    private TextView questionTextView;
    private Question[] questions = {
            new Question(R.string.question1, true),
            new Question(R.string.question2, true),
            new Question(R.string.question3, false),
            new Question(R.string.question4, false),
            new Question(R.string.question5, true),
            new Question(R.string.question6, false),
            new Question(R.string.question7, true),
            new Question(R.string.question8, false),
            new Question(R.string.question9, true),
            new Question(R.string.question10, false)
    };
    private int questionIndex = 0;
    private StringBuilder results = new StringBuilder();
    private int rating = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SYSTEM INFO", "Method onCreate() is working");
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            questionIndex = savedInstanceState.getInt("question");
        }

        questionTextView = findViewById(R.id.questionTextView);
        questionTextView.setText(questions[questionIndex].getQuestion());

        yesBtn = findViewById(R.id.yesBtn);
        noBtn = findViewById(R.id.noBtn);
        showAnswer = findViewById(R.id.showAnswer);

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                results.append("The question was: " + getString(questions[questionIndex].getQuestion()) + "\""
                                        + "\n" + "Your answer was: " + "YES\"\n");

                if (questions[questionIndex].isAnswer()) {
                    rating += 10;
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                }
                if (questionIndex >= questions.length - 1) {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("results", results.toString());
                    intent.putExtra("rating", rating);
                    startActivity(intent);
                    rating = 0;
                    results = new StringBuilder();
                }
                questionIndex = (questionIndex + 1) % questions.length;
                questionTextView.setText(questions[questionIndex].getQuestion());
            }
        });

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                results.append("The question was: " + getString(questions[questionIndex].getQuestion()) + "\""
                        + "\n" + "Your answer was: " + "NO\"\n");
                if (!questions[questionIndex].isAnswer()) {
                    rating += 10;
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                }
                if (questionIndex >= questions.length - 1) {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("results", results.toString());
                    intent.putExtra("rating", rating);
                    startActivity(intent);
                    rating = 0;
                    results = new StringBuilder();
                }
                questionIndex = (questionIndex + 1) % questions.length;
                questionTextView.setText(questions[questionIndex].getQuestion());
            }
        });

        showAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
                intent.putExtra("answer", questions[questionIndex].isAnswer());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("SYSTEM INFO", "Method onStart() is working");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("SYSTEM INFO", "Method onResume() is working");
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.d("SYSTEM INFO", "Method onSaveInstanceState() is working"); //после переворота экрана сохраняет инфо(индекс)
        savedInstanceState.putInt("question", questionIndex);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("SYSTEM INFO", "Method onPause() is working");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("SYSTEM INFO", "Method onStop() is working");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SYSTEM INFO", "Method onDestroy() is working");
    }

}