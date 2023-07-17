package student.model;

public class Register {
	
	private int stud_id;
	private String stud_name;
	private String stud_DOB;
	private String stud_add;
	private Double stud_per;
	private int course_id;
	private String pass;
	public Register(int stud_id, String stud_name, String stud_DOB, String stud_add, Double stud_per, int course_id,
			String pass) {
		super();
		this.stud_id = stud_id;
		this.stud_name = stud_name;
		this.stud_DOB = stud_DOB;
		this.stud_add = stud_add;
		this.stud_per = stud_per;
		this.course_id = course_id;
		this.pass = pass;
	}
	public int getStud_id() {
		return stud_id;
	}
	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}
	public String getStud_name() {
		return stud_name;
	}
	public void setStud_name(String stud_name) {
		this.stud_name = stud_name;
	}
	public String getStud_DOB() {
		return stud_DOB;
	}
	public void setStud_DOB(String stud_DOB) {
		this.stud_DOB = stud_DOB;
	}
	public String getStud_add() {
		return stud_add;
	}
	public void setStud_add(String stud_add) {
		this.stud_add = stud_add;
	}
	public Double getStud_per() {
		return stud_per;
	}
	public void setStud_per(Double stud_per) {
		this.stud_per = stud_per;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
}
