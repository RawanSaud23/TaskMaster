package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class categorieshomepage extends AppCompatActivity {
    RelativeLayout p ;
    RelativeLayout c ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorieshomepage);
        p=findViewById(R.id.plumb);
        p.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), PlumbingSub.class);
            startActivity(intent);
        } });

        c=findViewById(R.id.clean);
        c.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), CleaningSub.class);
            startActivity(intent);
        } });
    }
}