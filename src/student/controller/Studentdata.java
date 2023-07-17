package student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import student.dao.StudentService;
import student.daoimpl.StudentServiceImpl;
import student.model.Student;

/**
 * Servlet implementation class Studentdata
 */
@WebServlet("/Studentdata")
public class Studentdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Object Student = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Studentdata() {
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
		String stud_DOB=request.getParameter("stud_DOB");
		String stud_addr=request.getParameter("stud_add");
		Double stud_per=Double.parseDouble(request.getParameter("stud_per"));
		int course_id=Integer.parseInt(request.getParameter("course_id"));
		String pass = request.getParameter("pass");
		PrintWriter p=response.getWriter();
		Student studobj=new Student(stud_id, stud_name, stud_DOB, stud_addr, stud_per, course_id, pass);
		System.out.println(studobj);
		List<Student> lststud=new ArrayList<Student>();
		lststud.add(studobj);
		StudentService s=new StudentServiceImpl(null);
		
		String msg=s.createStudent(lststud);
		p.print(msg);
		if(msg.equals("valid"))
		{
			request.getSession().setAttribute("edit",Student);
			
			response.sendRedirect("student_view.jsp");
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
