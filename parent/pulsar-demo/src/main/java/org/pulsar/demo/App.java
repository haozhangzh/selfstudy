package org.pulsar.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// mapTest();
    	for(int i=1;i<4;i++)
    	   mapTestWithSize(1000000);
    	System.out.println("-----------------");
    	for(int i=1;i<4;i++)
     	   mapTest(1000000);
    	System.out.println("-----------------");
    	for(int i=1;i<4;i++)
    	  treeMapTest(1000000);
    }
    
    public static void  mapTest(int loopCount){
    	long start = System.currentTimeMillis();
    	Map<Integer,Object> map = new HashMap<Integer,Object>();
        for(int i=0;i<loopCount;i++){
        	map.put(i, i);
        }
        System.out.println(System.currentTimeMillis()-start);
    }
    public static void  mapTestWithSize(int loopCount){
    	long start = System.currentTimeMillis();
    	Map<Integer,Object> map = new HashMap<Integer,Object>(loopCount);
        for(int i=0;i<loopCount;i++){
        	map.put(i, i);
        }
        System.out.println(System.currentTimeMillis()-start);
    }
    
    public static void treeMapTest(int loopCount){
    	long start = System.currentTimeMillis();
    	Map<Integer,Object> map = new TreeMap<Integer,Object>();
        for(int i=0;i<loopCount;i++){
        	map.put(i, i);
        }
        System.out.println(System.currentTimeMillis()-start);
    }
}
