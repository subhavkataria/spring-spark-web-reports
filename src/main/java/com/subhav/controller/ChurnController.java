package com.subhav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subhav.bean.WorkFlowBean;
import com.subhav.service.WorkFlowService;

@RestController
@RequestMapping("/reports/")
public class ChurnController {
	
	@Autowired
	@Qualifier("reports-service")
	private WorkFlowService workFlowService;
	
	@GetMapping("{workflow}")
	public String fetchChurnList(@PathVariable("workflow") String workFlow) {
		try {
			workFlowService.execute(new WorkFlowBean(workFlow,null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Execured";
	}
	

}
