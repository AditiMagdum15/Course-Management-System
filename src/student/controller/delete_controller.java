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

import com.sun.media.jfxmedia.events.NewFrameEvent;

import student.model.cart;

/**
 * Servlet implementation class delete_controller
 */
@WebServlet("/delete_controller")
public class delete_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out=response.getWriter())
		{
			ArrayList<cart> lst=new ArrayList<>();
		String id=request.getParameter("Course_id");
		out.print("hi");
		
		if(id!=null)
		{
			
			ArrayList< cart> cart_list=(ArrayList<cart>) request.getSession().getAttribute("cart-list");
			
			if(cart_list!=null)
			{
				for(cart c:cart_list)
				{
					if (c.getCourse_id()==Integer.parseInt(id)) {
						cart_list.remove(cart_list.indexOf(c));
						break;
						
					}
				}
				response.sendRedirect("cart.jsp");
			}else {
				response.sendRedirect("cart.jsp");
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
