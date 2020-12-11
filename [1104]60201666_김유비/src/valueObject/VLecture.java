package valueObject;

public class VLecture {
	
	private String code; 
	private String lectureName;
	private String location;
	private String personnel;
	private String credit;
	private String professor;
	private String time;
	private String campus;
	
	public VLecture(String code, String lectureName, String location, String personnel, String credit, String professor, String time, String campus) {
		this.code = code;
		this.lectureName = lectureName;
		this.location = location;
		this.personnel = personnel;
		this.credit = credit;
		this.professor = professor;
		this.time = time;
		this.campus =campus;
		
	}
	
	public VLecture(String code, String lectureName, String personnel, String credit, String professor, String time, String campus) {
		this.code = code;
		this.lectureName = lectureName;
		this.personnel = personnel;
		this.credit = credit;
		this.professor = professor;
		this.time = time;
		this.campus =campus;
		
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLectureName() {
		return lectureName;
	}
	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPersonnel() {
		return personnel;
	}
	public void setPersonnel(String personnel) {
		this.personnel = personnel;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	
	
}
