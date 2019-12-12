package com.kharredo.muqit.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.kharredo.muqit.Model.ModelTest;
import com.kharredo.muqit.R;

import java.util.List;
import java.util.zip.Inflater;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.viewholder>  {

    List<ModelTest> data;
    Context context;
    OnClickListner listner;

    public RecyclerAdapter(List<ModelTest> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.grid_item,null,false);
        viewholder viewholder=new viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, final int position) {

        final ModelTest modelTest=data.get(position);
        holder.imageView.setImageResource(modelTest.getImage());
        holder.name.setText(modelTest.getProduct_name());
        holder.price.setText(modelTest.getProduct_price());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listner.onClick(position,modelTest);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView imageView;
        TextView name,price;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.card);
            imageView = itemView.findViewById(R.id.imageView2);
            name = itemView.findViewById(R.id.textView2);
            price = itemView.findViewById(R.id.textView3);

        }
    }

    public interface OnClickListner{

        public void onClick(int position, ModelTest modelTest);
        //ModelShowTutor modelShowTutor it is model
    }


    public void setOnClickListener(OnClickListner listner){
        this.listner = listner;
    }
}
