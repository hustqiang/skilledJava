package com.mine;

public class Main {
    public static void main(String[] rags) {
        ThreadTest threadTest = new ThreadTest();
/**
 * 如果直接调用run方法，相当于在主线程中直接运行方法体，并没有开出新线程，
 * 也就是说，此时线程数并没有增加
 */
        threadTest.run();

        //start方法才是开启线程的方法
        ThreadTest threadTest1 = new ThreadTest();
        threadTest1.start();

        //采用implement的方法是不能用start方法的
        ThreadTestImpl threadImpl = new ThreadTestImpl();
        Thread thread = new Thread(threadImpl);
        thread.start();

        //匿名内部类方式
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 900; i++) {
                    System.out.println("inner class" + i);
                }
            }
        }).start();


    }

}

class ThreadTest extends Thread {
    @Override
    public void run() {

        for (int i = 0; i < 90; i++) {
            System.out.println(i);
            System.out.println(System.currentTimeMillis());
            try {
            //把当前线程从运行状态转换为休眠状态，时间（单位为ms）到期以后又转为运行状态
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //获取当前线程的主键，得到一个唯一的，不重复的ID
            long id = getId();

            System.out.println("线程ID" + id);
            System.out.println(System.currentTimeMillis());
        }
    }
}


class ThreadTestImpl implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 900; i++) {
            System.out.println("implement" + i);
        }
    }
}

