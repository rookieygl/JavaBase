package com.ygl.algorithm.dynamicProgram;

import java.util.Arrays;

/**
 * @Project open sources
 * @Author: rookie_ygl
 * @DATE: 2020/7/26 0:03
 * @DESC: rookie stronger
 **/
public class test {
    public static int match(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        int len = arr.length;
        int halfOfSum = sum / 2;
        // 确定矩阵二维定义：第一维代表前i个物体，i可为0；第二维代表从0开始的连续容量值
        // 确定矩阵长宽，并初始化。因为矩阵第一维和第二维都是从0开始，所以要加一;
        int[][] matrix = new int[len + 1][halfOfSum + 1];

        //arr的下标，是否与matrix的下标冲突:是的
        //matrix[i][j]定义：用前i个物体装容量为j的背包能够装下的最大值
        //arr[i]定义：第i+1个物体的大小，所以arr[i-1]才是第i个物体的大小
        //遍历从矩阵边界开始（不包括边界），所以i = 1， j = 1
        for (int i = 1; i < len + 1; i++) {
            for (int j = 1; j < halfOfSum + 1; j++) {
                //如果第i件物体装进背包
                //备注：j - arr[i-1] >= 0防止下标为负
                if (j - arr[i - 1] >= 0) {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - arr[i - 1]] + arr[i - 1]);
                }
            }
        }

        for (int[] ints : matrix) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + "\t");
            }
            System.out.println("");
        }
        System.out.println(matrix[len][halfOfSum]);
        return sum - matrix[len][halfOfSum] * 2;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int value = match(arr);
        System.out.println(value);
    }

}
