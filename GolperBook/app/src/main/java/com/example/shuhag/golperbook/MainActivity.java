package com.example.shuhag.golperbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(100);
        progressBar.setProgress(0);

        final Thread thread = new Thread(){
            @Override
            public void run() {
                try{
                    for(int i =0; i<100; i++){
                        progressBar.setProgress(i);
                        sleep(50);
                    }
                } catch (Exception e){
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(getApplicationContext(),GolperList.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();
    }
}
