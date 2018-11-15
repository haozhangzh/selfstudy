package org.springMvc.annotation.resolver;

import org.springMvc.annotation.SelfService;
public class ServiceResolver extends AbstractResolver {

	@Override
	public Class getResolverType() {
		return SelfService.class;
	}


}
