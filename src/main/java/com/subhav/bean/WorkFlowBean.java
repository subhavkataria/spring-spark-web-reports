package com.subhav.bean;

public class WorkFlowBean {
	
	private String workFlowType;
	private String runDate;
	
	
	
	public WorkFlowBean(String workFlowType, String runDate) {
		super();
		this.workFlowType = workFlowType;
		this.runDate = runDate;
	}
	public String getWorkFlowType() {
		return workFlowType;
	}
	public void setWorkFlowType(String workFlowType) {
		this.workFlowType = workFlowType;
	}
	public String getRunDate() {
		return runDate;
	}
	public void setRunDate(String runDate) {
		this.runDate = runDate;
	}
	
	
	

}
