package com.entity;

import java.util.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Airtel implements Sim {
	private String simType = "3G/4G/5G";
	private String simName = "AIRTEL";
	private Map<String, String> coverageArea = new HashMap<>();
	private String bandwidth = "";
	public Airtel() {

	}
	
	public Airtel(String simType, String simName) {
		super();
		this.simType = simType;
		this.simName = simName;
	}

	public Airtel(String simType, String simName, Map<String,String> coverageArea) {
		super();
		this.simType = simType;
		this.simName = simName;
		this.coverageArea = coverageArea;
	}

	@Override
	public String simType() {
		return simType;
	}

	@Override
	public String simName() {
		return simName;
	}
	public String getBandwidth() {
		return bandwidth;
	}

	public void setBandwidth(String bandwidth) {
		this.bandwidth = bandwidth;
	}
	@PostConstruct
	public void initAnnotationMethod() {
		System.out.println("Airtel Init Annotation Method");
	}
	@PreDestroy
	public void destroyAnnotationMethod()
	{
		System.out.println("Airtel Destroy Annotation Method");
	}
	@Override
	public Map<String, String> coverageArea() {
		/*
		Map<String,Set<String>> defaultCoverageArea = new HashMap<>();
		Set<String> subLoc = new HashSet<>();
		subLoc.add("Chennai");
		subLoc.add("Pondicherry");
		subLoc.add("Mumbai");
		Set<String> subLoc1 = new HashSet<>();
		subLoc1.add("Los Angels");
		subLoc1.add("Atlanta");
		subLoc1.add("Amsterdam");
		defaultCoverageArea.put("India", subLoc);
		defaultCoverageArea.put("America", subLoc1);
		*/
		return coverageArea;
	}
	
}
