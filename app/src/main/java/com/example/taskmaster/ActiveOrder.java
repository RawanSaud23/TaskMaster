package com.example.taskmaster;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

public class ActiveOrder extends AppCompatActivity {

    Button btnCancle;
    AlertDialog.Builder builder;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_active_order);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //alt cancel
        btnCancle = findViewById(R.id.CancleOreder);
        builder = new AlertDialog.Builder(this);

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("CANCELLTION COFIRMATION!")
                        .setMessage("Are you sure you want to cancel your order?")
                        .setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                finish(); //next phase we will make it work as it should be :)
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                dialog.dismiss(); // Close the dialog
                            }
                        })
                        .show();
            }
        });

        //Alt time
        TextClock TxtTime = findViewById(R.id.textClock);
        builder = new AlertDialog.Builder(this);

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("UPDATE TIME COFIRMATION!")
                        .setMessage("Are you sure you want to update time of your order?")
                        .setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                finish(); //next phase we will make it work as it should be :)
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                dialog.dismiss(); // Close the dialog
                            }
                        })
                        .show();
            }
        });

        //alt loc
        TextView TxtLoc = findViewById(R.id.loc);
        builder = new AlertDialog.Builder(this);

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("UPDATE LOCATION COFIRMATION!")
                        .setMessage("Are you sure you want to update your location for the order?")
                        .setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                finish(); //next phase we will make it work as it should be :)
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                dialog.dismiss(); // Close the dialog
                            }
                        })
                        .show();
            }
        });
    }
}