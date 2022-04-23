package com.sabghat.cashandcarry;

import android.database.Cursor;
import android.os.Bundle;
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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final DBHelper dbHelper = new DBHelper(this);

        if (getIntent().getIntExtra("type",0) == 1) {
            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("description");

            binding.detailItemImage.setImageResource(image);
            binding.detailItemPrice.setText(String.format("%d", price));
            binding.detailItemName.setText(name);
            binding.detailItemDescription.setText(description);

            binding.orderButton.setOnClickListener(view -> {

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
            });
        } else {
            int id = getIntent().getIntExtra("id", 0);
            Cursor cursor = dbHelper.getOrderById(id);

            int image = cursor.getInt(4);

            binding.detailItemImage.setImageResource(image);
            binding.detailItemPrice.setText(String.format("%d", cursor.getInt(3)));
            binding.detailItemName.setText(cursor.getString(6));
            binding.detailItemDescription.setText(cursor.getString(5));

            binding.detailYourName.setText(cursor.getString(1));
            binding.detailPhoneNumber.setText(cursor.getString(2));

            binding.orderButton.setText("Update Now");
            binding.orderButton.setOnClickListener(view -> {
                boolean isUpdated = dbHelper.updateOrder(
                        binding.detailYourName.getText().toString(),
                        binding.detailPhoneNumber.getText().toString(),
                        Integer.parseInt(binding.detailItemPrice.getText().toString()),
                        image,
                        binding.detailItemDescription.getText().toString(),
                        binding.detailItemName.getText().toString(),
                        1,
                        id
                );

                if (isUpdated) {
                    Toast.makeText(OrderDetail.this, "Updated", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(OrderDetail.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}