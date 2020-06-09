package com.ygl.algorithm.sort;

/**
 * @Author: open stack
 * @Author: ygl
 * @Date: 2020/5/7 22:47
 * @Desc:
 */
public class InsertSort {
	public static void main(String[] args) {
		int[] arr = {1, 6, 8, 7, 3, 5, 16, 4, 8, 36, 13, 44};
		insertSort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	/**
	 * 插入排序
	 * 是在一个已经有序的小序列的基础上，一次插入一个元素。
	 * 当然，刚开始这个有序的小序列只有1个元素，就是第一个元素。比较是从有序序列的末尾开始，
	 * 也就是想要插入的元素和已经有序的最大者开始比起，如果比它大则直接插入在其后面，
	 * 否则一直往前找直到找到它该插入的位置。如果碰见一个和插入元素相等的，
	 * 那么插入元素把想插入的元素放在相等元素的后面。所以，相等元素的前后顺序没有改变，
	 * 从原无序序列出去的顺序就是排好序后的顺序，所以插入排序是稳定的。
	 */
	public static void insertSort(int[] numbers) {
		int size = numbers.length;
		int temp = 0;
		int j = 0;
		for (int i = 0; i < size; i++) {
			temp = numbers[i];
			//假如temp比前面的值小，则将前面的值后移
			for (j = i; j > 0 && temp < numbers[j - 1]; j--) {
				numbers[j] = numbers[j - 1];
			}
			numbers[j] = temp;
		}
	}
}
