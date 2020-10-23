package kr.or.ddit.basic;

import java.util.HashSet;

public class EqualsHashCodeTest {

	public static void main(String[] args) {
		
		/*
		 * 
		 * 메서드 영역, Call -Stack, Heap영역 이렇게 3가지 여역이 있다.
		 * 
		 * EqualsHashCodeTest 즉 클래스정보 이게 메서드 영역에 저장된다.
		 * 
		 * 메서드 영역에 클래스정보 말고도 static 자료가 저장된다.
		 * 
		 * Call - Stack에 메인 메서드 영역이 만ㄷ르어진다.
		 * Call - Stack중에 맨위에 있는것이 돌아가는거다.
		 * 
		 * 
		 * .역할은 애가 가리키는 영역으로 가라 라는 의미이다.
		 * 
		 */
		
		
		Person p1 = new Person();
		p1.setId(1);
		p1.setName("홍길동");
		
		Person p2 = new Person();
//		p2.setId(2);
//		p2.setName("일지매");
		p2.setId(1);
		p2.setName("홍길동");
		
		Person p3 = p1; // 이거는 예를들어 p1이 100번지면 100번지 값을 p3에 넣으라는 의미이다.
		
		System.out.println( p1 == p2); //p1과 p2 같냐고 하는건 데이터가 아니라 주소버지 뭐 100번지, 200번지 인거 비교하는거라 같은값이 아니게 된다.
		System.out.println( p1 == p3); // 그래서 p3에는 p1의 번지값이 들어가기 때문에 p1 == p3하면 같게 된다(?).
		
		System.out.println( p1.equals(p2)); // 지금 이 equals가 오브젝트 객체에 만들어진놈 그리고 참조값이 아니라 데이터를 비교하게 된다.
//		우리가 클래스를 만들때 상속을 안하면 오브젝트를 자동으로 상속한다. 그래서 지금 여기에 없지만 오브젝트를 기본적으로 상속했다.
		System.out.println("----------------------------------------------------------");
		
		HashSet<Person> testSet = new HashSet<>();
		
		testSet.add(p1);
		testSet.add(p2);
		
		System.out.println("Set의 크기 : " + testSet.size());
		// 값이 2라고 나오는데 이유는 객체중에 Hash가 들어가는 것들은 내부에서 객체를 비교할때 Hashcode라는것도 비교한다.
		// Hashcode는 번지값이라고 생각해도 된다. 즉 HashCode는 중복되지 않은 어떤 값이라고 보면된다.
		// 그래서 Set 입장에서는 같은걸로 보이지 않는다.
		
		System.out.println("p1 : " + p1.hashCode());
		System.out.println("p2 : " + p2.hashCode());
		System.out.println("p3 : " + p3.hashCode());
		
		/*
		 * - equals()메서드 ==> 두 객체의 내용이 같은지 검사
		 * - hashCode()메서드 ==> 두 객체의 동일성을 검사
		 * 
		 * - hashSet, Hashtable, HashMap과 같이 Hash로 시작하는 컬렉션 객체들은
		 *   객체의 의미상의 동일성을 비교하기 위해서 hashCode()메서드를 호출하여 비교한다.
		 *   그러므로, 객체가 같은지 여부를 결정하려면 hashCode() 메서드를 재정의 해야 한다.
		 *   
		 *   - hashCode()메서드에서 사용하는 '해상 알고리즘'은 서로 다른 객체들에 대해서
		 *   	같은 hashcode를 나타낼 수 있다.
		 * 
		 * 
		 * 
		 */
		
		
		
		
	}

}


class Person {
	private int id;
	private String name;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// Alt+shift+s 눌러서 뭐시기 equals하면 밑에처럼 자동으로 만들어진다.
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
	
	//equals 재정의
	/*@Override
	public boolean equals(Object obj) { // 매개변수는 Object obj 이거 절대 바꾸면 안된다.
		
		if (obj==null) return false;
		
		if (this.getClass() != obj.getClass()) { // 같은 유형의 클래스인지 검사
			return false;
		}
		
		if(this==obj)	// 참조값(주소값)이 같은지 검사 
			return true;
		
		Person myObj = (Person)obj; // 매개변수의 객체를 현재 객체 유형으로 형변환 한다.
		
		if (this.name==null && myObj.name != null) {
			return false;
		}
		
		if(this.id == myObj.id && this.name == myObj.name) {
			return true;
		}
		
		if(this.id == myObj.id && this.name.equals(myObj.name)) {
			return true;
		}
		
		return false;
		
		
	}*/
	
	
	
	
}



















