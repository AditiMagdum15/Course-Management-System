package student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.model.Register;
import student.dao.RegisterImpl;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int s1=Integer.parseInt(request.getParameter("stud_id"));
		String s2=request.getParameter("stud_name");
		String s3=request.getParameter("stud_DOB");
		String s4=request.getParameter("stud_add");		
		Double s5=Double.parseDouble(request.getParameter("stud_per"));
		int s6=Integer.parseInt(request.getParameter("course_id"));
		String s7=request.getParameter("pass");
		PrintWriter ps=response.getWriter();
		ps.print(s1);
		ps.print(s2);
		ps.print(s3);
		ps.print(s4);
		ps.print(s5);
		ps.print(s6);

		
		Register register=new Register(s1, s2, s3, s4, s5,s6,s7);
		
		List<Register>lst=new ArrayList<Register>();
		lst.add(register);	
		
		RegisterImpl rdao=new RegisterImpl();
		int i=rdao.create(lst);
		if(i>0)
		{
			//HttpSession session=request.getSession();
		//	session.setAttribute("msg",msg);
			response.sendRedirect("login.jsp");
		}
		else {
			response.sendRedirect("Home.html");
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
