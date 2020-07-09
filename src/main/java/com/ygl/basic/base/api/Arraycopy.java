package com.ygl.basic.base.api;

/**
 * @Project: ydzy-report
 * @Author: ygl
 * @Date: 2020/7/9 16:03
 * @Desc:
 */
public class Arraycopy {
	public static void main(String[] args) {
		int[] formArray={1,2,3,4,0,0};
		/*添加的第一种方法 每个元素向后移一个格，给新来的腾出个地方

		System.arraycopy(src, srcPos, dest, destPos, length);

		src表示源数组

		srcPos表示源数组中拷贝元素的起始位置。

		dest表示目标数组

		destPos表示拷贝到目标数组的起始位置

		length表示拷贝元素的个数


		copy后原来位置的元素并没有改变，要做一定的处理，比如增加和删除操作
		* */
		System.arraycopy(formArray, 2, formArray, 1, 2);

		for (int i = 0; i < formArray.length; i++) {
			System.out.println("index" + i + ": " + formArray[i]);
		}
	}
}
