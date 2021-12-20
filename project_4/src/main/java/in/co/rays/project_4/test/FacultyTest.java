package in.co.rays.project_4.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import in.co.rays.project_4.bean.FacultyBean;
import in.co.rays.project_4.model.FacultyModel;

public class FacultyTest {
	public static void main(String[] args) throws Exception {
		//testInsert();
		 //testDelete();
		//testUpdates();
		//testList();
		 //testFindBy();
		
		testSearch();
	}

	private static void testFindBy() {
		FacultyModel um = new FacultyModel();
		FacultyBean fbean = um.findByPk(2);
		System.out.println(fbean.getId() + "\t" + fbean.getFirstName() + "\t" + fbean.getLastName() + "\t"
				+ fbean.getGender() + "\t" + fbean.getJoiningDob() + "\t" + fbean.getQualification() + "\t"
				+ fbean.getMobileNo() + "\t" + fbean.getEmailId() + "\t" + fbean.getCollegeId() + "\t"
				+ fbean.getCollegeName() + "\t" + fbean.getSubjectId() + "\t" + fbean.getSubjectName() + "\t"
				+ fbean.getCourseId() + "\t" + fbean.getCourseName());

	}

	

	public static void testInsert() throws Exception {
		FacultyBean fbean = new FacultyBean();

		String date = "12/05/1995";
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		

		fbean.setFirstName("ayushi");
		fbean.setLastName("agrawal");
		fbean.setGender("male");
		fbean.setJoiningDob(sdf.parse("01/12/2015"));
		fbean.setQualification("be");
		fbean.setEmailId("a@");
		fbean.setMobileNo("98987887778");
		fbean.setCollegeId(101);
		fbean.setCollegeName("svce");
		fbean.setCourseId(102);
		fbean.setCourseName("pcm");
		fbean.setSubjectId(103);
		fbean.setSubjectName("maths");
		FacultyModel umodel = new FacultyModel();
		umodel.add(fbean);
	}

	public static void testDelete() {
		FacultyBean fbean = new FacultyBean();
		fbean.setId(1);
		FacultyModel fmodel = new FacultyModel();
		fmodel.delete(fbean);
	}

	public static void testUpdates() throws ParseException {
		FacultyBean fbean = new FacultyBean();

		String date = "29/05/1995";
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date d = sdf.parse(date);
        fbean.setId(2);
		fbean.setFirstName("ayushii");
		fbean.setLastName("agrawals");
		fbean.setGender("female");
		fbean.setJoiningDob(sdf.parse("12/11/2001"));
		fbean.setQualification("bsc");
		fbean.setEmailId("a@a");
		fbean.setMobileNo("398987887778");
		fbean.setCollegeId(1011);
		fbean.setCollegeName("svcei");
		fbean.setCourseId(1022);
		fbean.setCourseName("svces");
		fbean.setSubjectId(1033);
		fbean.setSubjectName("phy");
		FacultyModel fmodel = new FacultyModel();
		fmodel.update(fbean);
	}

	public static void testList() {

		FacultyModel fmodel = new FacultyModel();
		ArrayList<FacultyBean> a = fmodel.list();
		for (FacultyBean fbean : a) {
			System.out.println(fbean.getId() + "\t" + fbean.getFirstName() + "\t" + fbean.getLastName() + "\t"
					+ fbean.getGender() + "\t" + fbean.getJoiningDob() + "\t" + fbean.getQualification() + "\t"
					+ fbean.getMobileNo() + "\t" + fbean.getEmailId() + "\t" + fbean.getCollegeId() + "\t"
					+ fbean.getCollegeName() + "\t" + fbean.getSubjectId() + "\t" + fbean.getSubjectName() + "\t"
					+ fbean.getCourseId() + "\t" + fbean.getCourseName());

		}
	}

	public static void testSearch() {
		FacultyBean fbean1 = new FacultyBean();

		//fbean1.setFirstName("ayushi");
		 //fbean1.setLastName("agrawals");
		//fbean1.setGender("female");
		// fbean1.setMobileNo("989");
		//fbean1.setQualification("be");
		//fbean1.setEmailId("a@");
		fbean1.setCollegeId(101);
		//fbean.setGender("female");

		FacultyModel fmodel = new FacultyModel();
		ArrayList<FacultyBean> a = (ArrayList<FacultyBean>) fmodel.search(fbean1);
		for (FacultyBean fbean : a) {
			System.out.println(fbean.getId() + "\t" + fbean.getFirstName() + "\t" + fbean.getLastName() + "\t"
					+ fbean.getGender() + "\t" + fbean.getJoiningDob() + "\t" + fbean.getQualification() + "\t"
					+ fbean.getMobileNo() + "\t" + fbean.getEmailId() + "\t" + fbean.getCollegeId() + "\t"
					+ fbean.getCollegeName() + "\t" + fbean.getSubjectId() + "\t" + fbean.getSubjectName() + "\t"
					+ fbean.getCourseId() + "\t" + fbean.getCourseName());
		}
	}

}
