package com.mine;

/**
 * @ClassName ThreadDemo
 * @Description 线程安全问题
 * @Author zhangqiang
 * @Date 2020-02-17 10:34
 * @ModifyDate 2020-02-17 10:34
 * @Version 1.0
 */
public class ThreadDemo implements Runnable {
    //火车票总数
    private static int count = 100;
    private Object mutex = new Object();

    @Override
    public void run() {
        while (count > 0) {
            /**
             * 由于系统运行多线程的本质还是计算机对这些线程进行分时处理，因此，系统还是会按照顺序来执行各个线程，
             * 如果在系统分配的时间内程序可以完全执行完以下的代码块，那么两个线程是不可能同时处于while当中的代码块的，
             * 也就不会出现安全问题。而如果把执行while代码块的时间延长的话，就有可能超出系统分配的时间，就会出现
             * 这种情况：其中一个线程还在这个代码块中，此时count=1，第一个线程打印"卖出第100张票"，此时第二个线程也进入了这个代码块，
             * 然后第一个线程对count减1，此时count=0，然后第二个线程就会打印"卖出第101张票"，问题就是这样产生的。
             *
             * ！！！如果将sleep的代码段放在count--后面，那么系统每次一进来就会对count进行操作，也就是说，在系统分配的时间内，
             * 就已经完成了数据的操作，然后系统再跳到其他线程，此时虽然第一个线程还没有执行完毕，但是数据变更已经完成，因此依然不会出现线程安全问题
             */
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /**
             * 即便加了锁，但是此时也会出现一个线程进入到while代码块中，然后另一个线程又对count进行操作了，还是会出现线程安全问题；
             * 如果把锁加到while外面，其实就变成单线程了
             */
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + "出售第" + (100 - count + 1) + "张票");
                count--;
            }
        }
    }

    //静态方法的锁是ThreadDemo.class，类锁
    synchronized static void showStatic() {
        System.out.println(Thread.currentThread().getName() + "出售第" + (100 - count + 1) + "张票");
        count--;
    }

    private void show() {
        System.out.println(Thread.currentThread().getName() + "出售第" + (100 - count + 1) + "张票");
        count--;
    }
}

class ThreadSafeTest {
    public static void main(String[] args) {
        //如果定义多个实例，实际上并没有达到共享同一个变量的预想
        ThreadDemo threadDemo = new ThreadDemo();
        Thread thread1 = new Thread(threadDemo);
        Thread thread2 = new Thread(threadDemo);
        thread1.start();
        thread2.start();

    }
}
