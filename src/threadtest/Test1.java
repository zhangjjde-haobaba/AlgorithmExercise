package threadtest;

/**
 * Created by jiang on 10/23/23 2:05 PM
 * 创建线程的方法1
 */
public class Test1 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }

}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("Thread");
    }
}