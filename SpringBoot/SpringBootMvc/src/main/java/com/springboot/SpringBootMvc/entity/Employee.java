package com.springboot.SpringBootMvc.entity;
import com.springboot.SpringBootMvc.annotation.RoleCheck;
import jakarta.validation.constraints.*;
import java.sql.Timestamp;
public class Employee {
    long id;
    @NotNull(message = "Cannot Be Empty")
    @Size(min = 1, message = "First Name is must")
    private String firstName;
    private String lastName;
    @Size(min = 5, message = "Phone number should be 5")
    private String phoneNumber;
    @Pattern(regexp = "^[a-zA-Z0-9]*", message = "Must be Alphabet and Number")
    private String emailId;
    @Min(value = 18, message = "Should Not less 18")
    @Max(value = 60, message = "Should Not more 60")
    private int age;
    private double salary;
    @RoleCheck
    private String roles;
    private Timestamp createTime;
    private Timestamp lastModified;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String phoneNumber, String emailId, int age, double salary,String roles, Timestamp createTime, Timestamp lastModified) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.age = age;
        this.salary = salary;
        this.roles=roles;
        this.createTime = createTime;
        this.lastModified = lastModified;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getRoles() {
        return roles;
    }
    public void setRoles(String roles) {
        this.roles = roles;
    }
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailId='" + emailId + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", roles='" + roles + '\'' +
                ", createTime=" + createTime +
                ", lastModified=" + lastModified +
                '}';
    }
}
