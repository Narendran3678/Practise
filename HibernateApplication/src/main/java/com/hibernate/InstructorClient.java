package com.hibernate;

import com.dao.mappings.InstructorDao;
import com.entity.Instructor;
import com.entity.InstructorDetail;

public class InstructorClient {
	public static void main(String args[]) 
	{
		insertInstructorAndDetail();
		//getInstructorAndDetail();
	}
	public static void insertInstructorAndDetail()
	{
		//Instructor to Instructor_Detail;
		InstructorDetail instructorDetail = new InstructorDetail("narendran3678@gmail.com","7092802533");
		Instructor instructor = new Instructor("Naren",instructorDetail);
		InstructorDao.persistInstructor(instructor);
		
		// Instructor_Detail to Instructor
		instructor = new Instructor("Izoku Midoriya");
		instructorDetail = new InstructorDetail("Midoriya@gmail.com","7093452126",instructor);
		InstructorDao.persistInstructor(instructorDetail);
		
	}
	public static void getInstructorAndDetail()
	{
		System.out.println(InstructorDao.getInstructor(1L)); 
		
	}
}
