/*
 * Date: 15-1-30
 * Project: DrawableWidget
 */
package com.githang.drawablewidget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Author: msdx (645079761@qq.com)
 * Time: 15-1-30 下午5:05
 */
public class DrawableSizeHelper {
    private Drawable left;
    private Drawable top;
    private Drawable right;
    private Drawable bottom;

    private int mDrawableWidht;
    private int mDrawableHeight;

    public void readAttributes(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DrawableButton);
        mDrawableWidht = typedArray.getDimensionPixelSize(R.styleable.DrawableButton_drawableWidth, 0);
        mDrawableHeight = typedArray.getDimensionPixelSize(R.styleable.DrawableButton_drawableHeight, 0);
        typedArray.recycle();
    }

    public void setDrawable(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public boolean isNotSet() {
        return mDrawableWidht <= 0 || mDrawableHeight <= 0;
    }

    public void setCompoundDrawablesWithIntrinsicBounds(TextView widget) {
        if (left != null) {
            left.setBounds(0, 0, mDrawableWidht, mDrawableHeight);
        }
        if (right != null) {
            right.setBounds(0, 0, mDrawableWidht, mDrawableHeight);
        }
        if (top != null) {
            top.setBounds(0, 0, mDrawableWidht, mDrawableHeight);
        }
        if (bottom != null) {
            bottom.setBounds(0, 0, mDrawableWidht, mDrawableHeight);
        }
        widget.setCompoundDrawables(left, top, right, bottom);
    }
}
