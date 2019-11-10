package com.example.sample_recyclerview_pager;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kevin on 2017. 10. 24..
 */

public class ProductCardAdapter extends RecyclerView.Adapter<ProductCardAdapter.ViewHolder> {

    private ArrayList<Product> items;
    private FragmentManager fragmentManager;

    HashMap<Integer, Integer> mViewPagerState = new HashMap<>();

    public ProductCardAdapter(FragmentManager fragmentManager, ArrayList<Product> items) {
        this.items = items;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        BannerPagerAdapter bannerPagerAdapter = new BannerPagerAdapter(fragmentManager);
        viewHolder.vp.setAdapter(bannerPagerAdapter);
        viewHolder.vp.setId(i+1);

        if (mViewPagerState.containsKey(i)) {
            viewHolder.vp.setCurrentItem(mViewPagerState.get(i));
        }

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        mViewPagerState.put(holder.getAdapterPosition(), holder.vp.getCurrentItem());
        super.onViewRecycled(holder);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewPager vp;

        public ViewHolder(View itemView) {
            super(itemView);
            vp = (ViewPager) itemView.findViewById(R.id.vp);
        }
    }

    public class BannerPagerAdapter extends FragmentPagerAdapter {
        public BannerPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return BlankFragment.newInstance(items.get(position));
        }

        @Override
        public int getCount() {
            return items.size();
        }


    }

}
