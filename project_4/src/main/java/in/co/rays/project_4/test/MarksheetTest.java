package in.co.rays.project_4.test;


import java.util.ArrayList;
import java.util.Iterator;

import in.co.rays.project_4.bean.MarksheetBean;
import in.co.rays.project_4.bean.RoleBean;
import in.co.rays.project_4.model.MarksheetModel;
import in.co.rays.project_4.model.RoleModel;


public class MarksheetTest {
	public static void main(String[] args) {
		//testAdd();
		//testUpdate();
		//testDelete();
		//testList();
		//testSearch();
		//testFindBy();
		testFindByRollNo();
	}
	public static void testAdd(){
		MarksheetBean bean=new MarksheetBean();
		bean.setChemistry(80);
		bean.setMaths(80);
		bean.setRollNo("1234");
		bean.setStudentId(1234);
		bean.setPhysics(70);
		bean.setName("shivam tiwari");
		MarksheetModel mm=new MarksheetModel();
		mm.add(bean);
		System.out.println("updated");
	}
	public static void testUpdate(){
		MarksheetBean bean=new MarksheetBean();
		bean.setId(1);
		bean.setChemistry(75);
		bean.setMaths(75);
		bean.setRollNo("1235");
		bean.setStudentId(1235);
		bean.setPhysics(75);
		bean.setName("shivam tiwari");
		MarksheetModel mm=new MarksheetModel();
		mm.update(bean);
		System.out.println("updated");
	}
	public static void testDelete(){
		MarksheetBean bean=new MarksheetBean();
		bean.setId(1);
		MarksheetModel mm=new MarksheetModel();
		mm.delete(bean);;
		System.out.println("deleted");
	}
	public static void testList(){
		MarksheetModel mm=new MarksheetModel();
		ArrayList<MarksheetBean> a11=mm.list();
		for (MarksheetBean mbean:a11) {
			System.out.print(mbean.getId());
			System.out.print("\t"+mbean.getRollNo());
			System.out.print("\t"+mbean.getStudentId());
			System.out.print("\t"+mbean.getName());
			System.out.print("\t"+mbean.getPhysics());
			System.out.print("\t"+mbean.getChemistry());
			System.out.println("\t"+mbean.getMaths());
			
		}
			
		}
		
	
	private static void testFindBy() {
		MarksheetModel mmodel=new MarksheetModel();
		MarksheetBean mbean=mmodel.findByPk(2);
		System.out.print(mbean.getId());
		System.out.print("\t"+mbean.getRollNo());
		System.out.print("\t"+mbean.getStudentId());
		System.out.print("\t"+mbean.getName());
		System.out.print("\t"+mbean.getPhysics());
		System.out.print("\t"+mbean.getChemistry());
		System.out.println("\t"+mbean.getMaths());
	}
	
	private static void testFindByRollNo() {
		MarksheetModel mmodel=new MarksheetModel();
		MarksheetBean mbean=mmodel.findByRollNo("1234");
		System.out.print(mbean.getId());
		System.out.print("\t"+mbean.getRollNo());
		System.out.print("\t"+mbean.getStudentId());
		System.out.print("\t"+mbean.getName());
		System.out.print("\t"+mbean.getPhysics());
		System.out.print("\t"+mbean.getChemistry());
		System.out.println("\t"+mbean.getMaths());
	}
	
	
	public static void testSearch(){
		MarksheetBean mbean1=new MarksheetBean();
		//mbean1.setId(2);
		//mbean1.setRollNo("1234");
		//mbean1.setStudentId(1234);
		//mbean1.setName("shivam");
		mbean1.setPhysics(70);
		//mbean1.setChemistry(80);
		//mbean1.setMaths(80);
		MarksheetModel mmodel=new MarksheetModel();
		ArrayList<MarksheetBean> a=(ArrayList<MarksheetBean>) mmodel.search(mbean1);
		for(MarksheetBean mbean:a){
			System.out.print(mbean.getId());
			System.out.print("\t"+mbean.getRollNo());
			System.out.print("\t"+mbean.getStudentId());
			System.out.print("\t"+mbean.getName());
			System.out.print("\t"+mbean.getPhysics());
			System.out.print("\t"+mbean.getChemistry());
			System.out.println("\t"+mbean.getMaths());
		
		
		
	}
	}

}
