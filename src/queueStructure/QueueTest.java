package queueStructure;

/**
 * Created by jiang on 2/3/23 10:55 PM
 */
public class QueueTest {
    public static void main(String[] args) {
        QueueDemo<Integer> queueDemo = new QueueDemo<>();
        queueDemo.push(1);
        queueDemo.push(2);
        queueDemo.push(3);
        System.out.println("队首元素是:"+queueDemo.peekFirst());
        System.out.println("队尾元素是:"+queueDemo.peekLast());
        System.out.println("弹出元素:"+queueDemo.pop());
        System.out.println("队首元素是:"+queueDemo.peekFirst());
        System.out.println("队尾元素是:"+queueDemo.peekLast());
    }
}
