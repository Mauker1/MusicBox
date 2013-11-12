package com.asuscomm.mauker.exceptions;

public class NotEnoughMoneyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8526133936554259211L;
	
	public NotEnoughMoneyException(String message){
		super ("O valor fornecido é inferior ao preço da música! " + message);
	}

}
