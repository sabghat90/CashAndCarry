package com.sabghat.cashandcarry;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sabghat.cashandcarry.Adapters.OrdersAdapter;
import com.sabghat.cashandcarry.Helper.DBHelper;
import com.sabghat.cashandcarry.Models.OrdersModel;
import com.sabghat.cashandcarry.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class Order extends AppCompatActivity {

    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper dbHelper = new DBHelper(this);
        ArrayList<OrdersModel> ordersModelArrayList = dbHelper.getOrders();

        OrdersAdapter adapter = new OrdersAdapter(ordersModelArrayList,this);
        binding.orderRecyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderRecyclerview.setLayoutManager(layoutManager);
    }
}