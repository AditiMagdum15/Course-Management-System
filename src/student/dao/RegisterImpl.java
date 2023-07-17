package student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import linkcode.ds.Datasource;
import student.model.Register;

public class RegisterImpl implements RegisterService{
	Datasource ds=new Datasource();
	@Override
	public int create(List<Register> lst) {
		// TODO Auto-generated method stub
		Register reg=lst.get(0);
		int i=0;
		Connection con=ds.getConnection();
		
		try {
			PreparedStatement pstate=con.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
			pstate.setInt(1, reg.getStud_id());
			pstate.setString(2, reg.getStud_name());
			pstate.setString(3, reg.getStud_DOB());
			pstate.setString(4, reg.getStud_add());
			pstate.setDouble(5, reg.getStud_per());
			pstate.setInt(6, reg.getCourse_id());
			pstate.setString(7, reg.getPass());
			i=pstate.executeUpdate();
		
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return i;

		
	}
	

}
