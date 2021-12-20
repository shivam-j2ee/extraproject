package in.co.rays.project_4.test;

import java.util.ArrayList;

import in.co.rays.project_4.bean.RoleBean;
import in.co.rays.project_4.bean.UserBean;
import in.co.rays.project_4.model.RoleModel;
import in.co.rays.project_4.model.UserModel;

public class RoleTest {

public static void main(String[] args) throws Exception {
	//testInsert();
	//testDelete();
	//testUpdate();
   //testList();
	//testFindBy();
	//testFindByName();
	//testSearch();
}
public static void testInsert(){
	RoleBean rbean=new RoleBean();
	rbean.setADMIN(1);
	rbean.setSTUDENT(2);
	rbean.setCOLLEGE(3);
	rbean.setKISOK(4);
	rbean.setFACULTUY(5);
	rbean.setName("hello");
	rbean.setDescription("how r u");
	RoleModel rmodel=new RoleModel();
	rmodel.add(rbean);
	
}
public static void testDelete(){
	RoleBean rbean=new RoleBean();
	rbean.setId(1);
	RoleModel rmodel=new RoleModel();
	rmodel.delete(rbean);
}
public static void testUpdate(){
	RoleBean rbean=new RoleBean();
	rbean.setId(1);
	rbean.setADMIN(4);
	rbean.setSTUDENT(5);
	rbean.setCOLLEGE(6);
	rbean.setKISOK(5);
	rbean.setFACULTUY(7);
	RoleModel rmodel=new RoleModel();
	rmodel.update(rbean);
}
public static void testList(){
	RoleBean r=new RoleBean();
	RoleModel rm=new RoleModel();
	ArrayList<RoleBean> a=rm.list();
	for(RoleBean rbean:a){
		System.out.println(rbean.getId()+"\t"+rbean.getADMIN()+"\t"+rbean.getSTUDENT()+"\t"+rbean.getCOLLEGE()+"\t"+rbean.getKISOK()+"\t"+rbean.getName()+"\t"+rbean.getFACULTUY()+"\t"+rbean.getDescription());
		
		
	}}
private static void testFindByName() {
	RoleModel rmodel=new RoleModel();
	RoleBean rbean=rmodel.findByName("hello");
System.out.println(rbean.getId()+"\t"+rbean.getADMIN()+"\t"+rbean.getSTUDENT()+"\t"+rbean.getCOLLEGE()+"\t"+rbean.getKISOK()+"\t"+rbean.getFACULTUY()+"\t"+rbean.getName()+"\t"+rbean.getDescription());
}
private static void testFindBy() {
	RoleModel rmodel=new RoleModel();
	RoleBean rbean=rmodel.findByPk(2);
System.out.println(rbean.getId()+"\t"+rbean.getADMIN()+"\t"+rbean.getSTUDENT()+"\t"+rbean.getCOLLEGE()+"\t"+rbean.getKISOK()+"\t"+rbean.getFACULTUY()+"\t"+rbean.getName()+"\t"+rbean.getDescription());
}
public static void testSearch(){
	RoleBean rbean1=new RoleBean();
	rbean1.setADMIN(1);
	
	RoleModel rmodel=new RoleModel();
	ArrayList<RoleBean> a=(ArrayList<RoleBean>) rmodel.search(rbean1);
	for(RoleBean rbean:a){
		System.out.println(rbean.getId()+"\t"+rbean.getADMIN()+"\t"+rbean.getSTUDENT()+"\t"+rbean.getCOLLEGE()+"\t"+rbean.getKISOK()+"\t"+rbean.getFACULTUY()+"\t"+rbean.getName()+"\t"+rbean.getDescription());	
	
	
	
}
}





}