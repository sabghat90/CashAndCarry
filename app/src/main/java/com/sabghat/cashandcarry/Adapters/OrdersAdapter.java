package com.sabghat.cashandcarry.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sabghat.cashandcarry.Models.OrdersModel;
import com.sabghat.cashandcarry.R;

import java.util.ArrayList;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.viewHolder> {

    ArrayList<OrdersModel> ordersModelArrayList;
    Context ctx;

    public OrdersAdapter(ArrayList<OrdersModel> ordersModelArrayList, Context ctx) {
        this.ordersModelArrayList = ordersModelArrayList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.order_sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final OrdersModel model = ordersModelArrayList.get(position);
        holder.orderItemImage.setImageResource(model.getOrderImage());
        holder.orderItemName.setText(model.getSoldItemName());
        holder.orderNumber.setText(model.getOrderNumber());
        holder.orderPrice.setText(model.getPrice());

    }

    @Override
    public int getItemCount() {
        return ordersModelArrayList.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        ImageView orderItemImage;
        TextView orderItemName, orderNumber, orderPrice;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            orderItemImage = itemView.findViewById(R.id.order_item_image);
            orderItemName = itemView.findViewById(R.id.order_item_name);
            orderNumber = itemView.findViewById(R.id.order_number);
            orderPrice = itemView.findViewById(R.id.order_price);
        }
    }
}
