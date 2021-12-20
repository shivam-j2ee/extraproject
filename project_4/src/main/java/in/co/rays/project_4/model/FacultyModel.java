package in.co.rays.project_4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.project_4.bean.FacultyBean;
import in.co.rays.project_4.utility.JdbcDataSource;

public class FacultyModel {

	public long nextPK() {
		long pk = 0;
		try {
			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select max(ID) from st_faculty");
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				pk = (int) r.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk + 1;
	}

	public long add(FacultyBean fbean) {
		long pk = nextPK();
		java.util.Date d=fbean.getJoiningDob();
		long l=d.getTime();
		java.sql.Date date= new java.sql.Date(l);
		System.out.println(date);
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into st_faculty values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setLong(1, pk);
			ps.setString(2, fbean.getFirstName());
			ps.setString(3, fbean.getLastName());
			ps.setString(4, fbean.getGender());
			ps.setDate(5, date);
			ps.setString(6, fbean.getQualification());
			ps.setString(7, fbean.getEmailId());
			ps.setString(8, fbean.getMobileNo());
			ps.setLong(9, fbean.getCollegeId());
			ps.setString(10, fbean.getCollegeName());
			ps.setLong(11, fbean.getCourseId());
			ps.setString(12, fbean.getCourseName());
			ps.setLong(13, fbean.getSubjectId());
			ps.setString(14, fbean.getSubjectName());
			ps.setString(15, fbean.getCreatedBy());
			ps.setString(16, fbean.getModifiedBy());
			ps.setTimestamp(17, fbean.getCreatedDateTime());
			ps.setTimestamp(18, fbean.getModifiedDateTime());
			int a = ps.executeUpdate();
			System.out.println("insert data" + a);
			ps.close();
			con.close();

		} catch (Exception e) {

		}
		return 0;

	}

