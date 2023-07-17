package student.model;

public class order {
	private int course_id;
	private String course_name;
	private int course_price;
	public order(int course_id, String course_name, int course_price) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_price = course_price;
	}
	
	public order() {
		super();
	}

	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getCourse_price() {
		return course_price;
	}
	public void setCourse_price(int course_price) {
		this.course_price = course_price;
	}
	

}
