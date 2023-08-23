package com.entity;

import java.util.*;

public interface Sim {
	public String simType();
	public String simName();
	public Map<String,String> coverageArea();
	public String getBandwidth();
}