package org.springMvc.model.handler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HandlerMapping {

	public static final Map<String,RequestInfo> handlerMapping = new ConcurrentHashMap<String,RequestInfo>();
	
	public void put(String className,RequestInfo controller){
		handlerMapping.put(className, controller);
	}
	
	public RequestInfo getHandler(String className){
		return handlerMapping.get(className);
	}
	
	public boolean exists(String className){
		
		return handlerMapping.containsKey(className);
	}
	
}
