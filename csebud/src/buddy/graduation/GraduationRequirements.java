package buddy.graduation;

import java.util.ArrayList;

import buddy.regulation.Regulation;

public class GraduationRequirements{
	
	private ArrayList<Regulation> regulation;
	private GraduationManager graduationManager;
	
	public void findRegulation(){}

	// getter / setter 메서드
	public ArrayList<Regulation> getRegulation() {
		return regulation;
	}

	public void setRegulation(ArrayList<Regulation> regulation) {
		this.regulation = regulation;
	}

	public GraduationManager getGraduationManager() {
		return graduationManager;
	}

	public void setGraduationManager(GraduationManager graduationManager) {
		this.graduationManager = graduationManager;
	}
	
}