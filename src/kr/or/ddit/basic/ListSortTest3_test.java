package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest3_test {

	public static void main(String[] args) {
		
		ArrayList<Student> stuList = new ArrayList<>(); // 맴버객체 저장
		
		stuList.add(new Student(1, "김철수", 50, 40, 70, 0));
		
		System.out.println("처음 데이터....");
		for (Student stu : stuList) {
			System.out.println(stu);
		}
		System.out.println("--------------------------------------------------------");
		
		Collections.sort(stuList);
		//맴버 클래스에다가 정렬기준을 넣어줘서 정렬시켜준다.
		
		System.out.println("회원 이름의 오름차순 정렬 후.....");
		for (Student stu : stuList) {
			System.out.println(stu);
		}
		System.out.println("--------------------------------------------------------");
		
		Collections.sort(stuList, new SortStuNumDesc());
		
		System.out.println("회원 번호의 내림차순 정렬 후.....");
		for (Student stu : stuList) {
			System.out.println(stu);
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
//class Student implements Comparable<Student>{ // 제네릭 기준은 현재 클래스하고 똑같이 적으면 된다.
	private int stuNum;
	private String stuName;
	private int korNum;
	private int engNum;
	private int mathNum;
	private int allNum;
	
	//자동 생성 Alt + Shift + s 에서 generate Getters and Satters...클릭해서 변수 만ㄷ름녀 도니다.
	
	public Student(int stuNum, String stuName, int korNum, int engNum, int mathNum, int allNum) {
		super();
		this.stuNum = stuNum;
		this.stuName = stuName;
		this.korNum = korNum;
		this.engNum = engNum;
		this.mathNum = mathNum;
		this.allNum = allNum;
	}

	public int getStuNum() {
		return stuNum;
	}
	public String getStuName() {
		return stuName;
	}
	public int getKorNum() {
		return korNum;
	}
	public int getEngNum() {
		return engNum;
	}
	public int getMathNum() {
		return mathNum;
	}
	public int getAllNum() {
		return allNum;
	}

	@Override
	public String toString() {
		return "Student [stuNum=" + stuNum + ", stuName=" + stuName + ", korNum=" + korNum + ", engNum=" + engNum
				+ ", mathNum=" + mathNum + ", allNum=" + allNum + "]";
	}
	
	@Override
	public int compareTo(Student stu) {
		// TODO Auto-generated method stub
		return this.getStuName().compareTo(stu.getStuName());
	}
	
	
	/* 이렇게 안하고도 자동으로 만드는 방법이 있다.
	 * public Member(int num, String name, String tel) {
		this.num = num;
		this.name = name;
		this.tel = tel;
	}*/
	
}

// Member클래스의 회원번호(num)의 내림차순으로 정렬할 외부 정렬 기준 클래스 작성
class SortStuNumDesc implements Comparator<Student> {
	@Override
	public int compare(Student stu1, Student stu2) {
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
		return Integer.compare(stu1.getStuNum(), stu2.getStuNum()) * - 1;
		
	}
	
}











