package treeStructure;

/**
 * Created by jiang on 10/10/23 10:52 PM
 */
public class PerityQuene<E extends Comparable> {
    //这个队列并不是先进先出，而是根据优先级
    //基于堆实现的(底层二叉堆)
    private MaxHeap<E> maxHeap;

    public PerityQuene() {
        maxHeap = new MaxHeap<>();
    }
    //入队列

    public void push(E e){
        maxHeap.insert(e);
    }

    //出队列

    public E pop(){
        E max = maxHeap.getMax();
        return max;

    }

    //查看队首元素
    public E peekFirst(){
        return maxHeap.findMax();
    }

    //查看队尾元素
    public E peekLast(){
        return maxHeap.findLast();
    }

}
