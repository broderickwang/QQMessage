package com.example.hannahxian.qqmessage;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hannahxian on 2016/12/2.
 */

public class MessageQue {
    //通过数组的结构存储message
    Message[] items;

    int putindex; //入队索引
    int takeindex; //出队索引

    int count;//计数器

    //互斥锁  给代码块加锁
    Lock lock;
    //条件变量
    private Condition notEmpty;
    private Condition notFull;

    public MessageQue() {
        this.items = new Message[50];//固定长度
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
    }

    //押入消息 子线程调用，运行  生产
    public void enqueMessage(Message message){
        try {
            lock.lock();
            // 消息队列满了，阻塞
            while (count == items.length){
                notFull.await();
            }
            this.items[putindex] = message;
            //循环quzhi
            putindex = (++putindex == items.length)?0:putindex;
            count++;

            // 生产出了产品通知消费线程进行消费
            notEmpty.signalAll();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    //出队列，主要在主线程调用，运行  消费
    public Message next(){
        Message msg = null;
        try{
            lock.lock();
            while (count == 0) {
                notEmpty.await();
            }
            msg = this.items[takeindex];
            this.items[takeindex] = null;
            takeindex = (++takeindex == items.length)?0:takeindex;
            count--;

            //使用了一个message对象，通知子线程可以继续生产了
            notFull.signalAll();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }


        return msg;
    }
}
