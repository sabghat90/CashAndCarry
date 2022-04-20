package com.sabghat.cashandcarry;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sabghat.cashandcarry.Helper.DBHelper;
import com.sabghat.cashandcarry.databinding.ActivityOrderDetailBinding;

public class OrderDetail extends AppCompatActivity {

    ActivityOrderDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final int image = getIntent().getIntExtra("image",0);
        final int price = Integer.parseInt(getIntent().getStringExtra("price"));
        final String name = getIntent().getStringExtra("name");
        final String description = getIntent().getStringExtra("description");

        binding.detailItemImage.setImageResource(image);
        binding.detailItemPrice.setText(String.format("%d", price));
        binding.detailItemName.setText(name);
        binding.detailItemDescription.setText(description);

        final DBHelper dbHelper = new DBHelper(this);

        binding.orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isInserted = dbHelper.insertOrder(
                        binding.detailYourName.getText().toString(),
                        binding.detailPhoneNumber.getText().toString(),
                        price,
                        image,
                        name,
                        description,
                        Integer.parseInt(binding.quantity.getText().toString())
                );

                if (isInserted) {
                    Toast.makeText(OrderDetail.this, "Order Added", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(OrderDetail.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}