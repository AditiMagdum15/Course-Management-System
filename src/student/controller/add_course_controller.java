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

import org.apache.catalina.connector.Request;

import student.dao.course_service;
import student.daoimpl.courseImpl;
import student.model.product;

/**
 * Servlet implementation class add_course_controller
 */
@WebServlet("/add_course_controller")
public class add_course_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add_course_controller() {
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int c=Integer.parseInt(request.getParameter("course_id"));
		String s=request.getParameter("course_name");
		int p=Integer.parseInt(request.getParameter("course_price"));
		course_service add=new courseImpl(null);
		product product=new product(c,s,p);
		List<product> lst2=new ArrayList<product>();
		lst2.add(product);
		String msg=add.createCourse(lst2);
		PrintWriter pri=response.getWriter();
		pri.print(msg);
		if(msg.equals("valid"))
		{
			response.sendRedirect("course_view.jsp");
		}
		else{
			response.sendRedirect("course_view.jsp");
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
