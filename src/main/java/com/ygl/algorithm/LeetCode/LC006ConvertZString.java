package com.ygl.algorithm.LeetCode;

import org.springframework.boot.ansi.AnsiOutput;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project open sources
 * @Author: rookie_ygl
 * @DATE: 2020/8/1 19:25
 * @DESC: rookie stronger
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 **/
public class LC006ConvertZString {
    public static void main(String[] args) {
        String leetcodeishiring = convert("LEETCODEISHIRING", 3);
        System.out.println(leetcodeishiring);
    }

    /**
     * 通过从左向右迭代字符串，我们可以轻松地确定字符位于 Z 字形图案中的哪一行。
     * <p>
     * 算法
     * <p>
     * 我们可以使用 \text{min}( \text{numRows}, \text{len}(s))min(numRows,len(s)) 个列表来表示 Z 字形图案中的非空行。
     * <p>
     * 从左到右迭代 ss，将每个字符添加到合适的行。可以使用当前行和当前方向这两个变量对合适的行进行跟踪。
     *
     * @param s       字符串
     * @param numRows 转换行数
     * @return
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}
