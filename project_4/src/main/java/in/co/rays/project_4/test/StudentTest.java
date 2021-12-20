package in.co.rays.project_4.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import in.co.rays.project_4.bean.StudentBean;
import in.co.rays.project_4.bean.UserBean;
import in.co.rays.project_4.model.StudentModel;
import in.co.rays.project_4.model.UserModel;

public class StudentTest {
	public static void main(String[] args) throws Exception {
		// insert();
		// del();
		// updat();
		// lists();
		// searchs();
		findByEmailId();
		// findBy();
	}

	private static void findBy() {
		StudentModel um = new StudentModel();
		StudentBean uu = um.findByPk(2);
		System.out.println(uu.getId() + "\t" + uu.getFirstName() + "\t" + uu.getLastName() + "\t" + uu.getDob() + "\t"
				+ uu.getEmail() + "\t" + uu.getMobileNo() + "\t" + uu.getCollegeId() + "\t" + uu.getCollegeName());

	}

	private static void findByEmailId() {
		StudentModel um = new StudentModel();
		StudentBean uu = um.findByEmailId("a@");
		System.out.println(uu.getId() + "\t" + uu.getFirstName() + "\t" + uu.getLastName() + "\t" + uu.getDob() + "\t"
				+ uu.getEmail() + "\t" + uu.getMobileNo() + "\t" + uu.getCollegeId() + "\t" + uu.getCollegeName());

	}

	public static void insert() throws Exception {
		StudentBean r = new StudentBean();
		String date = "12/05/1995";
		Date dd = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d = sdf.parse(date);

		r.setFirstName("ayushi");
		r.setLastName("agrawal");
		r.setDob(d);
		r.setMobileNo("5689");
		r.setEmail("ay");

		r.setCollegeId(125);
		r.setCollegeName("svce");
		StudentModel rm = new StudentModel();
		rm.add(r);

	}

	public static void del() {
		StudentBean u = new StudentBean();
		u.setId(1);
		StudentModel um = new StudentModel();
		um.delete(u);
	}

	public static void updat() {
		StudentBean u = new StudentBean();
		u.setId(2);
		u.setFirstName("ayu");
		u.setLastName("agr");
		u.setMobileNo("989");
		u.setEmail("a@");
		u.setCollegeId(12);
		u.setCollegeName("cgi");
		StudentModel rb = new StudentModel();
		rb.update(u);
	}

	public static void lists() {
		StudentBean r = new StudentBean();
		StudentModel rm = new StudentModel();
		ArrayList<StudentBean> a = rm.list();
		for (StudentBean uu : a) {
			System.out.println(uu.getId() + "\t" + uu.getFirstName() + "\t" + uu.getLastName() + "\t" + uu.getDob()
					+ "\t" + uu.getEmail() + "\t" + uu.getMobileNo() + "\t" + uu.getCollegeId() + "\t"
					+ uu.getCollegeName());

		}
	}

	public static void searchs() {
		StudentBean u = new StudentBean();
		u.setFirstName("ayu");
		// u.setLastName("agrawals");
		// u.setMobileNO("989");
		// u.setRoleId(101);
		// u.setUnSuccessfullLogin(1);

		StudentModel um = new StudentModel();
		ArrayList<StudentBean> a = (ArrayList<StudentBean>) um.search(u);
		for (StudentBean uu : a) {

			System.out.println(uu.getId() + "\t" + uu.getFirstName() + "\t" + uu.getLastName() + "\t" + uu.getDob()
					+ "\t" + uu.getEmail() + "\t" + uu.getMobileNo() + "\t" + uu.getCollegeId() + "\t"
					+ uu.getCollegeName());

		}
	}
}
