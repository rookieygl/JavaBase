package com.ygl.algorithm.LeetCode;

/**
 * @Project open sources
 * @Author: rookie_ygl
 * @DATE: 2020/7/26 11:38
 * @DESC: rookie stronger
 * <dp>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <dp>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <dp>
 * ab不是回文 aba是回文
 **/
public class LC005LongestPalindromeSubString {
    public static void main(String[] args) {
        String abcda = longestPalindromeByDP("abcda");
        System.out.println(abcda);
    }

    /**
     *动态规划求解
     *
     * @param s
     * @return
     */
    public static String longestPalindromeByDP(String s) {
        int sLen = s.length();
        int maxLen = 0;
        String ans = "";
        boolean[][] dp = new boolean[sLen][sLen];
        // 遍历所有长度
        for (int len = 1; len <= sLen; len++) {
            for (int start = 0; start < sLen; start++) {
                //枚举子串的起始位置start，这样可以通过 end=start + len - 1 得到子串的结束位置
                int end = start + len - 1;
                // 下标越界，结束循环
                if (end >= sLen) {
                    break;
                }
                dp[start][end] = (len == 1 || len == 2 || dp[start + 1][end - 1]) && s.charAt(start) == s.charAt(end);

                if (dp[start][end] && len > maxLen) {
                    maxLen = len;
                    ans = s.substring(start, end + 1);
                }

            }
        }
        return ans;
    }


    /**
     * 中心扩散
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);

            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len-1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public static  int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return (R-1) - (L+1) + 1;
    }
}
