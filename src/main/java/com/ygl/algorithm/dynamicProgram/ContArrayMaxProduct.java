package com.ygl.algorithm.dynamicProgram;

/**
 * @Project: ydzy-report
 * @Author: ygl
 * @Date: 2020/7/22 10:24
 * @Desc: 连续数组最大乘积
 */
public class ContArrayMaxProduct {
	public static void main(String[] args) {
		//System.out.println(Math.max(0,5));
		//System.out.println(Integer.MAX_VALUE);
		//System.out.println(Integer.MIN_VALUE);
		int arrayMaxProduct = getArrayMaxProduct(new int[]{1, 8, -5, 0});
		System.out.println(arrayMaxProduct);

	}

	private static int getArrayMaxProduct(int[] arr) {
		int dpMax = arr[0], dpMin = arr[0],result = arr[0];
		for (int i = 1; i < arr.length; i++) {
			//if (arr[i] < 0) {
			//	dpMax = dpMax + dpMin;
			//	dpMin = dpMax - dpMin;
			//	dpMax = dpMax - dpMin;
			//}

			dpMax = Math.max(Math.max(dpMax * arr[i], dpMin * arr[i]), arr[i]);
			dpMin = Math.min(Math.min(dpMax * arr[i], dpMin * arr[i]), arr[i]);
			result = Math.max(result,dpMax);
		}

		return result;
	}

}
