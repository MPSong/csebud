package RSS;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

public class RssModule {

	// 동국대학교 홈페이지 RSS는 2.0버전을 따르므로 RSS 2.0을 기준으로 하여 태그를 사용
	static final String TITLE = "title";
	static final String LINK = "link";
	static final String AUTHOR = "author";
	static final String ITEM = "item";
	static final String DATE = "pubDate";
	
	final URL url;

	private final List<RSScontainer> elements = new ArrayList<RSScontainer>();

	public RssModule(String Url) { // 생성자
		try {
			this.url = new URL(Url); // URL 정보를 등록한다.(URL 객체 생성)
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	public void readRSS() {
		try {
			boolean isFeedHeader = true;
			// 초기화
			String title = "";
			String link = "";
			String author = "";
			String date = "";

			// XML 문서를 파싱하기 위해 XMLInputFactory를 생성한다.(StAX parser)
			XMLInputFactory inputFactory = XMLInputFactory.newFactory();
			InputStream in = XMLread(); // XML stream 파일을 열어 I/O클래스인
										// InputStream의
										// 객체에 담는다.

			// XML 파일을 읽기위한 XMLEventReader 객체 생성
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

			while (eventReader.hasNext()) { // 읽어오며 더 이상 읽을 내용이 없으면 false를 리턴한다.
				XMLEvent event = eventReader.nextEvent(); // 다음 XML 이벤트를 가져와
															// event객체에 저장

				// 시작 부분에서 태그에 따라 변수에 정보를 저장하고, 끝 부분에서는 저장한 정보를 FeedMessage객체에
				// 넘겨준다.
				if (event.isStartElement()) { // startElemnt인지 체크한다.
					// 요소의 정규화 이름을 획득하기 위해 asStartElement의 getName메소드를 호출한다.
					String localPart = event.asStartElement().getName().getLocalPart();

					// localPart의 이름에 따라 XML의 내용을 가져온다.
					switch (localPart) {
					case ITEM: // 게시글 시작을 의미한다.
						if (isFeedHeader) { // 맨 위 헤더는 무시하기 위해
							isFeedHeader = false;
						}
						event = eventReader.nextEvent();
						break;
					case TITLE: // 제목
						title = getCharacterData(event, eventReader);
						break;
					case LINK: // 링크
						link = getCharacterData(event, eventReader);
						break;
					case DATE: // 작성일
						date = getCharacterData(event, eventReader);
						break;
					case AUTHOR: // 저자
						author = getCharacterData(event, eventReader);
						break;
					}
				} else if (event.isEndElement()) { // EndElement라면
					// 저장하는 부분
					if (event.asEndElement().getName().getLocalPart() == (ITEM)) {
						RSScontainer message = new RSScontainer();
						message.setAuthor(author);
						message.setLink(link);
						message.setTitle(title);
						message.setDate(date);
						getAnnouncement().add(message);
						event = eventReader.nextEvent();
						continue;
					}
				}
			}
		} catch (XMLStreamException e) {
			throw new RuntimeException(e);
		}
	}

	public List<RSScontainer> getAnnouncement() {
		return elements;
	}

	// 읽어온 내용을 스트링으로 변환시키기위한 매소드
	private String getCharacterData(XMLEvent event, XMLEventReader eventReader) throws XMLStreamException {
		String data = ""; // 초기화
		event = eventReader.nextEvent();
		if (event instanceof Characters) { // Characters 클래스의 객체이면,
			data = event.asCharacters().getData(); // result에 저장
		}
		return data;
	}

	// XML stream의 파일을 자바I/O Inputstream으로 읽기 위한 매소드.
	private InputStream XMLread() {
		try {
			return url.openStream(); // openStream(입력 스트림개설)
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RssModule parser = new RssModule(
				"http://www.dongguk.edu/rssList.jsp?boardId=3646&id=kr_010802000000&site_id=kr"); // rss주소

		parser.readRSS(); //읽는 부분
		for (RSScontainer message : parser.getAnnouncement()) { // 화면 출력
			System.out.println(message);

		}
	}

}
