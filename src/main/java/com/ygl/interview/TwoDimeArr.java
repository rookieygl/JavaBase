package com.ygl.interview;

/**
 * @Author: open stack
 * @Author: ygl
 * @Date: 2020/4/14 17:26
 * @Desc:
 */
public class TwoDimeArr {
	public static void main(String[] args) {
		//矩阵反转
		int row = 5,//行数
				col = 6; //列数

		int tdArr[][] = new int[row][col];
		int num = 0;

		//数组赋值
		for (int i = 0; i < tdArr.length; i++) {
			for (int j = 0; j < tdArr[0].length; j++) {
				tdArr[i][j] = ++num;
			}
		}
		//打印输出
		print2DArray(tdArr);

		System.out.println("顺时针直线输出： ");
		clock2DArray(tdArr);
	}

	/**
	 * 输出数组矩阵
	 *
	 * @param tdArr
	 */
	static void print2DArray(int tdArr[][]) {
		for (int[] ints : tdArr) {
			for (int j = 0; j < tdArr[0].length; j++) {
				System.out.print(ints[j] + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * 顺时针输出数组
	 * 递归方式
	 *
	 * @param tdArr 目标数组
	 */
	private static void clock2DArray(int tdArr[][]) {
		//单元素二维数组
		if (tdArr[0].length == 1) {
			for (int i = 0; i < tdArr.length; i++)
				System.out.print(tdArr[i][0] + " ");
			return;
		}
		//单列二维数组
		else if (tdArr.length == 1 && tdArr[0].length != 1) {
			for (int i = 0; i < tdArr[0].length; i++)
				System.out.print(tdArr[0][i] + " ");
			return;
		} else if (tdArr.length > 1) {
			int row = tdArr.length;//行数
			int column = tdArr[0].length;//列数
			//遍历行
			for (int colIndex = 0; colIndex < column; colIndex++)
				System.out.print(tdArr[0][colIndex] + " ");

			//遍历列
			for (int rowIndex = 1; rowIndex < row; rowIndex++)
				System.out.print(tdArr[rowIndex][column - 1] + " ");

			//反向遍历行
			for (int i = column - 2; i >= 0; i--)
				System.out.print(tdArr[row - 1][i] + " ");

			//反向遍历列
			for (int i = row - 2; i >= 1; i--)
				System.out.print(tdArr[i][0] + " ");

			if (row - 2 > 0 && column - 2 > 0) {
				int subData[][] = new int[row - 2][column - 2];
				for (int i = 1; i < row - 1; i++)
					for (int j = 1; j < column - 1; j++)
						subData[i - 1][j - 1] = tdArr[i][j];
				clock2DArray(subData);
			}
		}
	}
}
