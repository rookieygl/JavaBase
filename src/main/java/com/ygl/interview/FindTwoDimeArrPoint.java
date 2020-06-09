package com.ygl.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: open stack
 * @Author: ygl
 * @Date: 2020/4/16 17:04
 * @Desc:
 */
public class FindTwoDimeArrPoint {
	public static void main(String[] args) {
		int tdArr[][] = {{13, 67, 6, 3, 11}, {13, 13, 5, 11, 8},
						{10, 10, 10, 41, 41}, {2, 2, 10, 10, 33},
						{13, 10, 13, 22, 34}};

		print2DArray(tdArr);
		System.out.println("所有相邻且相等的点: ");
		find2DArrayByFor(tdArr, 2, 1);
	}

	/**
	 * 输出数组矩阵
	 *
	 * @param tdArr
	 */
	static void print2DArray(int tdArr[][]) {
		for (int i = 0; i < tdArr.length; i++) {
			for (int j = 0; j < tdArr[0].length; j++) {
				System.out.print(tdArr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * 查找二维数组相等且相连（步数为1）的点
	 * 遍历查找
	 *
	 * @param tdArr
	 * @param valueRow
	 * @param valueCol
	 */
	static void find2DArrayByFor(int tdArr[][], int valueRow, int valueCol) {
		int indexArr[][] = new int[tdArr.length * tdArr[0].length][];
		int findValue = tdArr[valueRow][valueCol];
		indexArr[0] = new int[]{valueRow, valueCol};
		int ka = 0;
		for (int rowIndex = 0; rowIndex < tdArr.length; rowIndex++) {
			for (int colIndex = 0; colIndex < tdArr[0].length; colIndex++) {
				if (tdArr[rowIndex][colIndex] == findValue) {
					for (int m = 0; m < indexArr.length; m++) {
						if (indexArr[m] != null) {
							int rowLen = Math.abs(rowIndex - indexArr[m][0]);
							int colLen = Math.abs(colIndex - indexArr[m][1]);
							if ((rowLen == 1 || colLen == 1) && (rowLen + colLen) <= 1) {
								indexArr[++ka] = new int[]{rowIndex, colIndex};
								System.out.print("(" + rowIndex + "," + colIndex + ")" +"\t");
								break;
							}
						}
					}
				}
			}
		}
	}

	/**
	 * 查找二维数组相等且相连（步数为1）的点
	 * 递归查找
	 *
	 * @param tdArr
	 * @param rowIndx
	 * @param colIndex
	 */
	static void find2DArray(int tdArr[][], int rowIndx, int colIndex) {
		List list = new ArrayList();
		list.add(rowIndx + colIndex);
		int findValue = tdArr[rowIndx][colIndex];
		if (rowIndx == 0 && colIndex == 0) {
			int rowNext = tdArr[rowIndx][colIndex + 1];
			if (rowNext == findValue) {
				find2DArray(tdArr, rowIndx, colIndex + 1);
			}
			int colNext = tdArr[rowIndx + 1][colIndex];
			if (colNext == findValue) {
				find2DArray(tdArr, rowIndx + 1, colIndex);
			}
		}
	}
}
