package com.ygl.basic.collection.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project: open sources
 * @Author: ygl
 * @Date: 2020/7/15 15:15
 * @Desc: 实现队列
 */
public class QueueDemo {

	List<Integer> list = new ArrayList<Integer>();
	int index = 0;  //下标

	//入队
	public void in(int n){
		list.add(n);
		index++;
	}

	//出队
	public int out(){
		if(!list.isEmpty()){
			index--;
			return list.remove(0);
		}
		return -1;
	}

}
