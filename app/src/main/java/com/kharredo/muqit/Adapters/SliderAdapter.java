package com.kharredo.muqit.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kharredo.muqit.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterVH> {
    private Context context;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {


        switch (position) {
            case 0:
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.aa)
                        .into(viewHolder.imageViewBackground);
                break;
            case 1:
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.bb)
                        .into(viewHolder.imageViewBackground);
                break;
            case 2:
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.cc)
                        .into(viewHolder.imageViewBackground);
                break;
            default:
                Glide.with(viewHolder.itemView)
                        .load(R.drawable.dd)
                        .into(viewHolder.imageViewBackground);
                break;

        }

    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return 4;
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        TextView textViewDescription;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.imageView);
//            textViewDescription = itemView.findViewById(R.id.textView);
            this.itemView = itemView;
        }
    }
}
