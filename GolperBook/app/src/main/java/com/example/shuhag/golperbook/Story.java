package com.example.shuhag.golperbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Story extends AppCompatActivity {

    TextView viewTitle, viewStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        //setTitle("শেখ সাদির গল্প");

        String[] title = getResources().getStringArray(R.array.story_title);
        String[] story = getResources().getStringArray(R.array.story);

        viewTitle = findViewById(R.id.tvTitle);
        viewStory = findViewById(R.id.tvStory);

        int pos = getIntent().getIntExtra("position",0);

        setTitle(title[pos]);

        viewTitle.setText(title[pos]);
        viewStory.setText(story[pos]);

    }

    public void image(View view) {
        startActivity(new Intent(this, GolperList.class));
    }
}
