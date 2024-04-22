package com.example.taskmaster;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.List;

public class ActiveOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_order);

        // Get the order ID from the intent
        DataBaseHelper dbHelper = new DataBaseHelper(this);
        String targetEmail = "amustafa@hotmail.com";
        int i = 1;


        while (true) {
            ordermod order = dbHelper.getOrderById(i);
            if (order == null) {
                // No more orders available, exit the loop
                break;
            }

            if (order.getClientID().equals(targetEmail)) {
                displayOrderDetails(order);
            }
            i++;


        }

    }
    private void displayOrderDetails(ordermod order) {
        // Inflate the appropriate layout based on the order status
        View orderItemView;
        if (order.getOrderStatus().equals("Accepted")) {
            orderItemView = LayoutInflater.from(this).inflate(R.layout.activity_order_item, null);
        } else {
            orderItemView = LayoutInflater.from(this).inflate(R.layout.activity_order_item_rejected, null);
        }

        // Find views inside the order item layout
        TextView orderLocationTextView = orderItemView.findViewById(R.id.loc);
        TextView orderTimeTextView = orderItemView.findViewById(R.id.textClock);
        TextView orderWorkerNameTextView = orderItemView.findViewById(R.id.WorkerInfo);
        TextView orderStatusTextView = orderItemView.findViewById(R.id.orderStatus);
        TextView serviceNameTextView = orderItemView.findViewById(R.id.orderName);
        TextView servicePriceTextView = orderItemView.findViewById(R.id.amount);

        // Set order details to the views
        orderLocationTextView.setText(order.getLocation());
        orderTimeTextView.setText(order.getTime());
        orderWorkerNameTextView.setText(order.getWorkerName() + " " + order.getWorkerPhone());
        orderStatusTextView.setText(order.getOrderStatus());

        // Retrieve and set service details
        DataBaseHelper dbHelper = new DataBaseHelper(this);
        servicemod service = dbHelper.getserviceById(order.getServiceID());
        if (service != null) {
            serviceNameTextView.setText(service.getSubcategory());
            servicePriceTextView.setText(String.valueOf(service.getPrice()));


        } else {
            // Handle case where service details for the order are not available
        }

        // Set margins for the order item view
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(10, 10, 10, 10);
        orderItemView.setLayoutParams(params);

        // Add the order item view to the appropriate container in your layout
        LinearLayout ordersContainer = findViewById(R.id.ordersContainer);
        ordersContainer.addView(orderItemView);
    }


}
