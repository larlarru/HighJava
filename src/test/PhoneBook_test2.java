package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import kr.or.ddit.basic.PhoneBook_test_test.Phone;

public class PhoneBook_test2 {
	
	/*
	 * 문제) 이름, 주소, 전화번호를 맴버로 갖는 Phone클래스를 만들고
	 * 		Map을 이용해서 전화번호 정보를 관리하는 프로그램을 작성하시오.
	 * 		이 프로그램에는 전화번호를 등록, 수정, 삭제, 검색, 전체 출력하는 기능이 있다.
	 * 
	 * 		(Map의 구조는 key값으로 '이름'을 사용하고, value값으로 'Phone클래스의 인스턴스'로 한다.)
	 * 
	 * 		- 삭제, 검색기능은 '이름'을 입력받아 처리한다.
	 * 
	 * -----------------------------------------------------
	 * 
	 * 실행예시)
	 * ----------
	 * 다음 메뉴를 선택하세요.
	 * 1. 전화 번호 등록
	 * 2. 전화번호 수정
	 * 3. 전화번호 삭제
	 * 4. 전화번호 검색
	 * 5. 전화번호 전체 출력
	 * 0. 프로그램 종료
	 * ---------------------
	 * 번호입력>> 1 한다면
	 * 
	 * 세롭게 등록할 전화번호 정보를 입력하세요.
	 * 이름 >> 홍길동
	 * 전화번호 >> 010-1234-5678
	 * 주소 >> 대전시 중구 대흥동
	 * 
	 * '홍길동' 전화번호 등록 완료!!
	 * 
	 * 실행예시)
	 * ----------
	 * 다음 메뉴를 선택하세요.
	 * 1. 전화 번호 등록
	 * 2. 전화번호 수정
	 * 3. 전화번호 삭제
	 * 4. 전화번호 검색
	 * 5. 전화번호 전체 출력
	 * 0. 프로그램 종료
	 * ---------------------
	 * 번호입력>> 1
	 * 
	 * 세롭게 등록할 전화번호 정보를 입력하세요.
	 * 이름 >> 홍길동
	 * 
	 * '홍길동'은 이미 등록된 사람입니다.
	 * 
	 * 실행예시)
	 * ----------
	 * 다음 메뉴를 선택하세요.
	 * 1. 전화 번호 등록
	 * 2. 전화번호 수정
	 * 3. 전화번호 삭제
	 * 4. 전화번호 검색
	 * 5. 전화번호 전체 출력
	 * 0. 프로그램 종료
	 * ---------------------
	 * 번호입력>> 5
	 * 
	 * -------------------------------------------------
	 * 번호	이름			전화번호			주소
	 * ---------------------------------------------
	 * 1	홍길동	010-1234-5678	대전시 중구 대홍동
	 * ~~~~~~~~~~~~~~~~~~~~~~~
	 * -----------------------------------------------
	 * 출력 완료...
	 * 
	 * 다음 메뉴를 선택하세요.
	 * 1. 전화 번호 등록
	 * 2. 전화번호 수정
	 * 3. 전화번호 삭제
	 * 4. 전화번호 검색
	 * 5. 전화번호 전체 출력
	 * 0. 프로그램 종료
	 * ---------------------
	 * 번호입력>> 0
	 * 
	 * 프로그램을 종료합니다.
	 * 
	 */
	
//	ArrayList<String> phList = new ArrayList<>();
	public static HashMap<String, Phone> phoneBook = new HashMap<>();
	
	Scanner sc = new Scanner(System.in);
		

	public static void main(String[] args) {
		new PhoneBook_test2().phoneBookStart();
	}


	public void phoneBookStart() {
		while(true) {
			System.out.println("=================================");
			System.out.println("다음 메뉴를 선택하세요.");
			System.out.println("1. 전화 번호 등록");
			System.out.println("2. 전화번호 수정");
			System.out.println("3. 전화번호 삭제");
			System.out.println("4. 전화번호 검색");
			System.out.println("5. 전화번호 전체 출력");
			System.out.println("0. 프로그램 종료");
			System.out.println("=================================");
			System.out.print("번호 입력>> ");
			int input = sc.nextInt();
			switch(input) {
				case 1 : // 전화번호 등록
					createPhoneNum();
					break;
				case 2 : // 전화번호 수정
					updatePhoneNum();
					break;
				case 3 : // 전화번호 삭제
					deletePhoneNum();
					break;
				case 4 : // 전화번호 검색
					selectOnePhoneNum();
					break;
				case 5 : // 전화번호 전체 출력
					selectPhoneNum();
					break;
				case 0 : // 프로그램 종료
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
				default : 
					System.out.println("잘못 입력했습니다. 다시 입력하세요.");
					break;
			}
		}
	}
	
	

