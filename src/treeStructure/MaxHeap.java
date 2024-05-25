package treeStructure;

/**
 * Created by jiang on 10/9/23 5:39 PM
 */
public class MaxHeap<E extends Comparable> {
    /**
     * 在泛型类定义中使用 E extends Comparable 是一种限制泛型类型参数的方法。
     * 这样做的目的是确保任何用作该类型参数的类都实现了 Comparable 接口，这意味着它们可以在类内部进行比较。
     */

    private E[] data; //真正存放数据的数组
    private int size;

    public MaxHeap() {
        this(10);
    }

    public MaxHeap(int capacity) {
        //类型安全: 数组将只接受实现了Comparable接口的对象，这与E的约束相一致
        //避免不必要的类型转换: 如果data是Comparable类型的数组，你可以直接在数组元素上调用compareTo方法，而不需要进行额外的类型转换。
        data = (E[]) new Comparable[capacity];
    }

    //返回个数
    public int size(){
        return size;
    }
    //判断堆是否为空
    public boolean isEmpty(){
        return size==0;
    }
    //左孩子
    public int left(int index){
        if(index<0){
            throw new IllegalArgumentException("index必须大于0");
        }
        return 2*index+1;
    }
    //右孩子
    public int right(int index){
        if(index<0){
            throw new IllegalArgumentException("index必须大于0");
        }
        return 2*index+2;
    }
    //父索引
    public int parent(int index){
        if(index<0){
            throw new IllegalArgumentException("index必须大于0");
        }
        return (index-1)/2;
    }
    //堆中最大值
    //根节点是最大的
    public E findMax(){
        if(size<0){
            throw new IllegalArgumentException("堆为空");
        }
        return data[0];
    }

    //取出最大值
    public E getMax(){
        if(size<0){
            throw new IllegalArgumentException("堆为空");
        }
        E temp = data[0];
        for(int i=0;i<size-1;i++){
            data[i] = data[i+1]; //i:size-1-1 i+1:size-1
        }
        size--;
        return temp;
    }

    public E findLast(){
        E e = null;
        if(size>0){
            e = data[size-1];
        }
        return e;
    }

    //上浮
    //在添加的时候发生
    public void up(int index){
        //找父索引
        int parent = this.parent(index);
        //比较父索引与该节点的值，父索引的值应该比该节点值要大
        while(parent>=0 && data[parent].compareTo(data[index]) == -1 ){
            E temp = data[parent];
            data[parent] = data[index];
            data[index] = temp;
            index = parent;
            parent = this.parent(index);

        }

    }

    //下沉
    public void down(int index){
        //左孩子
        int left = this.left(index);
        //右孩子
        int right = this.right(index);
        //max记录孩子中值比较大的索引
        int max = -1;
        if(right<size){
            max = data[left].compareTo(data[right]) == 1 ?left:right;
        }else if(left<size){
            max = left;
        }
        //最大堆，任何节点的值都要小于等于父节点的值
        while(max != -1 && data[index].compareTo(data[max])==-1){
            E temp = data[index];
            data[index] = data[max];
            data[max] = temp;

            index = max;
            left = this.left(index);
            right = this.right(index);

            if(right<size){
                max = data[left].compareTo(data[right]) == 1 ?left:right;
            }else if(left<size){
                max = left;
            }
        }

    }

    //增
    public void insert(E e){
        data[size] = e;
        size++;
        up(size-1); //因为size++过了 因此size-1才是新增的索引

    }
    //删除
    public void delete(int index){
//        E temp = data[index];
        data[index] = data[size-1];
//        data[size-1] = temp;
        data[size-1] = null;
        size--;
        down(index);

        //先将要删除的节点和最后的节点对调
        //删除最后一个节点
        //再将节点下沉
    }

    //修改
    public void update(int index, E e){
        data[index] = e;
        //修改的数据不清楚比原来大还是比原来小 （不清楚上浮或者下沉）
        int left = this.left(index);
        int right = this.right(index);
        int max = -1;
        if(right<size){
            max = data[left].compareTo(data[right]) == 1 ?left:right;
        }else if(left<size){
            max = left;
        }

        if(max != -1){
            if(data[index].compareTo(data[max])==-1){
                down(index);
            }else {
                up(index);
            }
        }

    }

    //查
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for(int i=0;i<size;i++){
            sb.append(data[i]);
            if(i != size-1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

class TestMaxHeap{
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap=new MaxHeap<>();

        maxHeap.insert(7);
        maxHeap.insert(5);
        maxHeap.insert(4);
        maxHeap.insert(3);
        maxHeap.insert(2);
        maxHeap.insert(1);
        System.out.println("增加元素前：");
        System.out.println(maxHeap);
        System.out.println();
        maxHeap.insert(6);
        System.out.println("增加元素后：");
        System.out.println(maxHeap);
        System.out.println();
        maxHeap.delete(3);
        System.out.println("删除元素后：");
        System.out.println(maxHeap);
        System.out.println();
    }
}
