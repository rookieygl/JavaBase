package com.ygl.algorithm.LeetCode;

/**
 * @Project open sources
 * @Author: rookie_ygl
 * @DATE: 2020/7/21 23:37
 * @DESC: rookie stronger
 **/
public class FindMid {
    public static int findMid(int[] a1, int start1, int end1, int[] a2, int start2, int end2) {
        int i = start1 + (end1-start1)/2;
        int j = start2 + (end2-start2)/2;
        if(i == a1.length-1) return a1[i]; //a1数组中的数都小于a2[0]中的数，返回最末尾的值
        if(j == a2.length-1) return a2[j]; //a2数组中的数都小于a1[0]

        if(a1[i]<=a2[j] && a1[i+1]>=a2[j]) //a2[j]插入第N个位置
            return a2[j];
        if(a2[j]<=a1[i] && a2[j+1]>=a1[i]) //a1[i]插入第N个位置
            return a1[i];

        if(a1[i]<a2[j] && a1[i+1]<a2[j]){ //在a1的后半段和a2的前半段
            return findMid(a1,i+1,end1,a2,start2,j-1);
        }
        if(a2[j]<a1[i] && a2[j+1]<a1[i]){
            return findMid(a1,start1,i-1,a2,j+1,end2);
        }
        return -1;

    }

    public static void main(String[] args) {
        //int[] a1 = {1,2,3,4};
        //int[] a2 = {5,6,7,8};

        //int[] a1 = {1,2,3,4,9};
        //int[] a2 = {5,6,7,8,10};

        //int[] a1 = {1,2,5,6,9};
        //int[] a2 = {3,4,5,7,8};

        int[] a1 = {1,2,3};
        int[] a2 = {1,3,4};

        System.out.println(findMid(a1,0,a1.length-1,a2,0,a2.length-1));


    }
}
