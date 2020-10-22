package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 학번(int), 이름(String), 국어점수, 영어점수, 수학점수, 총점, 등수를 맴버로 갖는 Student클래스를 만든다.
 * 이 Student클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서 초기화 처리를 한다.
 * 
 * - 이 Student객체는 List에 저장하여 관리한다.
 * 
 *  - List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고,
 *  총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는
 *  외부 정렬 기준 클래스를 작성하여 정렬된 결과를 출력하시오.
 *  
 *  (단, 등수는 List에 전체 데이터가 추가된 후에 저장되도록 한다.)
 * 
 */

public class ListSortTest3 {

	public static void main(String[] args) {
		
		ArrayList<Student> stuList =  new ArrayList<>();
		
		stuList.add(new Student(1, "김철수", 50, 40, 45, 0, 0));
		stuList.add(new Student(4, "홍길동", 44, 32, 41, 0, 0));
		stuList.add(new Student(2, "이세상", 77, 98, 90, 0, 0));
		stuList.add(new Student(3, "저세상", 1, 1, 1, 0, 0));
		stuList.add(new Student(5, "박한세상", 50, 40, 45, 0, 0));
		
		System.out.println("처음 데이터....");
		for (Student stu : stuList) {
			System.out.println(stu);
		}
		System.out.println("--------------------------------------------------------");
		
		Collections.sort(stuList);
		//맴버 클래스에다가 정렬기준을 넣어줘서 정렬시켜준다.
		
		System.out.println("학번의 오름차순 정렬 후.....");
		for (Student stu : stuList) {
			System.out.println(stu);
		}
		System.out.println("--------------------------------------------------------");
		
		Collections.sort(stuList, new SortAllNumDesc());
		
		System.out.println("총점의 내림차순 정렬 후.....");
		for (Student stu : stuList) {
			System.out.println(stu);
		}
		System.out.println("--------------------------------------------------------");
		
		
		int count = 1;		
		for (int i = 0; i < stuList.size(); i++) {
			count = 1;
			for (int j = 0; j < stuList.size(); j++) {
				if(stuList.get(i).getAllNum() < stuList.get(j).getAllNum()) {
					count++;
				}
			}
			stuList.get(i).rankNum(count);
		}
		
		Collections.sort(stuList);
				
		System.out.println("등수 이후 데이터....");
		for (Student stu : stuList) {
			System.out.println(stu);
		}
		System.out.println("--------------------------------------------------------");
		
	


	}

}

class Student implements Comparable<Student> {
	private int stuNum;
	private String stuName;
	private int korNum;
	private int engNum;
	private int mathNum;
	private int allNum;
	private int rank;
	
	
	public Student (int stuNum, String stuName, int korNum, int engNum, int mathNum, int allNum, int rank) {
		super();
		this.stuNum = stuNum;
		this.stuName = stuName;
		this.korNum = korNum;
		this.engNum = engNum;
		this.mathNum = mathNum;
		this.allNum = korNum + engNum + mathNum;
		this.rank = rank;
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
	
	public int getRank() {
		return rank;
	}

	@Override
	public String toString() {
		return "Student [stuNum=" + stuNum + ", stuName=" + stuName + ", korNum=" + korNum + ", engNum=" + engNum
				+ ", mathNum=" + mathNum + ", allNum=" + allNum + ", rank=" + rank + "]";
	}
	
	//학번 내부 정렬
	@Override
	public int compareTo(Student stu) {
		return new Integer(getStuNum()).compareTo(stu.getStuNum());
	}
	
	//등수
	public void rankNum (int count){
		this.rank = count;
	}

	
}



//총점 외부 클래스
class SortAllNumDesc implements Comparator<Student> {
	@Override
	public int compare(Student stu1, Student stu2) {
		
		if (stu1.getAllNum() > stu2.getAllNum()) {
			return - 1;
		} else if (stu1.getAllNum() == stu2.getAllNum()) {
			if (stu1.getStuName().compareTo(stu2.getStuName()) < 0) {
				return - 1;
			} else if (stu1.getStuName() ==stu2.getStuName()) {
				return 0;
			}
			return 0;
		} else {
			return 1;
		}
		
	}
	
}




















