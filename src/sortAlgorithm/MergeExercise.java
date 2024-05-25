package sortAlgorithm;

import java.util.Arrays;

/**
 * Created by jiang on 1/17/23 11:02 PM
 */
public class MergeExercise {
    public static void main(String[] args) {
        int[] arr = {31,12,1,45,67,98,21,1};
        int[] arr2 = seperate(arr);
        for(int i=0;i<arr2.length;i++){
            System.out.print(arr2[i]+"\t\t");
        }
    }

    //归并排序
    //第一步 将数组分割
    public static int[] seperate(int[] arr){

        //数组长度为0或1不需要分割
        if(arr.length<2){
            return arr;
        }
        //Math.floor(3.5)例如：小于3.5的最大整数 那就是3
        int mid = (int)Math.floor(arr.length/2); //防止数组长度为奇数
        //将下标为mid左侧的元素放入一个新的数组中
        int[] left = Arrays.copyOfRange(arr,0,mid);//[0,mid)顶多复制到mid-1 包含from不包含to
        int[] right = Arrays.copyOfRange(arr,mid,arr.length);
        //将两个数组不断继续划分
//        seperate(left);
//        seperate(right);
        return merge(seperate(left),seperate(right));

    }
    //合并数组 按照升序排列
    public static int[] merge(int[] left, int[] right){
        int[] newArr = new int[left.length+right.length];

        if(newArr.length<2){
            //如果左数组长度为0则返回右数组否则返回左数组
            return left.length==0?right:left;
        }
        int k=0,i=0,j=0; //k代表新数组的下标 i代表left数组的下标 j代表right数组的下标
        //假设left数组和right数组长度都为1 那么下标都为0 但是新数组长度为2 下标为1 在i++或j++的时候就会报错
        while(i<left.length && j<right.length){
            //比较两个数组 如果左数组的第i个元素比右数组的第i个元素小 那么把left[i]赋给newArr[k] 然后i指针指向后一个元素 k也一样
            if(left[i]<right[j]){
                newArr[k] = left[i];
                k++;
                i++;
            }
            else{
                //等同于上一种写法
                newArr[k++] = right[j++];
            }
        }
        //将剩余值赋给新数组
        //假设left数组为{31}right数组为{21}
        //经过一轮循环之后k=1, j=1这个时候j不满足j<right.length循环的条件 但是i还为0 于是要把31添加到新数组中
        while(i<left.length){
            newArr[k++] = left[i++];
        }
        while(j<right.length){
            newArr[k++] = right[j++];
        }
        return newArr;
    }

}
