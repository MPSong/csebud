package buddy.lecture;

import java.util.ArrayList;

import buddy.lecture.LectureReview;

public class LectureReviewManager{
	
	private ArrayList<LectureReview> reviews;
	
	// 아직 구현되지 않은 메서드들
	public void writeReview(String writerId, String writerPwd, String content, int lectureCode){}
	public void adjustReview(String writerId, String writerPwd, String content){}
	public void deleteReview(String writerId, String writerPwd, String content){}
	public LectureReview retrieveReview(int reviewCode)
	{
		return null;
	}
	
	// getter / setter 메서드들
	public ArrayList<LectureReview> getReviews() {
		return reviews;
	}
	public void setReviews(ArrayList<LectureReview> reviews) {
		this.reviews = reviews;
	}
	
}