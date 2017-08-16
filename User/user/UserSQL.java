package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import pl.coderslab.model.DbUtil;

public class UserSQL implements UserDao {

	// KEWRENDY SQL

	private static String USER_INSERT = "INSERT INTO USER VALUES(0,?,?,?,?)";
	private static String FIND_BY_ID = "SELECT * FROM USER WHERE user_id = ?";
	private static String FIND_ALL = "SELECT * FROM USER";
	private static String UPDATE_USER = "UPDATE USER SET username=? , email=? , password=? , group_id=? WHERE user_id = ?";
	private static String DELETE_USER_BY_ID = "DELETE FROM USER  WHERE user_id = ?";
	private static String DELETE_ALL = "DELETE * FROM USER";
	private static String FIND_BY_GROUP_ID = "SELECT * FROM USER WHERE group_id = ?";
	

	private static String USER_ID = "user_id";
	private static String USERNAME = "username";
	private static String EMAIL = "email";
	private static String PASSWORD = "password";
	private static String GROUP_ID = "group_id";

	/*
	 * 
	 * User insert(User user) ; List<User> findAll() ; void update(User user) ;
	 * void delete(User user) ; User findById(int user_id); void deleteAll() ;
	 * List<User> findByGroupId(int group_id);
	 * 
	 */
	public UserSQL() {

	}

	private Connection createConnection() throws SQLException {
		Connection c = DbUtil.getConn();
		return c;
	}

	@Override
	public User insert(User user) {

		try (Connection connection = createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(USER_INSERT,
						PreparedStatement.RETURN_GENERATED_KEYS);) {

			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setInt(4, user.getGroup_id());

			int result = preparedStatement.executeUpdate();
			if (result != 1) {
				throw new RuntimeException("Executed update returned " + result);
			}

			try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
				if (rs.first()) {
					user.setId(rs.getInt(1));
					return user;
				} else {
					throw new RuntimeException("Generated Keys was not found ");
				}

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<User> findAll() {

		try (Connection connection = createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
				ResultSet rs = preparedStatement.executeQuery();) {

			List<User> user = new ArrayList<>();
			while (rs.next()) {
				user.add(new User(rs.getInt(USER_ID), rs.getString(USERNAME), rs.getString(EMAIL),
						rs.getString(PASSWORD), rs.getInt(GROUP_ID)));
			}
			return user;
		} catch (Exception e) {
			throw new RuntimeException();
		}

	}

	@Override
	public void update(User user) {
		try (Connection connection = createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);) {
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setInt(4, user.getGroup_id());

			int rs = preparedStatement.executeUpdate();
			if (rs != 1) {
				throw new RuntimeException("Zmiana nie nastąpiła");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void delete(User user) {
		try (Connection connection = createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);) {

			preparedStatement.setInt(1, user.getId());
			int delete = preparedStatement.executeUpdate();
			if (delete != 1) {
				throw new RuntimeException("Usunięcie się nie powiodło");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public User findById(int user_id) {

		try (Connection connection = createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);) {

			User user = new User();
			preparedStatement.setInt(1, user_id);
			try (ResultSet rs = preparedStatement.executeQuery();) {
				while (rs.next()) {
					user.setEmail(rs.getString(EMAIL));
					user.setId(rs.getInt(USER_ID));
					user.setUserName(rs.getString(USERNAME));

				}
				return user;
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void deleteAll() {
		try (Connection connection = createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ALL);) {

			int del = preparedStatement.executeUpdate();
			if (del != 0) {
				throw new RuntimeException("Nie udało się usunąć ");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public List<User> findByGroupId(int group_id) {

		try (Connection connection = createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_GROUP_ID);) {

			preparedStatement.setInt(1, group_id);
			try (ResultSet rs = preparedStatement.executeQuery()) {
				List<User> user = new ArrayList<>();
				while (rs.next()) {
					user.add(new User(rs.getInt(USER_ID), rs.getString(USERNAME), rs.getString(EMAIL),
							rs.getString(PASSWORD), rs.getInt(GROUP_ID)));
				}
				return user;
			}
		} catch (SQLException e) {
			throw new RuntimeException("Nie udało się odnaleźć");
		}

	}
}
