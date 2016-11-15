package RSS;

public class RSScontainer {
	private String title;
	private String link;
	private String author;
	private String date;

	public void setTitle(String title) {
		this.title = title;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "FeedMessage [title=" + title + ", link=" + link + ", date= " + date + ", author=" + author + "]";
	}
}
