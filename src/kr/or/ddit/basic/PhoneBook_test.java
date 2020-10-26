package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook_test {
	
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
	
	ArrayList<String> phList = new ArrayList<>();
	HashMap<String, String> phoneBook = new HashMap<>();
	
	Scanner sc = new Scanner(System.in);
	
	int input;
	String sInput;
	

	public static void main(String[] args) {
		new PhoneBook_test().phoneBookStart();
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
			input = sc.nextInt();
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
		
		System.out.println("전화 번호 등록\n");
		System.out.println(phoneBook);
		sc.nextLine(); //clear개념
		name : while (true) {
			System.out.print("이름 입력>> ");
			sInput = sc.nextLine();
						
			if (phoneBook.get("name") != null && phoneBook.get("name").equals(sInput)) {
				System.out.println("다시 입력하시시오.");
			} else {
				phoneBook.put("name", sInput);
				break name;
			}
		}
//		phoneBook.put("name", sInput);
		
		
		System.out.print("전화번호 입력>> ");
		sInput = sc.nextLine();
		phoneBook.put("phNum", sInput);
		System.out.print("주소 입력>> ");
		sInput = sc.nextLine();
		phoneBook.put("addr", sInput);
		
		phList.add("이름 : " + phoneBook.put("name", sInput) 
				+" 전화번호 : "+ phoneBook.put("phNum", sInput)
				+" 주소 : "+ phoneBook.put("addr", sInput));
//		phList.add(phoneBook.put("phNum", sInput));
//		phList.add(phoneBook.put("addr", sInput));
		
		
		System.out.println(phoneBook.get("name") + " 전화번호 등록완료");
		System.out.println("잘되는지 확인" + phoneBook);
		phoneBookStart();
	}
	
	//전화 번호 수정
	private void updatePhoneNum() {
		System.out.println("전화번호 수정");
		for (String key : phoneBook.keySet()) {
			String value = phoneBook.get(key);
			System.out.println(key + " : " + value);
		}
		
		for (int i=0; i<phList.size();i++) {
			System.out.println("이름\t번호\t주소");
			System.out.println("i번째 : " + i + " 에 있는 내용물 : " + phList.get(i));
		}
		
		System.out.print("수정하고 싶은 이름에 맞는 i번호 입력 >>");
		input = sc.nextInt();
		sc.nextLine();
		System.out.print("이름 입력>> ");
		sInput = sc.nextLine();
		phoneBook.put("name", sInput);
		System.out.print("전화번호 입력>> ");
		sInput = sc.nextLine();
		phoneBook.put("phNum", sInput);
		System.out.print("주소 입력>> ");
		sInput = sc.nextLine();
		phoneBook.put("addr", sInput);
		
		phList.set(input, phoneBook.put("name", sInput) 
				+""+ phoneBook.put("phNum", sInput)
				+""+ phoneBook.put("addr", sInput));
		
		/*System.out.print("수정하고 싶은 이름에 맞는 i번호 입력 >>");
		input = sc.nextInt();
		sc.nextLine();
		System.out.print("수정할 이름 입력 >>");
		sInput = sc.nextLine();
		phList.set(input, sInput);
		
		System.out.print("수정하고 싶은 번호에 맞는 i번호 입력 >>");
		input = sc.nextInt();
		sc.nextLine();
		System.out.print("수정할 번호 입력 >>");
		sInput = sc.nextLine();
		phList.set(input, sInput);
//		phoneBook.put("phNum", sInput);
		
		System.out.print("수정하고 싶은 주소에 맞는 i번호 입력 >>");
		input = sc.nextInt();
		sc.nextLine();
		System.out.print("수정할 주소 입력 >>");
		sInput = sc.nextLine();
		phList.set(input, sInput);*/
//		phoneBook.put("addr", sInput);
		
		
		System.out.println("수정 완료 되었습니다.");
		phoneBookStart();
	}
	
	// 전화 번호 삭제
	private void deletePhoneNum() {
		for (int i=0; i<phList.size();i++) {
			System.out.println("이름\t번호\t주소");
			System.out.println(i + "번째에 있는 내용물 : " + phList.get(i));
		}
		
		System.out.print("삭제할 전화번호 리스트 번호 입력>>");
		input = sc.nextInt();
		phList.remove(input);
		System.out.println("삭제되었습니다.");
		phoneBookStart();
		
	}
	
	// 전화번호 전체 출력
	private void selectPhoneNum() {
		for (int i=0; i<phList.size();i++) {
			System.out.println("이름\t번호\t주소");
			System.out.println(i + "번째에 있는 내용물 : " + phList.get(i));
		}
	}

}






















