package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class PlumbingSub extends AppCompatActivity {
RelativeLayout w ;
RelativeLayout r;
RelativeLayout f ;
RelativeLayout d ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumbing_sub);

        w=findViewById(R.id.washbasins);
        w.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), subcategorydetailswashbasins.class);
            startActivity(intent);
        } });

        r=findViewById(R.id.roof);
        r.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), subcategorydetailsroofinsulation.class);
            startActivity(intent);
        } });



        f=findViewById(R.id.water);
        f.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), subcategorydetailswaterfilter.class);
            startActivity(intent);
        } });

        d=findViewById(R.id.dynamo);
        d.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), subcategorydetailsdynamo.class);
            startActivity(intent);
        } });



    }
}