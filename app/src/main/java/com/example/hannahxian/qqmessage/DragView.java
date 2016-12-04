package com.example.hannahxian.qqmessage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by hannahxian on 2016/11/28.
 */

public class DragView extends View {
    private int mStatusBarHeight;
    private boolean isDispear;
    public DragView(Context context) {
        this(context,null);
    }

    public DragView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DragView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();

        canvas.translate(0,-mStatusBarHeight);

        if(!isDispear){
        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    public int getmStatusBarHeight() {
        return mStatusBarHeight;
    }

    public void setmStatusBarHeight(int mStatusBarHeight) {
        this.mStatusBarHeight = mStatusBarHeight;
    }
}
