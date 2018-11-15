package org.agent.demo;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
    {
		App.sayHi();
    }
    
    public static void hello(){
    	System.out.println( "Hello World!" );
    	
    }
    public static void sayHi(){
      for(int i=0;i<10;i++){
    		try {
    			hello();
    			Thread.currentThread().sleep(2000);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
    }
}
