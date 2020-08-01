package com.ygl.algorithm.dynamicProgram;

import java.util.Arrays;

/**
 * @Project open sources
 * @Author: rookie_ygl
 * @DATE: 2020/6/21 20:51
 * @DESC: rookie stronger
 * <p>
 * 背包问题
 **/
public class KnapSpace {
    static int[] weight = {5, 3, 4};       // 每个宝石的体积,这里前面的0是为了后面表示方便，即V[1]表示为第一个宝石的体积，下同
    static int[] value = {20, 10, 12};    // 每个宝石的价值
    static int capacity = 10;    // 书包容量
    static int[][] dp = new int[value.length + 1][capacity + 1];    // 状态数组

    public static void main(String[] args) {
        dp[0][capacity] = 0;
        //遍历物品个数
        for (int i = 1; i < value.length; i++) {
            //寻找最优解
            for (int j = 1; j < capacity; j++) {
                if (j >= weight[i]) {
                    //状态转移方程
                    //dp[i - 1][j - weight[i]] 对应的物品所剩余空间
                    //dp[i - 1][j - weight[i]] + value[i] 加入该物品和对应剩余空间的价值
                    //Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]) 比较加入物品，是否是最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                    System.out.println("物品:" + Arrays.toString(dp[i]) + ", 价值:[" + dp[i][j] + "]");
                }else {
                    //这次循环放不下该物品，取上次遍历对应结果的最大值
                    //这个步骤可以省略
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        print_array(dp);
    }

    /**
     * 打印保存数据的二位数组
     *
     * @param Arr
     */
    public static void print_array(int[][] Arr) {
        for (int i = 1; i < Arr.length; i++) {
            for (int j = 1; j < Arr[i].length; j++) {
                System.out.print("[" + i + "]" + "[" + j + "]" + "当前价值" + Arr[i][j] + "\n");
            }
            System.out.println();
        }
    }

//    public static void findBeat(int i, int j,int[] dp ){
//        if (i >= 0) {
//            if (dp[i][j] == dp[i - 1][j]) {
//                item[i] = 0;
//                findWhat(i - 1, j);
//            }
//            else if (j - w[i] >= 0 && dp[i][j] == dp[i - 1][j - w[i]] + v[i]) {
//                item[i] = 1;
//                findWhat(i - 1, j - w[i]);
//            }
//        }
//    }
}
