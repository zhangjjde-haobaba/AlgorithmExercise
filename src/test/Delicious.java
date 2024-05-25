package test;

import java.util.Scanner;

/**
 * Created by jiang on 4/5/24 9:21 PM
 */
public class Delicious {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nm = sc.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] cake = new int[n][m];
        int sum = 0;
//        for(int i=0;i<n;i++){
//            String[] line = sc.nextLine().split(" ");
//            int[] row = new int[m];
//            for(int k=0;k<line.length;k++){
//                row[k] = Integer.parseInt(line[k]);
//            }
//            for(int j=0;j<m;j++){
//                cake[i][j] = row[j];
//                sum+=cake[i][j];
//            }
//        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                cake[i][j] = sc.nextInt();
                sum += cake[i][j];
            }
        }
        sc.close();
        int min = Integer.MAX_VALUE;
        // 水平切割，计算从第0行到第i行的美味度
        int s1 = 0; // 切割线上方的美味度
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                s1 += cake[i][j];
            }
            int diff = Math.abs(sum - 2 * s1); // 计算两边美味度之差的绝对值
            min = Math.min(min, diff); // 更新最小差值
        }

        // 重置s1为0，以便重新用于垂直切割
        s1 = 0;
        // 垂直切割，计算从第0列到第i列的美味度
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                s1 += cake[j][i];
            }
            int diff = Math.abs(sum - 2 * s1);
            min = Math.min(min, diff); // 更新最小差值
        }

        System.out.println(min);
    }
}
