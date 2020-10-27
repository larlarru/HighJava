package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class HotelRom_test {
	
	private static Map<Integer, Room> roomMap;
	private Scanner scan;
	
	public HotelRom_test() {
		roomMap = new HashMap<>();
		scan = new Scanner(System.in);
	}

	public static void main(String[] args) {
		
		new HotelRom_test().start();
		/*
		 *  201~209 : 싱글룸
		 * 301~309 : 더블룸
		 * 401~409 : 스위트룸
		 */
	}
	
	
	// 프로그램 시작 메서드
	public void start() {
		
		roomMap.put(201, new Room(201, "싱글룸", null));
		roomMap.put(202, new Room(202, "싱글룸", null));
		roomMap.put(203, new Room(203, "싱글룸", null));
		roomMap.put(204, new Room(204, "싱글룸", null));
		roomMap.put(205, new Room(205, "싱글룸", null));
		roomMap.put(206, new Room(206, "싱글룸", null));
		roomMap.put(207, new Room(207, "싱글룸", null));
		roomMap.put(208, new Room(208, "싱글룸", null));
		roomMap.put(209, new Room(209, "싱글룸", null));
		
		roomMap.put(301, new Room(301, "더블룸", null));
		roomMap.put(302, new Room(302, "더블룸", null));
		roomMap.put(303, new Room(303, "더블룸", null));
		roomMap.put(304, new Room(304, "더블룸", null));
		roomMap.put(305, new Room(305, "더블룸", null));
		roomMap.put(306, new Room(306, "더블룸", null));
		roomMap.put(307, new Room(307, "더블룸", null));
		roomMap.put(308, new Room(308, "더블룸", null));
		roomMap.put(309, new Room(309, "더블룸", null));
		
		roomMap.put(401, new Room(401, "스위트룸", null));
		roomMap.put(402, new Room(402, "스위트룸", null));
		roomMap.put(403, new Room(403, "스위트룸", null));
		roomMap.put(404, new Room(404, "스위트룸", null));
		roomMap.put(405, new Room(405, "스위트룸", null));
		roomMap.put(406, new Room(406, "스위트룸", null));
		roomMap.put(407, new Room(407, "스위트룸", null));
		roomMap.put(408, new Room(408, "스위트룸", null));
		roomMap.put(409, new Room(409, "스위트룸", null));
		
		System.out.println("*********************************************");
		System.out.println("       호텔문을 열었습니다. 어서오십시요."); 
		System.out.println("*********************************************");
		
		while (true) {
			int choice = roomMenu();

			switch (choice) {
			case 1: // 체크인
				checkIn();
				break;
			case 2: // 체크아웃
				checkOut();
				break;
			case 3: // 객실상태
				roomState();
				break;
			case 4: // 업무종료
				System.out.println("업무 종료");
				return;
			default:
				System.out.println("번호 잘못 입력하셨습니다. 다시 입력하세요.");
				break;
			}
		}
		
	}

	private int roomMenu() {
		
		System.out.println();
		System.out.println("-----------------------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
		System.out.println("-----------------------------------------------------------");
		System.out.print("번호 입력>> ");
		int num = scan.nextInt();
		return num;
	}
	
	// 체크인 하는곳
	private void checkIn() {
		System.out.println();
		System.out.println("-----------------------------------------------------------");
		System.out.println("체크인 작업");
		System.out.println("-----------------------------------------------------------");
		System.out.println("201~209 : 싱글룸");
		System.out.println("301~309 : 더블룸");
		System.out.println("401~409 : 스위트룸");
		System.out.println("-----------------------------------------------------------");
		
		/*// 출력
		System.out.println("-----------------------------------------------------------");
		System.out.println("현재 객실 상태");
		System.out.println("-----------------------------------------------------------");
		System.out.println("방 번호\t방 종류\t투숙객 이름");
		System.out.println("-----------------------------------------------------------");
		
		
		Iterator<Integer> roomIt = roomMap.keySet().iterator();
		
		while(roomIt.hasNext()) {
			int roomNum = roomIt.next();
			Room r = roomMap.get(roomNum);
			System.out.println("	" + r.getRoomNum() + "	"
					+ r.getRoomType() + "	" + r.getName());
		}*/

		
		System.out.print("번호 입력>>");
		int roomNum = scan.nextInt();
		
		
		Room r = roomMap.get(roomNum);
		// 방 상태 검사
		if (r.getRoomNum() == roomNum && r.getName()!=null) {
			System.out.println("이미 있습니다.");
			return;
		}
		
		System.out.print("이름 입력>>");
		String name = scan.next();
		
		roomMap.put(roomNum, new Room(roomNum, r.getRoomType(), name));
		
		System.out.println("체크 완료 되었습니다.");
		
		
		
		
		
		
	}
	
	// 체크아웃
	private void checkOut() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("		체크아웃");
		System.out.println("-----------------------------------------------------------");
		
		System.out.print("체크아웃할 방번호 입력해 주세요.");
		//체크아웃할 방번호 입력
		System.out.print("번호 입력>>");
		int roomNum = scan.nextInt();
		
		
		Room r = roomMap.get(roomNum);
		// 체크아웃을 위한 방 검사
		if (r.getRoomNum() == roomNum && r.getName()==null) {
			System.out.println(roomNum + "객실에는 체크인 한 사람이 없습니다.");
			return;
		}
//		.r...r..r..
				
		roomMap.put(roomNum, new Room(roomNum, r.getRoomType(), null));
		
		System.out.println(roomNum + "호 객실의 체크아웃을 완료 되었습니다.");
		
	}
	
	// 객실 상태
	private void roomState() {
		// 출력
		System.out.println("-----------------------------------------------------------");
		System.out.println("현재 객실 상태");
		System.out.println("-----------------------------------------------------------");
		System.out.println("방 번호\t방 종류\t투숙객 이름");
		System.out.println("-----------------------------------------------------------");

		Iterator<Integer> roomIt = roomMap.keySet().iterator();

		while (roomIt.hasNext()) {
			int roomNum = roomIt.next();
			Room r = roomMap.get(roomNum);
			System.out.println("	" + r.getRoomNum() + "	" + r.getRoomType() + "	" + r.getName());
		}
	}


	
	
	

}


class Room {
	
	private int roomNum;
	private String roomType;
	private String name;	//투수객 이름
	
	
	public int getRoomNum() {
		return roomNum;
	}
	public String getRoomType() {
		return roomType;
	}
	public String getName() {
		return name;
	}
	
	public Room(int roomNum, String roomType, String name) {
		super();
		this.roomNum = roomNum;
		this.roomType = roomType;
		this.name = name;
	}
}






