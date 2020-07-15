package com.ygl.algorithm.stack;


import java.util.Stack;

/**
 * @Project open sources
 * @Author: rookie_ygl
 * @DATE: 2020/7/12 23:57
 * @DESC: rookie stronger
 *
 * 最小栈实现
 **/
public class MinStack {
    private Stack<Integer> mainStack = new Stack<>();//主栈
    private Stack<Integer> minStack = new Stack<>();//辅助最小栈

    public static void main(String[] args) throws Exception {
        MinStack minStack = new MinStack();
        System.out.println(minStack.pop());
        minStack.push(3);
        minStack.push(4);
    }

    /**
     * push一个新元素，入栈
     *
     * @param element 入栈元素
     */
    public void push(int element) {
        mainStack.push(element);

        //如果辅助栈为空，或者新元素小于等于辅助栈栈顶，将新元素压入辅助栈
        if (minStack.empty() || element <= minStack.peek()) {
            minStack.push(element);
        }
    }

    /**
     * 出栈
     *
     * @return
     */
    public Integer pop() throws Exception {
        //如果出栈元素和辅助栈栈顶元素相等，辅助栈出栈
        if (mainStack.empty()) {
            throw new Exception("");
        }
        if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }

        return mainStack.pop();
    }

    /**
     * 获取小元素
     *
     * @return
     * @throws Exception
     */
    public int getMin() throws Exception {
        //只要主栈有值，最小栈也有值
        if (mainStack.empty()) {
            throw new Exception("");
        }
        //获取最下元素只在最小栈获取，最小栈的栈顶始终保存最小元素
        return minStack.peek();
    }


}
