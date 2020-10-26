package kr.or.ddit.basic;

import java.util.Scanner;

//메서드에 스테틱을 붙이는 경우
//메서드가 유틸리티 기능일 경우(어떤것을 편하게 하기위한.)
public class ScanUtil {
	//스캐너..숫자..입력받을때 계속 스캐너 사용하기 귀찮다...
	//편하게 사용하게 메서드를 만들것이다.
	
	private static Scanner s = new Scanner(System.in);
	
	//유틸리티 성향의 메서드인 경우 스테틱을 붙인다.
	//객체생성을 하지 않고 사용하기위해 하는것.
	public static String nextLine(){
		return s.nextLine();
	}
	
	public static int nextInt(){
	return Integer.parseInt(s.nextLine());
//	Math.random()
//	Math.round(a) 이것들 처럼 만들은것..
	}
}
