package in.co.rays.project_4.bean;

public class RoleBean extends BaseBean{
private int ADMIN;
private int STUDENT;
private int COLLEGE;
private int KISOK;
private int FACULTUY;
private String name;
private String description;
public int getCOLLEGE() {
	return COLLEGE;
}
public void setCOLLEGE(int cOLLEGE) {
	COLLEGE = cOLLEGE;
}
public int getFACULTUY() {
	return FACULTUY;
}
public void setFACULTUY(int fACULTUY) {
	FACULTUY = fACULTUY;
}

public int getADMIN() {
	return ADMIN;
}
public void setADMIN(int aDMIN) {
	ADMIN = aDMIN;
}
public int getSTUDENT() {
	return STUDENT;
}
public void setSTUDENT(int sTUDENT) {
	STUDENT = sTUDENT;
}

public int getKISOK() {
	return KISOK;
}
public void setKISOK(int kISOK) {
	KISOK = kISOK;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

	
	
	
	
	
}
