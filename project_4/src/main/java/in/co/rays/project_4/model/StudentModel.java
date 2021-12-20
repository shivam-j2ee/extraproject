package in.co.rays.project_4.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import in.co.rays.project_4.bean.StudentBean;
import in.co.rays.project_4.bean.UserBean;
import in.co.rays.project_4.utility.JdbcDataSource;

public class StudentModel {

	public long nextPK() {
		long pk = 0;
		try {
			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select max(ID) from st_student");
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				pk = (int) r.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk + 1;
	}

	public long add(StudentBean studentbean) {
		long pk = nextPK();
		java.util.Date d=studentbean.getDob();
		long l=d.getTime();
		java.sql.Date date= new java.sql.Date(l);
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into st_student values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setLong(1, pk);
			ps.setString(2, studentbean.getFirstName());
			ps.setString(3, studentbean.getLastName());
			ps.setDate(4, date);
			ps.setString(5, studentbean.getMobileNo());
			ps.setString(6, studentbean.getEmail());
			ps.setLong(7, studentbean.getCollegeId());
			ps.setString(8, studentbean.getCollegeName());
			ps.setString(9, studentbean.getCreatedBy());
			ps.setString(10, studentbean.getModifiedBy());
			ps.setTimestamp(11, studentbean.getCreatedDateTime());
			ps.setTimestamp(12, studentbean.getModifiedDateTime());
			int a = ps.executeUpdate();
			System.out.println("insert data" + a);
			ps.close();
			con.close();

		} catch (Exception e) {

		}
		return 0;

	}

	public void delete(StudentBean studentbean) {
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from st_student where ID=?");
			ps.setLong(1, studentbean.getId());
			System.out.println("Delete data successfully");
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(StudentBean studentbean) {
		java.util.Date d=studentbean.getDob();
		long l=d.getTime();
		java.sql.Date date= new java.sql.Date(l);
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update st_student set FIRST_NAME=?,LAST_NAME=?,EMAIL_ID=?,COLLEGE_ID=?,COLLEGE_NAME=?,MOBILE_NO=?,DOB=? where ID=?");
			ps.setString(1, studentbean.getFirstName());
			ps.setString(2, studentbean.getLastName());
			ps.setString(3, studentbean.getEmail());
			ps.setLong(4, studentbean.getCollegeId());
			ps.setString(5, studentbean.getCollegeName());
			ps.setString(6, studentbean.getMobileNo());
			ps.setDate(7, date);
			
			ps.setLong(8, studentbean.getId());
			System.out.println("update data successfully");
			ps.executeUpdate();
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<StudentBean> list() {
		ArrayList<StudentBean> a = new ArrayList<StudentBean>();
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from st_student");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentBean studentbean = new StudentBean();
				studentbean.setId(rs.getLong(1));
				studentbean.setFirstName(rs.getString(2));
				studentbean.setLastName(rs.getString(3));
				studentbean.setDob(rs.getDate(4));
				studentbean.setMobileNo(rs.getString(5));
				studentbean.setEmail(rs.getString(6));
				studentbean.setCollegeId(rs.getLong(7));
				studentbean.setCollegeName(rs.getString(8));
				a.add(studentbean);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return a;

	}

	public StudentBean findByPk(long pk) {
		StudentBean studentbean = new StudentBean();
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from st_student where ID=?");
			ps.setLong(1, pk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				studentbean.setId(rs.getLong(1));
				studentbean.setFirstName(rs.getString(2));
				studentbean.setLastName(rs.getString(3));
				studentbean.setDob(rs.getDate(4));
				studentbean.setMobileNo(rs.getString(5));
				studentbean.setEmail(rs.getString(6));
				studentbean.setCollegeId(rs.getLong(7));
				studentbean.setCollegeName(rs.getString(8));

			}
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentbean;

	}

	public StudentBean findByEmailId(String email) {
		StudentBean studentbean = new StudentBean();
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from st_student where EMAIL_ID=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				studentbean.setId(rs.getLong(1));
				studentbean.setFirstName(rs.getString(2));
				studentbean.setLastName(rs.getString(3));
				studentbean.setDob(rs.getDate(4));
				studentbean.setMobileNo(rs.getString(5));
				studentbean.setEmail(rs.getString(6));
				studentbean.setCollegeId(rs.getLong(7));
				studentbean.setCollegeName(rs.getString(8));

			}
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentbean;

	}

	public List search(StudentBean student) {

		StringBuffer sql = new StringBuffer("select * from st_student where 1=1");
		if (student != null) {
			if (student.getId() > 0) {
				sql.append(" AND ID = " + student.getId());
			}
			if (student.getFirstName() != null && student.getFirstName().length() > 0) {
				sql.append(" AND FIRST_NAME like '" + student.getFirstName() + "%'");
			}
			if ((student.getLastName() != null) && (student.getLastName().length() > 0)) {
				sql.append(" AND LAST_NAME like '" + student.getLastName() + "%'");
			}
			if ((student.getDob() != null) && (student.getDob().getDate() > 0)) {
				sql.append(" AND DOB = " + student.getDob());
			}
			if ((student.getMobileNo() != null) && (student.getMobileNo().length() > 0)) {

				sql.append(" AND MOBILE_NO like '" + student.getMobileNo() + "%'");
			}

			if ((student.getEmail() != null) && (student.getEmail().length() > 0)) {
				sql.append(" AND EMAIL_ID like '" + student.getEmail() + "%'");
			}
			if ((student.getCollegeId() > 0)) {
				sql.append(" AND COLLEGE_ID = " + student.getCollegeId());
			}
			if ((student.getCollegeName() != null) && (student.getCollegeName().length() > 0)) {
				sql.append(" AND COLLEGE_NAME like '" + student.getCollegeName() + "%'");
			}

		}
		ArrayList<StudentBean> arraylist = new ArrayList<StudentBean>();

		try {

			Connection con = JdbcDataSource.getConnection();

			PreparedStatement ps = con.prepareStatement(sql.toString());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				StudentBean studentbean = new StudentBean();
				studentbean.setId(rs.getLong(1));
				studentbean.setFirstName(rs.getString(2));
				studentbean.setLastName(rs.getString(3));
				studentbean.setDob(rs.getDate(4));
				studentbean.setMobileNo(rs.getString(5));
				studentbean.setEmail(rs.getString(6));
				studentbean.setCollegeId(rs.getLong(7));
				studentbean.setCollegeName(rs.getString(8));
				arraylist.add(studentbean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return arraylist;

	}

}
