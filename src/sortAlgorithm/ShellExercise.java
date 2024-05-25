package sortAlgorithm;

/**
 * Created by jiang on 1/23/23 9:58 PM
 */
public class ShellExercise {
    public static void main(String[] args) {
        int[] arr = {31,12,1,45,67,98,21,-1,0,0};
        shellSortAsc(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\t\t");
        }
    }
    //希尔排序
    public static void shellSortAsc(int[] arr){
        int gap = arr.length/2;
        while(gap>=1){
            for(int i=gap;i<arr.length;i++){

                int temp = arr[i];
                int index = i-gap;
                while(index>=0 && arr[index]>temp){
                    arr[index+gap] = arr[index];
                    index=index-gap;
                }

                arr[index+gap] = temp;
            }
            gap = gap/2;
        }
    }
}
