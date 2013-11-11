package com.asuscomm.mauker.control;

public interface OperationControlInterface {

	public void init(); // Initialize and show GUI.
	
	public void insertCoin(int value);
	public void insertCash(int value);
	public void doPlay(String music);
	public void resetJukebox();
	
	public String getTotalMoney();

}
