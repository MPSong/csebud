package buddy.rss;

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

import buddy.rss.RssContainer;

public class RssModule {

	static final String TITLE = "title";
	static final String LINK = "link";
	static final String AUTHOR = "author";
	static final String ITEM = "item";
	static final String DATE = "pubDate";

	final URL url;

	private final List<RssContainer> elements = new ArrayList<RssContainer>();

	public RssModule(String Url) {
		try {
			this.url = new URL(Url);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	public void readRSS() {
		try {
			boolean isFeedHeader = true;

			String title = "";
			String link = "";
			String author = "";
			String date = "";
			int flag = 0;
			
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			InputStream in = XMLread();

			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

			while (eventReader.hasNext() && flag < 10) {
				XMLEvent event = eventReader.nextEvent();
				if (event.isStartElement()) {
					
					String localPart = event.asStartElement().getName().getLocalPart();

					switch (localPart) {
					case ITEM:
						if (isFeedHeader) {
							isFeedHeader = false;
						}
						event = eventReader.nextEvent();
						break;
					case TITLE:
						title = getCharacterData(event, eventReader);
						break;
					case LINK:
						link = getCharacterData(event, eventReader);
						break;
					case DATE:
						date = getCharacterData(event, eventReader);
						break;
					case AUTHOR:
						author = getCharacterData(event, eventReader);
						break;
					}
				} else if (event.isEndElement()) {
					if (event.asEndElement().getName().getLocalPart() == (ITEM)) {
						RssContainer message = new RssContainer();
						message.setAuthor(author);
						message.setLink(link);
						message.setTitle(title);
						message.setDate(date);
						getList().add(message);
						event = eventReader.nextEvent();
						flag++;
						continue;
					}
				}
			}
		} catch (XMLStreamException e) {
			throw new RuntimeException(e);
		}
	}

	public List<RssContainer> getList() {
		return elements;
	}

	private String getCharacterData(XMLEvent event, XMLEventReader eventReader) throws XMLStreamException {
		String data = "";
		event = eventReader.nextEvent();
		if (event instanceof Characters) {
			data = event.asCharacters().getData();
		}
		return data;
	}

	private InputStream XMLread() {
		try {
			return url.openStream();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
