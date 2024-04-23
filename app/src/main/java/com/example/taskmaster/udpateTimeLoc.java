package com.example.taskmaster;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class udpateTimeLoc extends AppCompatActivity {
    private EditText TimeEd,LocEd;
    private Button update;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_udpate_time_loc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //get DB

        TimeEd= findViewById(R.id.TimeUpd);
        LocEd= findViewById(R.id.LocUpd);
        update=findViewById(R.id.update);

        //add current data based on user setText
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //user update info

            }
        });

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Handle navigation arrow click here
            // For example, start the PlumbingSub activity
            Intent intent = new Intent(this, ActiveOrder.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}