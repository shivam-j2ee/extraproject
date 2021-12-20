package in.co.rays.project_4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import in.co.rays.project_4.bean.UserBean;
import in.co.rays.project_4.utility.JdbcDataSource;

public class UserModel {

	public long nextPK() {
		long pk = 0;
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select max(ID) from st_user");
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				pk = (int) r.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk + 1;
	}

	public long add(UserBean ubean) {
		long pk = nextPK();
		java.util.Date d = ubean.getDob();
		long l = d.getTime();
		java.sql.Date date = new java.sql.Date(l);
		Connection con = null;

		try {

			con = JdbcDataSource.getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps = con
					.prepareStatement("insert into st_user values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setLong(1, pk);
			ps.setString(2, ubean.getFirstName());
			ps.setString(3, ubean.getLastName());
			ps.setString(4, ubean.getLogin());
			ps.setString(5, ubean.getPassword());
			ps.setDate(6, date);
			ps.setString(7, ubean.getMobileNO());
			ps.setLong(8, ubean.getRoleId());
			ps.setInt(9, ubean.getUnSuccessfullLogin());
			ps.setString(10, ubean.getGender());
			ps.setTimestamp(11, ubean.getLastLogin());
			ps.setString(12, ubean.getLock());
			ps.setString(13, ubean.getRegisteredIP());
			ps.setString(14, ubean.getLastLoginIP());
			ps.setString(15, ubean.getCreatedBy());
			ps.setString(16, ubean.getModifiedBy());
			ps.setTimestamp(17, ubean.getCreatedDateTime());
			ps.setTimestamp(18, ubean.getModifiedDateTime());
			int a = ps.executeUpdate();
			System.out.println("insert data" + a);
			con.commit();
			ps.close();
			con.close();

		} catch (Exception e) {

		} finally {
			JdbcDataSource.closeConnection(con);
		}
		return pk;

	}

	public void delete(UserBean ubean) {
		Connection con = null;
		try {
			con = JdbcDataSource.getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement("delete from st_user where ID=?");
			ps.setLong(1, ubean.getId());
			System.out.println("Delete data successfully");
			ps.executeUpdate();
			con.commit();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcDataSource.closeConnection(con);
		}
	}

	public void update(UserBean ubean) {
		java.util.Date d = ubean.getDob();
		long l = d.getTime();
		java.sql.Date date = new java.sql.Date(l);
		System.out.println(date);
		Connection con = null;
		try {

			con = JdbcDataSource.getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(
					"update st_user set FIRST_NAME=?,LAST_NAME=?,LOGIN=?,PASSWORD=?,DOB=?,MOBILE_NO=?,ROLE_ID=?,UNSUCCESSFULL_LOGIN=?,GENDER=? where ID=?");
			ps.setString(1, ubean.getFirstName());
			ps.setString(2, ubean.getLastName());
			ps.setString(3, ubean.getLogin());
			ps.setString(4, ubean.getPassword());
			ps.setDate(5, date);
			ps.setString(6, ubean.getMobileNO());
			ps.setLong(7, ubean.getRoleId());
			ps.setInt(8, ubean.getUnSuccessfullLogin());
			ps.setString(9, ubean.getGender());
			ps.setLong(10, ubean.getId());
			System.out.println("update data successfully");
			ps.executeUpdate();
			con.commit();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcDataSource.closeConnection(con);
		}
	}

	public ArrayList<UserBean> list() {
		ArrayList<UserBean> arraylist = new ArrayList<UserBean>();
		Connection con = null;
		try {
			con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from st_user");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserBean ubean = new UserBean();
				ubean.setId(rs.getLong(1));
				ubean.setFirstName(rs.getString(2));
				ubean.setLastName(rs.getString(3));
				ubean.setLogin(rs.getString(4));
				ubean.setPassword(rs.getString(5));
				ubean.setDob(rs.getDate(6));
				ubean.setMobileNO(rs.getString(7));
				ubean.setRoleId(rs.getLong(8));
				ubean.setUnSuccessfullLogin(rs.getInt(9));
				ubean.setGender(rs.getString(10));
				ubean.setLastLogin(rs.getTimestamp(11));
				ubean.setLock(rs.getString(12));
				ubean.setRegisteredIP(rs.getString(13));
				ubean.setLastLoginIP(rs.getString(14));
				arraylist.add(ubean);
			}
			con.commit();
			rs.close();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcDataSource.closeConnection(con);
		}
		return arraylist;

	}

	public UserBean findByPk(long pk) {
		UserBean ubean = new UserBean();
		Connection con = null;
		try {
			con = JdbcDataSource.getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement("select * from st_user where ID=?");
			ps.setLong(1, pk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ubean.setId(rs.getLong(1));
				ubean.setFirstName(rs.getString(2));
				ubean.setLastName(rs.getString(3));
				ubean.setLogin(rs.getString(4));
				ubean.setPassword(rs.getString(5));
				ubean.setDob(rs.getDate(6));
				ubean.setMobileNO(rs.getString(7));
				ubean.setRoleId(rs.getLong(8));
				ubean.setUnSuccessfullLogin(rs.getInt(9));
				ubean.setGender(rs.getString(10));
				ubean.setLastLogin(rs.getTimestamp(11));
				ubean.setLock(rs.getString(12));
				ubean.setRegisteredIP(rs.getString(13));
				ubean.setLastLoginIP(rs.getString(14));

			}
			con.commit();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcDataSource.closeConnection(con);
		}

		return ubean;

	}

