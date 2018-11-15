package org.springMvc.service.impl;

import org.springMvc.annotation.SelfService;
import org.springMvc.service.DemoService;

@SelfService
public class DemoServiceImpl implements DemoService {

	@Override
	public String helloWorld() {
		
		return "helloWorld";
	}

}
