package com.sabghat.cashandcarry.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sabghat.cashandcarry.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    ArrayList<MainAdapter> mainAdapterArrayList;
    Context ctx;

    public MainAdapter(ArrayList<MainAdapter> mainAdapterArrayList, Context ctx) {
        this.mainAdapterArrayList = mainAdapterArrayList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView item_image;
        TextView item_name, item_price, item_description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            item_image = itemView.findViewById(R.id.item_image_v);
            item_name = itemView.findViewById(R.id.item_name_tv);
            item_price = itemView.findViewById(R.id.item_price_tv);
            item_description = itemView.findViewById(R.id.item_description_tv);
        }
    }
}
