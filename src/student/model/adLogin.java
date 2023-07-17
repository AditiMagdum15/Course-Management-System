package student.model;

public class adLogin {
	private String unm;
	private String pass;
	public adLogin(String unm, String pass) {
		super();
		this.unm = unm;
		this.pass = pass;
	}
	public String getUnm() {
		return unm;
	}
	public void setUnm(String unm) {
		this.unm = unm;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}


}
