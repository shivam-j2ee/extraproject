package in.co.rays.project_4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.project_4.bean.RoleBean;
import in.co.rays.project_4.utility.JdbcDataSource;

public class RoleModel {

	public long nextPK() {
		long pk = 0;
		try {
			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select max(ID) from st_role");
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				pk = (int) r.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk + 1;
	}

	public long add(RoleBean rbean) {
		long pk = nextPK();
		try {
			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into st_role values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setLong(1, pk);
			ps.setInt(2, rbean.getADMIN());
			ps.setInt(3, rbean.getSTUDENT());
			ps.setInt(4, rbean.getCOLLEGE());
			ps.setInt(5, rbean.getKISOK());
			ps.setInt(6, rbean.getFACULTUY());
			ps.setString(7, rbean.getName());
			ps.setString(8, rbean.getDescription());
			ps.setString(9, rbean.getCreatedBy());
			ps.setString(10, rbean.getModifiedBy());
			ps.setTimestamp(11, rbean.getCreatedDateTime());
			ps.setTimestamp(12, rbean.getModifiedDateTime());
			int a = ps.executeUpdate();
			System.out.println("insert data" + a);
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void delete(RoleBean rbean) {
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from st_role where ID=?");
			ps.setLong(1, rbean.getId());
			System.out.println("Delete data successfully");
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(RoleBean rbean) {

		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update st_role set ADMIN=?,STUDENT=?,COLLEGE=?,KISOK=?,FACULTY=? where ID=?");
			ps.setInt(1, rbean.getADMIN());
			ps.setInt(2, rbean.getSTUDENT());
			ps.setInt(3, rbean.getCOLLEGE());
			ps.setInt(4, rbean.getKISOK());
			ps.setInt(5, rbean.getFACULTUY());
			ps.setLong(6, rbean.getId());
			System.out.println("update data successfully");
			ps.executeUpdate();
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<RoleBean> list() {
		ArrayList<RoleBean> arlist = new ArrayList<RoleBean>();
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from st_role");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RoleBean rbean = new RoleBean();
				rbean.setId(rs.getLong(1));
				rbean.setADMIN(rs.getInt(2));
				rbean.setSTUDENT(rs.getInt(3));
				rbean.setCOLLEGE(rs.getInt(4));
				rbean.setKISOK(rs.getInt(5));
				rbean.setFACULTUY(rs.getInt(6));
				rbean.setName(rs.getString(7));
				rbean.setDescription(rs.getString(8));

				arlist.add(rbean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arlist;

	}

	public RoleBean findByPk(long pk) {
		RoleBean rbean = new RoleBean();
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from st_role where ID=?");
			ps.setLong(1, pk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				rbean.setId(rs.getLong(1));
				rbean.setADMIN(rs.getInt(2));
				rbean.setSTUDENT(rs.getInt(3));
				rbean.setCOLLEGE(rs.getInt(4));
				rbean.setKISOK(rs.getInt(5));
				rbean.setFACULTUY(rs.getInt(6));
				rbean.setName(rs.getString(7));
				rbean.setDescription(rs.getString(8));

			}
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rbean;

	}

	public RoleBean findByName(String name) {
		RoleBean rbean = new RoleBean();
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from st_role where NAME=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				rbean.setId(rs.getLong(1));
				rbean.setADMIN(rs.getInt(2));
				rbean.setSTUDENT(rs.getInt(3));
				rbean.setCOLLEGE(rs.getInt(4));
				rbean.setKISOK(rs.getInt(5));
				rbean.setFACULTUY(rs.getInt(6));
				rbean.setName(rs.getString(7));
				rbean.setDescription(rs.getString(8));

			}
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rbean;

	}

	public List search(RoleBean rbean1) {

		StringBuffer sql = new StringBuffer("select * from st_role where 1=1");
		if (rbean1 != null) {
			if (rbean1.getId() > 0) {
				sql.append(" AND ID = " + rbean1.getId());
			}
			if (rbean1.getADMIN() > 0) {
				sql.append(" AND ADMIN = '" + rbean1.getADMIN());
			}
			if (rbean1.getSTUDENT() > 0) {
				sql.append(" AND STUDENT = '" + rbean1.getSTUDENT());
			}
			if (rbean1.getCOLLEGE() > 0) {
				sql.append(" AND COLLEGE = '" + rbean1.getCOLLEGE());
			} 
			if (rbean1.getFACULTUY() > 0) {
				sql.append(" AND FACULTY = '" + rbean1.getFACULTUY());
			}

			if (rbean1.getKISOK() > 0) {
				sql.append(" AND KISOK = '" + rbean1.getKISOK());
			}
			if ((rbean1.getName() != null) && (rbean1.getName().length() > 0)) {
				sql.append(" AND name like " + rbean1.getName());
			}
			if ((rbean1.getDescription() != null) && (rbean1.getDescription().length() > 0)) {
				sql.append(" AND description like '" + rbean1.getDescription() + "%'");
			}
		}
		ArrayList<RoleBean> ar = new ArrayList<RoleBean>();

		try {

			Connection con = JdbcDataSource.getConnection();

			PreparedStatement ps = con.prepareStatement(sql.toString());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RoleBean rbean = new RoleBean();
				rbean.setId(rs.getLong(1));
				rbean.setADMIN(rs.getInt(2));
				rbean.setSTUDENT(rs.getInt(3));
				rbean.setCOLLEGE(rs.getInt(4));
				rbean.setKISOK(rs.getInt(5));
				rbean.setName(rs.getString(6));
				rbean.setDescription(rs.getString(7));
				ar.add(rbean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ar;

	}

}