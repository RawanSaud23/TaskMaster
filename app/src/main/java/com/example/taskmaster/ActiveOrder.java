package com.example.taskmaster;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
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

        // Retrieve the order details based on the order ID
       ordermod order= dbHelper.getOrderById(111);
        //ordermod order = new ordermod(111, 123, 1119, "P.O.Box: 55570", 50, "2:00", "Khalid Batais", "Accepted", "051234567");
       // ordermod order1 = new ordermod(112, 123, 1119, "P.O.Box: 55570", 50, "2:00", "Khalid Batais", "Rejected", "051234567");
        //ordermod order3 = new ordermod(113, 123, 1119, "P.O.Box: 55570", 50, "2:00", "Khalid Batais", "Accepted", "051234567");

        if (order != null) {
           // int serviceId = order.getServiceID();
           // servicemod service = dbHelper.getserviceById(serviceId);

            // Proceed with displaying the order details
            displayOrderDetails(order);
           // displayOrderDetails(order1);
           // displayOrderDetails(order3);


        } else {
            // Handle case where order with given ID does not exist
        }
    }
    private void displayOrderDetails(ordermod order) {

        //TextView serviceNameTextView = findViewById(R.id.orderName);
        //TextView servicePriceTextView = findViewById(R.id.amount);
        // Add more TextViews for other service details as needed


        // Update views with service details
        //  serviceNameTextView.setText(service.getSubcategory());
        //  servicePriceTextView.setText(String.valueOf(service.getPrice()));
        // Update more TextViews with other service details as needed
        View orderItemView;


        LinearLayout ordersContainer = findViewById(R.id.ordersContainer);

        // Inflate the order item layout for this order
        if(order.getOrderStatus().equals("Accepted")) {
            orderItemView = LayoutInflater.from(this).inflate(R.layout.activity_order_item, ordersContainer, false);
        }
        else{
           orderItemView = LayoutInflater.from(this).inflate(R.layout.activity_order_item_rejected, ordersContainer, false);
        }
        // Find views inside the order item layout
        TextView orderLocationTextView = orderItemView.findViewById(R.id.loc);
        TextView orderTimeTextView = orderItemView.findViewById(R.id.textClock);
        TextView orderWorkerNameTextView = orderItemView.findViewById(R.id.WorkerInfo);
        TextView orderStatusTextView = orderItemView.findViewById(R.id.orderStatus);

        // Set order details to the views
        orderLocationTextView.setText(order.getLocation());
        orderTimeTextView.setText(order.getTime());
        orderWorkerNameTextView.setText(order.getWorkerName()+" "+order.getWorkerPhone());
        orderStatusTextView.setText(order.getOrderStatus());

        // Add the order item view to the ordersContainer
        ordersContainer.addView(orderItemView);
    }

}
