package springboot.service;

import springboot.entity.Student;

import java.util.List;

public interface StudentServiceI {
    public List<Student> findAll() ;
    public Student find(long id);
    public Student persist(Student employee);
    public boolean delete(long id);
    public List<Student> findByGrade(Double grade);
}
