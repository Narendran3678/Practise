package com.hibernate;

import com.dao.mappings.InstructorDao;
import com.entity.Instructor;
import com.entity.InstructorDetail;

public class InstructorClient {
	public static void main(String args[]) 
	{
		
		InstructorDetail instructorDetail = new InstructorDetail("narendran3678@gmail.com","7092802533");
		Instructor instructor = new Instructor("Naren",instructorDetail);
		
		InstructorDao.persistInstructor(instructor);
	}
}
