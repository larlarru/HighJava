package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest2 {

	public static void main(String[] args) {
		
		ArrayList<Member> memList = new ArrayList<>(); // 맴버객체 저장
		
		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(5, "이순신", "010-2222-1111"));
		memList.add(new Member(10, "성춘향", "010-3333-1111"));
		memList.add(new Member(11, "강감찬", "010-4444-1111"));
		memList.add(new Member(4, "일지매", "010-5555-1111"));
		memList.add(new Member(7, "변학도", "010-6666-1111"));	
		
		System.out.println("처음 데이터....");
		for (Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("--------------------------------------------------------");
		
		Collections.sort(memList);
		//맴버 클래스에다가 정렬기준을 넣어줘서 정렬시켜준다.
		
		System.out.println("회원 이름의 오름차순 정렬 후.....");
		for (Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("--------------------------------------------------------");
		
		Collections.sort(memList, new SortNumDesc());
		
		System.out.println("회원 번호의 내림차순 정렬 후.....");
		for (Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("--------------------------------------------------------");
		
		
		
		
	}

}


// 사용자가 작성하는 클래스 내부에 정렬기준을 지정할려면 Comparable인터페이스를 구현해서 작성해야 한다.
// (내부 정렬기준을 넣어서 클래스를 작성한다.)
// 내부 정렬 기준은 하나밖?에 못 만드는데 기준 여러개 만들고 싶으면 외부 정렬기준 만들어서 여러개 만들어 가져다 쓰면 된다.

// Comparable인터페이스는 compareTo()메서드가 선언되어 있다.
// 그래서 이 compareTo()메서드를 재정의 해서 정렬 기준을 지정한다.

// 예) Member클래스의 회원이름을 기준으로 오름차순이 되도록하는 내부 정렬 기준 추가하기
// (Comparable인터페이스를 구현해서 작성한다.)
class Member implements Comparable<Member>{ // 제네릭 기준은 현재 클래스하고 똑같이 적으면 된다.
	private int num;
	private String name;
	private String tel;
	
	//자동 생성 Alt + Shift + s 에서 generate Getters and Satters...클릭해서 변수 만ㄷ름녀 도니다.
	
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}
	
	public String getTel() {
		return tel;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}
	
	@Override
		public int compareTo(Member mem) { // 현재 멤버 즉 Member에 저장된거와 들어오는 mem?과 비교한다.
			return this.getName().compareTo(mem.getName()); //현재 이름 클래스 구해오기
		}
	
	
	/* 이렇게 안하고도 자동으로 만드는 방법이 있다.
	 * public Member(int num, String name, String tel) {
		this.num = num;
		this.name = name;
		this.tel = tel;
	}*/
	
}

// Member클래스의 회원번호(num)의 내림차순으로 정렬할 외부 정렬 기준 클래스 작성
class SortNumDesc implements Comparator<Member> {
	@Override
	public int compare(Member mem1, Member mem2) {
		/*if (mem1.getNum() > mem2.getNum()) {
			return - 1;
		} else if (mem1.getNum() == mem2.getNum()) {
			return 0;
		} else {
			return 1;
		}*/
		
		//Wrapper클래스를 이용하는 방법1
//		return new Integer(mem1.getNum()).compareTo(mem2.getNum()) * - 1;
		
		//Wrapper클래스를 이용하는 방법2
		return Integer.compare(mem1.getNum(), mem2.getNum()) * - 1;
		
	}
	
}











