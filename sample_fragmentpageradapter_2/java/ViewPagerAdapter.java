package com.example.sample_fragmentpageradapter_2;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private static final int FRAGMENT_SUB01 = 0;
    private static final int FRAGMENT_SUB02 = 1;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case FRAGMENT_SUB01:
                return Sub01Fragment.getInstance();
            case FRAGMENT_SUB02:
                return Sub02Fragment.getInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case FRAGMENT_SUB01:
                return "SUB01";
            case FRAGMENT_SUB02:
                return "SUB02";
            default:
                return null;
        }
    }
}

