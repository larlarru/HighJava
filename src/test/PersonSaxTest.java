package test;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;

public class PersonSaxTest {
	public static void main(String[] args) {
		File file = new File("./src/test/people.xml");	// file 대신, api 키로 만들어진 uri 주소도 가능
		SAXParserFactory factory = SAXParserFactory.newInstance();	
		// SAXParser 객체를 초기화 하려면
		// 먼저 SAXParserFactory 인스턴스를 초기화 해야한다.
		
		// 이 메소드는 SAXParserFactory 구현 클래스를 로드하고 
		// 초기화하기 위해 javax.xml.parsers.SAXParserFactory 시스템 속성을 참고한다. 
		
		// 만약 javax.xml.parser.SAXParserFactory 
		// 시스템 속성이 정의되어 있지 않을 때에는 
		// 플랫폼 디폴트의 SAXParserFactory 인스턴스가 리턴된다. 
		
		// 만약 런타임에서 SAXParserFactory 
		// 구현 클래스가 설명된 javax.xml.parsers.SAXParserFactory 
		// 속성이 로드 되지 않거나 초기화가 안되면 
		// FactoryConfigurationError가 발생된다.
		
		//------------------------------
		
		// SAXParserFactory 인스턴스는 
		// 임의로 애플리케이션 프로그래머가 
		// factory의 setNamespaceAware와 
		// setValidateing 메소드를 이용해서 
		// 네임스페이스(namespace)나 유효성을 정해주는 것으로 설정한다. 
		// 애플리케이션 프로그래머가 세팅하는 데로 파서가 설정되지 않을 때는 
		// ParserConfigurationException이 발생된다.
		
		// =======================================================
		
		//// 구현 클래스의 새로운 인스턴스를 생성한다.
		
		try {

			// factory를 사용할 SAXParser 의 새로운 객체 생성
			SAXParser parser = factory.newSAXParser();
			// PeopleSaxHandler 클래스 선언
			PeopleSaxHandler handler = new PeopleSaxHandler();
			// 생성된 file과 handler를 통해서 SAXParser객체로 파싱해 가져온다.
			parser.parse(file, handler);
									
			// PeopleSaxHandler 클래스에 있는 파싱한 사람객체를 넣은 리스트를 출력하기 위해 
			// 파싱한 사람객체리스트를 담을 리스트를 만든다.
			List<Person> list = handler.getPersonList();
			
			for(Person p:list) {
				System.out.println(p);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
}

