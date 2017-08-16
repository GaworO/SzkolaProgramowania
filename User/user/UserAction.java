package user;


import java.io.IOException;
import java.net.Inet4Address;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserAction
 */
@WebServlet("/UserAction")
public class UserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String act = request.getParameter("acction");
		UserSQL userSQL = new UserSQL(); 
		int userId = Integer.parseInt(request.getParameter("user"));
		
		if(act.equals("add")){
			getServletContext().getRequestDispatcher("indexU").forward(request, response);
			
			
			
		} else if(act.equals("delete")){
			User user = userSQL.findById(userId);
			userSQL.delete(user);
			getServletContext().getRequestDispatcher("/UserPanel").forward(request, response);
			
			
		}else if(act.equals("edit")){
			
			User user = userSQL.findById(userId);
			userSQL.update(user);
			request.setAttribute("userSQL", userSQL);
			getServletContext().getRequestDispatcher("/indexUS").forward(request, response);
			
			
			
		}
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
