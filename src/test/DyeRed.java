package test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jiang on 4/8/24 9:51 PM
 */
public class DyeRed {
    static boolean[] visited; // 标记节点是否被访问过
    static int redEdges = 0; // 记录可以染红的边的数量
    static int[] values; // 节点权值
    static ArrayList<Integer>[] graph; // 图的邻接表表示
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //结点数
        int n = sc.nextInt();
        //权值 列表
        values = new int[n + 1]; // 存储每个节点的权值，节点编号从1开始
        for (int i = 1; i <= n; i++) {
            values[i] = sc.nextInt();
        }

        // 创建邻接列表表示树
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 读取边信息
        /*
        *
        * 包含n个节点的树会有n-1条边（这是树的一个性质，即树是一个无环连通图，其边数总是比节点数少1）。
        * 因此，我们需要迭代n-1次来读取所有边的信息。循环变量i从0开始，一直迭代到n-2（包含），正好迭代了n-1次
        *
        * */
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }


        visited = new boolean[n + 1];
        dfs(1); // 假设根节点为1开始DFS

        System.out.println(redEdges); // 输出可以染红的边的数量


        sc.close();
    }
    //判断是否为完全平方数
//    static boolean isSquare(int n){
//        for(int i=1;i<=n/2;i++){
//            if(i*i == n){
//                return true;
//            }
//        }
//        return false;
//    }
    // 判断是否为完全平方数的更高效实现
    static boolean isSquare(int n) {
        int sqrt = (int)Math.sqrt(n);
        return sqrt * sqrt == n;
    }
    static void dfs(int node) {
        visited[node] = true;
        for (int next : graph[node]) {
            if (!visited[next]) {
                // 判断权值乘积是否为完全平方数
                if (isSquare(values[node] * values[next])) {
                    redEdges++; // 可以染红的边+1
                }
                dfs(next);
            }
        }
    }
}
