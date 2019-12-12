package com.kharredo.muqit.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.kharredo.muqit.R;
import com.kharredo.muqit.ui.home.HomeFragment;

public class GridAdapter extends BaseAdapter {

    Context context;
    int Product_Images[];
    String Product_Name[];
    String Product_Price[];
    LayoutInflater inflater;



    public GridAdapter(Context context, int[] product_Images, String[] product_Name, String[] product_Price) {
        this.context = context;
        this.Product_Images = product_Images;
        this.Product_Name = product_Name;
        this.Product_Price = product_Price;
    }

    @Override
    public int getCount() {
        return Product_Name.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.grid_item, null);
        final ImageView imageView = view.findViewById(R.id.imageView2);
        final TextView name = view.findViewById(R.id.textView2);
        final TextView price = view.findViewById(R.id.textView3);
        imageView.setBackgroundColor(Color.argb(100, 206, 206, 206));
        name.setBackgroundColor(Color.argb(100, 206, 206, 206));
        price.setBackgroundColor(Color.argb(100, 206, 206, 206));


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                imageView.setBackgroundColor(Color.WHITE);
                name.setBackgroundColor(Color.WHITE);
                price.setBackgroundColor(Color.WHITE);

                ViewGroup.LayoutParams layoutParams = name.getLayoutParams();
                layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
                name.setLayoutParams(layoutParams);

                ViewGroup.LayoutParams layoutParams1 = price.getLayoutParams();
                layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
                price.setLayoutParams(layoutParams1);

                imageView.setImageResource(Product_Images[i]);
                name.setText(Product_Name[i]);
                price.setText(Product_Price[i]);
            }
        },1500);



        return view;
    }

}
