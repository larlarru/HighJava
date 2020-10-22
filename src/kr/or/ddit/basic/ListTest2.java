package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ListTest2 {

	public static void main(String[] args) {
		
		//문제) 5명의 사람 이름을 입력받아서 ArrayList에 저장한 후에 
		//이들 중에서 '김'씨 성을 가진 사람의 이름을 모두 출력하시오.
		//입력은 Scanner객체를 이용한다.
		
		//뮨재2 5명의 별명을 입력 받아서 ArrayList에 저장한 후에 이들 중에서 별명의 길이가 제일 긴 별명을 출력하시오.
		//(단, 각 별명의 길이는 모두 다르게 입력한다.)
		
		//문제3 문제2에서 별명의 길이가 같은 것이 여러개 있을 경우를 처리하시오.
		//(즉, 제일 긴 별명 모두 출력한다.)
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> name = new ArrayList<>();
//		Scanner.add("김xx");
//		Scanner.add("이xx");
//		Scanner.add("박xx");
//		Scanner.add("김yy");
//		Scanner.add("김zzz");
//		Scanner.add("정xx");
//		Scanner.add("광xx");
		
		/*for (int i = 0; i < 5; i++) {
			System.out.print("이름 입력 > ");
			String sinput = sc.nextLine();
			name.add(sinput);
		}*/
		
		/*a : while(true) {
			System.out.println();
			System.out.println("종료하실거면 exit");
			System.out.print("이름 입력 > ");
			String sinput = sc.nextLine();
			System.out.println();
			switch (sinput) {
			case "exit":				
				break a;
			default:
				name.add(sinput);
				break;
			}
		}*/
		
		System.out.println("문제1");
		for (int i = 0; i < 5; i++) {
			System.out.print("이름 입력 > ");
			String sinput = sc.nextLine();
			name.add(sinput);
		}
		
		
		for (String str : name) {
			if (str.contains("김")) {
				System.out.println(str);
			}
		}
		
		for (String str : name) {
			System.out.println(str);
		}
		
		name.clear();
		
		/*a : while(true) {
			System.out.println("문제2");
			System.out.println("종료하실거면 exit");
			System.out.print("별명 입력 > ");
			String sinput = sc.nextLine();
			System.out.println();
			switch (sinput) {
			case "exit":				
				break a;
			default:
				name.add(sinput);
				break;
			}
		}*/
		System.out.println("문제2");
		for (int i = 0; i < 5; i++) {
			System.out.print("별명 입력 > ");
			String sinput = sc.nextLine();
			name.add(sinput);
		}
		
		ArrayList<String> temp = new ArrayList<>();
		for (int i = 0; i < name.size(); i++) {
			for (int j = 0; j < name.size(); j++) {
				if(name.get(i).length() < name.get(j).length()) {
					temp.clear();
					temp.add(name.get(j));
				} else if(name.get(i).length() > name.get(j).length()) {
					temp.clear();
					temp.add(name.get(i));
				}
			}
		}
		
		System.out.println("가장 긴 별명 출력 : " + temp);
		
		name.clear();
		
		/*a : while(true) {
			System.out.println("문제3");
			System.out.println("종료하실거면 exit");
			System.out.print("별명 입력 > ");
			String sinput = sc.nextLine();
			System.out.println();
			switch (sinput) {
			case "exit":				
				break a;
			default:
				name.add(sinput);
				break;
			}
		}*/
		System.out.println("문제3");
		for (int i = 0; i < 5; i++) {
			System.out.print("별명 입력 > ");
			String sinput = sc.nextLine();
			name.add(sinput);
		}
		
		ArrayList<String> sameTemp = new ArrayList<>();
		
		int x = 0;
		for (int i = 0; i < name.size(); i++) {
			if (name.get(i).length() > x) {
				x = name.get(i).length();
				sameTemp.clear();
				sameTemp.add(name.get(i));
			} else if (name.get(i).length() == x) {
				sameTemp.add(name.get(i));
			}
		}
				
		
		System.out.println("가장 긴 별명들 출력 : " + sameTemp);
		
		
		
	}

}







