package com.ygl.algorithm.sort;

import java.util.Arrays;

/**
 * @USER: rookie_ygl
 * @DATE: 2020/6/1
 * @TIME: 23:00
 * @DESC: open stack
 *
 * 堆排序的数据结构是根堆
 *
 * 从小到大排 就是大根堆。从大到小，就是小根堆
 *
 * 大根堆存在 arr[i]>=arr[2i+1] && arr[2i+2]
 *
 * 左右节点占一个元素，为空也占位
 **/
public class StackTreeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 2, 10, 4, 5, 6, 1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序 升序
     *
     * @param array 待调整堆
     */
    public static void heapSort(int[] array) {
        //把无序数组构建最大堆
        //寻找非叶子节点，只有非叶子节点需要调整
        //根据二叉树的特性，非叶子节点是n/2
        for (int i = (array.length) / 2 - 1; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
        //输出最大堆
        System.out.println(Arrays.toString(array));

        //倒叙遍历数组，循环删除堆顶元素，与数组尾部元素交换，
        //调整结束就是排序好的数组
        for (int i = array.length - 1; i > 0; i--) {
            //尾部元素和头部元素交换
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            //下沉调整最大堆
            downAdjust(array, 0, i);
        }
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

        //防止角标越界
        while (childIndex < length) {
            //如果有右孩子，且左孩子大于右孩子的值，则定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }

            //如果父节点大与任何一个孩子的值，则直接跳出
            if (temp >= array[childIndex]) {
                break;
            }

            //如果父节点不是最大，就和当前子节点交换位置
            //一次能确定一个父节点和两个子节点
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }
}
