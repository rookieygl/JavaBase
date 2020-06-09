package com.ygl.collection.linklist.singlylink;

/**
 * @Author: open stack
 * @Author: ygl
 * @Date: 2020/4/7 18:48
 * @Desc:
 */
public class SinglyNode<E> {
	public E value;
	public SinglyNode<E> nextNode;

	public SinglyNode(E value) {
		this.value = value;
	}
}
