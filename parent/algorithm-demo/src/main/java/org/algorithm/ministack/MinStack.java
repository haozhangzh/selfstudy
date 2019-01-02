package org.algorithm.ministack;

import java.util.Stack;

public class MinStack {
	/***
	 * 空间换时间
	 * minStack的长度跟dataStack的长度一样
	 * 
	 */ 
	private static Stack<Integer> dataStack = new Stack<>();
	private static Stack<Integer> minStack = new Stack<>();

	public static void push(int newNum) {
		dataStack.push(newNum);
		if (minStack.isEmpty()) {
			minStack.push(newNum);
		} else {
			minStack.push(Math.min(minStack.peek(), newNum));
		}
	}

	public static int pop() {
		if (dataStack.isEmpty()) {
			throw new RuntimeException("stack is empty");
		}
		minStack.pop();
		return dataStack.pop();
	}

	public static int getMin() {
		if (minStack.isEmpty()) {
			throw new RuntimeException("stack is empty");
		}
		return minStack.peek();
	}

	public int size() {
		return dataStack.size();
	}

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(1);
		stack.push(2);
		stack.push(1);
		System.out.println("数据栈大小："+dataStack.size());
		System.out.println("最小栈大小："+minStack.size());
        for(int i = 0;i<minStack.size();i++){
        	System.out.print(minStack.get(i));
        }
		while (stack.size() > 0) {
			System.out.println(stack.getMin());
			stack.pop();
		}
	}

}
