package com.example.shuhag.golperbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GolperList extends AppCompatActivity {

    ListView movieTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_golper_list);

        //setTitle("শেখ সাদির গল্প");

        movieTitle = findViewById(R.id.lvMT);

        String movieTitleName[] = getResources().getStringArray(R.array.story_title);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, movieTitleName);
        movieTitle.setAdapter(adapter);


        movieTitle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GolperList.this, Story.class);
                intent.putExtra("position", position);
                startActivity(intent);

            }
        });

    }
}
