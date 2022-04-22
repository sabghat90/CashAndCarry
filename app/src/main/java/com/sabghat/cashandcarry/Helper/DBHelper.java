package com.sabghat.cashandcarry.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.sabghat.cashandcarry.Models.OrdersModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    final static String DBNAME = "cashandcarry.db";
    final static int DBVERSION = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table orders" +
                        "(id integer primary key autoincrement," +
                        "name text," +
                        "phone text," +
                        "price int," +
                        "image int," +
                        "quantity int," +
                        "description text," +
                        "itemname text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists orders");
        onCreate(sqLiteDatabase);
    }

    public boolean insertOrder(String name, String phone, int price, int image, String desc,
                               String orderItemName, int quantity){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();

        /*
        id = 0
        name = 1
        phone = 2
        price = 3
        image = 4
        desc = 5
        itemname = 6
        quantity = 7
         */

        values.put("name", name);
        values.put("phone", phone);
        values.put("price", price);
        values.put("image", image);
        values.put("description", desc);
        values.put("itemname", orderItemName);
        values.put("quantity",quantity);

        long id = database.insert("orders",null,values);
        if (id <= 0) {
            return false;
        } else {
            return true;
        }

    }

    public ArrayList<OrdersModel> getOrders() {
        ArrayList<OrdersModel> ordersModels = new ArrayList<>();

        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("select * from orders",null);

        if (cursor.moveToFirst()){
            while (cursor.moveToNext()){
                OrdersModel model = new OrdersModel();
                model.setOrderNumber(cursor.getInt(0)+ "");
                model.setSoldItemName(cursor.getString(6));
                model.setOrderImage(cursor.getInt(4));
                model.setPrice(cursor.getInt(3)+"");
                ordersModels.add(model);
            }
        }

        cursor.close();
        database.close();
        return ordersModels;
    }

    public Cursor getOrderById(int id) {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("select * from orders where id = " + id,null);

        if (cursor != null)
            cursor.moveToFirst();
//        cursor.close();
//        database.close();
        return cursor;
    }

    public boolean updateOrder(String name, String phone, int price, int image, String desc,
                               String orderItemName, int quantity, int id){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();

        /*
        id = 0
        name = 1
        phone = 2
        price = 3
        image = 4
        desc = 5
        itemname = 6
        quantity = 7
         */

        values.put("name", name);
        values.put("phone", phone);
        values.put("price", price);
        values.put("image", image);
        values.put("description", desc);
        values.put("itemname", orderItemName);
        values.put("quantity",quantity);

        long row = database.update("orders",values,"id = " + id, null);
        if (row <= 0) {
            return false;
        } else {
            return true;
        }

    }

    public int deleteOrder(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("orders","id = " + id, null);
    }
}
