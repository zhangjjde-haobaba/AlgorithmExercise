package structureArrayAndList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jiang on 10/21/23 4:40 PM
 */
public class TwoNumIntersection {
    public static void main(String[] args) {
        int nums1[] = {1,2,2,1};
        int nums2[] = {2,2};
        int[] arr = intersect(nums1,nums2);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> num1map = new HashMap<>();
        HashMap<Integer, Integer> num2map = new HashMap<>();

        for(int i=0;i<nums1.length;i++){
            if(num1map.containsKey(nums1[i]) == false){
                num1map.put(nums1[i],1);
            }else{
                int count = num1map.get(nums1[i]);
                count++;
                num1map.put(nums1[i],count);
            }

        }

        System.out.println(num1map);

        for(int i=0;i<nums2.length;i++){
            if(num2map.containsKey(nums2[i]) == false){
                num2map.put(nums2[i],1);
            }else{
                int count = num2map.get(nums2[i]);
                count++;
                num2map.put(nums2[i],count);
            }

        }

        List<Integer> result = new ArrayList<>();
        for (int key : num1map.keySet()) {
            if (num2map.containsKey(key)) {
                int count = Math.min(num1map.get(key), num2map.get(key));
                for (int i = 0; i < count; i++) {
                    result.add(key);
                }
            }
        }

        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }

        return arr;
    }

}
