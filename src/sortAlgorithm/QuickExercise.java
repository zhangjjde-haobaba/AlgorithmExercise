package sortAlgorithm;

/**
 * Created by jiang on 1/14/23 12:26 AM
 */
public class QuickExercise {
    public static void main(String[] args) {
        int[] arr = {31,12,1,45,67,98,21,1};
//        quickSort2(0,arr.length-1,arr);
        quickSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\t\t");
        }
    }
    //快速排序--使用双指针
    //1.从数列中挑出一个元素，称为 "基准"（pivot）默认arr[left]为基准值;
    //2.重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
    // 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
    //3.递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；

    //定义一个规则：大的往前放，从前往后找小的，从后往前找大的
    //arr[i]>=arr[left] i++ 从前往后
    //arr[j]<=arr[left] j-- 从后往前
    public static void quickSort(int[] arr, int left, int right){
        //基准值arr[left]
        int i = left;
        int j = right;
        //i一定不能大于j, i也不能等于j(i=j的时候需要交换基准值和其他数值)
        if(i>=j){
            return;
        }
        //定义基准值
        int key = arr[i];
        //定义一个规则：大的往前放，从前往后找小的，从后往前找大的
        while(i!=j){
            //从前往后，找出一个比基准值key小的(大于key的指针往后走)
            //>=的原因是arr[i]第一个元素就是key没有等于的话直接卡死
            while(arr[i]>=key&&i<j){
                i++;
            }
            while(arr[j]<key&&i<j){
                j--;
            }
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
        //当i和j相等时，及两个指针都走到同一处的时候
        if(i==j){
            //规则是从大到小排列，如果基准值key小于arr[i]则交换两个
            if(key<arr[i]){
                int temp = arr[left];
                arr[left] = arr[i];
                arr[i] = temp;
            }
        }
        //对左右两部分进行排序
        //左部分下标left-->i
        //右部分下标i+1-->right
        quickSort(arr,left,i-1);
        quickSort(arr,i,right);
    }

    //快速排序--使用双指针
    //1.从数列中挑出一个元素，称为 "基准"（pivot）默认arr[left]为基准值;
    //2.重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
    // 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
    //3.递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；

    //定义一个规则：升序


    public static void quickSort2(int left, int right, int[] arr){
        int i = left;
        int j = right;
        //i一定不能大于j, i也不能等于j(i=j的时候需要交换基准值和其他数值)
        if(i>=j){
            return;
        }
        //基准值arr[left]
        int k = arr[left];
        while(i!=j){
            //升序
            //从前往后，找出一个比基准值k大的，如果前面元素大于等于k, i++
            while(arr[i]<=k && i<j){
                i++;
            }
            //从后往前，找出一个比基准值k小的,如果后面元素小于基准值j--
            while(arr[j]>k&&i<j){
                j--;
            }
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
        //i==j
        if(arr[i]<k){
            int temp = arr[i];
            arr[i] = arr[left];
            arr[left] = temp;
        }
        //对左右两部分进行排序
        //左部分下标left-->i-1
        //右部分下标i-->right
        quickSort2(left,i-1,arr);
        quickSort2(i,right,arr);

    }
}
