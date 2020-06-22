package com.ygl.basic.algorithm.dynamicProgram;

import java.util.Arrays;

/**
 * @Project open sources
 * @Author: rookie_ygl
 * @DATE: 2020/6/21 20:51
 * @DESC: rookie stronger
 **/
public class KnapSpace {
    public static void main(String[] args) {
        int N = 3;     // 宝石个数
        int C = 10;    // 书包容量
        int V[] = {0, 5, 3, 4};       // 每个宝石的体积,这里前面的0是为了后面表示方便，即V[1]表示为第一个宝石的体积，下同
        int W[] = {0, 20, 10, 12};    // 每个宝石的价值
        int d[][] = new int[N + 1][C + 1];    // 状态数组

        d[0][C] = 0;
        for (int i = 1; i <= N; i++) {
            System.out.println("++++++++++++++++++"+i);
            for (int j = 1; j <= C; j++) {
                if (i > 0 && j >= V[i]) {
                    // 状态转移方程
                    d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - V[i]] + W[i]);
                    System.out.println("物品:" +Arrays.toString( d[i])  + "价值:[" + d[i][j] + "]");
                }
            }
        }
        print_array(d);
    }

    // 打印保存数据的二位数组
    public static void print_array(int[][] Arr) {
        for (int i = 1; i < Arr.length; i++) {
            for (int j = 1; j < Arr[i].length; j++) {
                System.out.print("[" + i + "]" + "[" + j + "]" + "当前价值" + Arr[i][j] + "\n");
            }
            System.out.println();
        }
    }
}
