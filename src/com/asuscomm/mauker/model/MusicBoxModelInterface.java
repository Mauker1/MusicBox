package com.asuscomm.mauker.model;

public interface MusicBoxModelInterface {

	public void insert25Cents();
	public void insert50Cents();
	public void insert1Real();
	public void insert2Reais();
	public void insert5Reais();
	public void insert10Reais();
	
	public void reset();
	
	public int getTotalAmount();
	
	public int getTotal25Cents();
	public int getTotal50Cents();
	public int getTotal1Real();
	public int getTotal2Reais();
	public int getTotal5Reais();
	public int getTotal10Reais();
	
}
