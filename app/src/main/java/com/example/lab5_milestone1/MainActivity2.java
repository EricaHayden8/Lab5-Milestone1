package com.example.lab5_milestone1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;
import android.view.MenuItem;

public class MainActivity2 extends AppCompatActivity {

    TextView textView2;

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.logout){
            Intent intent = new Intent(this, MainActivity.class);
            SharedPreferences sharedPreferences = getSharedPreferences("com.example.Lab5-Milestone1", Context.MODE_PRIVATE);
            sharedPreferences.edit().remove(MainActivity.usernameKey).apply();
            startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.addNote){
            return true;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView2 = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message");
        textView2.setText("Welcome " + str + "!");
    }
}