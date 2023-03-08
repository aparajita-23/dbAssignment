package com.sample.exception;

public class InvalidTradeException extends Exception{
	
	/**
	 * Custom Exception class for Invalid Trade
	 */
	private static final long serialVersionUID = 1L;

	public InvalidTradeException(String ex) {
		super(ex);
		System.out.println("Exception Occured - Invalid Trade!");
	}
	
	public InvalidTradeException(Exception e, String description) {
		System.out.println("Exception Occured - Invalid Trade:"+description+" - "+e.getMessage());
	}
	
}
