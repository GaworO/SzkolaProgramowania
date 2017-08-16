package solution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.model.DbUtil;

public class SolutionSQL implements SolutionDAO {

	
	public static String LOAD_ALL = "SELECT * FROM SOLUTION ORDER BY created LIMIT  ?";
	
	public static String SOLUTION_ID = "solution_id";
	public static String CREATED_DATE= "created";
	public static String UPADE_DATE= "upade";
	public static String DESCRIPTION= "description";
	
	

	private Connection createConnection() throws SQLException {
		Connection c = DbUtil.getConn();
		return c;
	}
	
	@Override
	public List<Solution> loadAll(int line) {
		
		try (Connection connection = createConnection() ; 
			 PreparedStatement preparedStatement = connection.prepareStatement(LOAD_ALL);){
			
			preparedStatement.setInt(1, line);
			try (ResultSet resultSet = preparedStatement.executeQuery();){
			List<Solution> solutions = new ArrayList<>();
			while(resultSet.next()){
				solutions.add(new Solution(resultSet.getInt(SOLUTION_ID) , resultSet.getDate(CREATED_DATE),
								resultSet.getDate(UPADE_DATE), resultSet.getString(DESCRIPTION)));
			}
			return solutions ; 
			
			}	
		} catch (SQLException e) {
			throw new RuntimeException("Nie ma takiego rozwiązania");
		}
		
			
		
		
	
	}
	
}




