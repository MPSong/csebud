package buddy.regulation;

import java.util.ArrayList;

public class Regulation{
	
	private int creditMajor;
	private int creditGeneral;
	private int msc;
	private ArrayList<String> preComplete;
	private ArrayList<String> requiredMajor;
	private ArrayList<String> requiredGeneral;
	public static enum regulationType { nineToEleven, twelve, thirteenToFourteen, fifteenToSixteen }
	// 각 학번 별로 다른 규정을 구분하기 위한 static enum 변수. 09-11/12/13-14/15-16 별로 다른 교칙이 적용된다.
	
	public void compareUser(){}

	
	// getter / setter 메서드들
	public int getCreditMajor() {
		return creditMajor;
	}

	public void setCreditMajor(int creditMajor) {
		this.creditMajor = creditMajor;
	}

	public int getCreditGeneral() {
		return creditGeneral;
	}

	public void setCreditGeneral(int creditGeneral) {
		this.creditGeneral = creditGeneral;
	}

	public int getMsc() {
		return msc;
	}

	public void setMsc(int msc) {
		this.msc = msc;
	}

	public ArrayList<String> getPreComplete() {
		return preComplete;
	}

	public void setPreComplete(ArrayList<String> preComplete) {
		this.preComplete = preComplete;
	}

	public ArrayList<String> getRequiredMajor() {
		return requiredMajor;
	}

	public void setRequiredMajor(ArrayList<String> requiredMajor) {
		this.requiredMajor = requiredMajor;
	}

	public ArrayList<String> getRequiredGeneral() {
		return requiredGeneral;
	}

	public void setRequiredGeneral(ArrayList<String> requiredGeneral) {
		this.requiredGeneral = requiredGeneral;
	}
	
	
}