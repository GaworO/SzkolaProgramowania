package pl.coderslab.model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DbUtil {

	private static DataSource ds;

	public static Connection getConn() throws SQLException {

		return getInstance().getConnection();

	}

	private static DataSource getInstance() {

		if (ds == null) {

			try {

				Context ctx = new InitialContext();

				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/SzkolaProgramowania");

			} catch (NamingException e) {

				e.printStackTrace();

			}

		}

		return ds;

	}
}
