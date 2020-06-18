package com.ygl.basic.algorithm.sort;

import java.util.Arrays;

public class QuickSort {
	private static int count = 0;
	public static void main(String[] args) {

		//int[] arr = {30,7,1,8,3,2,20};
		int[] arr = {7,6,5,4,3,2,1};
		QKSort(arr, 0, arr.length - 1);
	}

	/**
	 * 快速排序是（挖坑法）是挖坑填数 + 分治来实现。
	 * 先从数列中取出一个数作为基准数。
	 * 分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
	 * 再对左右区间重复第二步，直到各区间只有一个数。
	 *
	 * @param arr
	 * @param start
	 * @param end
	 */
	private static void QKSort(int[] arr, int start, int end) {
		/*条件判断*/
		if (start >= end) {
			return;
		}
		int left = start, right = end;

		//最左端元素为基元
		int temp = arr[left];

		//基元比较，在循环结束后基元插入数据，作为二分的基准点。
		while (left < right) {
			//最右端查找，比基元大的元素，不动，坐标左移，继续寻找比基元小的元素
			while (left < right && arr[right] >= temp) {
				right--;
			}

			//1、找到比基元小的，该元素赋值给基元位置，也就是最左端
			//2、未发现比基元小的元素，最右端元素放到基元位置，也就是最左端
			arr[left] = arr[right];

			//最左端查找，比基元小的元素，不动，坐标右移，寻找比基元大的元素
			while (left < right && arr[left] <= temp) {
				left++;
			}

			//1、找到比基元小的，左移互换，继续循环。直到左边都比基元小
			//2、未发现比基元小的元素，基元移动到最右端，也就是left==right 结束循环，此时是最坏的情况，那就是最大数在最左端
			arr[right] = arr[left];

		}
		//基元重回数组
		arr[left] = temp;
		QKSort(arr, start, left - 1);
		QKSort(arr, left + 1, end);
		System.out.println(++count);
		System.out.println(Arrays.toString(arr));
	}
}