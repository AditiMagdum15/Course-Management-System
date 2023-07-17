package student.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import student.dao.StudentService;
import student.daoimpl.StudentServiceImpl;
import student.model.Student;

/**
 * Servlet implementation class edit_controller
 */
@WebServlet("/edit_controller")
@MultipartConfig
public class edit_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Student = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int stud_id=Integer.parseInt(request.getParameter("stud_id"));
		String stud_name=request.getParameter("stud_name");
		String dob=request.getParameter("stud_DOB");
		String stud_add=request.getParameter("stud_add");
		double stud_per=Double.parseDouble(request.getParameter("stud_per"));
		int course_id=Integer.parseInt(request.getParameter("course_id"));
		String pass=request.getParameter("pass");
		HttpSession s=request.getSession();
		Student student=(Student)s.getAttribute("edit");
		student.setStud_id(stud_id);
		student.setStud_name(stud_name);
		student.setStud_DOB(dob);
		student.setStud_add(stud_add);
		student.setStud_per(stud_per);
		student.setCourse_id(course_id);
		StudentServiceImpl s1=new StudentServiceImpl(null);
		boolean ans=s1.update(student);
		if(ans)
		{
			System.out.println("updates to db");
			
		}
		else {
			System.out.println("not updated");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
