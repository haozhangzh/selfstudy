package org.springMvc.propInit;

import java.lang.reflect.Field;
import java.util.Map;

import org.springMvc.annotation.SelfAutowired;
import org.springMvc.model.handler.BeanMapping;

public class PropInit {

	public static void propLoad(Object obj,BeanMapping beanMapping) throws IllegalArgumentException, IllegalAccessException{
		Field[] fields= obj.getClass().getDeclaredFields();
		if(fields!=null && fields.length>0){
			for(Field field:fields){
				System.out.println("field Type:"+field.getType().getName());
				if(field.isAnnotationPresent(SelfAutowired.class)){
					for(Map.Entry<String, Object> entry:beanMapping.entrySet()){
						System.out.println("bean Mapping key :"+entry.getKey());
						if(field.getType().isAssignableFrom(entry.getValue().getClass())){
							field.setAccessible(true);
							field.set(obj, entry.getValue());
							break;
						}
					}
				}
			}
		}
		
	}
}
