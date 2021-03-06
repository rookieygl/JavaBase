package com.ygl.algorithm.dynamicWindow;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/**
 * @Project open sources
 * @Author: rookie_ygl
 * @DATE: 2020/7/24 23:49
 * @DESC: rookie stronger
 * 删除出现最少的字符
 **/
public class DeleteMinChar {
    public static void main(String[] args) {
        String abcdaascb = deleteMinChar("abcdaascb");
        System.out.println(abcdaascb);
    }

    /**
     * 遍历字符串，存入map
     * 遍历map,去除出现最少的字符即可。
     *
     * @param s
     * @return
     */
    public static String deleteMinChar(String s) {
        HashMap<Character, Integer> cMap = new HashMap<>();
        char[] ch = s.toCharArray();
        for (char c : ch) {
            if (cMap.containsKey(c)) {
                cMap.put(c, cMap.get(c) + 1);
            } else {
                cMap.put(c, 1);
            }
        }


        //获取出现最少的字符串
        Collection<Integer> values = cMap.values();
        Integer min = Collections.min(values);

        StringBuffer stringBuffer = new StringBuffer();
        for (char c : ch) {
            if (!cMap.get(c).equals(min)) {
                stringBuffer.append(c);
            }
        }
        return String.valueOf(stringBuffer);
    }
}
