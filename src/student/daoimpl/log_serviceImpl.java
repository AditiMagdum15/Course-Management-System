package student.daoimpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.activation.DataSource;

import linkcode.ds.Datasource;
import student.dao.log_service;
import student.db.database;
import student.model.Login;
import student.model.adLogin;
import student.model.order;
import student.model.product;

public class log_serviceImpl implements log_service{
	private Connection con;
	String query;
	Datasource ds;
	PreparedStatement state=null;
	public log_serviceImpl(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public String validateUser(List<adLogin> log) {
		// TODO Auto-generated method stub
		
		adLogin l=log.get(0);
		log=null;
		int i=0;
		
		String msg=null;
		query="select * from l where unm=? and pass=?";
		try {
			Connection con=ds.getConnection();
			System.out.println("connector"+con);
			System.out.println("hii");
			System.out.println(query);
			state=con.prepareStatement(query);
			state.setString(1, l.getUnm());
			state.setString(2, l.getPass());
			ResultSet rs=state.executeQuery();
			if(rs.next())
			{
				msg="valid";
			}
			else{
				msg="nvalid";
			}
			System.out.println(msg);
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return msg;

	}

	public boolean insertorder(product ordermodel) {
		boolean b=false;
		try {
			query="insert into order1(course_id,course_name,course_price) select course_id,course_name,course_price from course where course_id=?";
			state=con.prepareStatement(query);
			state.setInt(1, ordermodel.getCourse_id());
			b=true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}


	



	

}
