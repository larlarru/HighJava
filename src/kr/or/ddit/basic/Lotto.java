package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Lotto {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		while (true) {
			System.out.println("");
			System.out.println("========================");
			System.out.println("Lotto 프로그램");
			System.out.println("------------------------");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("========================");
			System.out.print("번호 입력>");
			int input = sc.nextInt();
			switch (input) {
			case 1:
				buyLotto();
				break;
			case 2:
				System.out.println("감사합니다 ^^");
				System.exit(0);
				break;

			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}

		}
		
	}
	
	//로또 사기
	private static void buyLotto() {
		System.out.println("로또 구입");
		System.out.println("로또 가격 : 1000원에 1개");
		
		int payback=0;//거스름돈
//		int money=0;//받은돈
		int coin=0;//로또번호를 받을수 있는 횟수

		System.out.print("금액 입력>");
		int input = sc.nextInt();

		if (input < 1000) {
			System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!!");
			buyLotto();
		} else if (input >= 101000) {
			System.out.println("\n입력 금액이 너무 많습니다. 로또번호 구입 실패!!!");
			buyLotto();
		} else {
			System.out.println("\n받은 금액은 " + input + 
					"원이고 거스롬돈은 " + payback + "원 입니다.");
			}

		coin = input / 1000;
		System.out.println("행운의 로또번호는 아래와 같습니다");
		
		// 로또번호 출력 겸 로또번호 생성겸 전부
		HashSet hs = new HashSet<>();
		for (int i = 0; i < coin; i++) {
			hs = new HashSet<>();
			while (hs.size() < 6) {
				hs.add((int) (Math.random() * 45 - 1 + 1) + 1);
			}
			ArrayList<Integer> lottonum = new ArrayList<>(hs);
			System.out.print((i + 1) + "번째 로또번호 : ");
			for (int j = 0; j < lottonum.size(); j++) {
				System.out.print(lottonum.get(j) + " ");

			}
			System.out.println();
		}
		payback = input % 1000;
		System.out.println();
		System.out.println("받은금액은 " + input + "원이고 거스름돈은 " + payback + "원입니다.");
		main(null);
		
		
	}

}





















