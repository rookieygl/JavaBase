package com.ygl.algorithm;

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
 * 欧几里得：两个正整数a和b（a>b），他们的最大公约数等于a除以b的余数c和b之间的最大公约数
 *
 * 九章算术：两个正整数a和b（a>b），他们的最大公约数等于a-b的差值c和较小数b的最大公约数。
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
     * @param a 参数
     * @param b 参数
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

    /**
     * 欧几里得和九章算术结合
     *
     * 偶数的最低位一定是0
     * 奇数的最低位一定是1
     * 所以如果要判断这个数是奇数还是偶数，只要用这个数按位与1就可以了。
     * 如果结果为1，那么就是奇数，如果结果为0，那么结果就是偶数。
     *
     * 该运算效率比与2取模效率高跟多。
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a,int b){
        //a==b 互为最大公约数
        if (a==b) {
            return a;
        }

        //a，b均为偶数时，gcd=2xgcd(a/2,b/2)=gcd(a>>1,b>>1)<<1
        if ((a&1)==0 && (b&1)==0){
            return gcd(a>>1,b>>1)<<1;


        //如果a为偶数，b为奇数时，gcd=gcd(a/2,b)=gcd(a>>1,b)
        }else if ((a&1)==0 && (b&1)!=0){
            return gcd(a>>1,b);
        }else if ((a&1)!=0&& (b&1)==0){
            return gcd(a,b>>1);

        //a,b均为奇数时，利用更相减损术运算一次，此时a-b，必然是偶数，继续进行位移运算
        }else {
            int big = a>b?a:b;
            int small = a<b?a:b;
            return gcd(big-small,small);
        }
    }

}
