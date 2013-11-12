package com.asuscomm.mauker.exceptions;

public class NoChangeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3911160995886692165L;
	
	public NoChangeException(String message){
		super("A máquina está sem troco! " + message);
	}

}
