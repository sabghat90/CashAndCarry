package com.sabghat.cashandcarry;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sabghat.cashandcarry.Adapters.OrdersAdapter;
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

        ArrayList<OrdersModel> ordersModelArrayList = new ArrayList<>();

        ordersModelArrayList.add(new OrdersModel(R.drawable.small_pizza,"Small Pizza","3","24243"));
        ordersModelArrayList.add(new OrdersModel(R.drawable.burger,"Burger","5","1231"));
        ordersModelArrayList.add(new OrdersModel(R.drawable.burger_fries,"Burger + Fires","7",
                "345345"));
        ordersModelArrayList.add(new OrdersModel(R.drawable.large_pizza,"Large Pizza","10",
                "2342432"));
        ordersModelArrayList.add(new OrdersModel(R.drawable.mix_rice,"Mix Rice","19","4534353"));
        ordersModelArrayList.add(new OrdersModel(R.drawable.rice,"Rice","9","5474745"));
        ordersModelArrayList.add(new OrdersModel(R.drawable.white_rice,"Pizza","3","45345"));

        OrdersAdapter adapter = new OrdersAdapter(ordersModelArrayList,this);
        binding.orderRecyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderRecyclerview.setLayoutManager(layoutManager);
    }
}