package com.example.test_pager_carousel;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

public class CarouselPagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {

    private static final int FIRST_PAGE = 0;
    private Context context;
    private CarouselPagerLayout[] mRootLayout;
    private int mCount = 0;
    private List mImgList;
    public CarouselPagerAdapter(Context context, List list) {
        this.context = context;
        this.mImgList = list;
        mCount = mImgList.size();
        mRootLayout = new CarouselPagerLayout[list.size()];
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        float scale =  MainActivity.BIG_SCALE;

        try {
            //First item change BigSize.
            if (position != FIRST_PAGE) {
                scale = MainActivity.SMALL_SCALE;
            }

            position = position % mImgList.size();

        } catch (Exception e) {
            // TODO: handle exception
        }
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.carouse_adapter_cell, null);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ImageView iv = Utils.findViewByIdFromView(view,R.id.img_pager,ImageView.class);
        iv.setLayoutParams(layoutParams);
        iv.setImageResource(mImgList.get(position));
        iv.setPadding(15, 15, 15, 15);

        mImgList.get(position);

        mRootLayout[position] = (CarouselPagerLayout) view.findViewById(R.id.root);
        mRootLayout[position].setScaleValue(scale);

        container.addView(view, 0);
        return view;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        try {
            if (positionOffset >= 0f && positionOffset < 1f) {
                CarouselPagerLayout cur = getRootView(position);
                CarouselPagerLayout next = getRootView(position + 1);

                cur.setScaleValue(MainActivity.BIG_SCALE - MainActivity.DIFF_SCALE * positionOffset);
                next.setScaleValue(MainActivity.SMALL_SCALE + MainActivity.DIFF_SCALE * positionOffset);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void finishUpdate(ViewGroup container) {
        super.finishUpdate(container);
    }

    @Override
    public int getCount() {
        if (mImgList != null) {
            return mImgList.size();
        }
        return 0;
    }

    /**
     * return 값에 따른 화면에 보여지는 결과가 달라진다.
     * @param view
     * @param o
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }

    private CarouselPagerLayout getRootView(int position){
        return mRootLayout[position];
    }
}

