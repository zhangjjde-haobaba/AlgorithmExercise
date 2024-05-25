package structureArrayAndList;

/**
 * Created by jiang on 1/24/23 11:02 PM
 * 手动实现一个数组,增删改查
 */
public class Array<E> {
    private E[] data; //元素空间
    private int size; //有效的元素个数

    //初始化开辟内存空间
    public Array(int capacity) {
        data = (E[])new Object[capacity];

    }

    public Array() {
        this(10);
    }

    //尾部增加
    public void addLast(E value){
        //如果数组长度和元素个数相等 那么就不能添加元素
        if(size==data.length){
            throw new IllegalArgumentException("数组已满，没有多余空间，添加失败");
        }
        data[size++] = value;
        if(size>=(int)(data.length/2)){
            resize();
        }
    }
    //插入
    public void add(int index, E value){
        //判断数组有没有空余空间可以插入
        if(size==data.length){
            throw new IllegalArgumentException("数组已满，没有多余空间，添加失败");
        }
        if(index<0||index>size){
            throw new IllegalArgumentException("请输入正确的位置");
        }
        if(index==size){
            data[index] = value; //尾部插入
        }else{
            //插入
            for(int i = size-1; i>=index; i--){
                data[i+1] = data[i];
            }
            data[index] = value;
        }

        size++;
        if(size>=(int)(data.length/2)){
            resize();
        }
    }

    //删除索引位置上的元素
    public void remove(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("索引不合法");
        }
        //把index后面的元素统一向前挪动一个位置
        for(int i = index; i<size;i++){
            data[i] = data[i+1];
        }
        size--;

    }

    //修改
    public void update(int index, E newValue){
        if(index<0||index>=size){
            throw new IllegalArgumentException("索引不合法");
        }
        data[index] = newValue;
    }
    //查找
    public E get(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("索引不合法");
        }
        return data[index];
    }
    //判断是否为空
    public boolean isEmpty(){
        return size==0;
    }
    //是否包含某元素
    public boolean contains(E value){
        for(int i = 0;i<size;i++){
            if(value.equals(data[i]) ){
                return true;
            }
        }
        return false;
    }

    //扩容
    public void resize(){
        //定义1.5倍的扩容
        E[] newData = (E[]) new Object[(int)(data.length*1.5)];
//        int[] newData = new int[(int)(data.length*1.5)];
        for(int i=0;i<size;i++){
            newData[i] = data[i];
        }
        data = newData;

    }
    //打印数组
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<size;i++){
            sb.append(data[i]+"\t\t");
        }
        return sb.toString();
    }

    //获取开辟的空间大小
    public int getCapacity(){
        return data.length;
    }
}
