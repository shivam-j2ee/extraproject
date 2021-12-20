package in.co.rays.project_4.test;

import java.util.ArrayList;

import in.co.rays.project_4.bean.CollegeBean;
import in.co.rays.project_4.model.CollegeModel;

public class CollegeTest {
	public static void main(String[] args) throws Exception {
		// testInsert();
		// testFindBy();
		// testDelete();
		// testUpdates();
		// testList();
		testSearch();
	}

	private static void testFindBy() {
		CollegeModel cm = new CollegeModel();
		CollegeBean colbean = cm.findByPk(2);
		System.out.println(colbean.getId() + "\t" + colbean.getName() + "\t" + colbean.getAddress() + "\t"
				+ colbean.getState() + "\t" + colbean.getCity() + "\t" + colbean.getPhoneNo());

	}

	public static void testInsert() throws Exception {
		CollegeBean colbean = new CollegeBean();

		colbean.setName("ayushi");
		colbean.setAddress("subhash nagar");
		colbean.setCity("indore");
		colbean.setState("mp");
		colbean.setPhoneNo("989");

		CollegeModel cmodel = new CollegeModel();
		cmodel.add(colbean);
	}

	public static void testDelete() {
		CollegeBean cbean = new CollegeBean();
		cbean.setId(1);
		CollegeModel cmodel = new CollegeModel();
		cmodel.delete(cbean);
	}

	public static void testUpdates() {
		CollegeBean colbean = new CollegeBean();

		colbean.setId(2);
		colbean.setName("ayushii");
		colbean.setAddress("subhash nagars");
		colbean.setCity("indores");
		colbean.setState("m.p");
		colbean.setPhoneNo("98937888");

		CollegeModel cmodel = new CollegeModel();
		cmodel.update(colbean);
	}

	public static void testList() {

		CollegeModel cmodel = new CollegeModel();
		ArrayList<CollegeBean> a = cmodel.list();
		for (CollegeBean colbean : a) {
			System.out.println(colbean.getId() + "\t" + colbean.getName() + "\t" + colbean.getAddress() + "\t"
					+ colbean.getState() + "\t" + colbean.getCity() + "\t" + colbean.getPhoneNo());

		}
	}

	public static void testSearch() {
		CollegeBean cbean1 = new CollegeBean();
		// cbean1.setId(2);
		// cbean1.setName("ayushi");
		// cbean1.setAddress("subhash ");
		// cbean1.setCity("indore");
		// cbean1.setState("mp");
		cbean1.setPhoneNo("989");
		System.out.println("hello");

		CollegeModel cmodel = new CollegeModel();
		ArrayList<CollegeBean> a = (ArrayList<CollegeBean>) cmodel.search(cbean1);
		for (CollegeBean colbean : a) {
			System.out.println(colbean.getId() + "\t" + colbean.getName() + "\t" + colbean.getAddress() + "\t"
					+ colbean.getState() + "\t" + colbean.getCity() + "\t" + colbean.getPhoneNo());

		}
	}

}
