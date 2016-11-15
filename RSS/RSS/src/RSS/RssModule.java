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

	// �������б� Ȩ������ RSS�� 2.0������ �����Ƿ� RSS 2.0�� �������� �Ͽ� �±׸� ���
	static final String TITLE = "title";
	static final String LINK = "link";
	static final String AUTHOR = "author";
	static final String ITEM = "item";
	static final String DATE = "pubDate";
	
	final URL url;

	private final List<RSScontainer> elements = new ArrayList<RSScontainer>();

	public RssModule(String Url) { // ������
		try {
			this.url = new URL(Url); // URL ������ ����Ѵ�.(URL ��ü ����)
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	public void readRSS() {
		try {
			boolean isFeedHeader = true;
			// �ʱ�ȭ
			String title = "";
			String link = "";
			String author = "";
			String date = "";

			// XML ������ �Ľ��ϱ� ���� XMLInputFactory�� �����Ѵ�.(StAX parser)
			XMLInputFactory inputFactory = XMLInputFactory.newFactory();
			InputStream in = XMLread(); // XML stream ������ ���� I/OŬ������
										// InputStream��
										// ��ü�� ��´�.

			// XML ������ �б����� XMLEventReader ��ü ����
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

			while (eventReader.hasNext()) { // �о���� �� �̻� ���� ������ ������ false�� �����Ѵ�.
				XMLEvent event = eventReader.nextEvent(); // ���� XML �̺�Ʈ�� ������
															// event��ü�� ����

				// ���� �κп��� �±׿� ���� ������ ������ �����ϰ�, �� �κп����� ������ ������ FeedMessage��ü��
				// �Ѱ��ش�.
				if (event.isStartElement()) { // startElemnt���� üũ�Ѵ�.
					// ����� ����ȭ �̸��� ȹ���ϱ� ���� asStartElement�� getName�޼ҵ带 ȣ���Ѵ�.
					String localPart = event.asStartElement().getName().getLocalPart();

					// localPart�� �̸��� ���� XML�� ������ �����´�.
					switch (localPart) {
					case ITEM: // �Խñ� ������ �ǹ��Ѵ�.
						if (isFeedHeader) { // �� �� ����� �����ϱ� ����
							isFeedHeader = false;
						}
						event = eventReader.nextEvent();
						break;
					case TITLE: // ����
						title = getCharacterData(event, eventReader);
						break;
					case LINK: // ��ũ
						link = getCharacterData(event, eventReader);
						break;
					case DATE: // �ۼ���
						date = getCharacterData(event, eventReader);
						break;
					case AUTHOR: // ����
						author = getCharacterData(event, eventReader);
						break;
					}
				} else if (event.isEndElement()) { // EndElement���
					// �����ϴ� �κ�
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

	// �о�� ������ ��Ʈ������ ��ȯ��Ű������ �żҵ�
	private String getCharacterData(XMLEvent event, XMLEventReader eventReader) throws XMLStreamException {
		String data = ""; // �ʱ�ȭ
		event = eventReader.nextEvent();
		if (event instanceof Characters) { // Characters Ŭ������ ��ü�̸�,
			data = event.asCharacters().getData(); // result�� ����
		}
		return data;
	}

	// XML stream�� ������ �ڹ�I/O Inputstream���� �б� ���� �żҵ�.
	private InputStream XMLread() {
		try {
			return url.openStream(); // openStream(�Է� ��Ʈ������)
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RssModule parser = new RssModule(
				"http://www.dongguk.edu/rssList.jsp?boardId=3646&id=kr_010802000000&site_id=kr"); // rss�ּ�

		parser.readRSS(); //�д� �κ�
		for (RSScontainer message : parser.getAnnouncement()) { // ȭ�� ���
			System.out.println(message);

		}
	}

}
