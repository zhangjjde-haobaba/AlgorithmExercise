package threadtest;

/**
 * Created by jiang on 10/23/23 2:09 PM
 */
public class Test2 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        //要先创建thread将runnable作为参数传入
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Runnable");
    }
}