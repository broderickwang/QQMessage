package com.example.hannahxian.qqmessage;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.*;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by hannahxian on 2016/11/28.
 */

public class DragTouchListner implements View.OnTouchListener {
    private View view;
    private Context context;
    private WindowManager windowManager;
    private WindowManager.LayoutParams layoutParams;
    DragView dragView;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    public DragTouchListner(View view, Context context) {
        this.view = view;
        this.context = context;
        init();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            this.view.setVisibility(View.GONE);

            windowManager.addView(dragView,layoutParams);
        }

        return false;
    }

    private void init(){
        dragView = new DragView(context);
        windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);

        layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = PixelFormat.TRANSLUCENT;
    }
}
