package com.example.test_b_recyclerview;

import android.view.View;

public interface OnPersonItemClickListener {
    public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position);
}
