package solution;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Solution_Servlet
 */
@WebServlet("/Solution_Servlet")
public class Solution_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Solution_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {			
			SolutionSQL solutionSQL = new SolutionSQL() ; 
			String paramCOntext = getServletContext().getInitParameter("number-solutions");
			int param = Integer.parseInt(getServletContext().getInitParameter("number-solutions"));
			List<Solution> solutionSQLs = solutionSQL.loadAll(param);
			request.setAttribute("solutionSQLs", solutionSQLs);
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			
		
	
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
