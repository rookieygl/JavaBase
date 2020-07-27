package com.ygl.algorithm.LeetCode.zjtd;

/**
 * @Project open sources
 * @Author: rookie_ygl
 * @DATE: 2020/7/26 20:56
 * @DESC: rookie stronger
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 **/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        longestCommonPrefix(new String[]{"flower", "flow", "flight"});
    }

    /**
     * 最长公共前缀
     * 将第一个字符和第二个字符去比较，保留相同前缀。
     * 依次比下去就是最长公共前缀，不存在就返回空。
     * <p>
     * 时间复杂度是0(s) s=数组所有的字符
     * 空间负债度是O(1)
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        //取出第一个元素
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if (ans.equals("")) {
                return ans;
            }
        }
        return ans;
    }
}