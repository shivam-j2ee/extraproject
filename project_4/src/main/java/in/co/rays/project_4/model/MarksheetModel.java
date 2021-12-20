package in.co.rays.project_4.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import in.co.rays.project_4.bean.MarksheetBean;
import in.co.rays.project_4.bean.StudentBean;
import in.co.rays.project_4.bean.UserBean;
import in.co.rays.project_4.utility.JdbcDataSource;

public class MarksheetModel {

	public static long nextPK() {
		long nextPK = 0;
		try {
			Connection conn = JdbcDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID)FROM st_marksheet");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				nextPK = rs.getLong(1);
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nextPK + 1;
	}

	public long add(MarksheetBean bean) {
		try {
			Connection conn = JdbcDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into st_marksheet values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setLong(1, nextPK());
			ps.setString(2, bean.getRollNo());
			ps.setLong(3, bean.getStudentId());
			ps.setString(4, bean.getName());
			ps.setInt(5, bean.getPhysics());
			ps.setInt(6, bean.getChemistry());
			ps.setInt(7, bean.getMaths());
			ps.setString(8, bean.getCreatedBy());
			ps.setString(9, bean.getModifiedBy());
			ps.setTimestamp(10, bean.getCreatedDateTime());
			ps.setTimestamp(11, bean.getModifiedDateTime());
			ps.execute();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void update(MarksheetBean bean) {
		try {
			Connection conn = JdbcDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"update st_marksheet set ROLL_NO=?, STUDENT_ID=?, NAME=?, PHYSICS=?, CHEMISTRY=?, MATHS=? where ID=? ");
			ps.setString(1, bean.getRollNo());
			ps.setLong(2, bean.getStudentId());
			ps.setString(3, bean.getName());
			ps.setInt(4, bean.getPhysics());
			ps.setInt(5, bean.getChemistry());
			ps.setInt(6, bean.getMaths());
			ps.setLong(7, bean.getId());
			ps.execute();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(MarksheetBean bean) {
		try {
			Connection conn = JdbcDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from st_marksheet where ID=?");
			ps.setLong(1, bean.getId());
			ps.execute();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<MarksheetBean> list() {
		ArrayList<MarksheetBean> a1 = new ArrayList<MarksheetBean>();
		try {

			Connection conn = JdbcDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from st_marksheet");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MarksheetBean mbean = new MarksheetBean();
				mbean.setId(rs.getLong(1));
				mbean.setRollNo(rs.getString(2));
				mbean.setStudentId(rs.getLong(3));
				mbean.setName(rs.getString(4));
				mbean.setPhysics(rs.getInt(5));
				mbean.setChemistry(rs.getInt(6));
				mbean.setMaths(rs.getInt(7));
				a1.add(mbean);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a1;
	}

	public MarksheetBean findByPk(long pk) {
		MarksheetBean mbean = new MarksheetBean();
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from st_marksheet where ID=?");
			ps.setLong(1, pk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mbean.setId(rs.getLong(1));
				mbean.setRollNo(rs.getString(2));
				mbean.setStudentId(rs.getLong(3));
				mbean.setName(rs.getString(4));
				mbean.setPhysics(rs.getInt(5));
				mbean.setChemistry(rs.getInt(6));
				mbean.setMaths(rs.getInt(7));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mbean;

	}

	public MarksheetBean findByRollNo(String rollNO) {
		MarksheetBean mbean = new MarksheetBean();
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from st_marksheet where ROLL_NO=?");
			ps.setString(1, rollNO);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mbean.setId(rs.getLong(1));
				mbean.setRollNo(rs.getString(2));
				mbean.setStudentId(rs.getLong(3));
				mbean.setName(rs.getString(4));
				mbean.setPhysics(rs.getInt(5));
				mbean.setChemistry(rs.getInt(6));
				mbean.setMaths(rs.getInt(7));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mbean;

	}

	public List search(MarksheetBean marksheet) {

		StringBuffer sql = new StringBuffer("select * from st_marksheet where 1=1");
		if (marksheet != null) {
			if (marksheet.getId() > 0) {
				sql.append(" AND ID = " + marksheet.getId());
			}
			if ((marksheet.getRollNo() != null) && (marksheet.getRollNo().length() > 0)) {
				sql.append("AND ROLL_NO like '" + marksheet.getRollNo() + "%'");
			}
			if (marksheet.getStudentId() > 0) {
				sql.append(" AND STUDENT_ID = " + marksheet.getStudentId());
			}
			if (marksheet.getName() != null && marksheet.getName().length() > 0) {
				sql.append(" AND NAME like '" + marksheet.getName() + "%'");
			}
			  if ( marksheet.getPhysics() > 0) {
	                sql.append(" AND PHYSICS = " + marksheet.getPhysics());
	            }
	            if (marksheet.getChemistry() > 0) {
	                sql.append(" AND CHEMISTRY = " + marksheet.getChemistry());
	            }
	            if ( marksheet.getMaths() > 0) {
	                sql.append(" AND MATHS = " + marksheet.getMaths());
	            }
		}
		ArrayList<MarksheetBean> arraylist = new ArrayList<MarksheetBean>();

		try {

			Connection con = JdbcDataSource.getConnection();

			PreparedStatement ps = con.prepareStatement(sql.toString());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MarksheetBean mbean = new MarksheetBean();
				mbean.setId(rs.getLong(1));
				mbean.setRollNo(rs.getString(2));
				mbean.setStudentId(rs.getLong(3));
				mbean.setName(rs.getString(4));
				mbean.setPhysics(rs.getInt(5));
				mbean.setChemistry(rs.getInt(6));
				mbean.setMaths(rs.getInt(7));
				arraylist.add(mbean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arraylist;

	}

	public MarksheetBean findByLogin(String login) {
		MarksheetBean mbean = new MarksheetBean();
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from st_marksheet where LOGIN=?");
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mbean.setId(rs.getLong(1));
				mbean.setRollNo(rs.getString(2));
				mbean.setStudentId(rs.getLong(3));
				mbean.setName(rs.getString(4));
				mbean.setPhysics(rs.getInt(5));
				mbean.setChemistry(rs.getInt(6));
				mbean.setMaths(rs.getInt(7));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mbean;

	}

}
