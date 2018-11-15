package org.threadlocal.util;

public class ThreadLocalUtils {
	static ThreadLocal<Long> longLocal = new ThreadLocal<Long>(){
		protected Long initialValue() {
	        return Long.valueOf(this.hashCode());
	    }
	};
	static ThreadLocal<String> stringLocal = new ThreadLocal<String>(){
		protected String initialValue() {
	        return String.valueOf(this.hashCode());
	    }
	};
	public static void set(){
		 longLocal.set(Thread.currentThread().getId());
		 stringLocal.set(Thread.currentThread().getName());
	 }
	 public static Long getLong(){
		 return longLocal.get();
	 }
	 public static  String getString(){
		 return stringLocal.get();
	 }
}
