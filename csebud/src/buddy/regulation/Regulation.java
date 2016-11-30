package buddy.regulation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import buddy.student.Course;

@Entity
public class Regulation {

	// needed credit
	String year;
	int gross;
	int mscGross;
	int mscMath;
	int mscScience;
	int mscProcess;
	int majorGross;
	int majorDesign;
	int englishMajor;
	int englishGross;
	int common;
	int cultural;
	int basic;
	int must;
	int select;
	List<LectureInfo> lecture;

	public String whatIsType(String lectureCode) {

		for (int i = 0; i < lecture.size(); i++) {
			
			if (lecture.get(i).getLcode().equals(lectureCode)||lecture.get(i).getSub().contains(lectureCode)) {
				//System.out.println(lecture.get(i).getLectureTitle()+"강의타입"+lecture.get(i).getType());
				return lecture.get(i).getLtype();
			}
		}
		
		return "cultural";
	}
	
	public boolean intToBool(int i){
		
		if(i==1) return true;
		else return false;
		
	}

	public void setSelect(int num, String value) {

		switch (num) {
		case 0:
			setYear(value);
			break;
		case 1:
			setGross(Integer.parseInt(value));
			break;
		case 2:
			setMscGross(Integer.parseInt(value));
			break;
		case 3:
			setMscMath(Integer.parseInt(value));
			break;
		case 4:
			setMscScience(Integer.parseInt(value));
			break;
		case 5:
			setMscProcess(Integer.parseInt(value));
			break;
		case 6:
			setMajorGross(Integer.parseInt(value));
			break;
		case 7:
			setMajorDesign(Integer.parseInt(value));
			break;
		case 8:
			setEnglishMajor(Integer.parseInt(value));
			break;
		case 9:
			setEnglishGross(Integer.parseInt(value));
			break;
		case 10:
			setCommon(Integer.parseInt(value));
			break;
		case 11:
			setCultural(Integer.parseInt(value));
			break;
		case 12:
			setBasic(Integer.parseInt(value));
			break;

		}

	}

	// 해당 년도의 lecturetype(강의구분)의 과목 출력
	public List<LectureInfo> getTypeLectureList(String lecturetype) {
		List<LectureInfo> result = new ArrayList();

		for (int i = 0; i < lecture.size(); i++) {
			if (lecture.get(i).getLtype().equals(lecturetype)) {
				result.add(lecture.get(i));
			}
		}
		return result;
	}

	public LectureInfo findLecture(String lectureCode) {

		for (int i = 0; i < lecture.size(); i++) {
			if (lecture.get(i).getLcode().equals(lectureCode)||lecture.get(i).getSub().contains(lectureCode)) {

				return lecture.get(i);
			}
		}
		return null;
	}

	public List<LectureInfo> getMustLectureList() {
		List<LectureInfo> result = new ArrayList();

		for (int i = 0; i < lecture.size(); i++) {
			if (lecture.get(i).getMust().equals("must")) {
				result.add(lecture.get(i));
			}
		}
		return result;
	}

	public List<LectureInfo> getSelectLectureList() {
		List<LectureInfo> result = new ArrayList();

		for (int i = 0; i < lecture.size(); i++) {
			if (lecture.get(i).getSelect().contains("select")) {
				result.add(lecture.get(i));
			}
		}
		return result;
	}

	public List<LectureInfo> getDesignLectureList() {
		List<LectureInfo> result = new ArrayList();

		for (int i = 0; i < lecture.size(); i++) {
			if (lecture.get(i).getEtc().contains("design")) {
				result.add(lecture.get(i));
			}
		}
		return result;
	}

	public List<LectureInfo> unMeetList(List<Course> courselist, String lecturetype) {

		List<LectureInfo> result = new ArrayList();

		if (lecturetype.equals("majorDesign")) {
			result.addAll(getDesignLectureList());
		} else if (lecturetype.equals("must")) {
			result.addAll(getMustLectureList());
		} else if (lecturetype.equals("select")) {
			result.addAll(getSelectLectureList());
		} else {

			result.addAll(getTypeLectureList(lecturetype));
			// System.out.println("???");

		}

		// for (int j = 0; j < result.size(); j++) {
		//
		// System.out.println(result.get(j).getLectureTitle() + "must");
		//
		// }
		//
		for (int i = 0; i < courselist.size(); i++) {
			for (int j = 0; j < result.size(); j++) {

				if (result.get(j).getLcode().equals(courselist.get(i).getLectureCode())||result.get(j).getSub().contains(courselist.get(i).getLectureCode())) {
					// System.out.println(result.get(j).getLectureTitle() +
					// "제거");
					result.remove(j);

					break;
				}

			}
		}

		return result;
	}
	
