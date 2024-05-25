package stackStructure;

/**
 * Created by jiang on 1/29/23 4:50 PM
 */
public class StackDemo<E> {
    private int maxSize;//初始化栈的空间大小
    private E[] data; //存放栈的元素

    private int top=-1;//栈顶的指针

    public StackDemo(int maxSize) {
        //初始化栈空间
        data = (E[])new Object[maxSize];
    }

    public StackDemo() {
        this(10);
    }
    //入栈，出栈，查看栈顶元素，栈是否为空,扩容

    //入栈
    public boolean push(E e){
        //判断栈空间是否已满
        if(top==data.length-1){
            throw new IllegalArgumentException("入栈失败,栈空间已满");
        }
        data[++top] = e;
        return true;
    }
    //出栈
    public E pop(){
        //判断栈是否为空栈
        if(top==-1){
            throw new IllegalArgumentException("当前栈为空");
        }
        E e = data[top];
        data[top] = null;
        top--;
        return e;
    }
    //查看栈顶元素
    public E peek(){
        //判断栈是否为空栈
        if(top==-1){
            throw new IllegalArgumentException("当前栈为空");
        }
        return data[top];
    }
    //判断栈是否为空
    public boolean isEmpty(){
        return top==-1;
    }

    //栈的扩容
    public void resize(){
        E[] newData = (E[])new Object[data.length+1/2*data.length];
        for(int i=0;i<data.length;i++){
            newData[i] = data[i];
        }
        data = newData;
    }

}
