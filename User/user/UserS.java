package user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserS
 */
@WebServlet("/UserS")
public class UserS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("name");
		UserSQL userSQL = new UserSQL() ; 
		
		
		if(request.getParameterMap().containsKey("userId")){
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			int group_id = Integer.parseInt(request.getParameter("id"));
			int id = Integer.parseInt(request.getParameter("userId"));
			User user = new User(id, userName, email, password, group_id);
			userSQL.update(user);
		} else {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			int group_id = Integer.parseInt(request.getParameter("id"));
			User user = new User(0, userName, email, password, group_id);
			userSQL.update(user);
		}
		response.sendRedirect(request.getContextPath()+"/UserPanel");		
		
		
	}

}
