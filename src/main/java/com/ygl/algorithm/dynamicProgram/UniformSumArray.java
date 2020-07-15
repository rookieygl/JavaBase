package com.ygl.algorithm.dynamicProgram;

import java.util.Arrays;

/**
 * @Project open sources
 * @Author: rookie_ygl
 * @DATE: 2020/6/21 20:22
 * @DESC: rookie stronger
 **/
public class UniformSumArray {
    public static void main(String[] args) {
        int[] ints = new int[]{12, 8, 6, 9, 19, 17, 1};
        splitArr(ints);
    }

    /**
     * 等分数组
     *
     * @param data
     * @return
     */
    public static int splitArrDynamic(int[] data) {
        int sum = 0;
        for (int anInt : data) {
            sum += anInt;
        }
        int count = sum / 2;

        int[] dp = new int[data.length];
        for (int i = 0; i < data.length; i++) {
                // 状态转移方程
                dp[i] = Math.max(dp[i - 1], dp[i - 1] + dp[i]);
                System.out.println("物品:" + Arrays.toString(dp) + "价值:[" + dp[i] + "]");
        }

        return 0;
    }

    /**
     * 等分数组
     *
     * @param data
     * @return
     */
    public static int splitArr(int[] data) {
        int sum = 0;
        for (int anInt : data) {
            sum += anInt;
        }
        int count = sum / 2;

        int[][] dp = new int[data.length][data.length];
        for (int i = 0; i < data.length; i++) {
            int[] tmpArr = new int[data.length + 1];
            tmpArr[i] = data[i];
            int tmpSum = 0;
            for (int j = data.length - 1; j > 0; j--) {
                tmpArr[i + 1] = data[j];
                if (i == j) {
                    continue;
                }
                tmpSum = tmpSum + data[i] + data[j];
                if (tmpSum > count) {
                    break;
                }
            }
            dp[i] = tmpArr;
        }
        printDouoArr(dp);
        return 0;
    }


    /**
     * 输出数组和
     *
     * @param dp
     */
    public static void printDouoArr(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            int[] booleans = dp[i];
            for (int j = 0; j < booleans.length; j++) {
                int sum = 0;
                for (int anInt : dp[i]) {
                    sum += anInt;
                }
                System.out.println("总和" + sum + "数组" + Arrays.toString(dp[i]) + "\t");
            }
        }
    }
}
