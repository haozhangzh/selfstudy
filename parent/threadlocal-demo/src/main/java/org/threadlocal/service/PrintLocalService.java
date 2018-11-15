package org.threadlocal.service;

import org.threadlocal.util.ThreadLocalUtils;

public class PrintLocalService {

	public void printLocalParam(){
		System.out.println("---PrintLocalService开始执行---");
		System.out.println(ThreadLocalUtils.getLong());
        System.out.println(ThreadLocalUtils.getString());
        System.out.println("---PrintLocalService结束执行---");
	}
}
