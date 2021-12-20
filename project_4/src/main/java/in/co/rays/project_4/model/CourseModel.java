package in.co.rays.project_4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.project_4.bean.CourseBean;
import in.co.rays.project_4.utility.JdbcDataSource;

public class CourseModel {
	Connection con = null;
	PreparedStatement ps = null;

	public long nextPK() {
		long pk = 0;

		try {
			con = JdbcDataSource.getConnection();
			ps = con.prepareStatement("select max(ID) from st_course");
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

	public long add(CourseBean b) {
		long pk = nextPK();

		String query = "insert into st_course values(?,?,?,?,?,?,?,?)";
		try {
			con = JdbcDataSource.getConnection();

			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, pk);
			ps.setString(2, b.getCourseName());
			ps.setString(3, b.getDescription());
			ps.setString(4, b.getDuration());
			ps.setString(5, b.getCreatedBy());
			ps.setString(6, b.getModifiedBy());
			ps.setTimestamp(7, b.getCreatedDateTime());
			ps.setTimestamp(8, b.getModifiedDateTime());

			int a = ps.executeUpdate();
			System.out.println("ok:");
			ps.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return 0;
	}

	public void update(CourseBean b) {
          
		String query = " update st_course set COURSE_NAME=?,DESCRIPTION=?,DURATION=? where ID=?";
		try {
			con = JdbcDataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, b.getCourseName());
			ps.setString(2, b.getDescription());
			ps.setString(3, b.getDuration());
			ps.setLong(4,b.getId());

			int a = ps.executeUpdate();
			System.out.print("ok " + a);
			ps.close();
			con.close();
		} catch (Exception e) {
		
			e.printStackTrace();
		}

	}

	public void delete(CourseBean b) {

		String query = " delete  from st_course where ID=?";
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
	public ArrayList<CourseBean> list()
	{


		ArrayList<CourseBean> al=new ArrayList<CourseBean>();
	
		String query="select* from st_course";
		
		try {
			con=JdbcDataSource.getConnection();
			PreparedStatement st1= con.prepareStatement(query);
			ResultSet rs=st1.executeQuery(query);
			while(rs.next())
			{
				CourseBean u=new CourseBean();
				u.setId(rs.getInt(1));
				u.setCourseName(rs.getString(2));
				u.setDescription(rs.getString(3));
				u.setDuration(rs.getString(4));
				u.setCreatedBy(rs.getString(5));
				u.setModifiedBy(rs.getString(6));
				u.setCreatedDateTime(rs.getTimestamp(7));
				u.setModifiedDateTime(rs.getTimestamp(8));
				al.add(u);
				
			}
			
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
		
	}
	public List search(CourseBean cbean1) {

		StringBuffer sql = new StringBuffer("select * from st_course where 1=1");
		if (cbean1 != null) {
			
			if (cbean1.getId() > 0) {
				sql.append(" AND ID = " + cbean1.getId());
			}
			if ((cbean1.getCourseName() !=  null)&&(cbean1.getCourseName().length() > 0)) {
				sql.append(" AND COURSE_NAME like '" + cbean1.getCourseName()+"%'");
			}
			if ((cbean1.getDescription() !=  null)&&(cbean1.getDescription().length() > 0)) {
				sql.append(" AND DESCRIPTION like '" + cbean1.getDescription()+"%'");

			}
			if ((cbean1.getDuration() !=  null)&&(cbean1.getDuration().length() > 0)) {
				sql.append(" AND DURATION like '" + cbean1.getDuration()+"%'");

			}
		}
	ArrayList<CourseBean> ar = new ArrayList<CourseBean>();
		try {

			Connection con = JdbcDataSource.getConnection();

			PreparedStatement ps = con.prepareStatement(sql.toString());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CourseBean cbean = new CourseBean();
				cbean.setId(rs.getInt(1));
				cbean.setCourseName(rs.getString(2));
				cbean.setDescription(rs.getString(3));
				cbean.setDuration(rs.getString(4));
				cbean.setCreatedBy(rs.getString(5));
				cbean.setModifiedBy(rs.getString(6));
				cbean.setCreatedDateTime(rs.getTimestamp(7));
				cbean.setModifiedDateTime(rs.getTimestamp(8));
				ar.add(cbean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ar;

	}

	public CourseBean findByPk(long pk) {
		CourseBean cbean = new CourseBean();
		try {
			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from st_course where ID=?");
			ps.setLong(1, pk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cbean.setId(rs.getInt(1));
				cbean.setCourseName(rs.getString(2));
				cbean.setDescription(rs.getString(3));
				cbean.setDuration(rs.getString(4));
				cbean.setCreatedBy(rs.getString(5));
				cbean.setModifiedBy(rs.getString(6));
				cbean.setCreatedDateTime(rs.getTimestamp(7));
				cbean.setModifiedDateTime(rs.getTimestamp(8));
			}
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cbean;

	}

}
