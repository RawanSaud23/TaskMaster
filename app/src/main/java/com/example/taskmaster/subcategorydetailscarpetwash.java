package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;


public class subcategorydetailscarpetwash extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategorydetailscarpetwash);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Handle navigation arrow click here
            // For example, start the PlumbingSub activity
            Intent intent = new Intent(this, CleaningSub.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}