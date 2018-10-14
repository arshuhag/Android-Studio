package com.example.shuhag.teaminfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void anisur(View view) {
        /*Intent intent = new Intent(MainActivity.this, Anisur.class);
        startActivity(intent);*/
        startActivity(new Intent(MainActivity.this, Anisur.class));
    }

    public void momo(View view) {
        startActivity(new Intent(MainActivity.this, Momo.class));
    }

    public void joty(View view) {
        startActivity(new Intent(MainActivity.this, Joty.class));
    }

    public void tasnim(View view) {
        startActivity(new Intent(MainActivity.this, Tasnim.class));
    }
}
