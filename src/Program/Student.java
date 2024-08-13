//DTO/Bean(Data Transfer Object)
package Program;

public class Student 
{
	//Student records

private String name;
private int marks;
private int rno;
public int getRno() {
	return rno;
}
public void setRno(int rno) {
	this.rno = rno;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getMarks() {
	return marks;
}
public void setMarks(int marks) {
	this.marks = marks;
}
//enter new records
private String sname;
private String Fname;
private String rollno;
private String dob;
private String address;
private String email;
private String mno;
private String cls1;
private String cls2;
private String aadhar;
private String course1;
private String course2;

//login details
private String username;
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getFname() {
	return Fname;
}
public void setFname(String fname) {
	Fname = fname;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getMno() {
	return mno;
}
public void setMno(String mno) {
	this.mno = mno;
}
public String getCls1() {
	return cls1;
}
public void setCls1(String cls1) {
	this.cls1 = cls1;
}
public String getCls2() {
	return cls2;
}
public void setCls2(String cls2) {
	this.cls2 = cls2;
}
public String getCourse1() {
	return course1;
}
public void setCourse1(String course1) {
	this.course1 = course1;
}
public String getCourse2() {
	return course2;
}
public void setCourse2(String course2) {
	this.course2 = course2;
}

public void setPassword(String password) {
	this.password = password;
}
public String getRollno() {
	return rollno;
}
public void setRollno(String rollno) {
	this.rollno = rollno;
}

private String password;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPasswrod(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAadhar() {
	return aadhar;
}
public void setAadhar(String aadhar) {
	this.aadhar = aadhar;
}







}
