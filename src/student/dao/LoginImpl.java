package student.dao;

import java.security.spec.DSAGenParameterSpec;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.State;

import linkcode.ds.Datasource;
import student.model.Login;
import student.model.Student;
import student.model.cart;
import student.model.product;

public class LoginImpl implements LoginService{
	private Connection con;
	String query;
	Datasource ds;
	PreparedStatement state=null;
	String msg;
	
	

	public LoginImpl(Connection con) {
		super();
		this.con = con;
	}

	

	



	@Override
	public String validateUser(List<Login> log) {
		// TODO Auto-generated method stub
		
		Login l=log.get(0);
		log=null;
		int i=0;
		
		String msg=null;
		query="select student_id,pass from student where student_id=? and pass=?";
		try {
			Connection con=ds.getConnection();
			System.out.println(query);
			state=con.prepareStatement(query);
			state.setString(1, l.getUnm());
			state.setString(2, l.getPas());
			ResultSet rs=state.executeQuery();
			if(rs.next())
			{
				msg="valid";
			}
			
			System.out.println(msg);
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return msg;

	}

	@Override
	public int deleteUser(List<Login> log) {
		// TODO Auto-generated method stub
		Datasource ds=new Datasource();
		Login l=log.get(0);
		log=null;
		String str="delete from student where username=?";
		try { 
			Connection con=ds.getConnection();
			PreparedStatement pstate=con.prepareStatement("delete from linkcodebank where username=?");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return 0;

		
	}
	public List<product> getallproducts() {
		List<product> products=new ArrayList<product>();
		try {
			query="select * from course order by course_id asc";
			Connection con=ds.getConnection();
			state=con.prepareStatement(query);
			ResultSet rst=state.executeQuery();
			while(rst.next())
			{
				product row=new product();
				
				row.setCourse_id(rst.getInt("course_id"));
				row.setCourse_name(rst.getString("course_name"));
				row.setCourse_price(rst.getInt("course_price"));
				products.add(row);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return products;
		
	}
  public List<cart> getcartproduct(ArrayList<cart> carts) {
	  List<cart> products=new ArrayList<cart>();
	  System.out.println(products);
	  try {
		  if(carts.size()>0)
		  {
			  for(cart item:carts)
			  {
				  query="select * from course where course_id=? ";
				  Connection con=ds.getConnection();
					state=con.prepareStatement(query);
				    state.setInt(1, item.getCourse_id());
					ResultSet rst=state.executeQuery();
					while(rst.next())
					{
						cart row=new cart();
						row.setCourse_id(rst.getInt("course_id"));
						row.setCourse_name(rst.getString("course_name"));
						row.setCourse_price(rst.getInt("course_price"));
						products.add(row);
					}
			  }
			  
		  }
		  
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return products;
	
}
  public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		
	  	Connection con=ds.getConnection();
		List<Student> lst=new ArrayList<Student>();
		
		try {
			String str="select * from student";
			System.out.println(str);
			
			Statement state=con.prepareStatement(str);
			ResultSet rs= state.executeQuery(str);
			
			while(rs.next()) {
//				Student slst=new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6),rs.getString(7));
//				lst.add(slst);
				Student row=new Student();
				row.setStud_id(rs.getInt("stud_id"));
				row.setStud_name(rs.getString("stud_name"));
				row.setStud_DOB(rs.getString("stud_DOB"));
				row.setStud_add(rs.getString("stud_add"));
				row.setStud_per(rs.getDouble("stud_per"));
				row.setCourse_id(rs.getInt("course_id"));
				row.setPass(rs.getString("pass"));
				lst.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(lst);
		
		return lst;
		
//		
	}







public String deletecourse(int parseInt) {
	
	con=ds.getConnection();
	
	try {
		
		query="delete from course where course_id=?";
		System.out.println("hello1");
		System.out.println(parseInt);
		state=con.prepareStatement(query);
		state.setInt(1,parseInt);
		System.out.println("hello2");
		ResultSet rs=state.executeQuery();
		if(rs.next())
		{
			System.out.println("hello");
			msg="valid";
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return msg;
	
}  
	
	
	

}
