package com.mine;

/**
 * @ClassName ThreadDeadLock
 * @Description 线程死锁：同步中嵌套同步，导致无法获取到锁
 * @Author zhangqiang
 * @Date 2020-02-17 21:29
 * @ModifyDate 2020-02-17 21:29
 * @Version 1.0
 */
public class ThreadDeadLock implements Runnable {
    //火车票总数
    private static int count = 100;
    private static Object obj = new Object();

    public boolean flag = true;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        if (flag) {
            while (count > 0) {
                synchronized (obj) {
                    try {
                        show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            while (count > 0) {
                try {
                    show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

     synchronized void show() throws Exception{
        synchronized (obj) {
            //如果这里没有sleep语句，也不会产生死锁情况，猜测原因是系统执行的太快，很快就把锁释放了
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + "出售第" + (100 - count + 1) + "张票");
            count--;
        }
    }
}


class ThreadDeadLockTest {
    public static void main(String[] args) throws Exception {
        //如果定义多个实例，实际上并没有达到共享同一个变量的预想
        ThreadDeadLock threadDeadLock = new ThreadDeadLock();
        Thread thread1 = new Thread(threadDeadLock);
        Thread thread2 = new Thread(threadDeadLock);
        thread1.start();
        //如果这里没有没有sleep，没有将第一个线程暂停下来，就不会占有锁，也就不会有线程死锁问题
        Thread.sleep(100);
        threadDeadLock.flag = false;
        thread2.start();

    }
}

