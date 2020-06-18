package com.ygl.basic.algorithm.search;

import java.util.Arrays;

/**
 * @Author: ydzy-report
 * @Author: ygl
 * @Date: 2020/5/21 18:23
 * @Desc:
 */
public class BinarySearch {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(args));
		int[] arr = {2,2,2,1};

		//System.out.println(binarySearch(arr, 0, arr.length - 1, 2));
		System.out.println(Arrays.binarySearch(arr, 2));
	}
	private static int binarySearch(int[] a, int fromIndex, int toIndex, long key){
		int low = fromIndex;
		int high = toIndex - 1;

		while (low <= high) {
			int mid = (low + high)/2;
			long midVal = a[mid];

			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1);  // key not found.
	}
}
