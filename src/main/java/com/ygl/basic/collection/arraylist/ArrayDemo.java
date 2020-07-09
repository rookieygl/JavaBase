package com.ygl.basic.collection.arraylist;

/**
 * @Author: ygl
 * @Date: 2020/4/3 15:59
 * @Desc:
 */
public class ArrayDemo<E> {

	private E[] data; //数组生命
	private int size; //数组的个数

	//构造函数，传入数组的容量capacity构造Array
	public ArrayDemo(int capacity) {
		data = (E[]) new Object[capacity];
		size = 0;
	}

	//无参数的构造函数，默认数组的容量capacity=10
	public ArrayDemo() {
		this(10);
	}

	public static void main(String[] args) {
		ArrayDemo<Integer> arrayDemo = new ArrayDemo<Integer>(10);

		for (int i = 0; i < 15; i++) {
			arrayDemo.add(i, i);
		}
		arrayDemo.set(10, 666);
		for (int i = 0; i < arrayDemo.size; i++) {
			System.out.println("index" + i + ": " + arrayDemo.getByIndex(i));
		}
	}

	/*向数组指定添加元素*/
	public void add(int index, E e) {
		// index 校验
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("add is fail,require index < 0 || index >size");
		}
		//当数组满 扩容为数组长度的两倍
		if (data.length == size) {
			this.resize(data.length * 2);
		}
		//给新元素，挪动一个位置
		System.arraycopy(data, index, data, index + 1, size - index);

		//新来的进坑
		data[index] = e;
		//维护size
		size++;
	}

	/*数组扩容和map扩容一样耗时 时间复杂度是O(n)*/
	private void resize(int newCapacity) {
		E[] newData = (E[]) new Object[newCapacity];
		if (size >= 0) System.arraycopy(data, 0, newData, 0, size);
		//data 重新赋值
		data = newData;
	}


	//数组第一位添加元素
	public void addFirst(E e) {
		//直接调用add方法
		this.add(0, e);
	}

	//数组最后一位添加元素
	public void addLast(E e) {
		//直接调用add方法
		this.add(size, e);
	}

	//根据索引删除某个元素 返回删除的元素
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("remove is fail,require index < 0 || index >= size");
		}
		//先把要删除的元素存起来，不然等会就给覆盖了。
		E value = data[index];
		if (size - index + 1 >= 0) System.arraycopy(data, index + 1, data, index + 1 - 1, size - index + 1);
		//维护size
		//此处为什么设置为null呢，因为泛型的原因，传进来的都是类对象，数组中存的是引用地址，引用不断开的话，垃圾回收器没办法回收。

		data[--size] = null;
		//此处缩容，当数组元素个数等于数组长度四分之一时，进行缩容
		if (size == data.length / 4 && data.length / 2 != 0) {
			//缩容为数组长度的二分之一
			this.resize(data.length / 2);
		}
		return value;
	}

	//根据值删除某个元素
	public void removeByValue(E e) {
		//复用根据值查找元素的方法，返回索引（此方法在下面）
		int index = this.getByElement(e);
		if (index != -1) {
			//复用根据索引删除的方法
			this.remove(index);
		}
	}


	//删除第一个元素
	public E removeFirst() {
		return this.remove(0);
	}

	//删除最后一个元素
	public E removeLast() {
		return this.remove(size - 1);
	}


	/*基础方法*/
	/*获取元素个数*/
	public int getSize() {
		return size;
	}

	/*获取数组长度*/
	public int getCapacity() {
		return data.length;
	}

	/*获取数组剩余空间*/
	public int getEmptyCapacity() {
		return data.length - size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	//根据索引查找数组某个元素,返回值
	public E getByIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("get is fail, require index < 0 || index >= size");
		}
		return data[index];
	}

	//根据值查找数组某个元素,返回索引
	public int getByElement(E e) {
		//本质：遍历数组进行比对
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	//是否包含该元素
	public boolean contains(E e) {
		//本质：遍历数组进行比对
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				return true;
			}
		}
		return false;
	}

	//修改数组某个元素
	public void set(int index, E e) {

		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("set is fail, require index < 0 || index >= size");
		}

		data[index] = e;
	}
}
