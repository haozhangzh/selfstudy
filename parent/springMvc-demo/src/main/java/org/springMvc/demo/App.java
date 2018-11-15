package org.springMvc.demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import org.springMvc.annotation.resolver.ControllerResolver;
import org.springMvc.annotation.resolver.ServiceResolver;
import org.springMvc.model.handler.BeanMapping;
import org.springMvc.model.view.Model;
import org.springMvc.propInit.PropInit;

/**
 * controller、Service实例化 自动装配测试
 *
 */
public class App 
{
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("java.class.path"));
		ControllerResolver cr = new ControllerResolver();
		ServiceResolver ser = new ServiceResolver();
		BeanMapping beanMapping = new BeanMapping();
		cr.process("org.springMvc",beanMapping);
		ser.process("org.springMvc", beanMapping);
		Set<Map.Entry<String, Object>> es = beanMapping.entrySet();
		for(Map.Entry<String, Object> entry:es){
			System.out.println(entry.getKey()+","+entry.getValue().getClass().getName());
		}
		Object obj = beanMapping.getHandler("org.springMvc.controller.DemoController");
		Class clasz = Class.forName("org.springMvc.controller.DemoController");
		PropInit.propLoad(obj, beanMapping);
		Method method = clasz.getMethod("helloWorld",Model.class);
		Model model = new Model();
		if(model.isEmpty()){
			System.out.println("model 初始化 没有任何值哟(＾Ｕ＾)ノ~ＹＯ");
		}
		Object result = method.invoke(obj,model);
		System.out.println("Controller的返回视图路径："+result);
		if(!model.isEmpty()){
			System.out.println("model 接收了返回值哟(＾Ｕ＾)ノ~ＹＯ，打印一下：");
			for(String str:model.keySet()){
				System.out.println("key = " + str);
				System.out.println("value = "+model.get(str));
			}
		}
	}
}
