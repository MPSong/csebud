package buddy.lecture;

import java.util.Date;

public class LectureReview{
	
	private int reviewCode;
	private String writerId;
	private String writerPwd;
	private String content;
	private Date writtenTime;
	private int lectureCode;
	
	// getter / setter 메서드들
	public int getReviewCode() {
		return reviewCode;
	}
	public void setReviewCode(int reviewCode) {
		this.reviewCode = reviewCode;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getWriterPwd() {
		return writerPwd;
	}
	public void setWriterPwd(String writerPwd) {
		this.writerPwd = writerPwd;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWrittenTime() {
		return writtenTime;
	}
	public void setWrittenTime(Date writtenTime) {
		this.writtenTime = writtenTime;
	}
	public int getLectureCode() {
		return lectureCode;
	}
	public void setLectureCode(int lectureCode) {
		this.lectureCode = lectureCode;
	}
	
}