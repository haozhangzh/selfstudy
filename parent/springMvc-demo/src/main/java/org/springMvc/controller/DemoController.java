package org.springMvc.controller;

import org.springMvc.annotation.SelfAutowired;
import org.springMvc.annotation.SelfController;
import org.springMvc.annotation.SelfRequestMapping;
import org.springMvc.model.view.Model;
import org.springMvc.service.DemoService;

@SelfController
@SelfRequestMapping(value="/demoController")
public class DemoController {

	@SelfAutowired
	private DemoService demoService;
	
	@SelfRequestMapping(value="/helloWorld")
	public String helloWorld(Model model){
		
		model.put("result",demoService.helloWorld());
		
		return "demo/result";
	}
	
}
