package com.kharredo.muqit.ui.welcome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.kharredo.muqit.Adapters.OnBoard_Adapter;
import com.kharredo.muqit.MainActivity;
import com.kharredo.muqit.OnBoardItem;
import com.kharredo.muqit.R;

import java.util.ArrayList;

public class WelcomeActivity extends AppCompatActivity {



    private LinearLayout pager_indicator;
    private int dotsCount;
    private ImageView[] dots;



    ViewPager onboard_pager;

    private OnBoard_Adapter mAdapter;

    private Button btn_get_started;

    int previous_pos=0;


    ArrayList<OnBoardItem> onBoardItems=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btn_get_started = (Button) findViewById(R.id.btn_get_started);
        onboard_pager = (ViewPager) findViewById(R.id.pager_introduction);
        pager_indicator = (LinearLayout) findViewById(R.id.viewPagerCountDots);

        if(restorePrefData()){

            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
            finish();
        }

        loadData();

        mAdapter = new OnBoard_Adapter(this,onBoardItems);
        onboard_pager.setAdapter(mAdapter);
        onboard_pager.setCurrentItem(0);
        onboard_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                // Change the current position intimation

                for (int i = 0; i < dotsCount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(WelcomeActivity.this, R.drawable.non_selected_item_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(WelcomeActivity.this, R.drawable.selected_item_dot));


                int pos=position+1;

                if(pos==dotsCount&&previous_pos==(dotsCount-1))
                    show_animation();
                else if(pos==(dotsCount-1)&&previous_pos==dotsCount)
                    hide_animation();

                previous_pos=pos;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        btn_get_started.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();

//                Toast.makeText(OnboardingActivity.this,"Redirect to wherever you want",Toast.LENGTH_LONG).show();
                savePrefsData();
                finish();

            }
        });

        setUiPageViewController();

    }

    // Load data into the viewpager

    public void loadData()
    {

        int[] header = {R.string.ob_header1, R.string.ob_header2, R.string.ob_header3};
        int[] desc = {R.string.ob_desc1, R.string.ob_desc2, R.string.ob_desc3};
        int[] imageId = {R.drawable.lejao, R.drawable.delivery, R.drawable.chalo};

        for(int i=0;i<imageId.length;i++)
        {
            OnBoardItem item=new OnBoardItem();
            item.setImageID(imageId[i]);
            item.setTitle(getResources().getString(header[i]));
            item.setDescription(getResources().getString(desc[i]));

            onBoardItems.add(item);
        }
    }

    // Button bottomUp animation

    public void show_animation()
    {
        Animation show = AnimationUtils.loadAnimation(this, R.anim.slide_up_anim);

        btn_get_started.startAnimation(show);

        show.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                btn_get_started.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                btn_get_started.clearAnimation();

            }

        });


    }

    // Button Topdown animation

    public void hide_animation()
    {
        Animation hide = AnimationUtils.loadAnimation(this, R.anim.slide_down_anim);

        btn_get_started.startAnimation(hide);

        hide.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                btn_get_started.clearAnimation();
                btn_get_started.setVisibility(View.GONE);

            }

        });


    }

    // setup the
    private void setUiPageViewController() {

        dotsCount = mAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(WelcomeActivity.this, R.drawable.non_selected_item_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(6, 0, 6, 0);

            pager_indicator.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(WelcomeActivity.this, R.drawable.selected_item_dot));
    }

    private boolean restorePrefData(){


        SharedPreferences pref=getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpendBefore = pref.getBoolean("isIntroOpnend",false);
        return isIntroActivityOpendBefore;
    }

    private void savePrefsData(){


        SharedPreferences pref=getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putBoolean("isIntroOpnend",true);
        editor.commit();
    }


}
