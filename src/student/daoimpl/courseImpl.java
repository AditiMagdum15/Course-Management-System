package student.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import student.dao.course_service;
import student.db.database;
import student.model.product;


public class courseImpl implements course_service{
	
	
	private Connection con;	
	
	public courseImpl(Connection con) {
		super();
		this.con = con;
	}

	public courseImpl() {
		super();
	}

	@Override
	public String createCourse(List<product> lst) {
		String str=null;
		database connect=new database();
		Connection con=connect.getConnection();
		product cour= lst.get(0);
		int i=0;
		
		try {
			PreparedStatement pstate=con.prepareStatement("insert into course values(?,?,?)");
			pstate.setInt(1,cour.getCourse_id());
			pstate.setString(2,cour.getCourse_name());
			pstate.setDouble(3,cour.getCourse_price());
			
			i=pstate.executeUpdate();
			if(i>0) {
				str="valid";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			str=e.getMessage();
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	@Override
	public List<product> editcourse(int course_id) {
		database connect=new database();
		Connection con=connect.getConnection();
		int i=0;		
		List<product> lst=new ArrayList<product>();
		try {
			PreparedStatement pstate=con.prepareStatement("delete from course where course_id =?");
			product cour= lst.get(0);
			pstate.setInt(1,cour.getCourse_id());
			i=pstate.executeUpdate();
			if(i>0) {
				System.out.println("Successfully deleted the information");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
	

	@Override
	public int deletecourse(int course_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<product> getAllcourse() {
		// TODO Auto-generated method stub
				database connect=new database();
				Connection con=connect.getConnection();
				int i=0;		
				List<product> lst=new ArrayList<product>();
				try {
					String str="select * from course order by course_id asc";
					Statement state=con.prepareStatement(str);
					ResultSet rSet=state.executeQuery(str);
					
					while(rSet.next()) {
//						coursemodel clst=new coursemodel(rSet.getInt(1), rSet.getString(2), rSet.getDouble(3), rSet.getString(4));
//						lst.add(clst);
						product row=new product();
						row.setCourse_id(rSet.getInt("course_id"));
						row.setCourse_name(rSet.getString("course_name"));
						row.setCourse_price(rSet.getInt("course_price"));
						
						lst.add(row);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return lst;
			}

	@Override
	public int addcourse(product p) {
		database connect=new database();
		Connection con=connect.getConnection();
		
		int i=0;
		String str="insert into course where course_id=?,course_name=?,course_price=? ";
		
		return 0;
	}
	

	
	
	

}
