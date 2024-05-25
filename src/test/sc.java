package test;

import java.util.Scanner;

/**
 * Created by jiang on 4/5/24 8:42 PM
 */
public class sc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int station = Integer.parseInt(sc.nextLine());
        String[] arr = sc.nextLine().split(" ");
        int[] array = new int[station];
        int total_distance = 0;
        for(int i=0;i<arr.length;i++){
            array[i] = Integer.parseInt(arr[i]);
            total_distance+=array[i];
        }
        String[] xy = sc.nextLine().split(" ");
        int start = Integer.parseInt(xy[0]);
        int end = Integer.parseInt(xy[1]);

        sc.close();
        //计算顺时针
        int clockwise = 0;
        for(int i=start-1; i!=end-1; i=(i+1)%station){
            clockwise += array[i];
        }

        //逆时针
        int reverseclock = total_distance - clockwise;

        System.out.println(clockwise<reverseclock?clockwise:reverseclock);

    }
}
