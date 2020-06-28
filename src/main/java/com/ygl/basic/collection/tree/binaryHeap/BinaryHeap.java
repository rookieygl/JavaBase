package com.ygl.basic.collection.tree.binaryHeap;

import java.util.Arrays;

/**
 * @Project open sources
 * @Author: rookie_ygl
 * @DATE: 2020/6/28 22:53
 * @DESC: rookie stronger
 * <p>
 * 构建最小堆
 **/
public class BinaryHeap {
    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0};
        upAjust(array);
        System.out.println(Arrays.toString(array));
        array = new int[]{7, 1, 2, 10, 2, 8, 9, 6};
        buildHeap(array);
        System.out.println(Arrays.toString(array));

    }

    public static void buildHeap(int[] array) {
        //从最后一个非叶子节点开始，一次做下沉调整
        for (int i = 0; i < array.length / 2 - 1; i++) {
            downAdjust(array, i, array.length);
        }

    }

    /**
     * 上浮调整
     *
     * @param array 待调整的堆
     */
    public static void upAjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        //tmp保存插入的叶子节点的值，用于最后的赋值
        int tmp = array[childIndex];
        while (childIndex > 0 && tmp < array[parentIndex]) {
            //无需真正交换，单向赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = tmp;
    }

    /**
     * 下沉调整
     * @param array 待调整的堆
     * @param parentIndex 需要下沉的父节点
     * @param length 堆长度
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        //tmp保存父节点的值,用于最后的赋值
        int tmp = array[parentIndex];
        //获取当前父节点的左孩子
        int childIndex = 2 * parentIndex + 1;

        //叶子节点存在，则继续循环
        while (childIndex < length) {
            //如果存在右孩子，且右孩子小于左孩子的值，定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }

            //如果父节点，小于任何一个孩子的值，直接跳出
            if (tmp > array[childIndex]) {
                break;
            }
            //如果父节点小于子节点，需要调整父节点位置
            //无需交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;

        }
        //最后赋值
        array[parentIndex] = tmp;
    }
}
