package com.subhav.service;

import com.subhav.bean.WorkFlowBean;

public interface WorkFlowService {
	
	public boolean execute(WorkFlowBean workFlowBean) throws Exception;
	
	default boolean isResponsibleFor(String loaderService) {
		return false;
	}

}
