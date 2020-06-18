package com.ygl.basic.algorithm.sort;

import java.util.Arrays;

/**
 * @USER: rookie_ygl
 * @DATE: 2020/6/1
 * @TIME: 23:00
 * @DESC: open stack
 **/
public class StackTreeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 8, 9, 10, 6};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆 下沉
     *
     * @param array       待调整的堆
     * @param parentIndex 需要下沉的父节点
     * @param length      堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        //temp 保存父节点的值 用于最后赋值
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            //如果有右孩子，且左孩子大与右孩子的值，则定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            //如果父节点大与任何一个孩子的值，则直接跳出
            if (temp >= array[childIndex]) {
                break;
            }

            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 堆排序 升序
     *
     * @param array 待调整堆
     */
    public static void heapSort(int[] array) {
        //把无序数组构建最大堆
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
        System.out.println(Arrays.toString(array));

        //循环删除堆顶元素，移到集合底部，调整结束就是排序好的数组
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            downAdjust(array, 0, i);
        }
    }
}
