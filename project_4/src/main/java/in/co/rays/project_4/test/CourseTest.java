package in.co.rays.project_4.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import in.co.rays.project_4.bean.CourseBean;
import in.co.rays.project_4.model.CourseModel;

public class CourseTest {
	public static void main(String[] args) throws Exception {
		 //testInsert();
		//testFindBy();
		// testDelete();
		// testUpdates();
		// testList();
		testSearch();
	}

	private static void testFindBy() {
		CourseModel cm = new CourseModel();
		CourseBean cbean = cm.findByPk(2);
		System.out.println(cbean.getId() + "\t" + cbean.getCourseName() + "\t" + cbean.getDescription() + "\t"
				+ cbean.getDuration());

	}

	public static void testInsert() throws Exception {
		CourseBean cbean = new CourseBean();

		cbean.setId(2);
		cbean.setCourseName("pcm");
		cbean.setDescription("hello");
		cbean.setDuration("3hrs");

		CourseModel cmodel = new CourseModel();
		cmodel.add(cbean);
	}

	public static void testDelete() {
		CourseBean cbean = new CourseBean();
		cbean.setId(1);
		CourseModel cmodel = new CourseModel();
		cmodel.delete(cbean);
	}

	public static void testUpdates() {
		CourseBean cbean = new CourseBean();

		cbean.setId(2);
		cbean.setCourseName("pcms");
		cbean.setDescription("hellos");
		cbean.setDuration("3hrss");

		CourseModel cmodel = new CourseModel();
		cmodel.update(cbean);
	}

	public static void testList() {

		CourseModel cmodel = new CourseModel();
		ArrayList<CourseBean> a = cmodel.list();
		for (CourseBean cbean : a) {
			System.out.println(cbean.getId() + "\t" + cbean.getCourseName() + "\t" + cbean.getDescription() + "\t"
					+ cbean.getDuration());

		}
	}

	public static void testSearch() {
		CourseBean cbean1 = new CourseBean();
		cbean1.setId(2);
		cbean1.setCourseName("pcm");
		System.out.println("hello");

		CourseModel cmodel = new CourseModel();
		ArrayList<CourseBean> a = (ArrayList<CourseBean>) cmodel.search(cbean1);
		for (CourseBean cbean : a) {
			System.out.println(cbean.getId() + "\t" + cbean.getCourseName() + "\t" + cbean.getDescription() + "\t"
					+ cbean.getDuration());
		}
	}
}
