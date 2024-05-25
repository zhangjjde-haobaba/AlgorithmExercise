package sortAlgorithm;

/**
 * Created by jiang on 1/10/23 9:48 PM
 */
public class BubbleExercise {
    public static void main(String[] args) {
        int[] arr = {31,12,1,45,67,98,21,1};
        bubblesort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\t\t");
        }
    }
    //冒泡排序
    //有两个for循环组成 第一个for循环是比较的次数，第二个for循环是当前比较的元素个数
    public static void bubblesort(int[] arr){
        //比较的次数
        for(int i=0;i<arr.length;i++){
            //比较的元素
            //如果后面的元素比前面大降序排列
            //j<arr.length-i-1多-1是为了在判断时防止数组下标越界
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j+1]>arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

    }
}
