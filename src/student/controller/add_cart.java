package student.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.activation.DataSource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.daoimpl.log_serviceImpl;
import student.db.database;
import student.model.order;
import student.model.product;

/**
 * Servlet implementation class add_cart
 */
@WebServlet("/add_cart")
public class add_cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public add_cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (java.io.PrintWriter out = response.getWriter()) {
			ArrayList<product> lst = new ArrayList<>();
			int id = Integer.parseInt(request.getParameter("Course_id"));
			product ordermodel = new product();
			ordermodel.setCourse_id(id);
			log_serviceImpl l = new log_serviceImpl(database.getConnection());
			boolean result = l.insertorder(ordermodel);
			out.print(result);
			HttpSession session = request.getSession();
			ArrayList<order> order = (ArrayList<student.model.order>) session.getAttribute("order");
			if (result == true) {
				if (order == null) {
					lst.add(ordermodel);
					session.setAttribute("order", lst);
					response.sendRedirect("course_list.jsp");
				} else {
					ArrayList<product> product = null;
					lst = product;
					boolean exist = false;
					for (order o : order) {
						if (o.getCourse_id() == id) {
							exist = true;
							out.print(
									"<h3 style='color:crimson; text-align: center'>Item Already in Cart. <a href='cart.jsp'>GO to Cart Page</a></h3>");

						}
					}
					if (!exist) {
						lst.add(ordermodel);
					}
				}
			} else {
				out.print("The value is false");
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
