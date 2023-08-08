package com.hibernate;

import com.dao.StudentDao;
import com.entity.Student;

public class StudentClient {
	public static void main(String[] args) {
		
		StudentDao studentDao = new StudentDao();
		//Student student = new Student("John", "Wick", "johnwick@javaguides.com");
		//studentDao.saveStudent(student);
		//studentDao.getStudents();
		
		
		//studentDao.saveJPAStudent(new Student("John", "Wick", "johnwick@javaguides.com"));
		//studentDao.saveJPAStudent(new Student("Bill", "Board", "Bill@javaguides.com"));
		//studentDao.getJPAStudents();
		studentDao.getJPAStudent(1L);
		//Student student1  = studentDao.getStudent(5L);
		//studentDao.deleteStudent(4L);
		//student1.setGrade(3);
		//studentDao.mergeStudent(student1);
		
	}
}
