package kr.or.ddit.basic;

import java.util.LinkedList;

public class StackQueueTest {
	
	
	/*일종의 자료구조이다.
	 * 
	 *Stack은 제일 먼저 들어간 애가 제일 마지막에 나온다.
	 * Queue는 먼저 들어간 놈이 먼저 나온다.
	 *
	 * Stack ==> 후입선촐(LIFO)의 자료구조
	 * Queue ==> 선입선출(FIFO)의 자료구조
	 * 
	 * List를 이용하여 Stack나 Queue를 구현한다.
	 * 
	 * Stack과 Queue는 LinkedList로 구현해서 사용할 수 있다.
	 * 
	 * 
	 */
	
	
	
	public static void main(String[] args) {
		//Stack 명령
		//1. 자료 입력 : push(입력데이터);
		//2. 자료 출력 : pop(); ==> 자료를 꺼내온 후 데이터를 Stack에서 지운다.
		//			  peek(); ==> 삭제없이 자료를 꺼내온다.
		
		LinkedList<String> stack = new LinkedList<>();
		
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("이순신");
		stack.push("변학도");
		
		System.out.println("stack 값 : " + stack);
		
		
		String data = stack.pop();
		System.out.println("꺼내온 값(data) : " + data);
		System.out.println("꺼내온 값(stack.pop()) : " + stack.pop());
		System.out.println("stack 값 : " + stack);
		
		stack.push("성춘향");
		System.out.println("추가후 stack 값 : " + stack);
		System.out.println();

		System.out.println("꺼내온 값(stack.pop()) : " + stack.pop());
		System.out.println("stack 값 : " + stack);
		System.out.println();
		
		System.out.println("삭제없이 꺼내온 값 : " + stack.peek());
		System.out.println("stack 값 : " + stack);
		System.out.println("=======================================================================");
		System.out.println();
		
		/*
		 * Queue 명령
		 * 1. 자료입력 : offer(입력 데이터);
		 * 2. 자료 출력 : poll();		==> 자료를 꺼내온 후 꺼내온 데이터를 Queue에서 삭제한다.
		 * 			   peek();		==> 삭제없이 데이터를 꺼내온다. 
		 */
		
		LinkedList<String> queue = new LinkedList<>();
		
		queue.offer("홍길동");
		queue.offer("이순신");
		queue.offer("일지매");
		queue.offer("변학도");
		
		System.out.println("queue 값 : " + queue);
		
		String temp = queue.poll();
		System.out.println("꺼내온 값 : " + temp);
		System.out.println("꺼내온 값 : " + queue.poll());
		System.out.println("queue 값 : " + queue);
		
		queue.offer("성춘향");
		System.out.println("추가 후 queue 값 : " + queue);
		
		System.out.println();
		System.out.println("꺼내온 값 : " + queue.poll());
		System.out.println("queue 값 : " + queue);
		System.out.println();
		
		System.out.println("삭제없이 꺼내온 값 : " + queue.peek());
		System.out.println("queue 값 : " + queue);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}























