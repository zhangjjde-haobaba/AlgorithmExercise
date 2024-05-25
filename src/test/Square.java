package test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiang on 10/11/23 7:16 PM
 */
public class Square {
    public static void main(String[] args) {
        int[][] points = {{0,0},{0,1},{1,0},{1,1}};

        List<Double> distances = new ArrayList<>();

        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                distances.add(twoPointDistance(points[i],points[j]));
            }
        }

//        System.out.println(distances);
//        System.out.println(Math.sqrt(2));

        List<Double> new_distance = new ArrayList<>();

        for(int i=0;i<distances.size();i++){
            if(distances.get(i) == 1.0 || distances.get(i) == Math.sqrt(2)){
                new_distance.add(distances.get(i));
            }
        }

        if(distances.size() == new_distance.size()){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }


    }
    public static double twoPointDistance(int[] point1, int[] point2){
        return Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
    }
}
