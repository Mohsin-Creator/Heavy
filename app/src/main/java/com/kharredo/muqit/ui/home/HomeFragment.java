package com.kharredo.muqit.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.kharredo.muqit.Adapters.RecyclerAdapter;
import com.kharredo.muqit.Adapters.SliderAdapter;
import com.kharredo.muqit.Model.ModelTest;
import com.kharredo.muqit.R;
import com.kharredo.muqit.ui.productDetail.ProductFragment;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    ShimmerFrameLayout shimmer1,shimmer2,shimmer3,shimmer4;

    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    ArrayList<ModelTest> data;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);

      /*  GridView flashGridView = root.findViewById(R.id.flash_grid);
        GridView featuredGridView = root.findViewById(R.id.featured_grid);
        GridView mostViewedGridView = root.findViewById(R.id.most_viewed_grid);
        GridView latestGridView = root.findViewById(R.id.latest_grid);
        int[] productImages = {R.drawable.per, R.drawable.coke, R.drawable.watch};
        final String[] productName = {"Perfume", "Bottle", "Watch"};
        String[] productPrice = {"1000", "50", "15000"};
        final GridAdapter gridAdapter = new GridAdapter(getActivity(), productImages, productName, productPrice);
        flashGridView.setAdapter(gridAdapter);
        featuredGridView.setAdapter(gridAdapter);
        mostViewedGridView.setAdapter(gridAdapter);
        latestGridView.setAdapter(gridAdapter);


        flashGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getActivity(), ""+productName[i], Toast.LENGTH_SHORT).show();

//                Product_Detail product_detail = new Product_Detail();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

            }
        });

        featuredGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        mostViewedGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        latestGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });*/

        recyclerView = root.findViewById(R.id.flash_recycler);

        data = new ArrayList<>();
        ModelTest modelTest1 = new ModelTest(R.drawable.coke,"Bottle","100");
        data.add(modelTest1);

        ModelTest modelTest2 = new ModelTest(R.drawable.jacket,"jacket","100");
        data.add(modelTest2);

        ModelTest modelTest3 = new ModelTest(R.drawable.coat,"coat","100");
        data.add(modelTest3);

        ModelTest modelTest4 = new ModelTest(R.drawable.coat,"coat","100");
        data.add(modelTest4);

        ModelTest modelTest5 = new ModelTest(R.drawable.coat,"coat","100");
        data.add(modelTest5);

        ModelTest modelTest6 = new ModelTest(R.drawable.coat,"coat","100");
        data.add(modelTest6);


        adapter = new RecyclerAdapter(data,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(new RecyclerAdapter.OnClickListner() {
            @Override
            public void onClick(int position, ModelTest modelTest) {
                Toast.makeText(getActivity(), ""+position, Toast.LENGTH_SHORT).show();

                /*Fragment test= new ProductFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.nav_host_fragment,test);
                fragmentTransaction.commit();*/

                ProductFragment second=new ProductFragment();
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment,second).addToBackStack(null).commit();
            }
        });



        shimmer1 = (ShimmerFrameLayout) root.findViewById(R.id.shimmer_one);
        shimmer1.startShimmer(); // If auto-start is set to false

        shimmer2 = (ShimmerFrameLayout) root.findViewById(R.id.shimmer_two);
        shimmer2.startShimmer(); // If auto-start is set to false

        shimmer3 = (ShimmerFrameLayout) root.findViewById(R.id.shimmer_three);
        shimmer3.startShimmer(); // If auto-start is set to false

        shimmer4 = (ShimmerFrameLayout) root.findViewById(R.id.shimmer_four);
        shimmer4.startShimmer(); // If auto-start is set to false

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                shimmer1 = (ShimmerFrameLayout) root.findViewById(R.id.shimmer_one);
                shimmer1.hideShimmer(); // If auto-start is set to false

                shimmer2 = (ShimmerFrameLayout) root.findViewById(R.id.shimmer_two);
                shimmer2.hideShimmer(); // If auto-start is set to false

                shimmer3 = (ShimmerFrameLayout) root.findViewById(R.id.shimmer_three);
                shimmer3.hideShimmer(); // If auto-start is set to false

                shimmer4 = (ShimmerFrameLayout) root.findViewById(R.id.shimmer_four);
                shimmer4.hideShimmer(); // If auto-start is set to false
            }
        }, 2500);


        /*final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        SliderView sliderView = root.findViewById(R.id.imageSlider);
        SliderAdapter adapter = new SliderAdapter(getActivity());
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimations.SWAP); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        return root;
    }
}