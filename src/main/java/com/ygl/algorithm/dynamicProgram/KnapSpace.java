package com.ygl.algorithm.dynamicProgram;

import java.util.Arrays;

/**
 * @Project open sources
 * @Author: rookie_ygl
 * @DATE: 2020/6/21 20:51
 * @DESC: rookie stronger
 **/
public class KnapSpace {
    static int value[] = {0, 5, 3, 4};       // 每个宝石的体积,这里前面的0是为了后面表示方便，即V[1]表示为第一个宝石的体积，下同
    static int weight[] = {0, 20, 10, 12};    // 每个宝石的价值
    static int capacity = 10;    // 书包容量
    static int number = value.length - 1;     // 宝石个数
    static int dp[][] = new int[value.length][capacity + 1];    // 状态数组
    static int[] item = new int[value.length];

    public static void main(String[] args) {

        dp[0][capacity] = 0;
        for (int i = 1; i <= number; i++) {
            System.out.println("++++++++++++++++++" + i);
            for (int j = 1; j <= capacity; j++) {
                if (i > 0 && j >= value[i]) {
                    // 状态转移方程
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - value[i]] + weight[i]);
                    System.out.println("物品:" + Arrays.toString(dp[i]) + "价值:[" + dp[i][j] + "]");
                }
            }
        }
        print_array(dp);
        findBest(value.length - 1, capacity);
    }

    // 打印保存数据的二位数组
    public static void print_array(int[][] Arr) {
        for (int i = 1; i < Arr.length; i++) {
            for (int j = 1; j < Arr[i].length; j++) {
                System.out.print("[" + i + "]" + "[" + j + "]" + "当前价值" + Arr[i][j] + "\number");
            }
            System.out.println();
        }
    }

    public static void findBest(int i, int j) {
        if (i > 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                item[i] = 0;
                findBest(i - 1, j);
            } else if (j - weight[i] >= 0 && dp[i][j] == dp[i - 1][j - weight[i]] + value[i]) {
                item[i] = 1;
                findBest(i - 1, j - weight[i]);
            }
        }
        System.out.println(Arrays.toString(item));
    }
}
