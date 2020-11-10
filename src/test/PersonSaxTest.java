package test;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class PersonSaxTest {
	public static void main(String[] args) {
		File file = new File("./src/test/people.xml");	// file 대신, api 키로 만들어진 uri 주소도 가능
		SAXParserFactory factory = SAXParserFactory.newInstance();	
		// 구현 클래스의 새로운 인스턴스를 생성한다.
		
		try {
			// factory를 사용한 SAXParser 의 새로운 객체 생성
			SAXParser parser = factory.newSAXParser();
			PeopleSaxHandler handler = new PeopleSaxHandler();
			parser.parse(file, handler);
			
			List<Person> list = handler.getPersonList();
			
			for(Person p:list) {
				System.out.println(p);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
}

