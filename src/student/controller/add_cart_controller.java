package student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.smartcardio.Card;

import student.model.cart;

/**
 * Servlet implementation class add_cart_controller
 */
@WebServlet("/add_cart_controller")
public class add_cart_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object lst1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add_cart_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out=response.getWriter())
		{
			ArrayList<cart> lst=new ArrayList<>();
			
			int id=Integer.parseInt(request.getParameter("Course_id"));
			
			cart cm=new cart();
			cm.setCourse_id(id);
			
			HttpSession session=request.getSession();
			ArrayList<cart> cart_list= (ArrayList<cart>) session.getAttribute("cart-list");
			if(cart_list==null)
			{
				lst.add(cm);
				session.setAttribute("cart-list", lst);
				response.sendRedirect("course_list.jsp");
			}
			else {
				lst=cart_list;
				boolean exist=false;
				for(cart c:cart_list)
				{
					if(c.getCourse_id()==id)
					{
						exist=true;
						out.println("<h3 style='color:crimson; text-align: center'>Item Already in Cart. <a href='cart.jsp'>GO to Cart Page</a></h3>");
						
					}
				}
				if(!exist)
				{
					lst.add(cm);
					
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
