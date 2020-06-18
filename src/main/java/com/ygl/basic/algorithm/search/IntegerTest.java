package com.ygl.basic.algorithm.search;

/**
 * @Author: ydzy-report
 * @Author: ygl
 * @Date: 2020/5/12 15:19
 * @Desc:
 */
public class IntegerTest {
    private static int[] a = {1, 2, 3};
    private static int num = 2;

    public static void main(String[] args) {
    	//二分查找必须有序，如果元素重复，不保证元素位置
        int i = halFind(0, a.length - 1);
        System.out.println(i);
    }

    public static int halFind(int l, int r) {
        int mid = (l + r) / 2;
        if (l == r && a[l] != num)//二分到只有一个元素，但是没有想要查找的元素
            return -1;
        if (a[mid] == num)
            return mid;
        else if (a[mid] > num)
            return halFind(l, mid - 1);
        else if (a[mid] < num)
            return halFind(mid + 1, r);
        return 0;
    }
}
