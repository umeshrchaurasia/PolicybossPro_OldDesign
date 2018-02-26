package com.datacomp.magicfinmart.design;

import android.content.Context;

public class SquareImageView extends android.support.v7.widget.AppCompatImageView {


    public SquareImageView(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        setMeasuredDimension(width, width);
    }

}