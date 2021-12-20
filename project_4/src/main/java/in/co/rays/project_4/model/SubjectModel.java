package in.co.rays.project_4.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.project_4.bean.SubjectBean;
import in.co.rays.project_4.utility.JdbcDataSource;

public class SubjectModel {
	public long nextPK() {
		long pk = 0;
		try {
			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select max(ID) from st_subject");
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				pk = (int) r.getLong(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk + 1;
	}
	public long add(SubjectBean sbean) {
		long pk = nextPK();
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into st_subject values(?,?,?,?,?,?,?,?,?,?)");
			ps.setLong(1, pk);
            ps.setString(2, sbean.getSubjectName());
            ps.setString(3, sbean.getDescription());
            ps.setString(4, sbean.getCourseName());
            ps.setLong(5, sbean.getCourseId());
            ps.setLong(6, sbean.getSubjectId());
           
            ps.setString(7, sbean.getCreatedBy());
			ps.setString(8, sbean.getModifiedBy());
			ps.setTimestamp(9, sbean.getCreatedDateTime());
			ps.setTimestamp(10, sbean.getModifiedDateTime());
			int a = ps.executeUpdate();
			System.out.println("insert data" + a);
			ps.close();
			con.close();

		} catch (Exception e) {

		}
		return 0;

	}

	public void delete(SubjectBean sbean) {
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from st_subject where ID=?");
			ps.setLong(1, sbean.getId());
			System.out.println("Delete data successfully");
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(SubjectBean sbean) {

		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update st_subject set SUBJECT_NAME=?,COURSE_NAME=?,COURSE_ID=?,SUBJECT_ID=?,DESCRIPTION=? where id=?");
			
			
            ps.setString(1, sbean.getSubjectName()); 
            ps.setString(2, sbean.getCourseName());
            ps.setLong(3, sbean.getCourseId());
            ps.setLong(4, sbean.getSubjectId());
            ps.setString(5, sbean.getDescription());
            ps.setLong(6,sbean.getId());
			System.out.println("update data successfully");
			ps.executeUpdate();
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public SubjectBean findByPk(long pk) {

		SubjectBean sbean = new SubjectBean();
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from st_subject where ID=?");
			ps.setLong(1, pk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				sbean.setId(rs.getLong(1));
			    sbean.setSubjectName(rs.getString(2));
			    sbean.setDescription(rs.getString(3));
			    sbean.setCourseName(rs.getString(4));
			    sbean.setCourseId(rs.getLong(5));
			    sbean.setSubjectId(rs.getLong(6));
			   

			}
			ps.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sbean;

	}
	public List search(SubjectBean sbean1) {

		StringBuffer sql = new StringBuffer("select * from st_subject where 1=1");
		if (sbean1 != null) {
			if (sbean1.getId() > 0) {
				sql.append(" AND ID = " + sbean1.getId());
			}
			if ((sbean1.getSubjectName() !=  null)&&(sbean1.getSubjectName().length() > 0)) {
				sql.append(" AND SUBJECT_NAME like '" + sbean1.getSubjectName()+"%'");
			}
			if ((sbean1.getCourseName() !=  null)&&(sbean1.getCourseName().length() > 0)) {
				sql.append(" AND COURSE_NAME like '" + sbean1.getCourseName()+"%'");

			}
			if (sbean1.getCourseId() > 0) {
				sql.append(" AND COURSE_ID = " + sbean1.getCourseId());
			}
			if (sbean1.getSubjectId() > 0) {
				sql.append(" AND SUBJECT_ID = " + sbean1.getSubjectId());
			}
			if ((sbean1.getDescription() !=  null)&&(sbean1.getDescription().length() > 0)) {
				sql.append(" AND DESCRIPTION like '" + sbean1.getDescription()+"%'");

			}
		}
	ArrayList<SubjectBean> ar = new ArrayList<SubjectBean>();
		try {

			Connection con = JdbcDataSource.getConnection();

			PreparedStatement ps = con.prepareStatement(sql.toString());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SubjectBean sbean = new SubjectBean();
				sbean.setId(rs.getLong(1));
			    sbean.setSubjectName(rs.getString(2));
			    sbean.setDescription(rs.getString(3));
			    sbean.setCourseName(rs.getString(4));
			    sbean.setCourseId(rs.getLong(5));
			    sbean.setSubjectId(rs.getLong(6));
			   
				ar.add(sbean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ar;

	}
	
	public ArrayList<SubjectBean> list() {
		ArrayList<SubjectBean> ar = new ArrayList<SubjectBean>();
		try {

			Connection con = JdbcDataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from st_subject");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SubjectBean sbean = new SubjectBean();
				sbean.setId(rs.getLong(1));
			    sbean.setSubjectName(rs.getString(2));
			    sbean.setDescription(rs.getString(3));
			    sbean.setCourseName(rs.getString(4));
			    sbean.setCourseId(rs.getLong(5));
			    sbean.setSubjectId(rs.getLong(6));
				ar.add(sbean);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ar;

	}
}
