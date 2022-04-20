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

        mainModelArrayList.add(new MainModel(R.drawable.small_pizza,"Small Pizza","3","I Like " +
                "Small Pizza."));
        mainModelArrayList.add(new MainModel(R.drawable.burger,"Burger","5","I Like Pizza."));
        mainModelArrayList.add(new MainModel(R.drawable.burger_fries,"Burger + Fires","7","I Like" +
                " Pizza."));
        mainModelArrayList.add(new MainModel(R.drawable.large_pizza,"Large Pizza","10","I Like " +
                "Pizza."));
        mainModelArrayList.add(new MainModel(R.drawable.mix_rice,"Mix Rice","19","I Like Pizza."));
        mainModelArrayList.add(new MainModel(R.drawable.rice,"Rice","9","I Like Pizza."));
        mainModelArrayList.add(new MainModel(R.drawable.white_rice,"Pizza","3","I Like Pizza."));

        MainAdapter adapter = new MainAdapter(mainModelArrayList,this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
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