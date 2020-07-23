package com.ygl.algorithm;

/**
 * @Project open sources
 * @Author: rookie_ygl
 * @DATE: 2020/7/20 23:05
 * @DESC: rookie stronger
 *
 * 判断一个数是否为2的整数次幂
 **/
public class ISPowerOf2 {
    public static void main(String[] args) {
        System.out.println(isPowerOf2(256));
        System.out.println(0&1);
        System.out.println(0|1);
        System.out.println(1|0);
    }

    /**
     *一个整数num是2的整数次幂，转成二进制时，只有最高位为1，其余位为0
     * 而该整数减1，转成二进制，所有位位1
     *
     * 那么(num & num - 1)==0
     *
     * 比如
     *    二进制 减1二进制  (num & num - 1)
     * 8  1000   111       0
     * 0&1 = 0 0&0 = 1
     * @param num
     * @return
     */
    public static boolean isPowerOf2(int num) {
        return (num & num - 1) == 0;
    }
}