	public UserBean findByLogin(String login) {
		UserBean ubean = new UserBean();
		Connection con = null;
		try {

			con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from st_user where LOGIN=?");
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ubean.setId(rs.getLong(1));
				ubean.setFirstName(rs.getString(2));
				ubean.setLastName(rs.getString(3));
				ubean.setLogin(rs.getString(4));
				ubean.setPassword(rs.getString(5));
				ubean.setDob(rs.getDate(6));
				ubean.setMobileNO(rs.getString(7));
				ubean.setRoleId(rs.getLong(8));
				ubean.setUnSuccessfullLogin(rs.getInt(9));
				ubean.setGender(rs.getString(10));
				ubean.setLastLogin(rs.getTimestamp(11));
				ubean.setLock(rs.getString(12));
				ubean.setRegisteredIP(rs.getString(13));
				ubean.setLastLoginIP(rs.getString(14));

			}
			con.commit();
			rs.close();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcDataSource.closeConnection(con);
		}

		return ubean;

	}

	public List search(UserBean u) {

		StringBuffer sql = new StringBuffer("select * from st_user where 1=1");
		if (u != null) {
			if (u.getId() > 0) {
				sql.append(" AND ID = " + u.getId());
			}
			if (u.getFirstName() != null && u.getFirstName().length() > 0) {
				sql.append(" AND FIRST_NAME like '" + u.getFirstName() + "%'");
			}
			if ((u.getLastName() != null) && (u.getLastName().length() > 0)) {
				sql.append(" AND LAST_NAME like '" + u.getLastName() + "%'");
			}
			if ((u.getLogin() != null) && (u.getLogin().length() > 0)) {
				sql.append(" AND LOGIN like '" + u.getLogin() + "%'");
			}

			if ((u.getPassword() != null) && (u.getPassword().length() > 0)) {
				sql.append(" AND PASSWORD like '" + u.getPassword() + "%'");
			}
			if ((u.getDob() != null) && (u.getDob().getDate() > 0)) {
				sql.append(" AND DOB = " + u.getDob());
			}
			if ((u.getMobileNO() != null) && (u.getMobileNO().length() > 0)) {
				sql.append(" AND MOBILE_NO like '" + u.getMobileNO() + "%'");
			}
			if (u.getRoleId() > 0) {
				sql.append(" AND ROLE_ID = " + u.getRoleId());
			}
			if (u.getUnSuccessfullLogin() > 0) {
				sql.append(" AND UNSUCCESSFULL_LOGIN =" + u.getUnSuccessfullLogin());
			}
			if ((u.getGender() != null) && (u.getGender().length() > 0)) {
				sql.append(" AND GENDER like '" + u.getGender() + "%'");
			}
			if ((u.getLastLogin() != null) && (u.getLastLogin().getTime() > 0)) {
				sql.append(" AND LAST_LOGIN = " + u.getLastLogin());
			}

		}
		ArrayList<UserBean> ar = new ArrayList<UserBean>();
		Connection con = null;
		try {

			con = JdbcDataSource.getConnection();
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql.toString());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserBean ubean = new UserBean();
				ubean.setId(rs.getLong(1));
				ubean.setFirstName(rs.getString(2));
				ubean.setLastName(rs.getString(3));
				ubean.setLogin(rs.getString(4));
				ubean.setPassword(rs.getString(5));
				ubean.setDob(rs.getDate(6));
				ubean.setMobileNO(rs.getString(7));
				ubean.setRoleId(rs.getLong(8));
				ubean.setUnSuccessfullLogin(rs.getInt(9));
				ubean.setGender(rs.getString(10));
				ubean.setLastLogin(rs.getTimestamp(11));
				ubean.setLock(rs.getString(12));
				ubean.setRegisteredIP(rs.getString(13));
				ubean.setLastLoginIP(rs.getString(14));
				ar.add(ubean);
			}
			con.commit();
			rs.close();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcDataSource.closeConnection(con);
		}

		return ar;

	}

	public List getRoles(UserBean bean) {
		Object log;
		// ((Object) log).debug("Model get roles Started");
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_USER WHERE role_Id=?");
		Connection conn = null;
		PreparedStatement pstmt = null;
		List list = new ArrayList();
		try {

			conn = JdbcDataSource.getConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setLong(1, bean.getRoleId());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLogin(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setDob(rs.getDate(6));
				bean.setMobileNO(rs.getString(7));
				bean.setRoleId(rs.getLong(8));
				bean.setUnSuccessfullLogin(rs.getInt(9));
				bean.setGender(rs.getString(10));
				bean.setLastLogin(rs.getTimestamp(11));
				bean.setLock(rs.getString(12));
				bean.setRegisteredIP(rs.getString(13));
				bean.setLastLoginIP(rs.getString(14));

				list.add(bean);
			}
			conn.commit();
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			// log.error("Database Exception..", e);
			// throw new ApplicationException("Exception : Exception in get
			// roles");

		} finally {
			JdbcDataSource.closeConnection(conn);
		}
		// log.debug("Model get roles End");
		return list;
	}
}