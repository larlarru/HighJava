package kr.or.ddit.basic;
/*
 * 문제)이름,주소,전화번호를 맴버로 갖는 Phone클래스를 만들고
 * Map을 이용해서 전화번호 정보를 관리하는 프로그램을 작성하시오
 * 이 프로그램에는 전화번호를 등록, 수정, 삭제, 검색,전체 출력하는 기능이 있다
 *
 * (Map의 구조는 key값으로 "이름",을 사용하고, value 값으로 'Phone 클래스의 인스턴트'로 한다.")
 *
 * -삭제, 검색기능은 '이름'을 입력받아 처리한다.
 *  * 실행예시)
 * -----------------------------------------------------------------
 * 다음 메뉴를 선택하세요.
 * 1. 전화번호 등록
 * 2. 전화번호 수정
 * 3. 전화번호 삭제
 * 4. 전화번호 검색
 * 5. 전화번호 전체 출력
 * 0. 프로그램 종료
 * ------------------------------------------------------------------
 * 번호입력>>
 *
 * 새롭게 등록할 전화번호 정보를 입력하세요.
 * 이름>> 홍길동
 * 전화번호>> 010-5123-2131
 * 주소>> 대전시 중구 대흥동
 *
 * '홍길동' 전화번호 등록 완료!!
 *
 * -----------------------------------------------------------------
 * 다음 메뉴를 선택하세요.
 * 1. 전화번호 등록
 * 2. 전화번호 수정
 * 3. 전화번호 삭제
 * 4. 전화번호 검색
 * 5. 전화번호 전체 출력
 * 0. 프로그램 종료
 * ------------------------------------------------------------------
 * 번호입력
 * 홍길동은 이미 등록된 사람입니다.
 *
 * 5
 * -----------------------------
 * 번호 이름 전화번호 주소
 * 1 홍길동 1010 대전
 * ~~~
 *
 * -------------------------------
 * 출력완료
 *
 * 0번
 *
 * 프로그램을 종료합니다.
 *
 * 이름 수정은 불가
 * */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.jar.Attributes.Name;

public class PhoneBook_test_test {
	public static HashMap<String, Phone> map = new HashMap<>();

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		PhoneBook_test_test.start();

	}

	private static void start() {

		System.out.println("-----------------------------------------------------------------");
		System.out.println("다음 메뉴를 선택하세요.");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 전화번호 전체 출력");
		System.out.println("0. 프로그램 종료");
		System.out.println("------------------------------------------------------------------");

		System.out.print("번호입력>>");
		int input = Integer.parseInt(sc.nextLine());
		System.out.println();
		switch (input) {
		case 1:
			insertPhone();
			break;
		case 2:
			reinsert();
			break;
		case 3:
			del();
			break;
		case 4:
			select();
			break;
		case 5:
			selectall();
			break;
		case 0:

			break;
		default:
			break;
		}
	}

	public static void insertPhone() {

		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.print("이름>> ");
		String name = sc.nextLine();
		System.out.println();

		System.out.print("전화번호>> ");
		String Num = sc.nextLine();
		System.out.println();

		System.out.print("주소>> ");
		String add = sc.nextLine();

		map.put(name, new Phone(Num, add));
		System.out.println(name + " 전화번호 등록 완료!!");

		start();
	}

	public static void reinsert() {
		if (map.size() == 0) {
			System.out.println("등록된 대상이 없습니다.");
			start();
		}
		System.out.println("수정할 대상의 이름을 입력해주세요.");
		System.out.print("이름>> ");
		String name = sc.nextLine();

		for (String key : map.keySet()) {
			Phone value = map.get(key);

			if (!name.equals(key)) {
				System.out.println("존재하지 않는 이름입니다.");
				start();
			} else {

				System.out.print("전화번호>> ");
				String Num = sc.nextLine();
				System.out.println();

				System.out.print("주소>> ");
				String add = sc.nextLine();

				map.put(name, new Phone(Num, add));
				System.out.println(name + " 전화번호 수정 완료!!");
			}

		}
		start();
		System.out.println();
	}

	public static void del() {
		if (map.size() == 0) {
			System.out.println("등록된 대상이 없습니다.");
			start();
		} else {
			System.out.println("삭제할 대상의 이름을 입력해주세요.");
			String name = sc.nextLine();

			for (String key : map.keySet()) {
				Phone value = map.get(key);

				if (!name.equals(key)) {
					System.out.println("존재하지 않는 이름입니다.");
					start();
				} else {
					Object moveTel = map.remove(name);
					System.out.println(moveTel + "이(가) 삭제되었습니다.");
				}
			}

		}
		start();
	}

	public static void select() {
		System.out.println("검색할 대상의 이름을 입력해주세요.");
		String name = sc.nextLine();

		for (String key : map.keySet()) {
			Phone value = map.get(key);
			if (name.equals(key)) {
				System.out.println("이름: " + key + " 전화번호 : " + value.phonNum + " 주소 : " + value.addr);
				start();
			}
		}
		System.out.println();

	}

	public static void selectall() {

		for (String key : map.keySet()) {
			Phone value = map.get(key);
			System.out.println("이름: " + key + " 전화번호 : " + value.phonNum + " 주소 : " + value.addr);
		}
		System.out.println();
		start();
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
