/*
 * Date: 15-1-30
 * Project: DrawableWidget
 */
package com.githang.drawablewidget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Author: msdx (645079761@qq.com)
 * Time: 15-1-30 下午5:03
 */
public class DrawableButton extends Button {
    private DrawableSizeHelper mHelper;

    public DrawableButton(Context context) {
        super(context);
    }

    public DrawableButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyAttributes(context, attrs);
    }

    public DrawableButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyAttributes(context, attrs);
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
