package com.sabghat.cashandcarry.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sabghat.cashandcarry.Models.MainModel;
import com.sabghat.cashandcarry.OrderDetail;
import com.sabghat.cashandcarry.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    ArrayList<MainModel> mainModelArrayList;
    Context ctx;

    public MainAdapter(ArrayList<MainModel> mainModelArrayList, Context ctx) {
        this.mainModelArrayList = mainModelArrayList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_view_sample,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MainModel model = mainModelArrayList.get(position);

        holder.item_image.setImageResource(model.getItemImage());
        holder.item_name.setText(model.getItemName());
        holder.item_price.setText(model.getItemPrice());
        holder.item_description.setText(model.getItemDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lunchDetailActivity = new Intent(ctx, OrderDetail.class);
                lunchDetailActivity.putExtra("image",model.getItemImage());
                lunchDetailActivity.putExtra("price",model.getItemPrice());
                lunchDetailActivity.putExtra("description",model.getItemDescription());
                lunchDetailActivity.putExtra("name",model.getItemName());
                lunchDetailActivity.putExtra("type",1);

                ctx.startActivity(lunchDetailActivity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mainModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
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
