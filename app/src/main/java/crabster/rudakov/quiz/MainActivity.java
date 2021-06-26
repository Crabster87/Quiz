package crabster.rudakov.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button yesBtn;
    private Button noBtn;
    private TextView questionTextView;
    private Question[] questions = {
            new Question(R.string.question, true),
            new Question(R.string.question1, true),
            new Question(R.string.question2, false),
            new Question(R.string.question3, false),
            new Question(R.string.question4, true)
    };
    private int questionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SYSTEM INFO", "Method onCreate() is working");
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            questionIndex = savedInstanceState.getInt("question", 0);
        }

        questionTextView = findViewById(R.id.questionTextView);
        questionTextView.setText(questions[questionIndex].getQuestion());

        yesBtn = findViewById(R.id.yesbtn);
        noBtn = findViewById(R.id.nobtn);

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questions[questionIndex].isAnswer()) {
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                }
                questionIndex = (questionIndex + 1) % questions.length;
                questionTextView.setText(questions[questionIndex].getQuestion());
            }
        });

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!questions[questionIndex].isAnswer()) {
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                }
                questionIndex = (questionIndex + 1) % questions.length;
                questionTextView.setText(questions[questionIndex].getQuestion());
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