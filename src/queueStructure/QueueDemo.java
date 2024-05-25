package queueStructure;

/**
 * Created by jiang on 2/2/23 3:06 PM
 */
public class QueueDemo<T> {
    //E和T都是泛型，E通常是在集合中使用代表元素, T通常代表类型
    //一直在索引为0的地方进行取操作，在索引>=0的地方进行插入操作
    private int size; //数组里面有效长度
    private T[] data; //存放队列元素的数组
    private int putIndex=-1; //队列队尾的指针

    public QueueDemo(int capacity){
        if(capacity<=0){
            throw new IllegalArgumentException("请输入合法参数,capacity应该大于0");
        }
        data = (T[])new Object[capacity];
    }

    public QueueDemo(){
        this(10);
    }
    //查看队首元素
    public T peekFirst(){
        if(putIndex==-1){
            throw new IllegalArgumentException("队列为空");
        }
        return data[0];
    }
    //查看队尾元素
    public T peekLast(){
        if(putIndex==-1){
            throw new IllegalArgumentException("队列为空");
        }
        return data[putIndex];
    }

    //添加队尾元素
    public void push(T t){
        if(size==data.length){
            throw new IllegalArgumentException("添加失败，队列已满");
        }
        data[++putIndex] = t;
        size++;
    }

    //弹出元素
    public T pop(){
        if(putIndex!=-1){
            T t = data[0];
            for(int i=0;i<size;i++){
                data[i] = data[i+1];
            }
            data[size-1] = null;
            putIndex--;
            size--;
            return t;
        }else{
            throw new IllegalArgumentException("队列为空");
        }
    }

}