	public List<LectureInfo> unMeetEnglishList(List<Course> courselist, String level) {
	      List<LectureInfo> result = new ArrayList();

	      for (int i = 0; i < lecture.size(); i++) {
	         if (lecture.get(i).getEtc().contains(level)) {
	            result.add(lecture.get(i));
	            System.out.println(lecture.get(i).getEtc() + " ");
	         }
	      }

	      for (int i = 0; i < courselist.size(); i++) {
	         for (int j = 0; j < result.size(); j++) {

	            if (result.get(j).getLcode().equals(courselist.get(i).getLectureCode())
	                  || result.get(j).getSub().contains(courselist.get(i).getLectureCode())) {
	               // System.out.println(result.get(j).getLectureTitle() +
	               // "제거");
	               result.remove(j);

	               break;
	            }

	         }
	      }
	      return result;

	   }

	public List<LectureInfo> unMeetLectureList(List<Course> courselist, String type) {

		switch (type) {
		case "mscMath":
			//System.out.println("???");
			return unMeetList(courselist, "mscMath");

		case "mscScience":
			return unMeetList(courselist, "mscScience");

		case "mscProcess":
			return unMeetList(courselist, "mscProcess");
		case "major":
			return unMeetList(courselist, "major");
		case "majorDesign":
			return unMeetList(courselist, "majorDesign");

		case "basic":
			return unMeetList(courselist, "basic");
		case "common":
			return unMeetList(courselist, "common");

		case "must":
			return unMeetList(courselist, "must");

		case "select":
			return unMeetList(courselist, "select");

		default:
			return null;

		}
	}

	public int MeetCredit(List<Course> courselist, String lecturetype) {
	      int result = 0;

	      if (lecturetype.equals("majorDesign")) {
	         for (int i = 0; i < courselist.size(); i++) {

	            if (findLecture(courselist.get(i).getLectureCode()) != null) {
	               if (findLecture(courselist.get(i).getLectureCode()).getEtc().contains("design")&&!courselist.get(i).getGrade().equals("F")) {
	                  result = result + Integer.parseInt(courselist.get(i).getCredit());
	               }
	            } else {
	               // System.out.println("찾는 강의 없음");
	            }

	         }
	      } else if (lecturetype.equals("must")) {
	         for (int i = 0; i < courselist.size(); i++) {

	            if (findLecture(courselist.get(i).getLectureCode()) != null) {
	               if (findLecture(courselist.get(i).getLectureCode()).getMust().equals("must")&&!courselist.get(i).getGrade().equals("F")) {
	                  result++;
	               }
	            } else {
	               // System.out.println("찾는 강의 없음");
	            }

	         }
	      } else if (lecturetype.equals("select")) {
	         for (int i = 0; i < courselist.size(); i++) {

	            if (findLecture(courselist.get(i).getLectureCode()) != null) {
	               if (findLecture(courselist.get(i).getLectureCode()).getSelect().contains("select")&&!courselist.get(i).getGrade().equals("F")) {
	                  result++;
	               }
	            } else {
	               // System.out.println("찾는 강의 없음");
	            }

	         }
	      } else if (lecturetype.equals("englishGross")) {
	         for (int i = 0; i < courselist.size(); i++) {

	            if (this.intToBool(courselist.get(i).getIsEnglishCourse())&&!courselist.get(i).getGrade().equals("F")) {
	               result = result + 1;
	            }

	         }
	      } else if (lecturetype.equals("englishMajor")) {

	         for (int i = 0; i < courselist.size(); i++) {

	            if (whatIsType(courselist.get(i).getLectureCode()).equals("major")
	                  && this.intToBool(courselist.get(i).getIsEnglishCourse()) &&!courselist.get(i).getGrade().equals("F")) {
	               result = result + 1;
	            }

	         }
	      } else if (lecturetype.equals("gross")) {
	         for (int i = 0; i < courselist.size(); i++) {
	            if(!courselist.get(i).getGrade().equals("F"))
	            result = result + Integer.parseInt(courselist.get(i).getCredit());

	         }
	      } else if (lecturetype.equals("mscGross")) {
	         for (int i = 0; i < courselist.size(); i++) {

	            if (whatIsType(courselist.get(i).getLectureCode()).equals("mscMath")
	                  || whatIsType(courselist.get(i).getLectureCode()).equals("mscProcess")
	                  || whatIsType(courselist.get(i).getLectureCode()).equals("mscScience")) {
	               
	               if(!courselist.get(i).getGrade().equals("F"))
	               result = result + Integer.parseInt(courselist.get(i).getCredit());
	            }

	         }
	      } else {

	         for (int i = 0; i < courselist.size(); i++) {
	            // System.out.println("sdds" + lecture.size());

	            if (whatIsType(courselist.get(i).getLectureCode()).equals(lecturetype)&&!courselist.get(i).getGrade().equals("F")) {

	               result = result + Integer.parseInt(courselist.get(i).getCredit());
	               // System.out.println("기" + result);

	            }
	         }
	      }

	      if (lecturetype.equals("mscProcess")) {
	         if (this.mscProcess < result) {
	            result = this.mscProcess;
	         }
	      }

	      if (lecturetype.equals("mscScience")) {
	         String st = null;
	         for (int i = 0; i < courselist.size(); i++) {
	            // System.out.println("sdds" + lecture.size());

	            if (whatIsType(courselist.get(i).getLectureCode()).equals("mscScience")
	                  && findLecture(courselist.get(i).getLectureCode()) != null) {
	               if (findLecture(courselist.get(i).getLectureCode()).getLname().contains("개론")) {

	                  st = findLecture(courselist.get(i).getLectureCode()).getLname().substring(0, 2);
	                  System.out.println(st);

	                  for (int n = 0; n < courselist.size(); n++) {
	                     if (whatIsType(courselist.get(i).getLectureCode()).equals("mscScience")
	                           && findLecture(courselist.get(i).getLectureCode()) != null) {
	                        if (findLecture(courselist.get(i).getLectureCode()).getLname().contains("실험")
	                              && findLecture(courselist.get(i).getLectureCode()).getLname()
	                                    .contains(st)) {
	                           result = result - 3;
	                        }
	                     }
	                  }

	               }

	            }
	         }
	      }

	      return result;

	   }

