package student.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.dao.log_service;
import student.daoimpl.log_serviceImpl;
import student.model.adLogin;

/**
 * Servlet implementation class admin_log_controller
 */
@WebServlet("/admin_log_controller")
public class admin_log_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_log_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s1=request.getParameter("unm");
		String s2=request.getParameter("pass");
		
		log_service ls=new log_serviceImpl(null);
		adLogin log=new adLogin(s1, s2);
		List<adLogin> lst=new ArrayList<adLogin>();
		lst.add(log);
			
		String msg=ls.validateUser(lst);
		System.out.println(msg);
		 HttpSession session=request.getSession();
		
		if(msg.equals("valid")) {
			System.out.println("login success....");
			request.getSession().setAttribute("msg1", log);
			response.sendRedirect("student_view.jsp");
		}
		else if(msg.equals("nvalid"))
		{
			response.sendRedirect("adlogin.jsp");
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
