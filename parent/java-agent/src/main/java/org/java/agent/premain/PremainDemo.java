package org.java.agent.premain;

import java.lang.instrument.Instrumentation;

import org.java.agent.demo.FirstAgent;

public class PremainDemo {

	public static void premain(String agentOps,Instrumentation inst){
		System.out.println("执行premain");
		System.out.println(agentOps);
		inst.addTransformer(new FirstAgent());
		inst.getInitiatedClasses(Thread.currentThread().getContextClassLoader());
	}
}
