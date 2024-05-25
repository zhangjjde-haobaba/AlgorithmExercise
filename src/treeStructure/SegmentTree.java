package treeStructure;

/**
 * Created by jiang on 10/11/23 8:53 AM
 */
public class SegmentTree<E> {

    private E[] data; //接收用户传进来的数组
    private E[] tree; //线段树
    private Merge<E> merge; //我将会使用一个实现了这个接口的对象

    public SegmentTree(E[] arr, Merge<E> merge) {
        //初始化 Merge
        this.merge = merge;
        data = (E[])new Object[arr.length]; //申明空间大小
        //传值
        for(int i=0;i<arr.length;i++){
          data[i] = arr[i];
         }
        //申明线段树空间大小 数组长度为N 线段树长度为4N
        tree = (E[])new Object[4*arr.length];
        buildSegmentTree(0,0,data.length-1);
    }

    //左孩子的索引
    private int leftChild(int index){
        return 2*index+1;
    }
    //右孩子的索引
    private int rightChild(int index){
        return 2*index+2;
    }

    //构建线段树
    public void buildSegmentTree(int index, int l, int r){
        if(l==r){
            tree[index]=data[l];
            return ;
        }
        int left=leftChild(index);//左孩子的索引
        int right=rightChild(index);//右孩子的索引
        int mid = l + (r-l)/2; //中间边界
        buildSegmentTree(left,l,mid); //构建左孩子的区间
        buildSegmentTree(right,mid+1,r); //构建右孩子的区间
        //求和
        tree[index] =  merge.merge(tree[left],tree[right]);

    }

    //查询区间
    public E queryArea(int queryL, int queryR){
        if(queryL<0 || queryL>=data.length || queryR <0 || queryR>=data.length || queryR<queryL){
            throw new IllegalArgumentException("输入不合法");
        }
        return query(0,0,data.length-1,queryL,queryR);
    }

    //执行真正的查询
    private E query(int index, int l, int r, int queryL, int queryR){
        E result = null;
        if(l==queryL&&r==queryR){
            return tree[index];
        }
        int left=leftChild(index);//左孩子的索引
        int right=rightChild(index);//右孩子的索引
        int mid = l + (r-l)/2; //中间边界
        if(queryL>=mid+1){
            //左孩子大于中间值 在右边找
            result = query(right,mid+1,r,queryL,queryR);
        }else if(queryR<=mid){
            //右孩子小于中间值 从左边找
            result = query(left,l,mid,queryL,queryR);
        }else{
            E a = query(left,l,mid,queryL,mid);
            E b = query(right,mid+1,r,mid+1,queryR);
            result = merge.merge(a,b);
        }
        return result;

    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for(int i=0;i<tree.length;i++){
            if(tree[i]!=null){
                sb.append(tree[i]);
            }else {
                sb.append("null");
            }
            if(i !=tree.length-1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
interface Merge<E>{
    E merge(E a, E b);
}
