package sortAlgorithm;

/**
 * Created by jiang on 1/18/23 11:33 PM
 */
public class InsertExercise {
    public static void main(String[] args) {
        int[] arr = {31,12,1,45,67,98,21,-1,0,0};
        insertSortAsc(arr);
        for(int i:arr){
            System.out.print(i+"\t\t");
        }
    }
    //插入排序(升序)
    public static void insertSortAsc(int[] arr){
        //i从1开始 因为默认第一个元素已经排序了
        for(int i=1;i<arr.length;i++){
            //定义一个变量存储arr[i]这个值 因为index是i-1如果arr[index]>arr[i] 要arr[index+1] = arr[index] index+1就是i arr[i]会被覆盖
            int temp = arr[i];
            int index = i-1;
            while(index>=0 && arr[index]>temp){
                arr[index+1] = arr[index];
                index--;
            }
            //如果arr[index]<temp的时候
            arr[index+1] = temp;
        }
    }
}
