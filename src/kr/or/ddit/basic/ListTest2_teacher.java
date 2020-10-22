package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.Scanner;

import org.w3c.dom.NameList;

public class ListTest2_teacher {

	public static void main(String[] args) {
		
		//문제) 5명의 사람 이름을 입력받아서 ArrayList에 저장한 후에 
		//이들 중에서 '김'씨 성을 가진 사람의 이름을 모두 출력하시오.
		//입력은 Scanner객체를 이용한다.
		
		//뮨재2 5명의 별명을 입력 받아서 ArrayList에 저장한 후에 이들 중에서 별명의 길이가 제일 긴 별명을 출력하시오.
		//(단, 각 별명의 길이는 모두 다르게 입력한다.)
		
		//문제3 문제2에서 별명의 길이가 같은 것이 여러개 있을 경우를 처리하시오.
		//(즉, 제일 긴 별명 모두 출력한다.)
		
		
		ArrayList<String> name = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1번 문제");
		System.out.print("이름입력>");
		String sInput = sc.nextLine();
		for (int i = 1; i < 5; i++) {
			System.out.println();
			name.add(sInput);
		}
		
		System.out.println();
		
		System.out.println("김씨 성을 가진 사람들");
		for (int i = 0; i < name.size(); i++) {
			if (name.get(i).substring(0, 1).equals("김")) { //name.get(i).substring(0, 1)하면 0번째부터 1번째 이전까지 가져오라는 소리다.
				System.out.println(name.get(i));
			}
			
			/*if (name.get(i).charAt(0)='김') {
				System.out.println(name.get(i));
			}*/
			
			/*if (name.get(i).indexOf("김")==0) {
				System.out.println(name.get(i));
			}*/
			
			if (name.get(i).startsWith("김")==true) {
				System.out.println(name.get(i));
			}
			
		}
		
		name.clear();
		
		System.out.println("문제2번");
		System.out.println("별명 입력");
		for (int i = 1; i < 5; i++) {
			sInput = sc.nextLine();
			name.add(sInput);
		}
		
		System.out.println();
		
		//제일 긴 별명이 저장될 변수 선언 ==> List의 첫번째 데이터로 초기화 한다.
		String maxAlias = name.get(0);
		
		for (int i = 1; i < name.size(); i++) {
			if (maxAlias.length() < name.get(i).length()) {
				maxAlias = name.get(i);
			}
		}
		
		System.out.println("제일 긴 별명 : " + maxAlias);
		
		name.clear();
		
		System.out.println("문제3번");
		System.out.println("별명 입력");
		for (int i = 1; i < 5; i++) {
			sInput = sc.nextLine();
			name.add(sInput);
		}
		
		System.out.println();
		
		//제일 긴 별명의 글자 수가 저장될 변수를 선언하고
		//List의 첫번째 데이터의 글자 수로 초기화 한다.
		int maxLength = name.get(0).length();
		
		for (int i = 1; i < name.size(); i++) {
			if (maxLength < name.get(i).length()) {
				maxLength = name.get(i).length();
			}
		}
		
		
		System.out.println("제일 긴 별명들...");
		for (int i = 0; i < name.size(); i++) {
			if (name.get(i).length() == maxLength) {
				System.out.println(name.get(i));
			}
		}
		
		
		
		
	}

}







