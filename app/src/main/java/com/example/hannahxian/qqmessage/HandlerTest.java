package com.example.hannahxian.qqmessage;

/**
 * Created by hannahxian on 2016/12/4.
 */

public class HandlerTest {
    public void main(){
        Looper.prepare();

        final Handle handle = new Handle(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };

        for(int i=0;i<19;i++){
            new Thread(){
                public void run(){
                    Message msg = new Message();
                    msg.what = 1;
                    msg.obj = "sdf";
                    handle.sendMessage(msg);
                }
            }.start();
        }

        Looper.loop();
    }
}
