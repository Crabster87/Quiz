package crabster.rudakov.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button showAnswer;
    private TextView questionTextView;
    private ImageView imageView;
    private Question[] questions = {
            new Question(R.string.question1, true, R.drawable.sweden),
            new Question(R.string.question2, true, R.drawable.russia),
            new Question(R.string.question3, false, R.drawable.brazil),
            new Question(R.string.question4, false, R.drawable.australia),
            new Question(R.string.question5, true, R.drawable.peru),
            new Question(R.string.question6, false, R.drawable.switzerland),
            new Question(R.string.question7, true, R.drawable.israel),
            new Question(R.string.question8, false, R.drawable.myanmar),
            new Question(R.string.question9, true, R.drawable.egypt),
            new Question(R.string.question10, false, R.drawable.turkey),
            new Question(R.string.question11, false, R.drawable.usa),
            new Question(R.string.question12, false, R.drawable.venezuela),
            new Question(R.string.question13, true, R.drawable.papua_new_guinea),
            new Question(R.string.question14, false, R.drawable.south_africa),
            new Question(R.string.question15, true, R.drawable.mexico),
            new Question(R.string.question16, true, R.drawable.thailand),
            new Question(R.string.question17, true, R.drawable.uganda),
            new Question(R.string.question18, false, R.drawable.belgium),
            new Question(R.string.question19, true, R.drawable.greece),
            new Question(R.string.question20, false, R.drawable.kazakhstan)
    };
    private int questionIndex = 0;
    private StringBuilder results = new StringBuilder();
    private int rating = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            questionIndex = savedInstanceState.getInt("question");
        }

        questionTextView = findViewById(R.id.questionTextView);
        questionTextView.setText(questions[questionIndex].getQuestion());

        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(questions[questionIndex].getImage());

        showAnswer = findViewById(R.id.showAnswer);
        showAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
                intent.putExtra("answer", questions[questionIndex].isAnswer());
                startActivity(intent);
            }
        });
        Log.d("SYSTEM INFO", "Method onCreate() is working");
    }

    /**
     * This method checks answers of user, displays results,
     * creates final results and also counts total mark.
     */
    public void checkAnswer(View v) {
        results.append("The question was: ")
                .append(getString(questions[questionIndex].getQuestion()))
                .append("\"\n")
                .append("Your answer was: ");
        switch (v.getId()) {
            case R.id.yesBtn:
                results.append("YES\"\n\n");
                if (questions[questionIndex].isAnswer()) {
                    rating += 5;
                    displayToast(getString(R.string.correct));
                } else {
                    displayToast(getString(R.string.incorrect));
                }
                break;
            case R.id.noBtn:
                results.append("NO\"\n\n");
                if (!questions[questionIndex].isAnswer()) {
                    rating += 5;
                    displayToast(getString(R.string.correct));
                } else {
                    displayToast(getString(R.string.incorrect));
                }
                break;
        }
        if (questionIndex == questions.length - 1) {
            initResultActivity();
        } else {
            questionIndex = (questionIndex + 1) % questions.length;
            questionTextView.setText(questions[questionIndex].getQuestion());
            imageView.setImageResource(questions[questionIndex].getImage());
        }
        Log.d("SYSTEM INFO", "Method checkAnswer() is working");
    }

    /**
     * This method displays toast message on the screen.
     *
     * @param message visible hint for user
     */
    public void displayToast(String message) {
        Toast toast = Toast.makeText(getApplicationContext(),
                message,
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        Log.d("SYSTEM INFO", "Method displayToast() is working");
    }

    /**
     * This method creates new ResultActivity, where displays
     * all the answers and total mark.
     */
    protected void initResultActivity() {
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("results", results.toString());
        intent.putExtra("rating", rating);
        startActivity(intent);
        rating = 0;
        results = new StringBuilder();
        Log.d("SYSTEM INFO", "Method initResultActivity() is working");
    }

    /**
     * Dispatch onStart() to all fragments.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("SYSTEM INFO", "Method onStart() is working");
    }

    /**
     * Dispatch onResume() to all fragments.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("SYSTEM INFO", "Method onResume() is working");
    }

    /**
     * This method saves changeable data in time of changing Activity.
     */
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.d("SYSTEM INFO", "Method onSaveInstanceState() is working");
        savedInstanceState.putInt("question", questionIndex);
        Log.d("SYSTEM INFO", "Method onSaveInstanceState() is working");
    }

    /**
     * Dispatch onPause() to all fragments.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("SYSTEM INFO", "Method onPause() is working");
    }

    /**
     * Dispatch onStop() to all fragments.
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("SYSTEM INFO", "Method onStop() is working");
    }

    /**
     * Dispatch onDestroy() to all fragments.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SYSTEM INFO", "Method onDestroy() is working");
    }

}