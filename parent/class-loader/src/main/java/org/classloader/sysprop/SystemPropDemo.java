package org.classloader.sysprop;

import java.util.Enumeration;
import java.util.Properties;

public class SystemPropDemo {

	public SystemPropDemo(){
		System.out.println("SystemPropDemo in classPath was loaded");
	}
	public static void main(String[] args) {
		Properties prop = System.getProperties();
		Enumeration<?> enums = prop.propertyNames();
		for(;enums.hasMoreElements();){
			Object ele = enums.nextElement();
			System.out.println(ele+" : "+ prop.getProperty((String) ele));
		}

	}

}
