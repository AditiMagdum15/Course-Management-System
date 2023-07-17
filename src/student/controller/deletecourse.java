package student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.LoginImpl;
import student.model.cart;

/**
 * Servlet implementation class deletecourse
 */
@WebServlet("/deletecourse")
public class deletecourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletecourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out=response.getWriter())
		{
			ArrayList<cart> lst=new ArrayList<>();
		String id=request.getParameter("course_id");
		out.print(id);
		
		if(id!=null)
		{
			LoginImpl l=new LoginImpl(null);
			String s=l.deletecourse(Integer.parseInt(id));
			
			
			if(s=="valid")
			{
				
				response.sendRedirect("course_view.jsp");
			}else {
				response.sendRedirect("course_view.jsp");
			}
		}
		
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
