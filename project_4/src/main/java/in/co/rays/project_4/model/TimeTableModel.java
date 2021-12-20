package in.co.rays.project_4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.project_4.bean.RoleBean;
import in.co.rays.project_4.bean.StudentBean;
import in.co.rays.project_4.bean.TimeTableBean;
import in.co.rays.project_4.utility.JdbcDataSource;

public class TimeTableModel {
	public long nextPK() {
		long pk = 0;
		try {
			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select max(ID) from st_timetable");
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				pk = (int) r.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk + 1;
	}
	public long add(TimeTableBean tbean) {
		long pk = nextPK();
		java.util.Date d=tbean.getExamDate();
		long l=d.getTime();
		java.sql.Date date= new java.sql.Date(l);
		System.out.println(date);
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into st_timetable values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setLong(1, pk);
			ps.setInt(2, tbean.getSubId());
            ps.setString(3, tbean.getSubName());
            ps.setLong(4, tbean.getCourseId());
            ps.setString(5, tbean.getCourseName());
            ps.setString(6, tbean.getSemester());
            ps.setDate(7, date);
            ps.setString(8, tbean.getExamTime());
            ps.setString(9, tbean.getDescription());
            ps.setString(10, tbean.getCreatedBy());
			ps.setString(11, tbean.getModifiedBy());
			ps.setTimestamp(12, tbean.getCreatedDateTime());
			ps.setTimestamp(13, tbean.getModifiedDateTime());
			int a = ps.executeUpdate();
			System.out.println("insert data" + a);
			ps.close();
			con.close();

		} catch (Exception e) {

		}
		return 0;

	}

	public void delete(TimeTableBean tbean) {
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from st_timetable where ID=?");
			ps.setLong(1, tbean.getId());
			System.out.println("Delete data successfully");
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(TimeTableBean tbean) {
		long pk = nextPK();
		java.util.Date d=tbean.getExamDate();
		long l=d.getTime();
		java.sql.Date date= new java.sql.Date(l);
		System.out.println(date);
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update st_timetable set SUB_ID=?,SUB_NAME=?,COURSE_ID=?,COURSE_NAME=?,SEMESTER=?,EXAM_DATE=?,EXAM_TIME=?,DESCRIPTION=? where ID=?");
			
			ps.setInt(1, tbean.getSubId());
            ps.setString(2, tbean.getSubName());
            ps.setLong(3, tbean.getCourseId());
            ps.setString(4, tbean.getCourseName());
            ps.setString(5, tbean.getSemester());
            ps.setDate(6, date);
            ps.setString(7, tbean.getExamTime());
            ps.setString(8, tbean.getDescription());
            ps.setLong(9,tbean.getId());
			System.out.println("update data successfully");
			ps.executeUpdate();
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public TimeTableBean findByPk(long pk) {

      TimeTableBean tbean = new TimeTableBean();
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from st_timetable where ID=?");
			ps.setLong(1, pk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tbean.setId(rs.getLong(1));
				tbean.setSubId(rs.getInt(2));
			    tbean.setSubName(rs.getString(3));
			    tbean.setCourseId(rs.getLong(4));
			    tbean.setCourseName(rs.getString(5));
			    tbean.setSemester(rs.getString(6));
			    tbean.setExamDate(rs.getDate(7));
			    tbean.setExamTime(rs.getString(8));
			    tbean.setDescription(rs.getString(9));

			}
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tbean;

	}
	public List search(TimeTableBean tbean1) {

		StringBuffer sql = new StringBuffer("select * from st_timetable where 1=1");
		if (tbean1 != null) {
			if (tbean1.getId() > 0) {
				sql.append(" AND ID = " + tbean1.getId());
			}
			if (tbean1.getSubId() > 0) {
				sql.append(" AND SUB_ID = " + tbean1.getSubId());
			}
			if ((tbean1.getSubName() !=  null)&&(tbean1.getSubName().length() > 0)) {
				sql.append(" AND SUB_NAME like '" + tbean1.getSubName()+"%'");
			}
			if (tbean1.getCourseId() > 0) {
				sql.append(" AND COURSE_ID = " + tbean1.getCourseId());
			}
			if ((tbean1.getCourseName() !=  null)&&(tbean1.getCourseName().length() > 0)) {
				sql.append(" AND COURSE_NAME like '" + tbean1.getCourseName()+"%'");

			}
			if ((tbean1.getSemester() !=  null)&&(tbean1.getSemester().length() > 0)) {
				sql.append(" AND SEMESTER like '" + tbean1.getSemester()+"%'");

			}if ((tbean1.getExamDate() != null) && (tbean1.getExamDate().getDate() > 0)) {
				sql.append(" AND EXAM_DATE = " + tbean1.getExamDate());
			}
			if ((tbean1.getExamTime() !=  null)&&(tbean1.getExamTime().length() > 0)) {
				sql.append(" AND EXAM_TIME like '" + tbean1.getExamTime()+"%'");

			}if ((tbean1.getDescription() !=  null)&&(tbean1.getDescription().length() > 0)) {
				sql.append(" AND DESCRIPTION like '" + tbean1.getDescription()+"%'");

			}
		}
		ArrayList<TimeTableBean> a = new ArrayList<TimeTableBean>();

		try {

			Connection con = JdbcDataSource.getConnection();

			PreparedStatement ps = con.prepareStatement(sql.toString());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TimeTableBean tbean = new TimeTableBean();
				tbean.setId(rs.getLong(1));
				tbean.setSubId(rs.getInt(2));
			    tbean.setSubName(rs.getString(3));
			    tbean.setCourseId(rs.getLong(4));
			    tbean.setCourseName(rs.getString(5));
			    tbean.setSemester(rs.getString(6));
			    tbean.setExamDate(rs.getDate(7));
			    tbean.setExamTime(rs.getString(8));
			    tbean.setDescription(rs.getString(9));
				a.add(tbean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return a;

	}
	
	public ArrayList<TimeTableBean> list() {
		ArrayList<TimeTableBean> a = new ArrayList<TimeTableBean>();
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from st_timetable");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TimeTableBean tbean = new TimeTableBean();
				tbean.setId(rs.getLong(1));
				tbean.setSubId(rs.getInt(2));
			    tbean.setSubName(rs.getString(3));
			    tbean.setCourseId(rs.getLong(4));
			    tbean.setCourseName(rs.getString(5));
			    tbean.setSemester(rs.getString(6));
			    tbean.setExamDate(rs.getDate(7));
			    tbean.setExamTime(rs.getString(8));
			    tbean.setDescription(rs.getString(9));
				a.add(tbean);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return a;

	}

}
