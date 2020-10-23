package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Iterator;

public class BaseBallTest {

	
	/*
	 * Set과 List를 이용하여 숫자 야구 게임 프로그램을 작성하시오.
	 * 컴퓨터의 숫자는 난수를 이용하여 구한다.
	 * (스트라이크는 S, 볼은 B로 나타낸다.)
	 * 
	 * 예시)
	 * 		컴퓨터의 난수 ==> 9 5 7
	 * 
	 * 실행예시)
	 * 		숫자입력 ==> 3 5 8
	 * 		3 5 8 ==> 1S 0B
	 * 		숫자입력 ==> 7 8 9
	 * 		7 8 9 ==> 0S 2B
	 * 		숫자입력 ==> 9 7 5
	 * 		9 7 5 ==> 1S 2B
	 * 		숫자입력 ==> 9 5 7
	 * 		9 5 7 ==> 3S 0B
	 * 		
	 * 		축하합니다.
	 * 		당신은 4번째만에 맞췄습니다.
	 * 
	 */
	
	public static void main(String[] args) {
		
		BallNum num1 = new BallNum();
		num1.getBaseBallNum((int)(Math.random()*9)+1);
		
		BallNum num2 = new BallNum();
		num2.setId((int)(Math.random()*9)+1);
		
		BallNum num3 = new BallNum();
		num3.setId((int)(Math.random()*9)+1);
		
		HashSet<BallNum> ballNum = new HashSet<>();
		ballNum.add(num1);
		ballNum.add(num2);
		ballNum.add(num3);
		
		System.out.println("num1 : " + num1.getId());
		System.out.println("num1 : " + num2.getId());
		System.out.println("num1 : " + num3.getId());
		
//		Iterator it = ballNum.iterator(); // Set 데이터를 Iterator로 변환하기

		
	}

}

class BallNum {
	private int baseBallNum;

	public int getBaseBallNum() {
		return baseBallNum;
	}

	public void setBaseBallNum(int baseBallNum) {
		this.baseBallNum = baseBallNum;
	}
	
	/*// Alt+shift+s 눌러서 뭐시기 equals하면 밑에처럼 자동으로 만들어진다.
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	*/
	
	
	
	
}
































