package com.example.taskmaster;

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
        int orderId = getIntent().getIntExtra("ORDER_ID", -1);

        // Create an instance of your DataBaseHelper class
       DataBaseHelper dbHelper = new DataBaseHelper(this);

        // Retrieve the order details based on the order ID ! we should change number 1
       ordermod order= dbHelper.getOrderById(4);
       ordermod order1= dbHelper.getOrderById(5);

        if (order != null) {
            // Proceed with displaying the order details
            displayOrderDetails(order);
            displayOrderDetails(order1);

        } else {
            // Handle case where order with given ID does not exist
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

        // Add the order item view to the appropriate container in your layout
        LinearLayout ordersContainer = findViewById(R.id.ordersContainer);
        ordersContainer.addView(orderItemView);
    }


}
