package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook_teacher {
	
	private Map<String, Phone> phoneBookMap;
	private Scanner scan;
	
	public PhoneBook_teacher() {
		phoneBookMap = new HashMap<>();
		scan = new Scanner(System.in);
	}

	public static void main(String[] args) {
		new PhoneBook_teacher().phoneBookStart();
	}
	
	// 프로그램을 시작하는 메서드
	private void phoneBookStart() {
		System.out.println("=====================================");
		System.out.println("		전화번호 관리 프로그램");
		System.out.println("=====================================");
		System.out.println();
		
		while(true) {
			int choice = displayMenu();
			
			switch(choice) {
				case 1 :	// 등록	
					insert();
					break;
				case 2 :	// 수정
					update();
					break;
				case 3 :	// 삭제
					delete();
					break;
				case 4 :	// 검색
					search();
					break;
				case 5 :	// 전체 출력
					displayAll();
					break;
				case 0 :	// 종료
					System.out.println("프로그램 종료");
					return;
				default :
					System.out.println("번호 잘못 입력하셨습니다. 다시 입력하세요.");
					break;
			}
		}
		
	}
	
	

	

	

	

	// 메뉴를 출력하고 작업 번호를 입력받아 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		System.out.println("=====================================");
		System.out.println("	다음 메뉴를 선택하세요. ");
		System.out.println();
		System.out.println("	1.전화번호 등록");
		System.out.println("	2.전화번호 수정");
		System.out.println("	3.전화번호 삭제");
		System.out.println("	4.전화번호 검색");
		System.out.println("	5.전화번호 전체 출력");
		System.out.println("	0.종료");
		System.out.println("=====================================");
		System.out.print("번호 입력>> ");
		int num = scan.nextInt();
		return num;
		
	}
	
	// 새로운 전화번호 정보를 등록하는 메서드
	private void insert() {
		System.out.println();
		System.out.println("새로 등록할 전화번호 정보를 입력하세요.");
		
		System.out.print("이름 입력>>");
		String name = scan.next();
		
		// 이미 등록된 사람인지 검사하기
		if(phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨는 이미 등록된 사람입니다.");
			return; // 메서드를 끝낸다.
		}
		
		System.out.print("전화번호 입력>>");
		String tel = scan.next();
		
		System.out.print("주소 입력>>");
//		String addr = scan.next();
		// 입력 버퍼 비우기
		scan.nextLine();	// 입력 버퍼 비어준다.
		String addr = scan.nextLine(); // 주소 입력 받기도 전에 그냥 넘어가버림 그 이유가 버퍼에 엔터값등이 남아 있기때문에 그걸 입력했다고 판단하고 넘어감
//		Phone p = new Phone(name, tel, addr);
//		phoneBookMap.put(name, p);
		phoneBookMap.put(name, new Phone(name, tel, addr));
		
		/*
		 * nextLine()은 입력 받지도 않고 넘어가는 형상이 생기는데 그 이유는
		 * 
		 * - Scanner의 입력 받는 메서드의 특징
		 * 		1. next(). nextInt(), nextDouble().....
		 * 			==> 데이터를 사이띄기, Tag키, Enter키값을 구분한다.
		 * 		
		 * 		가나다
		 * 		마바사
		 * 
		 * 		가나다 마바사
		 * 
		 * 		가나다	마바사
		 * 				
		 * 
		 * 		변수1 = scan.next();	- 첫번째 분리된 데이터 가져온다.
		 * 		변수2 = scan.next();	- 두번째 분리된 데이터 가져온다.
		 * 
		 * 		입력한 커서가 깜빡거리면 버퍼에 입력한 값이 없다.
		 * 		그리고 데이터 가져가면 버퍼에 Tag이나 Enter 이런게 남아있다.
		 * 		다만 next는 무시한다.
		 * 
		 * 		2. nextLine();	==>	한 줄단위로 입력한다.
		 * 							즉, 자료를 입력하고 Enter키를 누르면 Enter키값까지 읽어간다.
		 * 
		 * 
		 * 입력 받는게 바로 입력되는게 아니라 임시기억장치 버퍼에 저장한다.
		 * 버퍼는 속도 차이가 많이 나는 장치와 장치 사이에 있다.
		 * 버퍼는 입력장치보다는 빠르고 CPU보다는 느리다.
		 * 그래서 CPU는 버퍼한테만 명령 내리고 버퍼가 명령 받은걸 실행하기 위해 입력장치에서 데이터 가져오는데 자기의 기억장치가 다 차야지 넘어온다.
		 * 
		 * 우리가 입력한 데이터는 버퍼에 저장되고 그다음에 scan너가 버퍼에 있는거 읽어간다.
		 * 
		 */ 
		
		
		System.out.println(name + "씨 등록 완료");
		
		
		
	}
	
	// Map에 저장된 전체 전화번호 정보를 수정하는 메서드
	private void update() {
		
		System.out.println("수정할 전화번호 입력");
		
		System.out.print("이름 >>");
		String name = scan.next();
		
		// 수정할 데이터가 있느지 검사
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨의 전화번호 정보가 없습니다.");
			System.out.println("수정불가!!");
			return;
		}
		
		System.out.print("새로운 전화번호>>");
		String newTel = scan.next();
		
		scan.nextLine();	// 입력 버퍼 비우기
		System.out.print("새로운 주소>>");
		String newAddr = scan.nextLine();
		
		// 방법1
		//	같은 키값에 새로운 전화번호 정보를 저장한다.	==>	수정작업
		phoneBookMap.put(name, new Phone(name, newTel, newAddr));
		
		/*
		// 방법2
		Phone p = phoneBookMap.get(name); // 키값을 이용해서 value값을 구한다.
		p.setTel(newTel);	// 구해온 Phone객체의 각각의 데이터를 변경한다.
		p.setAddr(newAddr);
		
		System.out.println(name + "씨의 전화번호 정보를 변경하였습니다.");
		*/
	}
	
	// 전화번호 정보를 삭제하는 메서드
	private void delete() {
		System.out.println();
		System.out.println("삭제할 전화번호 정보를 입력하세요.");
		System.out.print("삭제할 사람 이름>>");
		String name = scan.next();
		
		// 등록된 전화번호 정보가 있는지 검사
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨의 전화번호 정보는 없습니다.");
			System.out.println("삭제 작업 불가!!");
			return;
		}
		
		phoneBookMap.remove(name);
		
		System.out.println(name + "씨의 전화번호 정보를 삭제했습니다.");
	}
	
	// 전화번호 정보를 검색하는 메서드
	private void search() {
		System.out.println();
		System.out.println("검색할 전화번호 정보를 입력하세요.");
		System.out.print("이름>>");
		String name = scan.next();
		
		// 등록된 전화번호 정보가 있는지 검사
		if (!phoneBookMap.containsKey(name)) {
			System.out.println(name + "씨의 전화번호 정보는 없습니다.");
			return;
		}
		
		// 검색한 데이터가 있으면 해당 key값에 맞는 value값을 구한다.
		Phone p = phoneBookMap.get(name);
		
		System.out.println();
		System.out.println(name + "씨의 전화번호 정보");
		System.out.println("=====================================");
		System.out.println("	이름 : " + p.getName());
		System.out.println("	전화번호 : " + p.getTel());
		System.out.println("	주소 : " + p.getAddr());
		System.out.println("=====================================");
		
	}
	
	
	// Map에 저장된 전체 전화번호 정보를 출력하는 메서드
	private void displayAll() {
		System.out.println();
		System.out.println("===========================================================");
		System.out.println("	번호	이름	전화번호	주소");
		System.out.println("===========================================================");
		
		if(phoneBookMap.size()==0) {
			System.out.println("등록된 데이터가 하나도 없습니다.");
		} else {
			int cnt = 0;	// 번호를 나타내는 변수
			Iterator<String> phoneIt = phoneBookMap.keySet().iterator();
			
			while(phoneIt.hasNext()) {
				cnt++;
				String name = phoneIt.next();	// 키값(등록된 사람이름) 찾기
				Phone p = phoneBookMap.get(name);	// value값(Phone객체) 구하기
				System.out.println("	" + cnt + "	" + p.getName() + "	"
						+ p.getTel() + "	" + p.getAddr());
			} // while문
		} // else문
		
		System.out.println("===========================");
		System.out.println("	출력 작업 끝");
		
	}
	
	
	

}


//이름, 주소, 전화번호를 맴버로 갖는 Phone 클래스
class Phone {
	private String name; 
	private String tel;
	private String addr;
	
	public Phone(String name, String tel, String addr) {
		super();
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}
	
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public String getAddr() {
		return addr;
	}
	/*public void setName(String name) {
		this.name = name;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}*/
}