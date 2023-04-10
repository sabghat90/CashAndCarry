package com.sabghat.cashandcarry.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sabghat.cashandcarry.Helper.DBHelper;
import com.sabghat.cashandcarry.Models.OrdersModel;
import com.sabghat.cashandcarry.OrderDetail;
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

        holder.itemView.setOnClickListener(view -> {
            Intent lunchDetailsActivity = new Intent(ctx, OrderDetail.class);
            lunchDetailsActivity.putExtra("id",Integer.parseInt(model.getOrderNumber()));
            lunchDetailsActivity.putExtra("type",2);
            ctx.startActivity(lunchDetailsActivity);
        });

        holder.itemView.setOnLongClickListener(view -> {
            // Create an alert dialog that asks the user to confirm the deletion of the order
            new AlertDialog.Builder(ctx)
                    .setTitle("Delete Order")
                    .setMessage("Are you sure to delete this order?")
                    .setPositiveButton("Yes", (dialogInterface, i) -> {
                        // Create a database helper
                        DBHelper dbHelper = new DBHelper(ctx);
                        // Delete the order from the database
                        if (dbHelper.deleteOrder(model.getOrderNumber()) > 0) {
                            Toast.makeText(ctx, "Deleted", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ctx, "Error", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("No", (dialogInterface, i) -> dialogInterface.cancel()).show();
            return false;
        });
    }

    // create a function to notify the adapter that the data has changed
    public void notifyDataChanged(ArrayList<OrdersModel> ordersModelArrayList) {
        this.ordersModelArrayList = ordersModelArrayList;
        notifyDataSetChanged();
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