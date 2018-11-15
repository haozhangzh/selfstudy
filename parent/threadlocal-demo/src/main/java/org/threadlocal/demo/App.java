package org.threadlocal.demo;

import org.threadlocal.service.PrintLocalService;
import org.threadlocal.util.ThreadLocalUtils;

/**
 * Hello world!
 *
 */
public class App 
{
	 
	 
    public static void main( String[] args ) throws InterruptedException
    {
    	PrintLocalService pls = new PrintLocalService();
    	ThreadLocalUtils.set();
    	System.out.println(ThreadLocalUtils.getLong());
        System.out.println(ThreadLocalUtils.getString());
        pls.printLocalParam();
        Thread t1 = new Thread(){
        	public void run(){
        		//ThreadLocalUtils.set();
        		// 517137758
        		System.out.println(ThreadLocalUtils.getString());
        		// 667979297
        		System.out.println(ThreadLocalUtils.getLong());
        		PrintLocalService pls1 = new PrintLocalService();
        		pls1.printLocalParam();
        	}
        };
        t1.start();
        t1.join();
        
        System.out.println(ThreadLocalUtils.getLong());
        System.out.println(ThreadLocalUtils.getString());
        System.out.println(517137758 & 15);
        System.out.println(667979297 & 15);
    }
}
