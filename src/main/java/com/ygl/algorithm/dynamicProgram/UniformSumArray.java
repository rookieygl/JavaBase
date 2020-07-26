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
//        splitArr(ints);
        int i = splitArrDynamic(ints);
        System.out.println(i);
    }

    /**
     * 等分数组
     *
     * @param arr 数组
     * @return
     */
    public static int splitArrDynamic(int[] arr) {
        //取等分值
        int sum = Arrays.stream(arr).sum();
        sum = sum / 2;

        int[][] dp = new int[arr.length + 1][sum + 1];

        //遍历所有元素
        for (int i = 1; i < arr.length + 1; ++i) {
            //最小值是1，那么等分数组最多包含sum.length个元素 决定了内圈循环
            for (int j = 1; j < sum + 1; ++j) {
                //能存下该数字
                if (j - arr[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i - 1]] + arr[i - 1]);
                    System.out.println("数组:" + Arrays.toString(dp[i]) + ", 最大值:[" + dp[i][j] + "]");
                }
            }
        }
        
        System.out.println(dp[arr.length][sum]);
        return sum - dp[arr.length][sum];
    }


    /**
     * 等分数组
     *
     * @param arr
     * @return
     */
    public static int splitArr(int[] arr) {
        int sum = 0;
        for (int anInt : arr) {
            sum += anInt;
        }
        int count = sum / 2;

        int[][] dp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            int[] tmpArr = new int[arr.length + 1];
            tmpArr[i] = arr[i];
            int tmpSum = 0;
            for (int j = arr.length - 1; j > 0; j--) {
                tmpArr[i + 1] = arr[j];
                if (i == j) {
                    continue;
                }
                tmpSum = tmpSum + arr[i] + arr[j];
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
