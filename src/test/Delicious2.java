package test;

import java.util.Scanner;

/**
 * Created by jiang on 4/6/24 9:59 PM
 */
public class Delicious2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 行数
        int m = sc.nextInt(); // 列数

        int[][] cake = new int[n][m]; // 蛋糕矩阵
        int[] rowSum = new int[n]; // 每行的累积美味度
        int[] colSum = new int[m]; // 每列的累积美味度
        int totalSum = 0; // 蛋糕的总美味度

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int deliciousness = sc.nextInt();
                cake[i][j] = deliciousness;

                rowSum[i] += deliciousness; // 累加行美味度
                colSum[j] += deliciousness; // 累加列美味度
                totalSum += deliciousness; // 更新总美味度
            }
        }

        int minDiff = Integer.MAX_VALUE; // 初始化最小差值为最大整数

        // 计算通过水平切割获得的最小美味度差
        int tempSum = 0; // 临时累积值
        for (int i = 0; i < n - 1; i++) {
            tempSum += rowSum[i];
            int remainingSum = totalSum - tempSum; // 计算剩余部分的美味度
            minDiff = Math.min(minDiff, Math.abs(tempSum - remainingSum));
        }

        // 计算通过垂直切割获得的最小美味度差
        tempSum = 0;
        for (int j = 0; j < m - 1; j++) {
            tempSum += colSum[j];
            int remainingSum = totalSum - tempSum; // 计算剩余部分的美味度
            minDiff = Math.min(minDiff, Math.abs(tempSum - remainingSum));
        }

        // 输出最小的美味度差
        System.out.println(minDiff);

        sc.close();
//        对于一维数组，前缀和的每个元素prefixSum[i]代表了原数组arr[0]到arr[i]的和。
//        这样，当我们需要计算数组中任意区间[l, r]的和时，可以直接通过prefixSum[r] - prefixSum[l-1]得到，而无需进行显式的循环求和。
//行的前缀和：每个元素代表了从第一行到当前行的美味度总和。
//列的前缀和：每个元素代表了从第一列到当前列的美味度总和。
//        2 2 3
//        4 5 6
//        7 8 9
//        行的前缀和可能看起来如下（不考虑增加的1空间，直接计算）：
//
//        第一行：2 + 2 + 3 = 7
//        第二行：4 + 5 + 6 = 15 (加上第一行的和，变为22)
//        第三行：7 + 8 + 9 = 24 (加上前两行的和，变为46)
//        列的前缀和可能看起来如下（同样不考虑增加的1空间）：
//
//        第一列：2 + 4 + 7 = 13
//        第二列：2 + 5 + 8 = 15 (加上第一列的和，变为28)
//        第三列：3 + 6 + 9 = 18 (加上前两列的和，变为46)
//        通过预先计算这样的前缀和，我们可以快速获取任意切割方式下的两部分美味度之和，从而计算出美味度差异。

//        在使用前缀和数组时，数组中的每个元素具有特定的含义。假设我们有一个原始数组 arr 和一个前缀和数组 prefixSum。
//        在这种情况下，prefixSum 数组的每个元素代表了原始数组 arr 中，从第一个元素到当前索引位置元素的累积和。具体来说：
//
//        prefixSum[0] 总是等于 0，这是一个初始化值，用于简化后续的计算。
//        prefixSum[i] 代表原始数组 arr 中从第 0 个元素（arr[0]）到第 (i-1) 个元素的总和。换句话说，prefixSum[i] = arr[0] + arr[1] + ... + arr[i-1]。
//        举个例子，如果原始数组 arr = [3, 1, 4, 1, 5]，那么相应的前缀和数组 prefixSum 将会是：
//
//        prefixSum[0] = 0（初始化值）
//        prefixSum[1] = 3（即 arr[0]）
//        prefixSum[2] = 4（即 arr[0] + arr[1]）
//        prefixSum[3] = 8（即 arr[0] + arr[1] + arr[2]）
//        prefixSum[4] = 9（即 arr[0] + arr[1] + arr[2] + arr[3]）
//        prefixSum[5] = 14（即 arr[0] + arr[1] + arr[2] + arr[3] + arr[4]）
//        因此，前缀和数组的每一个元素都代表了从数组的开始到当前位置的所有元素的和。
//        这种方法允许我们快速计算原数组任意区间内元素的和，只需一个简单的减法操作，
//        即 prefixSum[j+1] - prefixSum[i] 就可以得到从 arr[i] 到 arr[j]（包含两端点）的和。
    }
}
