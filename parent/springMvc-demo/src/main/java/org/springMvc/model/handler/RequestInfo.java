package org.springMvc.model.handler;

import java.util.HashSet;
import java.util.Set;

public class RequestInfo {

	private final Set<String> httpMethods = new HashSet<String>();
	
	private String className;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public  Set<String> getHttpmethods() {
		return httpMethods;
	}
	
	public void addHttpMethods(String httpMethod){
		this.httpMethods.add(httpMethod);
		
	}
	
	public boolean acceptHttpMethod(String httpMethod){
		if(httpMethods.size()==0){
			return true;
		}else{
			return httpMethod.contains(httpMethod);
		}
	}
}
