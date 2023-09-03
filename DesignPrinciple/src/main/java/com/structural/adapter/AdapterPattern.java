package com.structural.adapter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum INSURANCE_COMPANY {
	LIC, HDFC, MAX
}

abstract class InsuranceI {
	public String getInsuranceName() {
		return "";
	}	
	public double getInsuranceCost() {
		return 0;
	}
	public Set<String> getIllnessCoverage() {
		return null;
	}
	public boolean isFamilyCoverage() {
		return false;
	}
	public double getTermInsuranceReturn() {
		return 0;
	}
}

class LifeInsuranceCorparation extends InsuranceI {

	protected String insuranceName = "";
	protected double insuranceCost = 0;
	protected boolean familyCoverage = false;
	
	
	@Override
	public String getInsuranceName() {
		insuranceName = "LIC";
		return insuranceName;
	}	
	@Override
	public double getInsuranceCost() {
		insuranceCost = 5_00_000;
		return insuranceCost;
	}
	@Override
	public boolean isFamilyCoverage() {
		familyCoverage = false;
		return familyCoverage;
	}
	@Override
	public String toString() {
		return "LifeInsuranceCorparation [insuranceName=" + insuranceName + ", insuranceCost=" + insuranceCost
				+ ", familyCoverage=" + familyCoverage + "]";
	}

}

class HDFCLifeInsurance extends InsuranceI {

	protected String insuranceName = "";
	protected double insuranceCost = 0;
	protected Set<String> illnessCoverage = null;
	
	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}
	public void setInsuranceCost(double insuranceCost) {
		this.insuranceCost = insuranceCost;
	}
	public void setIllnessCoverage(Set<String> illnessCoverage) {
		this.illnessCoverage = illnessCoverage;
	}
	
	@Override
	public String getInsuranceName() {
		insuranceName = "HDFC";
		return insuranceName;
	}
	@Override
	public double getInsuranceCost() {
		insuranceCost = 10_00_000;
		return insuranceCost;
	}
	@Override
	public Set<String> getIllnessCoverage() {
		illnessCoverage = Stream.of("Heart", "Fracture", "Diabetes").collect(Collectors.toCollection(HashSet::new));
		return illnessCoverage;
	}

	public String toString() {
		return "HDFCLifeInsurance [insuranceName=" + insuranceName + ", insuranceCost=" + insuranceCost
				+ ", illnessCoverage=" + illnessCoverage + "]";
	}

}

class MaxLifeInsurance extends InsuranceI {
	protected String insuranceName = "";
	protected double insuranceCost = 0;
	protected Set<String> illnessCoverage = null;
	protected boolean familyCoverage = false;
	protected double termInsuranceReturn =0;

	
	@Override
	public String getInsuranceName() {
		insuranceName = "MAX";
		return insuranceName;
	}
	@Override
	public double getInsuranceCost() {
		insuranceCost = 7_00_000;
		return insuranceCost;
	}
	@Override
	public Set<String> getIllnessCoverage() {
		illnessCoverage = Stream.of("Heart", "Accident", "Thyroid", "Cancer")
				.collect(Collectors.toCollection(HashSet::new));
		return illnessCoverage;
	}
	@Override
	public boolean isFamilyCoverage() {
		familyCoverage = true;
		return familyCoverage;
	}
	@Override
	public double getTermInsuranceReturn() {
		termInsuranceReturn = 1_00_000;
		return termInsuranceReturn;
	}

	@Override
	public String toString() {
		return "MaxLifeInsurance [insuranceName=" + insuranceName + ", insuranceCost=" + insuranceCost
				+ ", illnessCoverage=" + illnessCoverage + ", familyCoverage=" + familyCoverage
				+ ", termInsuranceReturn=" + termInsuranceReturn + "]";
	}
	
}

class InsuranceAdapter {
	protected String corporation_name;
	protected double policy_cost = 0;
	protected Set<String> illness_Covered;
	protected boolean family_coverage;
	protected double term_insurance_return;
	protected InsuranceI insuranceI;
	
	public InsuranceAdapter(InsuranceI insurance)
	{
		this.insuranceI = insurance;
		this.corporation_name =insuranceI.getInsuranceName();
		this.policy_cost = insuranceI.getInsuranceCost();
		this.illness_Covered =  insuranceI.getIllnessCoverage();
		this.family_coverage = insuranceI.isFamilyCoverage();
		this.term_insurance_return = insurance.getTermInsuranceReturn();
	}

	@Override
	public String toString() {
		return "InsuranceAdapter [corporation_name=" + corporation_name + ", policy_cost=" + policy_cost
				+ ", illness_Covered=" + illness_Covered + ", family_coverage=" + family_coverage
				+ ", term_insurance_return=" + term_insurance_return + "]";
	}
	
}

class Hospital {
	public static InsuranceAdapter provideInsuranceDetail(INSURANCE_COMPANY ic) {
		InsuranceAdapter insurance = null;
		switch (ic) {
		case LIC:
			insurance = new InsuranceAdapter(new LifeInsuranceCorparation());
			break;
		case HDFC:
			insurance = new InsuranceAdapter(new HDFCLifeInsurance());
			break;
		case MAX:
			insurance = new InsuranceAdapter(new MaxLifeInsurance());
			break;
		default:
			
		}
		return insurance;
	}
}

public class AdapterPattern {
	public static void main(String arg[]) {
		InsuranceAdapter hdfc = Hospital.provideInsuranceDetail(INSURANCE_COMPANY.HDFC);
		InsuranceAdapter lic = Hospital.provideInsuranceDetail(INSURANCE_COMPANY.LIC);
		InsuranceAdapter max = Hospital.provideInsuranceDetail(INSURANCE_COMPANY.MAX);
		
		System.out.println(hdfc);
		System.out.println(lic);
		System.out.println(max);
	}
}
