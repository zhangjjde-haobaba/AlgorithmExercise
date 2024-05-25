package structureArrayAndList;

import java.util.Hashtable;

/**
 * Created by jiang on 10/14/23 11:07 PM
 */
public class WritingTestForArray {
    public static void main(String[] args) {
        int[] arr={1,9,5,5,4,6};
        int sum = 10;
//        method1(arr,sum);
//        method3(arr,sum);
        int[] arr1 = {-1,9,-3,0,5,4,-6};
//        int[] result = method4(arr1);
//        int[] result = method5(arr1);
//        for(int i:result){
//            System.out.print(i+"\t\t");
//        }
//        System.out.println();
        int[] arr2={3,3,3,2,1};
//        method6(arr2);
        method7(arr2);
    }




     /*
    1.输入一个数组和一个值,寻找数组中任意两个数的和等于给定的值的下标,
    如果存在多对值,则任意输出一组就行
    核心：任意一个a[k],另一个值sum-a[k],可借鉴快排双指针的思想,最快的是
    借鉴哈希表
    */

     //{1,9,5,5,4,6} 10
     //暴力求解
     public static void method1(int[] arr, int sum){
        for(int i=0;i<arr.length;i++){
            for(int j=0; j<arr.length;j++){
                if(i != j && arr[j] == sum-arr[i]){
                    System.out.println("i:"+i+",j:"+j);
                    return;
                }
            }
        }
     }

     //推荐使用Hash表(key 存对象 确保唯一性)
    public static void method2(int[] arr, int sum){
         //集合
        Hashtable<Integer,Integer> hashtable = new Hashtable<>();
        /**
         * 快速数据访问： 哈希表通常允许在常数时间复杂度O(1)内插入和检索数据项，这是由于它使用哈希函数直接映射到数据的存储位置。
         * 高效的搜索： 与其他数据结构相比，如数组或链表，哈希表提供了更快的搜索速度。
         */
        // hashtable key存值 v存索引
        for(int i=0;i<arr.length;i++){
            hashtable.put(arr[i],i);
        }
        //一个是arr[i] 另一个是sum-arr[i]
        //arr[i]另一个是不是sum-arr[i]
        for(int i=0;i<arr.length;i++){
            int index=hashtable.get(sum-arr[i]);
            if(index!=-1&&index!=i){
                System.out.println("i:"+i+",j:"+index);
                return;
            }
        }


    }

    //快排思想 前后指针
    public static void method3(int[] arr, int sum){
         int l = 0;
         int r = arr.length-1;
         while(l!=r){
             if(arr[l]+arr[r]==sum){
                 System.out.println("i:"+l+",j:"+r);
                 return;
             }
             l++;
             r--;
         }
    }

    /*
     * 2.给定一个整型数组，里面的值有正有负（暂时认为0也是正数部分），
     * 现在请调整位置，把负数放在数组的左边，正数放在数组的右边
     * */
    //两次填充
    public static int[] method4(int[] arr){
        int[] result = new int[arr.length];
        int j = 0;
        //填充负数
        for(int i = 0; i<arr.length;i++){
            if(arr[i]<0){
                result[j++] = arr[i];
            }
        }
        //填充正数 包括0
        for(int i = 0; i<arr.length;i++){
            if(arr[i]>=0){
                result[j++] = arr[i];
            }
        }
        return result;
    }
    //借鉴快排
    public static int[] method5(int[] arr){
        int l = 0;
        int r = arr.length-1;
        while(l != r){
            if(arr[l]<0){
                l++;
            }
            if(arr[r]>=0){
                r--;
            }
            if(l<r){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        return arr;
    }

    /*
     * 3.在一个数组中，某一个元素的次数超过了数组长度的一半，
     * 请输出这个数字
     * */
    //排序，排完序相同的元素都在一块儿
    public static void method6(int[] arr){
        //快排
        quickSort2(0,arr.length-1,arr);
        int count = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[i] == arr[i-1]){
                count++;

            }else{
                if(count>arr.length/2){
                    System.out.println(arr[i-1]);
                    return;
                }else {
                    count=1;
                }
            }
        }
        /**
         * 我们是基于当前元素与下一个元素是否相同来决定是否增加计数或重置计数的。
         *
         * 但是，当我们到达数组的最后一个元素时，由于没有下一个元素与其进行比较，我们可能会错过检查这个最后一个元素的出现次数。
         */
        if(count>arr.length/2){
            System.out.println(arr[arr.length-1]);
            return;
        }else{
            System.out.println("不存在该数字");
        }
    }

    //快速升序
    public static void quickSort2(int left,int right,int[] arr){
        int i=left;
        int j=right;
        if(i>=j){
            return;
        }
        int k=arr[left];
        while(i!=j){
            //从前往后找出一个比基准值k大的,如果后面元素小于基准值，i++
            while(arr[i]<=k&&i<j){
                i++;
            }
            //从后往前找出一个比基准值k小的,如果前面元素大于等于基准值，j--
            while(arr[j]>k&&i<j){
                j--;
            }
            if(i<j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }

        }
        //i==j
        if(arr[i]<arr[left]){
            int temp=arr[i];
            arr[i]=arr[left];
            arr[left]=temp;
        }
        quickSort2(left,i-1,arr);
        quickSort2(i,right,arr);

    }

    //使用hash表 key存数字，value是出现的次数
    public static void method7(int[] arr){
        Hashtable<Integer,Integer> hashtable = new Hashtable<>();
        for(int i=0;i<arr.length;i++){
            int count=hashtable.containsKey(arr[i])?hashtable.get(arr[i]):1;
            if(count>arr.length/2){
                System.out.println(arr[i]);
                return;
            }else{
                hashtable.put(arr[i],count+1);
            }
        }
    }

    /**
     * 数组查询问题 能用hash表就用hash表
     */



}
