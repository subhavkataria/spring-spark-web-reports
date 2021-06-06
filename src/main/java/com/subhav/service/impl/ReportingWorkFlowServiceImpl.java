package com.subhav.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subhav.bean.WorkFlowBean;
import com.subhav.service.ApiReader;
import com.subhav.service.WorkFlowService;

@Service("reports-service")
public class ReportingWorkFlowServiceImpl implements WorkFlowService{
	
	@Autowired
	private ApiReader apiReader;

	@Override
	public boolean isResponsibleFor(String loaderService) {
		return loaderService.equalsIgnoreCase("CHURN");
	}

	@Override
	public boolean execute(WorkFlowBean workFlowBean) throws Exception {
		apiReader.readSourceFile("src/main/resources/Churn.csv");
		return false;
	}

}
