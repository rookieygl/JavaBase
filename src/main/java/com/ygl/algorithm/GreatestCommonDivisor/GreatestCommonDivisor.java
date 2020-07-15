package com.ygl.algorithm.GreatestCommonDivisor;

/**
 * @Project open sources
 * @Author: rookie_ygl
 * @DATE: 2020/7/13 23:43
 * @DESC: rookie stronger
 * <p>
 * 求最大公约数
 * <p>
 * 结合欧几里得算法（辗转相处法）和九章算术
 * <p>
 * 欧几里得：两个正整数a和b（a>b） 他们的最大公约数等于a除以b的余数c和b之间的最大公约数
 **/
public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(getGCDByEA(100, 10));
    }

    /**
     * 欧几里得算法求最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    public static int getGCDByEA(int a, int b) {
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        if (big % small == 0) {
            return small;
        }

        return getGCDByEA(big % small, small);
    }

    /**
     * 九章算术获取最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    public static int getGCDByJiuZang(int a, int b) {
        if (a == b) {
            return a;
        }
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        return getGCDByJiuZang(big - small, small);
    }

}
