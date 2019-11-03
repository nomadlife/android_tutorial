package com.example.test_pager_carousel;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class CarouselPagerLayout extends LinearLayout {
    public CarouselPagerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public CarouselPagerLayout(Context context) {
        super(context);
    }
    private float scale = MainActivity.BIG_SCALE;
    public void setScaleValue(float scale){
        this.scale = scale;
        this.invalidate();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        int w = this.getWidth();
        int h = this.getHeight();
        canvas.scale(scale,scale,w/2,h/2);
        super.onDraw(canvas);
    }
}

