/*
 * Copyright (c) 2015. Huang Haohang.
 * All rights reserved.
 */

package com.githang.drawablewidget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;

/**
 * @author 黄浩杭 (msdx.android@qq.com)
 */
public class DrawableRadio extends RadioButton {
    private DrawableSizeHelper mHelper;

    public DrawableRadio(Context context) {
        super(context);
    }

    public DrawableRadio(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawableRadio(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public DrawableRadio(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    private void applyAttributes(Context context, AttributeSet attrs) {
        if (mHelper == null) {
            mHelper = new DrawableSizeHelper();
        }
        mHelper.readAttributes(context, attrs);
        if (!mHelper.isNotSet()) {
            mHelper.setCompoundDrawablesWithIntrinsicBounds(this);
        }
    }

    @Override
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
        if (mHelper == null) {
            mHelper = new DrawableSizeHelper();
        }
        mHelper.setDrawable(left, top, right, bottom);
        if (!mHelper.isNotSet()) {
            mHelper.setCompoundDrawablesWithIntrinsicBounds(this);
        }
    }

    @Override
    @TargetApi(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable start, Drawable top, Drawable end, Drawable bottom) {
        super.setCompoundDrawablesWithIntrinsicBounds(start, top, end, bottom);
        if (mHelper == null) {
            mHelper = new DrawableSizeHelper();
        }
        mHelper.setDrawable(start, top, end, bottom);
        if (!mHelper.isNotSet()) {
            mHelper.setCompoundDrawablesRelativeWithIntrinsicBounds(this);
        }
    }
}
