package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/* 
 * 문제 Set과 List를 이용하여 숫자 야구 게임 프로그램을 작성하시오.
 * 컴퓨터의 숫자는 난수를 이용하여 구현한다.
 * (스트라이크는 S 볼은 B로 나타낸다.)
 * 
 * 
 * 예시)
 * 컴퓨터의 난수==> 9,5,7 난수만들때 셋을 쓰고 스트라이크나 볼을 맞추려면 숫서가 맞는지 안맞는지 파악하기위해 리스트에 담는다. 아까 해봤대.
 * (1부터 9사이의 중복되지 않는 난수 3개 생성)//입력하는 데이터도 리스트에 똑같이 저장을 해야지 검사 하기 쉬울 것. 배열대신 리스트라고 생각하면 할만 할 것
 *
 * 실행예시 
 * 숫자를 입력받음 => 3 5 8
 * 3 5 8 입력한 숫자 나오고
 * 1s 0b 위치+같은숫자 스트라이크
 * 숫자입력 또 받음.
 * 7 8 9 위치만 다름. 볼 다 다름 아웃 3스트라이크가 안되면 계속 입력을 받는다.
 * 9 5 7 3s 0b
 * 
 * 당신은 4번째만에 맞췄습니다.
 * */
public class BaseBall {
//로또 구매 프로그램 작성

	public static void main(String[] args) {	
		int a;
		int b;
		int c;
		while(true) {
			
			a = (int) (Math.random()*9)+1;
//			System.out.println(a);
			b = (int) (Math.random()*9)+1;
//			System.out.println(b);
			c = (int) (Math.random()*9)+1;
//			System.out.println(c);
			if(a != b && a != c && b != c) {
					break;
			}
		}
		
		
		Boll b1 = new Boll();
		Boll b2 = new Boll();
		Boll b3 = new Boll();
		b1.setOne(a);
		b2.setOne(b);
		b3.setOne(c);

		HashSet<Boll> Bolls = new HashSet<>();
		Bolls.add(b3);
		Bolls.add(b2);
		Bolls.add(b1);
//		System.out.println("sad"+b1.getOne());
		
		int count = 1;
		while(true) {
			int S =0;
			int B =0;
			
			System.out.println("첫 번째 숫자 입력.");
			int on = ScanUtil.nextInt();
			System.out.println("두 번째 숫자 입력.");
			int tw = ScanUtil.nextInt();
			System.out.println("세 번째 숫자 입력.");
			int sa = ScanUtil.nextInt();
			
			int co = 0;
			

			for (Boll boll : Bolls) {
//				System.out.println(boll.getOne());
				
				if(co == 0 && boll.getOne() == on) {
					S += 1;
				}else if(co == 0 && boll.getOne() == tw) {
				B++;
				}
				else if(co == 0 && boll.getOne() == sa) {
					B++;
				}

				
				if(co == 1 && boll.getOne() == on) {
					B += 1;
				}else if(co == 1 && boll.getOne() == tw) {
				S++;
				}
				else if(co == 1 && boll.getOne() == sa) {
					B++;
				}
				
				if(co == 2 && boll.getOne() == on) {
					B += 1;
				}else if(co == 2 && boll.getOne() == tw) {
				B++;
				}
				else if(co == 2 && boll.getOne() == sa) {
					S++;
				}

				
				co++;
			}
			
			System.out.println("S :"+S+" B :"+B);
			if(S == 3) {
				System.out.println("축하합니다.");
				System.out.println("당신은 "+count+"번째만에 맞췄습니다");
				break;
			}
			count++;
	}
	}
}

class Boll{
	int one;
	int two;
	int sam;
	
	public Boll() {
		super();
		this.one = one;
		this.two = two;
		this.sam = sam;
	}

	public int getOne() {
		return one;
	}

	public void setOne(int one) {
		this.one = one;
	}

	public int getTwo() {
		return two;
	}

	public void setTwo(int two) {
		this.two = two;
	}

	public int getSam() {
		return sam;
	}

	public void setSam(int sam) {
		this.sam = sam;
	}

	@Override
	public String toString() {
		return "Boll [one=" + one + ", two=" + two + ", sam=" + sam + "]";
	}
	
}
