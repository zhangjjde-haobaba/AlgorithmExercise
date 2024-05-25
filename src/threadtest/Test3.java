package threadtest;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by jiang on 10/23/23 2:17 PM
 *
 * runnable 不需要返回值 callable需要返回值
 */
public class Test3 {
    public static void main(String[] args) throws Exception{
        MyCallable myCallable = new MyCallable();
        //要将callable放到futureTask中
        FutureTask futureTask = new FutureTask(myCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
}

class MyCallable implements Callable{

    @Override
    public Object call() throws Exception {
        System.out.println("Callable");
        return "success";
    }
}
