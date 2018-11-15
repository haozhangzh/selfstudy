package org.classloader;

import org.classloader.demo.MyClassLoader;

/**
 * Hello world!
 *
 */
public class App 
{
	public App(){
		System.out.println("App in target is loaded");
	}
    public static void main( String[] args ) throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {   // 一种情况，直接读取class文件，从jar包中读取呢
        MyClassLoader loader = new MyClassLoader("/Users/user/Desktop");
        //Class c = Class.forName("org.classloader.sysprop.SystemPropDemo", true, loader);
        Class c = loader.loadPathClass("org.classloader.sysprop.SystemPropDemo");
        Object obj = c.newInstance();
        System.out.println(obj.getClass().getClassLoader());
    }
}
