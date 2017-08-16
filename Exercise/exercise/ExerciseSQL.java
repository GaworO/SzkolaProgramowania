package exercise;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import pl.coderslab.model.DbUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExerciseSQL implements ExerciseDao {

	// TU SKOŃCZYŁAM

	// private Integer exercise_id ;
	// private String titile ;
	// private String description ;

	private static String INSERT_NEW_EXERCISE = "INSERT INTO EXERCISE VALUES(0,?,?)";
	private static String FIND_ALL = "SELECT * FROM EXERCISE";
	private static String UPDATE = "UPDATE EXERCISE SET title = ? , description  = ?";
	private static String DELETE_BY_ID = "DELETE EXERCISE WHERE exercise_id =?";
	private static String FIND_BY_ID = "SELECT * FROM EXERCISE WHERE exercise_id =?";
	private static String DELETE_ALL = "DELETE * FROM EXERCISE ";

	private static String EXERCISE_ID = "exercise_id ";
	private static String DESCRIPTION = "description";
	private static String TITLE = "title";

	private Connection createConnection() throws SQLException {
		Connection c = DbUtil.getConn();
		return c;
	}

	@Override
	public Exercise insert(Exercise exercise) {

		try (Connection connection = createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_EXERCISE,
						PreparedStatement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, exercise.getTitile());
			preparedStatement.setString(2, exercise.getDescription());

			int desc = preparedStatement.executeUpdate();
			if (desc != 1) {
				throw new RuntimeException();
			}
			try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
				if (resultSet.first()) {
					exercise.setExercise_id(resultSet.getInt(1));
					return exercise;
				} else {
					throw new RuntimeException();
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

	@Override
	public List<Exercise> findAll() {

		try (Connection connection = createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			List<Exercise> exercises = new ArrayList<>();
			while (resultSet.next()) {
				exercises.add(new Exercise(resultSet.getInt(EXERCISE_ID), resultSet.getString(TITLE),
						resultSet.getString(DESCRIPTION)));

			}

			return exercises;

		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	@Override
	public void update(Exercise exercise) {

		try (Connection connection = createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {

			preparedStatement.setString(1, exercise.getTitile());
			preparedStatement.setString(2, exercise.getDescription());

			int desc = preparedStatement.executeUpdate();
			if (desc != 1) {
				throw new RuntimeException("Zmiana nie nastąpiła");
			}

		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	@Override
	public void delete(Exercise exercise) {

		try (Connection connection = createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {

			preparedStatement.setInt(1, exercise.getExercise_id());
			int desc = preparedStatement.executeUpdate();
			if (desc != 0) {
				throw new RuntimeException("Nie nastąpiło usunięcie ");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public List<Exercise> findById(int exercise_id) {

		try (Connection connection = createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(EXERCISE_ID)) {
			preparedStatement.setInt(1, exercise_id);
			List<Exercise> exercises = new ArrayList<>();

			try (ResultSet resultSet = preparedStatement.executeQuery();) {
				if (resultSet.first()) {
					exercises.add(new Exercise(resultSet.getInt(EXERCISE_ID), resultSet.getString(TITLE),
							resultSet.getString(DESCRIPTION)));
					return exercises;
				} else {
					throw new RuntimeException("Nie ma takiego zadania");
				
				}

			}

		} catch (SQLException e) {

			throw new RuntimeException();
		}

	}

	@Override
	public void deleteAll() {

		try (Connection connection = createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ALL)) {

			preparedStatement.executeQuery();

		} catch (SQLException e) {
			throw new RuntimeException("Nie udało się usunąć");
		}

	}

}
