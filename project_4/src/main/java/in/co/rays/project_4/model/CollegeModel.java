package in.co.rays.project_4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.project_4.bean.CollegeBean;
import in.co.rays.project_4.utility.JdbcDataSource;

public class CollegeModel {
	Connection con = null;
	PreparedStatement ps = null;

	public long nextPK() {
		long pk = 0;

		try {
			con = JdbcDataSource.getConnection();
			ps = con.prepareStatement("select max(ID) from st_college");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getLong(1);
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pk + 1;

	}

	public long add(CollegeBean b) {
		long pk = nextPK();
		try {
			con = JdbcDataSource.getConnection();
			System.out.println("con ok...");

			PreparedStatement ps = con.prepareStatement("insert into st_college values(?,?,?,?,?,?,?,?,?,?)");
			System.out.println("ps ok...");
			ps.setLong(1, pk);
			ps.setString(2, b.getName());
			ps.setString(3, b.getAddress());
			ps.setString(4, b.getState());
			ps.setString(5, b.getCity());
			ps.setString(6, b.getPhoneNo());
			ps.setString(7, b.getCreatedBy());
			ps.setString(8, b.getModifiedBy());
			ps.setTimestamp(9, b.getCreatedDateTime());
			ps.setTimestamp(10, b.getModifiedDateTime());

			int a = ps.executeUpdate();
			System.out.println("ok:");
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return 0;
	}

	public void update(CollegeBean b) {

		String query = " update st_college set NAME=?,ADDRESS=?,STATE=?,CITY=?,PHONE_NO=? where ID=?";
		try {
			con = JdbcDataSource.getConnection();
			ps = con.prepareStatement(query);

			ps.setString(1, b.getName());
			ps.setString(2, b.getAddress());
			ps.setString(3, b.getState());
			ps.setString(4, b.getCity());
			ps.setString(5, b.getPhoneNo());
			ps.setLong(6, b.getId());
			int a = ps.executeUpdate();
			System.out.print("ok " + a);
			ps.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void delete(CollegeBean b) {

		String query = " delete  from st_college where ID=?";
		try {
			con = JdbcDataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setLong(1, b.getId());
			int a = ps.executeUpdate();

			System.out.print("ok " + a);
			ps.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<CollegeBean> list() {

		ArrayList<CollegeBean> al = new ArrayList<CollegeBean>();

		String query = "select * from st_college";

		try {

			con = JdbcDataSource.getConnection();
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery(query);
			while (rs.next()) {
				CollegeBean cbean = new CollegeBean();
				cbean.setId(rs.getLong(1));
				cbean.setName(rs.getString(2));
				cbean.setAddress(rs.getString(3));
				cbean.setState(rs.getString(4));
				cbean.setCity(rs.getString(5));
				cbean.setPhoneNo(rs.getString(6));
				al.add(cbean);

			}

			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;

	}

	public CollegeBean findByPK(long pk) {
		String query = "select * from st_college where ID=?";
		CollegeBean cbean = new CollegeBean();
		try {
			con = JdbcDataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setLong(1, pk);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				cbean.setId(rs.getLong(1));
				cbean.setName(rs.getString(2));
				cbean.setAddress(rs.getString(3));
				cbean.setState(rs.getString(4));
				cbean.setCity(rs.getString(5));
				cbean.setPhoneNo(rs.getString(6));

			}

			ps.close();
			con.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return cbean;

	}

	public List search(CollegeBean cbean1) {

		StringBuffer sql = new StringBuffer("select * from st_college where 1=1");
		if (cbean1 != null) {

			if (cbean1.getId() > 0) {
				sql.append(" AND ID = " + cbean1.getId());
			}
			if ((cbean1.getName() != null) && (cbean1.getName().length() > 0)) {
				sql.append(" AND NAME like '" + cbean1.getName() + "%'");
			}
			if ((cbean1.getAddress() != null) && (cbean1.getAddress().length() > 0)) {
				sql.append(" AND ADDRESS like '" + cbean1.getAddress() + "%'");

			}
			if ((cbean1.getCity() != null) && (cbean1.getCity().length() > 0)) {
				sql.append(" AND CITY like '" + cbean1.getCity() + "%'");

			}
			if ((cbean1.getState() != null) && (cbean1.getState().length() > 0)) {
				sql.append(" AND STATE like '" + cbean1.getState() + "%'");

			}
			if ((cbean1.getPhoneNo() != null) && (cbean1.getPhoneNo().length() > 0)) {
				sql.append(" AND PHONE_NO like '" + cbean1.getPhoneNo() + "%'");

			}
		}
		ArrayList<CollegeBean> ar = new ArrayList<CollegeBean>();
		try {

			Connection con = JdbcDataSource.getConnection();

			PreparedStatement ps = con.prepareStatement(sql.toString());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CollegeBean cbean = new CollegeBean();

				cbean.setId(rs.getLong(1));
				cbean.setName(rs.getString(2));
				cbean.setAddress(rs.getString(3));
				cbean.setState(rs.getString(4));
				cbean.setCity(rs.getString(5));
				cbean.setPhoneNo(rs.getString(6));

				ar.add(cbean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ar;

	}

	public CollegeBean findByPk(long pk) {
		CollegeBean cbean = new CollegeBean();
		try {
			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from st_college where ID=?");
			ps.setLong(1, pk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cbean.setId(rs.getLong(1));
				cbean.setName(rs.getString(2));
				cbean.setAddress(rs.getString(3));
				cbean.setState(rs.getString(4));
				cbean.setCity(rs.getString(5));
				cbean.setPhoneNo(rs.getString(6));
			}
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cbean;

	}

}
