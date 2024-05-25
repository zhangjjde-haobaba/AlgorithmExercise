package sortAlgorithm;

/**
 * Created by jiang on 1/11/23 6:07 PM
 */
public class SelectExercise {
    public static void main(String[] args) {
        int[] arr = {31,12,1,45,67,98,21,1};
        selectSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\t\t");
        }
    }
    //选择排序
    /*
    * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。

      再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
      *
      * 两层for循环:
      *     外层for:无序区的起始
      *     里层for:找出无序区最小(大)的元素
    * */
    public static void selectSort(int[] arr){
        //第一次比较，数组没有有序区，整个数组都是无序区
        for(int i=0;i<arr.length;i++){
            //默认arr[i]是无序区最小的元素, i之后是无序区 i之前是有序区
            int smallest = i;
            for(int j=i;j<arr.length;j++){
                if(arr[j]<arr[smallest]){
                    smallest = j;
                }
            }
            if(i!=smallest){
                int temp = arr[smallest];
                arr[smallest] = arr[i];
                arr[i] = temp;
            }

        }

    }
}
