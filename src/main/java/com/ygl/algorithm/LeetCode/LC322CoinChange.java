package com.ygl.algorithm.LeetCode;

import java.util.Arrays;

/**
 * @Project open sources
 * @Author: rookie_ygl
 * @DATE: 2020/7/30 19:58
 * @DESC: rookie stronger
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 **/
public class LC322CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }

    /**
     *动态规划找零钱
     *
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        //动态数组赋值
        Arrays.fill(dp, amount + 1);

        //当amount为零，那么硬币数也是0
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                //硬币满足小于amount条件
                if (coin <= i) {
                    //当前amount减去硬币面值，加1就是当前硬币的组合
                    dp[i] = Math.min(dp[i],  dp[i - coin]+ 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
