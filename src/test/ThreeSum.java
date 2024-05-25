package test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiang on 10/18/23 4:14 PM
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int sum = 0;
        List<List<Integer>> out = new ArrayList<>();
        if (nums.length < 3 && nums.length > 0) {
            return null;
        }
        if (nums.length == 3) {
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            if (sum == 0) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < nums.length; i++) {
                    list.add(nums[i]);
                }
                out.add(list);
                return out;


            }
        }
        if (nums.length > 3) {
            quickSort(nums, 0, nums.length - 1);
            int left = 0;
            int right = nums.length - 1;
            List<Integer> inlist = new ArrayList<>();
            for (int i = 0; i < nums.length - 1; i++) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    inlist.add(nums[i]);
                    inlist.add(nums[left]);
                    inlist.add(nums[right]);
                }
                left++;
                right--;
            }
            out.add(inlist);

        }
        return out;
    }



    public static void quickSort(int[] arr, int left, int right){

        int i = left;
        int j = right;

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

        quickSort(arr,left,i-1);
        quickSort(arr,i,right);
    }
}
