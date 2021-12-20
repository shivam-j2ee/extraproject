package in.co.rays.project_4.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import in.co.rays.project_4.bean.MarksheetBean;
import in.co.rays.project_4.bean.StudentBean;
import in.co.rays.project_4.bean.TimeTableBean;
import in.co.rays.project_4.model.MarksheetModel;
import in.co.rays.project_4.model.StudentModel;
import in.co.rays.project_4.model.TimeTableModel;

public class TimeTableTest {
	public static void main(String[] args) throws ParseException {
		// addTest();
		// updateTest();
		// DeleteTest();
		// testList();
		// testFindByPk();
		testSearch();

	}

	private static void testSearch() throws ParseException {
		TimeTableBean tbean1 = new TimeTableBean();

		/*
		 * String date="2005-10-10"; SimpleDateFormat sdf = new
		 * SimpleDateFormat("dd/MM/yyyy"); Date d = sdf.parse(date);
		 */ // tbean1.setId(1);
			// tbean1.setSubId(1);
			// tbean1.setCourseName("maths");
			// tbean1.setCourseId(101);
			// tbean1.setCourseName("be");
			// tbean1.setSemester("fifth");
			// tbean1.setExamDate(d);
			// tbean1.setExamTime("3hr");
		tbean1.setDescription("hello");
		TimeTableModel tm = new TimeTableModel();
		ArrayList<TimeTableBean> a = (ArrayList<TimeTableBean>) tm.search(tbean1);
		for (TimeTableBean tbean : a) {
			System.out.print(tbean.getId());
			System.out.print("\t" + tbean.getSubId());
			System.out.print("\t" + tbean.getSubName());
			System.out.print("\t" + tbean.getCourseId());
			System.out.print("\t" + tbean.getCourseName());
			System.out.print("\t" + tbean.getSemester());
			System.out.print("\t" + tbean.getExamDate());
			System.out.print("\t" + tbean.getExamTime());
			System.out.print("\t" + tbean.getDescription());

		}
	}

	private static void testFindByPk() {
		TimeTableModel tm = new TimeTableModel();
		TimeTableBean tbean = tm.findByPk(1);
		System.out.print(tbean.getId());
		System.out.print("\t" + tbean.getSubId());
		System.out.print("\t" + tbean.getSubName());
		System.out.print("\t" + tbean.getCourseId());
		System.out.print("\t" + tbean.getCourseName());
		System.out.print("\t" + tbean.getSemester());
		System.out.print("\t" + tbean.getExamDate());
		System.out.print("\t" + tbean.getExamTime());
		System.out.print("\t" + tbean.getDescription());

	}

	public static void addTest() throws ParseException {
		TimeTableBean tbean = new TimeTableBean();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		tbean.setSubId(1);
		tbean.setSubName("maths");
		tbean.setCourseId(101);
		tbean.setCourseName("be");
		tbean.setSemester("fifth");
		tbean.setExamDate(sdf.parse("01/11/2012"));
		tbean.setExamTime("3hr");
		tbean.setDescription("hello");
		TimeTableModel tmodel = new TimeTableModel();
		tmodel.add(tbean);
	}

	public static void updateTest() throws ParseException {
		TimeTableBean tbean = new TimeTableBean();
		String date = "10/9/2005";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d = sdf.parse(date);
		tbean.setId(1);
		tbean.setSubId(1);
		tbean.setSubName("physics");
		tbean.setCourseId(102);
		tbean.setCourseName("bee");
		tbean.setSemester("fourth");
		tbean.setExamDate(sdf.parse("01/02/2012"));
		tbean.setExamTime("4hr");
		tbean.setDescription("hello...");
		TimeTableModel tmodel = new TimeTableModel();
		tmodel.update(tbean);
	}

	public static void DeleteTest() {
		TimeTableBean tbean = new TimeTableBean();
		tbean.setId(1);
		TimeTableModel tmodel = new TimeTableModel();
		tmodel.delete(tbean);
		System.out.println("deleted");
	}

	public static void testList() {
		TimeTableModel tmodel = new TimeTableModel();
		ArrayList<TimeTableBean> a11 = tmodel.list();
		for (TimeTableBean tbean : a11) {
			System.out.print(tbean.getId());
			System.out.print("\t" + tbean.getSubId());
			System.out.print("\t" + tbean.getSubName());
			System.out.print("\t" + tbean.getCourseId());
			System.out.print("\t" + tbean.getCourseName());
			System.out.print("\t" + tbean.getSemester());
			System.out.print("\t" + tbean.getExamDate());
			System.out.print("\t" + tbean.getExamTime());
			System.out.print("\t" + tbean.getDescription());

		}

	}

}
