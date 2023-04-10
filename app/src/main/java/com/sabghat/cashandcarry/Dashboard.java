package com.sabghat.cashandcarry;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sabghat.cashandcarry.Adapters.MainAdapter;
import com.sabghat.cashandcarry.Models.MainModel;
import com.sabghat.cashandcarry.databinding.ActivityDashboardBinding;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        ArrayList<MainModel> mainModelArrayList = new ArrayList<>();


        mainModelArrayList.add(new MainModel(R.drawable.burger,"Burger","5","I Like Pizza."));
        mainModelArrayList.add(new MainModel(R.drawable.burger_fries,"Burger + Fires","7","I Like" +
                " Pizza."));
        mainModelArrayList.add(new MainModel(R.drawable.chicken, "Chicken + Tomato Salad","20",
                "Chicken, tomato salad close up"));
        mainModelArrayList.add(new MainModel(R.drawable.spicy_korean_tteokbokki,"Spicy Korean " +
                "Tteokbokki","14",
                "Spicy Korean Tteokbokki Dish"));
        mainModelArrayList.add(new MainModel(R.drawable.french_fries,"French Fries","6.5","Taste " +
                "the fires and enjoy"));
        mainModelArrayList.add(new MainModel(R.drawable.salad,"Salad","3","Salad is always will " +
                "be your best"));
        mainModelArrayList.add(new MainModel(R.drawable.pasta,"Pasta","5","Pasta is awesome"));
        mainModelArrayList.add(new MainModel(R.drawable.muffins,"Muffins","8.7","Taste the " +
                "Muffins"));


        MainAdapter adapter = new MainAdapter(mainModelArrayList,this);
        binding.recyclerview.setAdapter(adapter);

        // Create a LinearLayoutManager to manage the layout of the RecyclerView.
LinearLayoutManager layoutManager = new LinearLayoutManager(this);

// Set the layout manager for the RecyclerView to the LinearLayoutManager we created.
binding.recyclerview.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(Dashboard.this, Order.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}