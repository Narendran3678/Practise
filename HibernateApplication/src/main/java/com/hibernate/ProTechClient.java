package com.hibernate;

import com.mapping.manytomany.Project;
import com.mapping.manytomany.ProjectTechDao;
import com.mapping.manytomany.Technology;

public class ProTechClient {
	public static void main(String args[])
	{
		//persistProjectData();
		persistTechData();
	}
	public static void persistProjectData()
	{
		/*
		Project project = new Project("Cafe","Aman Pratik");
		project.getTechList().add(new Technology("Java","1.8"));
		project.getTechList().add(new Technology("Esper Enginer","2.1"));
		
		ProjectTechDao.persistDirector(project);*/
		
		Technology tech1 = new Technology("Java","1.8");
		Technology tech2 = new Technology("Esper Enginer","2.1");
		Technology tech3 = new Technology("Oracle","21C");
		
		Project project = new Project("Cafe","Aman Pratik");
		Project project1 = new Project("Captcha","Ankita");
		Project project2 = new Project("DSAS","Sudarshan");
		
		project.getTechList().add(tech1);
		project.getTechList().add(tech2);
		project.getTechList().add(tech3);
		
		project1.getTechList().add(tech1);
		project1.getTechList().add(tech3);
		
		project2.getTechList().add(tech2);
		project2.getTechList().add(tech3);
		
		ProjectTechDao.persistDirector(project);
		ProjectTechDao.persistDirector(project1);
		ProjectTechDao.persistDirector(project2);
		
		ProjectTechDao.commitTransaction();
		ProjectTechDao.closeSession();
	}
	public static void persistTechData()
	{
		Technology tech1 = new Technology("Java","1.8");
		Technology tech2 = new Technology("Esper Enginer","2.1");
		Technology tech3 = new Technology("Oracle","21C");
		
		Project project = new Project("Cafe","Aman Pratik");
		Project project1 = new Project("Captcha","Ankita");
		Project project2 = new Project("DSAS","Sudarshan");
		
		project.getTechList().add(tech1);
		project.getTechList().add(tech2);
		project.getTechList().add(tech3);
		
		project1.getTechList().add(tech1);
		project1.getTechList().add(tech3);
		
		project2.getTechList().add(tech2);
		project2.getTechList().add(tech3);
		
		tech1.getProjectList().add(project);
		tech1.getProjectList().add(project1);
		
		tech2.getProjectList().add(project);
		tech2.getProjectList().add(project2);
		
		tech3.getProjectList().add(project);
		tech3.getProjectList().add(project1);
		tech3.getProjectList().add(project2);
		
		ProjectTechDao.persistDirector(tech1);
		ProjectTechDao.persistDirector(tech2);
		ProjectTechDao.persistDirector(tech3);
		
		ProjectTechDao.commitTransaction();
		ProjectTechDao.closeSession();
	}
}
