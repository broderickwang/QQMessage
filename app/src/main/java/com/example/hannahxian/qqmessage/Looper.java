package com.example.hannahxian.qqmessage;

/**
 * Created by hannahxian on 2016/12/2.
 */

public class Looper {
    //每个线程都有一个looper对象
    static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<>();

    //一个looper对象对应一个消息队列
    MessageQue messageQue;

    private Looper(){
        messageQue = new MessageQue();
    }

    //looper的初始化
    public static void prepare(){
        if(sThreadLocal != null)
            throw  new RuntimeException("exception");
        sThreadLocal.set(new Looper());
    }

    public static Looper myLooper(){
        return sThreadLocal.get();//获取当前线程的looper对象
    }

    public static void loop(){
        //轮训消息对象
        Looper me = myLooper();
        if(me == null)
            throw new RuntimeException("looper is null");

        MessageQue que = me.messageQue;
        for(;;){
            Message msg = que.next();
            if(msg==null){
                continue;
            }

            //转发给handler
            msg.target.despatchMsg(msg);
        }
    }
}
