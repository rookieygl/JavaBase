package com.ygl.algorithm.dynamicWindow;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Project open sources
 * @Author: rookie_ygl
 * @DATE: 2020/7/25 0:01
 * @DESC: rookie stronger
 * <p>
 * <p>
 * 滑动窗口，判断字符串是否可以组成回文
 **/
public class IsPalindromeString {

    public static void main(String[] args) {
        System.out.println(isPalindromeString("abcbaa"));
    }

    /**
     *滑动窗口，记录字符出现的个数
     *
     * 奇数字符只能允许出现一次，超出则无法组成回文字符串
     *
     * @param s
     * @return
     */
    public static boolean isPalindromeString(String s) {
        HashMap<Character, Integer> cMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            cMap.put(aChar, cMap.getOrDefault(aChar, 0) + 1);
        }

        int noPalindrome = 0;
        Collection<Integer> values = cMap.values();
        for (Integer value : values) {
            if ((value & 1) != 0) {
                noPalindrome++;
                if (noPalindrome > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
