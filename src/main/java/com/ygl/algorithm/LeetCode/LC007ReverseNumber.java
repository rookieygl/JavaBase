package com.ygl.algorithm.LeetCode;

/**
 * @Project open sources
 * @Author: rookie_ygl
 * @DATE: 2020/8/1 19:31
 * @DESC: rookie stronger
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 **/
public class LC007ReverseNumber {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE+8);
        System.out.println(reverse(123));
    }

    /**
     * 十进制，除以10，余数乘10反转
     *
     * 注意数值溢出
     *
     * @param x num
     * @return
     */
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;

            //余数按照十进制组合
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