	// -----------------------getter
	// setter------------------------------------------------------------------------------
	public int getGross() {
		return gross;
	}

	public void setGross(int gross) {
		this.gross = gross;
	}

	public int getMscGross() {
		return mscGross;
	}

	public void setMscGross(int mscGross) {
		this.mscGross = mscGross;
	}

	public int getMscMath() {
		return mscMath;
	}

	public void setMscMath(int mscMath) {
		this.mscMath = mscMath;
	}

	public int getMscScience() {
		return mscScience;
	}

	public void setMscScience(int mscScience) {
		this.mscScience = mscScience;
	}

	public int getMscProcess() {
		return mscProcess;
	}

	public void setMscProcess(int mscProcess) {
		this.mscProcess = mscProcess;
	}

	public int getMajorGross() {
		return majorGross;
	}

	public void setMajorGross(int majorGross) {
		this.majorGross = majorGross;
	}

	public int getMajorDesign() {
		return majorDesign;
	}

	public void setMajorDesign(int majorDesign) {
		this.majorDesign = majorDesign;
	}

	public int getEnglishMajor() {
		return englishMajor;
	}

	public void setEnglishMajor(int englishMajor) {
		this.englishMajor = englishMajor;
	}

	public int getEnglishGross() {
		return englishGross;
	}

	public void setEnglishGross(int englishGross) {
		this.englishGross = englishGross;
	}

	public int getCommon() {
		return common;
	}

	public void setCommon(int common) {
		this.common = common;
	}

	public int getCultural() {
		return cultural;
	}

	public void setCultural(int cultural) {
		this.cultural = cultural;
	}

	public int getBasic() {
		return basic;
	}

	public void setBasic(int basic) {
		this.basic = basic;
	}

	public String getYear() {
		return year;
	}

	public int getMust() {
		return must;
	}

	public void setMust(int must) {
		this.must = must;
	}

	public int getSelect() {
		return select;
	}

	public void setSelect(int select) {
		this.select = select;
	}

	public void setYear(String year) {
		this.year = year;
		lecture = new ArrayList();
		int must = 0;
		for (int i = 0; i < RegulationManager.cseTypeLecture.size(); i++) {
			if (RegulationManager.cseTypeLecture.get(i).getYear().equals(this.year)
					|| RegulationManager.cseTypeLecture.get(i).getYear().equals("ALL")) {
				lecture.add(RegulationManager.cseTypeLecture.get(i));

				// System.out.println("실행됨");

				if (RegulationManager.cseTypeLecture.get(i).getMust().equals("must")) {
					must = must + 1;

				}

				if (RegulationManager.cseTypeLecture.get(i).getSelect().contains("select")) {
					//System.out.println(" ---------------"+Integer.parseInt(RegulationManager.cseTypeLecture.get(i).getSelect().substring(6)));
					setSelect(Integer.parseInt(RegulationManager.cseTypeLecture.get(i).getSelect().substring(6)));
				}
			}
			
		}
		setMust(must);
	}

}
