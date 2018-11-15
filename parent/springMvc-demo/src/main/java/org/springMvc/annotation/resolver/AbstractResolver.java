package org.springMvc.annotation.resolver;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.springMvc.model.handler.BeanMapping;

public abstract class AbstractResolver implements IResolver {

	private Set<String> resolvedClassPathSet = new HashSet<String>();
	protected Set<String> classSet = new HashSet<String>();
	public void process(String classPath,BeanMapping beanMapping) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		if(!contaninsClassPath(classPath)){
			this.listClass(classPath);
		}
		resolve(beanMapping);
	}
	private boolean contaninsClassPath(String classPath){
		if(resolvedClassPathSet.size()==0){
			resolvedClassPathSet.add(classPath);
			return false;
		}else{
			for(String str:resolvedClassPathSet){
				if(classPath.contains(str)){
					return true;
				}
			}
			resolvedClassPathSet.add(classPath);
			return false;
		}
	}
	private void listClass(String classPath){
		if(classPath==null || "".equals(classPath)){
			return;
		}
		File file = new File(System.getProperty("user.dir")+"/target/classes/"+classPath.replace(".", System.getProperty("file.separator")));
		if(file.isDirectory()){
			
			File[] files = file.listFiles();
			for(File tempFile:files){
				if(tempFile.isFile() && tempFile.getAbsolutePath().endsWith(".class")){
					classSet.add(classPath+"."+tempFile.getName().replace(".class", ""));
				}else if(tempFile.isDirectory()){
					listClass(classPath+"."+tempFile.getName());
				}
			}
		}else if(file.isFile()  && file.getAbsolutePath().endsWith(".class")){
			classSet.add(classPath+"."+file.getName().replace(".class", ""));
			
		}
	}
	public void resolve(BeanMapping beanMapping) throws ClassNotFoundException,InstantiationException, IllegalAccessException{
		if(classSet.size()>0){
			for(String className:classSet){
				Class clasz = Class.forName(className);
				if(clasz.isAnnotationPresent(this.getResolverType())){
					beanMapping.put(className, clasz.newInstance());
				}
			}
		}
	}

}
