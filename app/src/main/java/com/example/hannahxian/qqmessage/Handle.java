package com.example.hannahxian.qqmessage;

/**
 * Created by hannahxian on 2016/12/2.
 */

public class Handle {
    private MessageQue mQue;
    private Looper looper;
    public interface Callback {
        public boolean handleMessage(Message msg);
    }

    /**
     * Subclasses must implement this to receive messages.
     */
    public void handleMessage(Message msg) {
    }
    //主线程里创建handler
    public Handle() {
        //获取主线程的looper对象
        looper = Looper.myLooper();
        this.mQue = looper.messageQue;
    }

    public void sendMessage(Message message){
        mQue.enqueMessage(message);
    }

    public Message next(){
        return null;
    }

    public void despatchMsg(Message msg){
        handleMsg(msg);
    }

    public void handleMsg(Message msg)
    {
    }
}
