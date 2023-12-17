package springboot.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Column(name="phonenumber")
    private String phoneNumber;
    @Column(name="emailid")
    private String emailId;
    @Column(name="salary")
    private Double salary;
    @Column(name="createtime")
    @CreationTimestamp
    private Timestamp createTime;
    @Column(name="lastmodified")
    @UpdateTimestamp
    private Timestamp lastModified;
    @Column(name="role_id")
    @OneToMany
    @JoinTable(name="employee_roles",
            joinColumns ={@JoinColumn(name="employee_id",referencedColumnName = "id") },
            inverseJoinColumns = {@JoinColumn(name="Roles_id",referencedColumnName = "id")}
    )
    @BatchSize(size=3) // Solves N+1 Problem by using in clause in conidition rather than select statement for each id
    private List<Role> role;

    public Employee() {}
    public Employee(String firstName, String lastName, String phoneNumber, String emailId, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.salary = salary;
    }

    public long getId() {
        return id;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailId='" + emailId + '\'' +
                ", salary=" + salary +
                ", createTime=" + createTime +
                ", lastModified=" + lastModified +
                ", role=" + role +
                '}';
    }
}
