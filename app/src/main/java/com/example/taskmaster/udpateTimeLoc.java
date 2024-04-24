package com.example.taskmaster;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class udpateTimeLoc extends AppCompatActivity {
    EditText TimeEd,LocEd;
    Button update;
    DataBaseHelper DB;
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

        // Get the order ID from the intent
        DataBaseHelper dbHelper = new DataBaseHelper(this);
        SharedPreferences sharedPreferences= getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        //String targetEmail = sharedPreferences.getString("email","email@hotmail.com");

        TimeEd= findViewById(R.id.TimeUpd);
        LocEd= findViewById(R.id.LocUpd);
        update=findViewById(R.id.update);

        //add current data based on user setText
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    updateLocTime();
                }
        });

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void updateLocTime() {
        // Get the edited date and time from the TextViews
        String newLoc = LocEd.getText().toString();
        String newTime = TimeEd.getText().toString();

        // Check if both date and time are empty
        boolean isDateEmpty = newLoc.isEmpty();
        boolean isTimeEmpty = newTime.isEmpty();

        if (isDateEmpty || isTimeEmpty) {
            // Both date and time are empty, show an error message
            Toast.makeText(this, "Please enter a date or time", Toast.LENGTH_SHORT).show();
            return; // Exit the method without further processing
        }

        // Check if the date or time was edited
        boolean isDateEdited = !isDateEmpty;
        boolean isTimeEdited = !isTimeEmpty;

        // Update the order object if the corresponding field was edited
        if (isDateEdited) {
            //orderID.setDate(newLoc)
        }
        if (isTimeEdited) {
            //OrderID.setTime(newTime);
        }

        // Check if any field was edited
        if (isDateEdited || isTimeEdited) {
            // Update the record in the database using the DataBaseHelper
            //DB.updateCustomer(customerModel);

            // Show a toast message or perform any other actions
            Toast.makeText(this, "Date or time updated successfully", Toast.LENGTH_SHORT).show();
        } else {
            // No fields were edited, show a message or perform any other actions
            Toast.makeText(this, "No changes were made", Toast.LENGTH_SHORT).show();
        }
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