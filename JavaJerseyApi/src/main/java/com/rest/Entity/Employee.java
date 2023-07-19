package com.rest.Entity;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Employee {
	private long id;
	private String firstName;
	private String lastName;
	private String emailid;
	private String phonenumber;
	private double salary;
	private Timestamp createtime;
	private Timestamp lastmodified;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public Timestamp getLastmodified() {
		return lastmodified;
	}
	public void setLastmodified(Timestamp lastmodified) {
		this.lastmodified = lastmodified;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailid=" + emailid
				+ ", phonenumber=" + phonenumber + ", salary=" + salary + ", createtime=" + createtime
				+ ", lastmodified=" + lastmodified + "]";
	}
	
	
}