	public void delete(FacultyBean fbean) {
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from st_faculty where ID=?");
			ps.setLong(1, fbean.getId());
			System.out.println("Delete data successfully");
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(FacultyBean fbean) {
		long pk = nextPK();
		java.util.Date d=fbean.getJoiningDob();
		long l=d.getTime();
		java.sql.Date date= new java.sql.Date(l);
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update st_faculty set FIRST_NAME=?,LAST_NAME=?,GENDER=?,JOINING_DOB=?,QUALIFICATION=?,EMAIL_ID=?,MOBILE_NO=?,COLLEGE_ID=?,COLLEGE_NAME=?,SUBJECT_ID=?,SUBJECT_NAME=?,COURSE_ID=?,COURSE_NAME=? where ID=?");
			ps.setString(1, fbean.getFirstName());
			ps.setString(2, fbean.getLastName());
			ps.setString(3, fbean.getGender());
			ps.setDate(4, date);
			ps.setString(5, fbean.getQualification());
			ps.setString(6, fbean.getEmailId());
			ps.setString(7, fbean.getMobileNo());
			ps.setLong(8, fbean.getCollegeId());
			ps.setString(9, fbean.getCollegeName());
			ps.setLong(10, fbean.getCourseId());
			ps.setString(11, fbean.getCourseName());
			ps.setLong(12, fbean.getSubjectId());
			ps.setString(13, fbean.getSubjectName());
			ps.setLong(14, fbean.getId());
			System.out.println("update data successfully");
			ps.executeUpdate();
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public FacultyBean findByPk(long pk) {

		FacultyBean fbean = new FacultyBean();
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from st_faculty where ID=?");
			ps.setLong(1, pk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				fbean.setId(rs.getLong(1));
				fbean.setFirstName(rs.getString(2));
				fbean.setLastName(rs.getString(3));
				fbean.setGender(rs.getString(4));
				fbean.setJoiningDob(rs.getDate(5));
				fbean.setQualification(rs.getString(6));
				fbean.setEmailId(rs.getString(7));
				fbean.setMobileNo(rs.getString(8));
				fbean.setCollegeId(rs.getLong(9));
				fbean.setCollegeName(rs.getString(10));
				fbean.setCourseId(rs.getLong(11));
				fbean.setCourseName(rs.getString(12));
				fbean.setSubjectId(rs.getLong(13));
				fbean.setSubjectName(rs.getString(14));
				
				
				

			}
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return fbean;

	}

	public List search(FacultyBean fbean1) {

		StringBuffer sql = new StringBuffer("select * from st_faculty where 1=1");
		if (fbean1 != null) {
			if (fbean1.getId() > 0) {
				sql.append(" AND ID = " + fbean1.getId());
			}
			if ((fbean1.getFirstName() != null) && (fbean1.getFirstName().length() > 0)) {
				sql.append(" AND FIRST_NAME like '" + fbean1.getFirstName() + "%'");
			}
			if ((fbean1.getLastName() != null) && (fbean1.getLastName().length() > 0)) {
				sql.append(" AND LAST_NAME like '" + fbean1.getLastName() + "%'");
			}
			if ((fbean1.getGender() != null) && (fbean1.getGender().length() > 0)) {
				sql.append(" AND GENDER like '" + fbean1.getGender() + "%'");
			}
			if ((fbean1.getJoiningDob() != null) && (fbean1.getJoiningDob().getDate() > 0)) {
				 sql.append(" AND JOINING_DOB = " + fbean1.getJoiningDob() );
			}
			if ((fbean1.getQualification() != null) && (fbean1.getQualification().length() > 0)) {
				sql.append(" AND QUALIFICATION like '" + fbean1.getQualification() + "%'");
			}
			if ((fbean1.getEmailId() != null) && (fbean1.getEmailId().length() > 0)) {
				sql.append(" AND EMAIL_ID like '" + fbean1.getEmailId() + "%'");
			}
			if ((fbean1.getMobileNo() != null) && (fbean1.getMobileNo().length() > 0)) {
				sql.append(" AND MOBILE_NO like '" + fbean1.getMobileNo() + "%'");
			}
			if (fbean1.getCollegeId() > 0) {
				sql.append(" AND COLLEGE_ID = " + fbean1.getCollegeId());
			}
			if ((fbean1.getCollegeName() != null) && (fbean1.getCollegeName().length() > 0)) {
				sql.append(" AND COLLEGE_NAME like '" + fbean1.getCollegeName() + "%'");
			}
			if (fbean1.getCourseId() > 0) {
				sql.append(" AND COURSE_ID = " + fbean1.getCourseId());
			}
			if ((fbean1.getCourseName() != null) && (fbean1.getCourseName().length() > 0)) {
				sql.append(" AND COURSE_NAME like '" + fbean1.getCourseName() + "%'");

			}
			if (fbean1.getSubjectId() > 0) {
				sql.append(" AND SUBJECT_ID = " + fbean1.getSubjectId());
			}

			if ((fbean1.getSubjectName() != null) && (fbean1.getSubjectName().length() > 0)) {
				sql.append(" AND SUBJECT_NAME like '" + fbean1.getSubjectName() + "%'");
			}
		}
		ArrayList<FacultyBean> ar = new ArrayList<FacultyBean>();
		try {

			Connection con = JdbcDataSource.getConnection();

			PreparedStatement ps = con.prepareStatement(sql.toString());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				FacultyBean fbean = new FacultyBean();
				fbean.setId(rs.getLong(1));
				fbean.setFirstName(rs.getString(2));
				fbean.setLastName(rs.getString(3));
				fbean.setGender(rs.getString(4));
				fbean.setJoiningDob(rs.getDate(5));
				fbean.setQualification(rs.getString(6));
				fbean.setEmailId(rs.getString(7));
				fbean.setMobileNo(rs.getString(8));
				fbean.setCollegeId(rs.getLong(9));
				fbean.setCollegeName(rs.getString(10));
				fbean.setCourseId(rs.getLong(11));
				fbean.setCourseName(rs.getString(12));
				fbean.setSubjectId(rs.getLong(13));
				fbean.setSubjectName(rs.getString(14));
				
				
				ar.add(fbean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ar;

	}

	public ArrayList<FacultyBean> list() {
		ArrayList<FacultyBean> ar = new ArrayList<FacultyBean>();
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from st_faculty");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				FacultyBean fbean = new FacultyBean();
				fbean.setId(rs.getLong(1));
				fbean.setFirstName(rs.getString(2));
				fbean.setLastName(rs.getString(3));
				fbean.setGender(rs.getString(4));
				fbean.setJoiningDob(rs.getDate(5));
				fbean.setQualification(rs.getString(6));
				fbean.setEmailId(rs.getString(7));
				fbean.setMobileNo(rs.getString(8));
				fbean.setCollegeId(rs.getLong(9));
				fbean.setCollegeName(rs.getString(10));
				fbean.setCourseId(rs.getLong(11));
				fbean.setCourseName(rs.getString(12));
				fbean.setSubjectId(rs.getLong(13));
				fbean.setSubjectName(rs.getString(14));
				
				
				ar.add(fbean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ar;

	}
}
