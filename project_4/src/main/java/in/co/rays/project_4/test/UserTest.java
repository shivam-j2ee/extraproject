package in.co.rays.project_4.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import in.co.rays.project_4.bean.UserBean;
import in.co.rays.project_4.model.UserModel;

public class UserTest {
	public static void main(String[] args) throws Exception {
		//testInsert();
		// testDelete();
		 //testUpdates();
		// testList();
		// testFindBy();
		// testFindByLog();
		 testSearch();
	}

	private static void testFindBy() {
		UserModel um = new UserModel();
		UserBean uu = um.findByPk(2);
		System.out.println(uu.getId() + "\t" + uu.getFirstName() + "\t" + uu.getLastName() + "\t" + uu.getLogin() + "\t"
				+ uu.getPassword() + "\t" + uu.getDob() + "\t" + uu.getMobileNO() + "\t" + uu.getRoleId() + "\t"
				+ uu.getUnSuccessfullLogin() + "\t" + uu.getGender() + "\t" + uu.getLastLogin() + "\t" + uu.getLock()
				+ "\t" + uu.getLastLoginIP() + "\t" + uu.getRegisteredIP());

	}

	private static void testFindByLog() {
		UserModel umodel = new UserModel();
		UserBean ubean = umodel.findByLogin("logins");
		System.out.println(ubean.getId() + "\t" + ubean.getFirstName() + "\t" + ubean.getLastName() + "\t"
				+ ubean.getLogin() + "\t" + ubean.getPassword() + "\t" + ubean.getDob() + "\t" + ubean.getMobileNO()
				+ "\t" + ubean.getRoleId() + "\t" + ubean.getUnSuccessfullLogin() + "\t" + ubean.getGender() + "\t"
				+ ubean.getLastLogin() + "\t" + ubean.getLock() + "\t" + ubean.getLastLoginIP() + "\t"
				+ ubean.getRegisteredIP());

	}

	public static void testInsert() throws Exception {
		UserBean ubean = new UserBean();

		Date dd = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Timestamp ts = new Timestamp(dd.getTime());

		ubean.setFirstName("ayushi");
		ubean.setLastName("agrawal");
		ubean.setLogin("login");
		ubean.setPassword("1234");
		ubean.setDob(sdf.parse("10/11/1980"));
		ubean.setMobileNO("98987887778");
		ubean.setRoleId(101);
		ubean.setUnSuccessfullLogin(2);
		ubean.setGender("female");
		ubean.setLastLogin(ts);
		ubean.setLock("lock");
		ubean.setRegisteredIP("register101");
		ubean.setLastLoginIP("lastip101");
		UserModel umodel = new UserModel();
		umodel.add(ubean);
	}

	public static void testDelete() {
		UserBean ubean = new UserBean();
		ubean.setId(1);
		UserModel umodel = new UserModel();
		umodel.delete(ubean);
	}

	public static void testUpdates() throws ParseException {
		UserBean ubean = new UserBean();

		Date dd = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

		Timestamp ts = new Timestamp(dd.getTime());

		ubean.setMobileNO("9406653787");
		ubean.setId(2);
		ubean.setFirstName("ayushis");
		ubean.setLastName("agrawals");
		ubean.setLogin("logins");
		ubean.setPassword("12345");
		ubean.setDob(sdf.parse("12/1/2015"));
		ubean.setMobileNO("989878877785");
		ubean.setRoleId(102);
		ubean.setUnSuccessfullLogin(3);
		ubean.setGender("females");
		UserModel umodel = new UserModel();
		umodel.update(ubean);
	}

	public static void testList() {

		UserModel umodel = new UserModel();
		ArrayList<UserBean> a = umodel.list();
		for (UserBean ubean : a) {
			System.out.println(ubean.getId() + "\t" + ubean.getFirstName() + "\t" + ubean.getLastName() + "\t"
					+ ubean.getLogin() + "\t" + ubean.getPassword() + "\t" + ubean.getDob() + "\t" + ubean.getMobileNO()
					+ "\t" + ubean.getRoleId() + "\t" + ubean.getUnSuccessfullLogin() + "\t" + ubean.getGender() + "\t"
					+ ubean.getLastLogin() + "\t" + ubean.getLock() + "\t" + ubean.getLastLoginIP() + "\t"
					+ ubean.getRegisteredIP());

		}
	}

	public static void testSearch() {
		UserBean ubean = new UserBean();

		//ubean.setFirstName("ayushi");
		//ubean.setLastName("agrawals");
		// ubean.setLogin("login");
		// ubean.setPassword("123");
		// ubean.setMobileNO("989");
		// ubean.setRoleId(101);
		// ubean.setUnSuccessfullLogin(1);

		ubean.setGender("female");

		UserModel um = new UserModel();
		ArrayList<UserBean> a = (ArrayList<UserBean>) um.search(ubean);
		for (UserBean ubean1 : a) {
			System.out.println(ubean1.getId() + "\t" + ubean1.getFirstName() + "\t" + ubean1.getLastName() + "\t"
					+ ubean1.getLogin() + "\t" + ubean1.getPassword() + "\t" + ubean1.getDob() + "\t"
					+ ubean1.getMobileNO() + "\t" + ubean1.getRoleId() + "\t" + ubean1.getUnSuccessfullLogin() + "\t"
					+ ubean1.getGender() + "\t" + ubean1.getLastLogin() + "\t" + ubean1.getLock() + "\t"
					+ ubean1.getLastLoginIP() + "\t" + ubean1.getRegisteredIP());

		}
	}

}
