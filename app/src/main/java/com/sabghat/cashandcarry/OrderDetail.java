package com.sabghat.cashandcarry;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sabghat.cashandcarry.databinding.ActivityOrderDetailBinding;

public class OrderDetail extends AppCompatActivity {

    ActivityOrderDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}