package springboot.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name="student")
public class Student extends BaseEntity{
	//http://localhost:8081/rest/students
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="first_name",unique=true)
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;
	
	@Column(name="email_id",unique=true)
	private String emailId;
	
	@Column(name="grade")
	private double grade; 

	public Student()
	{
	}
	public Student(String firstname, String lastname, String emailId) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailId = emailId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				", emailId='" + emailId + '\'' +
				", grade=" + grade +
				", createtime=" + createtime +
				", createdby='" + createdby + '\'' +
				", modifiedtime=" + modifiedtime +
				", modifiedby='" + modifiedby + '\'' +
				'}';
	}
}
