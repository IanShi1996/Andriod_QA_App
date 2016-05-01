package com.tianxingli24gmail.android_self_qa_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AnswerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void answer(View view) {
        EditText editText = (EditText) findViewById(R.id.edit_answer);
        String response = editText.getText().toString();

        //compare with the actual to the question
        //in the future correct response data WILL NOT be passed in through the intent
        Intent fromPrev = getIntent();
        String correctAnswer = fromPrev.getStringArrayExtra(SetQuestionActivity.EXTRA_MESSAGE)[1];

        Button button = (Button) findViewById(R.id.button_answer);

        if (response.equals(correctAnswer))
        {
            button.setText("CORRECT");
        }
        else
        {
            button.setText("INCORRECT");
        }
    }

}
