package group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.model.DbUtil;

public class GroupSQL implements GroupDao {

	private static String FIND_BY_GROUP_ID = "SELECT * FROM USER_GROUP WHERE group_id=? ";
	private static String FIND_ALL = "SELECT * FROM USER_GROUP";
	private static String DELETE_ALL = "DELETE * FROM USER_GROUP ";
	private static String DELETE_BY_GROUP_ID = "DELETE * FROM USER_GROUP WHERE group_id=? ";
	private static String UPDATE_GROUP = "UPDATE USER_GROUP SET group_id=? , name=? WHERE group_id=?";
	private static String INSERT_GROUP = "INSERT INTO USER_GROUP(name) VALUE (?)";
	private static String GROUP_ID = "group_id";
	private static String NAME = "name";

	
	public GroupSQL() {
	}
	
	
	private Connection createConnection() throws SQLException {
		Connection c = DbUtil.getConn();
		return c;
	}
	
	
	

	@Override
	public Group insert(Group group) {

		try (Connection connection = createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_GROUP,
						PreparedStatement.RETURN_GENERATED_KEYS);) {

			preparedStatement.setInt(1, group.getGroup_id());
			int result = preparedStatement.executeUpdate();
			if (result != 1) {
				throw new RuntimeException("Execute runtime exeption " + result);
			}
			try (ResultSet rs = preparedStatement.getGeneratedKeys();) {
				if (rs.first()) {
					group.setGroup_id(rs.getInt(1));
					return group;

				} else {
					throw new RuntimeException("Generated key was not found");
				}
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Group> findAll() {

		try (Connection connection = createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
				ResultSet rs = preparedStatement.executeQuery();) {

			List<Group> groups = new ArrayList<>();

			while (rs.next()) {
				groups.add(new Group(rs.getInt(GROUP_ID), rs.getString(NAME)));

			}
			return groups;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void update(Group group) {

		try (Connection connection = createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_GROUP)) {

			preparedStatement.setInt(1, group.getGroup_id());
			preparedStatement.setString(2, group.getGroup_name());

			int rs = preparedStatement.executeUpdate();
			if (rs != 1) {
				throw new RuntimeException("Zmiana nie nastąpiła");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void delete(Group group) {
		try (Connection connection = createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_GROUP_ID)) {

			preparedStatement.setInt(1, group.getGroup_id());
			int rs = preparedStatement.executeUpdate();
			if (rs != 1) {
				throw new RuntimeException("Usunięcie się nie powiodło");

			}

		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	@Override
	public List<Group> findById(Group group) {

		try (Connection connection = createConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_GROUP_ID);) {

			List<Group> groups = new ArrayList<>();
			preparedStatement.setInt(1, group.getGroup_id());
			try (ResultSet rs = preparedStatement.executeQuery();) {
				if (rs.first()) {
					groups.add(new Group(rs.getInt(GROUP_ID), rs.getString(NAME)));
					return groups;
				} else {
					throw new RuntimeException();
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

			int rs = preparedStatement.executeUpdate();
			if (rs != 0) {
				throw new RuntimeException("Nie udało się usunać");
			}

		} catch (Exception e) {
			throw new RuntimeException();
		}

	}

}
