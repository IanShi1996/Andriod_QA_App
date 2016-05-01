package com.tianxingli24gmail.android_self_qa_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SetAnswerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_answer);
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //get data from the intent, pair it up with new input and save/display these
    public void setAnswer(View view) {
        Intent fromPrev = getIntent();
        EditText editText = (EditText) findViewById(R.id.edit_set_answer);
        String[] QA = new String[2];
        QA[0] = fromPrev.getStringExtra(SetQuestionActivity.EXTRA_MESSAGE);
        QA[1] = editText.getText().toString();

        Intent forNext = new Intent(this, AnswerActivity.class);
        forNext.putExtra(SetQuestionActivity.EXTRA_MESSAGE, QA);
        startActivity(forNext);
        /*
        //display the result for testing
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(result);

        //add this TextView object to the relativeLayout
        LinearLayout layout = (LinearLayout) findViewById(R.id.content);
        layout.addView(textView);*/
    }
}
