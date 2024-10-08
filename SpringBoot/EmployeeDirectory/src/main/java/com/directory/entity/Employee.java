package com.directory.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="employee")
@NamedQueries({
        @NamedQuery(name="Employee.findByLastName",query="select e from Employee e where e.lastName=:lastName")
})
@NamedNativeQueries({
        @NamedNativeQuery(name="Employee.updateByLastName",query="update employee set age=age+1 where lastname=?1")
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id") private Long id;

    @NotNull
    @Size(min=1, message = "FirstName is Mandatory")
    @Column(name="firstname") private String firstName;

    @Column(name="lastname")  private String lastName;
    @Size(max=10, message = "Phonenumber must Max is 10")
    @Size(min=5, message = "Phonenumber must Atleast is 5")
    @Column(name="phonenumber") private String phoneNumber;

    @Pattern(regexp = "(\\w)*@{1}(\\w)*.(\\w){2,4}",message = "Contains Illegal Character")
    //@Pattern(regexp = "(\\w)*",message = "Contains Illegal Character")
    @Column(name="emailid") private String emailId;

    @Transient
    @Column(name="password") private String password;

    @Column(name="age")
    private Integer age;

    @Column(name="salary") private Double salary;

    @NotNull
    @Size(min=1, message = "Must Contain Atleast 1 Role")
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Roles> roles;

    @Column(name="createtime")
    @CreationTimestamp private Timestamp createTime;

    @Column(name="lastmodified")
    @UpdateTimestamp
    private Timestamp lastModified;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String phoneNumber, String emailId, Integer age, Double salary, List<Roles> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.age = age;
        this.salary = salary;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
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
                ", password='" + password + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", roles=" + roles +
                ", createTime=" + createTime +
                ", lastModified=" + lastModified +
                '}';
    }
}
