package in.co.rays.project_4.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import in.co.rays.project_4.bean.SubjectBean;
import in.co.rays.project_4.bean.TimeTableBean;
import in.co.rays.project_4.model.SubjectModel;
import in.co.rays.project_4.model.TimeTableModel;

public class SubjectTest {
	public static void main(String[] args) {
		//addTest();
		//findByPkTest();
		//deleteTest();
		//listTest();
		//updateTest();
		searchTest();
	}

	public static void addTest() {
		SubjectBean sbean = new SubjectBean();

		sbean.setId(1);
		sbean.setSubjectName("maths");
		sbean.setCourseId(101);
		sbean.setSubjectId(101);
		sbean.setCourseName("be");
		sbean.setDescription("hello");
		SubjectModel smodel = new SubjectModel();
		smodel.add(sbean);

	}

	private static void findByPkTest() {
		SubjectModel smodel = new SubjectModel();
		SubjectBean sbean = smodel.findByPk(2);
		System.out.print(sbean.getId());
		System.out.print("\t" + sbean.getSubjectName());
		System.out.print("\t" + sbean.getCourseId());
		System.out.print("\t" + sbean.getCourseName());
		System.out.print("\t" + sbean.getSubjectId());
		System.out.print("\t" + sbean.getDescription());

	}

	public static void deleteTest() {
		SubjectBean tbean = new SubjectBean();
		tbean.setId(1);
		SubjectModel tmodel = new SubjectModel();
		tmodel.delete(tbean);
		System.out.println("deleted");
	}

	public static void listTest() {
		SubjectModel smodel = new SubjectModel();
		ArrayList<SubjectBean> a11 = smodel.list();
		for (SubjectBean sbean : a11) {
			System.out.print(sbean.getId());
			System.out.print("\t" + sbean.getSubjectName());
			System.out.print("\t" + sbean.getCourseName());
			System.out.print("\t" + sbean.getCourseId());
			System.out.print("\t" + sbean.getSubjectId());
			System.out.print("\t" + sbean.getDescription());
		}

	}

	public static void updateTest() {
		SubjectBean tbean = new SubjectBean();
		tbean.setId(4);
		tbean.setSubjectName("physics");
		tbean.setCourseId(102);
		tbean.setCourseName("bee");
		tbean.setSubjectId(102);
		tbean.setDescription("hello...");
		SubjectModel tmodel = new SubjectModel();
		tmodel.update(tbean);
	}

	private static void searchTest() {
		SubjectBean sbean1 = new SubjectBean();

	   //sbean1.setId(1);
		//sbean1.setSubjectName("maths");
		 //sbean1.setCourseId(101);
		//sbean1.setSubjectId(101);
		// sbean1.setCourseName("be");
		//sbean1.setDescription("hello");
		SubjectModel tm = new SubjectModel();
		ArrayList<SubjectBean> a = (ArrayList<SubjectBean>) tm.search(sbean1);
		for (SubjectBean sbean : a) {
			System.out.print(sbean.getId());
			System.out.print("\t" + sbean.getSubjectName());
			System.out.print("\t" + sbean.getSubjectId());
			System.out.print("\t" + sbean.getCourseId());
			System.out.print("\t" + sbean.getCourseName());
			System.out.print("\t" + sbean.getDescription());

		}
	}

}