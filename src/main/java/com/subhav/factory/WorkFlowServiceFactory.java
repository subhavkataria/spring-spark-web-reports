package com.subhav.factory;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subhav.service.WorkFlowService;

@Service
public class WorkFlowServiceFactory {
	
	@Autowired
	List<WorkFlowService> serviceList;
	
	public WorkFlowService getService(String loaderService) {
		
		Optional<WorkFlowService> serviceHolder = serviceList.stream().filter(service -> service.isResponsibleFor(loaderService)).findFirst();
		if(serviceHolder.isPresent()) {
			return serviceHolder.get();
		}
		throw new UnsupportedOperationException("Unsupported Loader "+loaderService);
		
	}
	

}
