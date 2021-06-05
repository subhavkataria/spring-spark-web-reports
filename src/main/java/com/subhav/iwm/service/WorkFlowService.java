package com.subhav.iwm.service;

public interface WorkFlowService {
	
	public String process();
	
	default boolean isProcessing() {
		return false;
	}

}
