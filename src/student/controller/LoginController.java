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

import student.model.Login;
import student.model.Student;
import student.dao.LoginImpl;
import student.dao.LoginService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Object Student = null;
	private static final Object Login = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String s1=request.getParameter("email");
		String s2=request.getParameter("password");
		LoginService ls=new LoginImpl(null);
		Login login=new Login(s1, s2); 
		List<Login>lst=new ArrayList<Login>();
		lst.add(login);
		
		String msg=ls.validateUser(lst);
		PrintWriter s=response.getWriter();
		
		if(msg.equals("valid")) {
			request.getSession().setAttribute("auth", Login);
			response.sendRedirect("course_list.jsp");
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute(msg, session);
			response.sendRedirect("login.jsp");
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
