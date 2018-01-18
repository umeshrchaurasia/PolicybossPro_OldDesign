package com.datacomp.magicfinmart.design;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by Rajeev Ranjan on 12/01/2018.
 */

public class CustomTextView extends android.support.v7.widget.AppCompatTextView {
    public CustomTextView(Context context) {
        super(context);
        setTypeface();
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface();
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface();
    }

    public void setTypeface() {
        super.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-BoldItalic.ttf"));
    }
}
