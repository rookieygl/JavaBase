package com.ygl.algorithm.recite;

import java.util.Arrays;

/**
 * @Author: ydzy-report
 * @Author: ygl
 * @Date: 2020/5/22 10:07
 * @Desc:
 */
public class Recite {
	private static int count = 0;
	public static void main(String[] args) {
		int[] arr = {5, 7, 3, 9, 1, 2, 2, 0};
		System.out.println( "原数组: " + Arrays.toString(arr));
		qkSort(arr, 0, arr.length - 1);
	}

	private static void qkSort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}
		int left = start, right = end;
		int tmp = arr[left];
		while (left < right) {
			while (left < right && arr[right] >= tmp) {
				right--;
			}
			arr[left] = arr[right];

			while (left < right && arr[left] <= tmp) {
				left ++;
			}
			arr[right] = arr[left];
		}

		arr[left] = tmp;
		System.out.println(count++ + ": " + Arrays.toString(arr));
		qkSort(arr,start,left);
		qkSort(arr,left+1,end);
	}
}
