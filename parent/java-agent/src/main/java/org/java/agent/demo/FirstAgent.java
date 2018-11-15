package org.java.agent.demo;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class FirstAgent implements ClassFileTransformer {

	public final String injectedClassName="org.agent.demo.App";
	
	public final String methodName = "hello";
	@Override
	public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
			ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
		className = className.replace("/", ".");
		System.out.println("ClassLoader Name:"+loader.getClass().getName());
		System.out.println("transform ClassName:"+className);
		if(className.equals(injectedClassName)){
            CtClass ctclass = null;
            try {
                ctclass = ClassPool.getDefault().get(className);// 使用全称,用于取得字节码类<使用javassist>
                CtMethod ctmethod = ctclass.getDeclaredMethod(methodName);// 得到这方法实例
                ctmethod.insertBefore("System.out.println(\"11111111\");");
                return ctclass.toBytecode();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            
		}
		return null;
	}

}