	// 전화번호 등록 메서드
	public void createPhoneNum() {
		System.out.println("===================================");
		System.out.println("전화 번호 등록\n");
		System.out.println("===================================");
		sc.nextLine(); //clear개념
		/*name : while (true) {
			System.out.print("이름 입력>> ");
			String sInput = sc.nextLine();
						
			if (phoneBook.get("name") != null && phoneBook.get("name").equals(sInput)) {
				System.out.println("다시 입력하시시오.");
			} else {
				phoneBook.put("name", sInput);
				break name;
			}
		}*/
		
		System.out.print("이름 입력>> ");
		String name = sc.nextLine();

		for (String key : phoneBook.keySet()) {
			Phone value = phoneBook.get(key);
			if (name.equals(key)) {
				System.out.println("이름: " + key + " 전화번호 : " + value.phonNum + " 주소 : " + value.addr);
				if (key.equals(name)) {
					System.out.println("다시 입력하세요.");
					createPhoneNum();
				} else {
				}
			}
		}
		
		
		System.out.print("전화번호 입력>> ");
		String phNum = sc.nextLine();
		
		System.out.print("주소 입력>> ");
		String add = sc.nextLine();
		
		phoneBook.put(name, new Phone(phNum, add));		
		
		
		
//		System.out.println(phoneBook.get("name") + " 전화번호 등록완료");
		System.out.println(name + " 전화번호 등록완료");
//		System.out.println("잘되는지 확인" + phoneBook.values());
		
		//전화번호 목록들 출력
		for (String key : phoneBook.keySet()) {
			Phone value = phoneBook.get(key);
			if (name.equals(key)) {
				System.out.println("이름: " + key + " 전화번호 : " + value.phonNum + " 주소 : " + value.addr);
			}
		}
		phoneBookStart();
	}
	
	//전화번호 수정
	private void updatePhoneNum() {
		System.out.println("===================================");
		System.out.println("전화 번호 수정\n");
		System.out.println("===================================");
		sc.nextLine();
		if (phoneBook.size() == 0) {
			System.out.println("등록된 대상이 없습니다.");
			phoneBookStart();
		}
		System.out.println("수정할 대상의 이름을 입력해주세요.");
		System.out.print("이름>> ");
		String name = sc.nextLine();

		for (String key : phoneBook.keySet()) {
			Phone value = phoneBook.get(key);

			if (!name.equals(key)) {
				System.out.println("존재하지 않는 이름입니다.");
				phoneBookStart();
			} else {

				System.out.print("전화번호>> ");
				String Num = sc.nextLine();
				System.out.println();

				System.out.print("주소>> ");
				String add = sc.nextLine();

				phoneBook.put(name, new Phone(Num, add));
				System.out.println(name + " 전화번호 수정 완료!!");
			}

		}
		
		// 전화번호 목록들 출력
		for (String key : phoneBook.keySet()) {
			Phone value = phoneBook.get(key);
			if (name.equals(key)) {
				System.out.println("이름: " + key + " 전화번호 : " + value.phonNum + " 주소 : " + value.addr);
			}
		}
		phoneBookStart();
	}
	
	// 전화번호 삭제
	private void deletePhoneNum() {
		sc.nextLine(); //clear개념
		if (phoneBook.size() == 0) {
			System.out.println("등록된 대상이 없습니다.");
			phoneBookStart();
		} else {
			System.out.println("삭제할 대상의 이름을 입력해주세요.");
			String name = sc.nextLine();

			for (String key : phoneBook.keySet()) {
				Phone value = phoneBook.get(key);

				if (!name.equals(key)) {
					System.out.println("존재하지 않는 이름입니다.");
					phoneBookStart();
				} else {
					phoneBook.remove(name);
					System.out.println(name + "이(가) 삭제되었습니다.");
				}
			}

		}
		phoneBookStart();
	}
	
	
	// 전화번호 검색
	private void selectOnePhoneNum() {
		sc.nextLine(); //clear개념
		System.out.println("검색할 대상의 이름을 입력해주세요.");
		String name = sc.nextLine();
		
		for(String key : phoneBook.keySet()) {
			Phone value = phoneBook.get(key);
			if(name.equals(key)) {
			System.out.println("이름: "+key+" 전화번호 : " +value.phonNum + " 주소 : "+value.addr);
			phoneBookStart();
			}
		}
		phoneBookStart();
	}
	
	// 전화번호 목록들 출력 메서드
	private void selectPhoneNum() {
		// 전화번호 목록들 출력
		for (String key : phoneBook.keySet()) {
			Phone value = phoneBook.get(key);
			System.out.println("이름: " + key + " 전화번호 : " + value.phonNum + " 주소 : " + value.addr);
		}
		phoneBookStart();
	}
	
	
	
	
	
	
	
	
	public static class Phone implements Comparable<Phone> {

		String phonNum;
		String addr;

		public Phone(String phonNum, String addr) {
			super();
			this.phonNum = phonNum;
			this.addr = addr;
		}

		public String getPhonNum() {
			return phonNum;
		}

		public void setPhonNum(String phonNum) {
			this.phonNum = phonNum;
		}

		public String getAddr() {
			return addr;
		}

		public void setAddr(String addr) {
			this.addr = addr;
		}

		@Override
		public int compareTo(Phone o) {
			// TODO Auto-generated method stub
			return 0;
		}

	}

}






















