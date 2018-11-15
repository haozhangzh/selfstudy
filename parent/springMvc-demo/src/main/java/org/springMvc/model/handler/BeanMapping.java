package org.springMvc.model.handler;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class BeanMapping {
  
	private static final Map<String,Object> beanMapping = new ConcurrentHashMap<String,Object>();
	
	public void put(String className,Object controller){
		beanMapping.put(className, controller);
	}
	
	public Object getHandler(String className){
		return beanMapping.get(className);
	}
	
	public boolean exists(String className){
		
		return beanMapping.containsKey(className);
	}
	
	public Set<Map.Entry<String, Object>> entrySet(){
		return beanMapping.entrySet();
	}
	
}
