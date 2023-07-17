package student.dao;

import java.util.List;

import student.model.Login;

public interface LoginService {
	
	public String validateUser(List<Login> log);
	public int deleteUser(List<Login> log);

}
