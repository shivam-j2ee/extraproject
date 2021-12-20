package in.co.rays.project_4.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JdbcDataSource {
	private static JdbcDataSource jds = null;
	private ComboPooledDataSource ds = null;

	private JdbcDataSource() {
		try {

			ds = new ComboPooledDataSource();
			ds.setDriverClass("com.mysql.jdbc.Driver");
			ds.setJdbcUrl("jdbc:mysql://localhost:3306/project_4");
			ds.setUser("root");
			ds.setPassword("root");
			ds.setInitialPoolSize(5);
			ds.setAcquireIncrement(5);
			ds.setMaxPoolSize(50);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static JdbcDataSource getInstance() {
		if (jds == null) {
			jds = new JdbcDataSource();
		}
		return jds;
	}

	public static Connection getConnection() {
		try {
			return getInstance().ds.getConnection();
		} catch (Exception e) {
			return null;

		}
	}

	public static void closeConnection(Connection conn) {
		try {
			
			if (conn != null)
				conn.close();
		} catch (Exception e) {

		}

	}
	 public static void trnRollback(Connection connection)
	            throws Exception {
	        if (connection != null) {
	            try {
	                connection.rollback();
	            } catch (SQLException ex) {
	               // throw new ApplicationException(ex.toString());
	            }
	        }
	    }


}
