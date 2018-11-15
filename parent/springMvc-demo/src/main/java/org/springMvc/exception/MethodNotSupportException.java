package org.springMvc.exception;

public class MethodNotSupportException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MethodNotSupportException(){
		super();
	}
	
	public MethodNotSupportException(String message){
		super(message);
	}
}
