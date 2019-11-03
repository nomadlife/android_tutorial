package com.example.test_pager_carousel;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

    public static final float BIG_SCALE = 1.0f;
    public static final float SMALL_SCALE = 0.9f;
    public static final float DIFF_SCALE = BIG_SCALE - SMALL_SCALE;

    CarouselPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager;
        pager = Utils.findViewByIdFromActivity(this, R.id.pager1, ViewPager.class);
        mAdapter = new CarouselPagerAdapter(this, setListInfo());
        pager.setAdapter(mAdapter);
        pager.setPageMargin(-getPagerMarginValue());
        pager.addOnPageChangeListener(mAdapter);
        mAdapter.notifyDataSetChanged();
    }


    private int getPagerMarginValue() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int pageMargin = (int) ((metrics.heightPixels / 9) * 2); //중요! 이 부분을 조절하여 margin 설정 가능
        return pageMargin;
    }

    private List<Integer> setListInfo() {
        return Arrays.asList(R.drawable.lighthouse, R.drawable.penguins,R.drawable.tulips);
    }
}

