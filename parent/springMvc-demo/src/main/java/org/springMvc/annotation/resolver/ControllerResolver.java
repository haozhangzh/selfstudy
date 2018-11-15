package org.springMvc.annotation.resolver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import org.springMvc.annotation.SelfController;
import org.springMvc.model.handler.BeanMapping;
import org.springMvc.model.view.Model;
import org.springMvc.propInit.PropInit;
import org.springMvc.service.DemoService;

public class ControllerResolver extends AbstractResolver{

	@Override
	public Class getResolverType() {
		return SelfController.class;
	}

}
