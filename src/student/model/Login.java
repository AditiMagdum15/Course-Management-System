package student.model;

public class Login {
	
	private String unm;
	private String pas;
	
	public Login(String unm, String pas) {
		super();
		this.unm = unm;
		this.pas = pas;
	}
	public String getUnm() {
		return unm;
	}
	public void setUnm(String unm) {
		this.unm = unm;
	}
	public String getPas() {
		return pas;
	}
	public void setPas(String pas) {
		this.pas = pas;
	}
	
	

}
