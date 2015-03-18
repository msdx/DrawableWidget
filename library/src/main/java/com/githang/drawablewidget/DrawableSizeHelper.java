/*
 * Date: 15-1-30
 * Project: DrawableWidget
 */
package com.githang.drawablewidget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author 黄浩杭 (msdx.android@qq.com)
 */
public class DrawableSizeHelper {
    private Drawable left;
    private Drawable top;
    private Drawable right;
    private Drawable bottom;

    private int mDrawableWidth;
    private int mDrawableHeight;

    public void readAttributes(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DrawableButton);
        mDrawableWidth = typedArray.getDimensionPixelSize(R.styleable.DrawableButton_drawableWidth, 0);
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
        return mDrawableWidth <= 0 && mDrawableHeight <= 0;
    }

    public void setCompoundDrawablesWithIntrinsicBounds(TextView widget) {
        if (left != null) {
            left.setBounds(0, 0, calculateWidth(left), calculateHeight(left));
        }
        if (right != null) {
            right.setBounds(0, 0, calculateWidth(right), calculateHeight(right));
        }
        if (top != null) {
            top.setBounds(0, 0, calculateWidth(top), calculateHeight(top));
        }
        if (bottom != null) {
            bottom.setBounds(0, 0, calculateWidth(bottom), calculateHeight(bottom));
        }
        widget.setCompoundDrawables(left, top, right, bottom);
    }

    public int calculateWidth(Drawable d) {
        if(mDrawableWidth == 0) {
            return d.getIntrinsicWidth() * mDrawableHeight / d.getIntrinsicHeight();
        }
        return mDrawableWidth;
    }

    public int calculateHeight(Drawable d) {
        if(mDrawableHeight == 0) {
            return  d.getIntrinsicHeight() * mDrawableWidth / d.getIntrinsicWidth();
        }
        return mDrawableHeight;
    }

    @TargetApi(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView widget) {
        if (left != null) {
            left.setBounds(0, 0, mDrawableWidth, mDrawableHeight);
        }
        if (right != null) {
            right.setBounds(0, 0, mDrawableWidth, mDrawableHeight);
        }
        if (top != null) {
            top.setBounds(0, 0, mDrawableWidth, mDrawableHeight);
        }
        if (bottom != null) {
            bottom.setBounds(0, 0, mDrawableWidth, mDrawableHeight);
        }
        widget.setCompoundDrawablesRelativeWithIntrinsicBounds(left, top, right, bottom);
    }
}
