package com.github.droidfu.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author: Daniel Grech
 * Date: 17/12/11 10:41 AM
 * Description :
 */
public class SquareView extends View{
    private static final String TAG = SquareView.class.getSimpleName();

    public SquareView(Context context) {
        super(context);
    }

    public SquareView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredWidth = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        int measuredHeight = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        
        //Ensure view is always square
        int size = Math.min(measuredHeight, measuredWidth);
        setMeasuredDimension(size, size);
    }
}
