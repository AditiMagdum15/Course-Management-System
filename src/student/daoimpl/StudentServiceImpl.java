package student.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import student.dao.StudentService;
import student.db.database;
import student.model.Student;

public class StudentServiceImpl implements StudentService {
	private Connection con;
	

	

	public StudentServiceImpl(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public String createStudent(List<Student> lst) {
		// TODO Auto-generated method stub
		String str=null;
		database dobj=new database();
		Connection con= dobj.getConnection();
		Student stud=lst.get(0);
		int i=0;
		
		try {
			PreparedStatement pstate=con.prepareStatement("insert into Student values(?,?,?,?,?,?,?)");
			pstate.setInt(1, stud.getStud_id());
			pstate.setString(2,stud.getStud_name());
			pstate.setString(3,stud.getStud_DOB());
			pstate.setString(4,stud.getStud_add());
			pstate.setDouble(5,stud.getStud_per());
			pstate.setInt(6,stud.getCourse_id());
			pstate.setString(7, stud.getPass());
			i=pstate.executeUpdate();
			
			if(i>0)
			{
				str="valid";
				System.out.println("You have successfully save the information !");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("text1..");
			System.out.println(e.getMessage());
			str=e.getMessage();
			e.printStackTrace();
		}
		
		return str;
	}

	@Override
	public Student retriveStudent(int stud_id) {
		// TODO Auto-generated method stub
		database dobj=new database();
		Student st=null;
		
		Connection con = (Connection) dobj.getConnection();
		int i=0;
		try {
			String query="select * from studnet where stud_id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			ps.setInt(1, stud_id);
			while(rs.next()) {
				 st=new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6),rs.getString(7));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return st;
	}

	@Override
	public int deleteStudent(int stud_id) {
		// TODO Auto-generated method stub
		
		int i=0;
		Connection con=database.getConnection();
		List<Student>lst=new ArrayList();
		
		try {
			PreparedStatement pstate=con.prepareStatement("delete from Student where stud_id =?");
			
			Student stud = lst.get(0);
			pstate.setInt(1, stud.getStud_id());
			i=pstate.executeUpdate();
			
			if(i>0)
			{
				System.out.println("You have successfully delete the information !");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return i;
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		
		Connection con=database.getConnection();
		
		List<Student> lst=new ArrayList();
		
		try {
			String str="select * from Student";
			PreparedStatement state=con.prepareStatement(str);
			System.out.println(state);
			ResultSet rs= state.executeQuery(str);
			
			while(rs.next()) {
				Student slst=new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6),rs.getString(7));
				lst.add(slst);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(lst);
		return lst;
	}
	public boolean update(Student s) {
		boolean b=false;
		Connection con=database.getConnection();
		try{
		PreparedStatement ps=con.prepareStatement("update student set student_name=?,student_dob=?,student_addr=?,student_per=?,course_id=? ,pass=? where student_id=?");
		
		
		ps.setString(1, s.getStud_name());
		ps.setString(2, s.getStud_DOB());
		ps.setString(3, s.getStud_add());
		ps.setString(4, s.getStud_add());
		ps.setDouble(5, s.getStud_per());
		ps.setInt(6, s.getCourse_id());
		ps.setString(7, s.getPass());
		ps.setInt(7, s.getStud_id());
		ps.executeUpdate();
		b=true;
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		return b;
		
	}
	

}

