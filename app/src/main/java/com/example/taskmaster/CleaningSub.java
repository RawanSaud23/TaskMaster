package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class CleaningSub extends AppCompatActivity {
    RelativeLayout d ;
    RelativeLayout s;
    RelativeLayout c ;
    RelativeLayout r ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaning_sub);

        d=findViewById(R.id.deep);
        d.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), subcategoreydetails.class);
            startActivity(intent);
        } });



        s=findViewById(R.id.shoe);
        s.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), subcategoreydetailsshoewash.class);
            startActivity(intent);
        } });

        c=findViewById(R.id.cloth);
        c.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), subcategorydetailsclotheswashing.class);
            startActivity(intent);
        } });

        r=findViewById(R.id.carpet);
        r.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), subcategorydetailscarpetwash.class);
            startActivity(intent);
        } });


    }
}