package com.entity;
import java.util.*;
public class Jio implements Sim {
	
	private String simType = "3G/4G/5G";
	private String simName = "JIO";
	private Map<String,String> coverageArea = new HashMap<>();
	private String bandwidth = "";
	public Jio() {

	}

	public Jio(String simType, String simName) {
		super();
		this.simType = simType;
		this.simName = simName;
	}

	public Jio(String simType, String simName, Map<String,String> coverageArea) {
		super();
		this.simType = simType;
		this.simName = simName;
		this.coverageArea = coverageArea;
	}

	public String getBandwidth() {
		return bandwidth;
	}

	public void setBandwidth(String bandwidth) {
		this.bandwidth = bandwidth;
	}

	@Override
	public String simType() {
		return simType;
	}

	@Override
	public String simName() {
		return simName;
	}

	public Map<String, String> coverageArea() {
		/*
		Map<String, Set<String>> defcoverageArea = new HashMap<>();
		Set<String> subLoc = new HashSet<>();
		subLoc.add("Chennai");
		subLoc.add("Delhi");
		subLoc.add("Banglore");
		Set<String> subLoc1 = new HashSet<>();
		subLoc1.add("New York");
		subLoc1.add("China Town");
		subLoc1.add("Amsterdam");
		defcoverageArea.put("India", subLoc);
		defcoverageArea.put("America", subLoc1);
		*/
		return coverageArea;
	}
	
}
