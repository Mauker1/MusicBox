package com.asuscomm.mauker.model;

import com.asuscomm.mauker.exceptions.NotEnoughMoneyException;

public interface MusicBoxModelInterface {

	public void insert25Cents();
	public void insert50Cents();
	public void insert1Real();
	public void insert2Reais();
	public void insert5Reais();
	public void insert10Reais();
	
	public void calculateChange(String music) throws NotEnoughMoneyException;
	
	public void reset();
	
	public int getTotalAmount();
	
	public int getTotal25Cents();
	public int getTotal50Cents();
	public int getTotal1Real();
	public int getTotal2Reais();
	public int getTotal5Reais();
	public int getTotal10Reais();
	
	public int getTotalChange();
	
	public int get_25CentsOnMachine();
	public void set_25CentsOnMachine(int _25CentsOnMachine);
	public int get_50CentsOnMachine();
	public void set_50CentsOnMachine(int _50CentsOnMachine);
	public int get_1RealOnMachine();
	public void set_1RealOnMachine(int _1RealOnMachine);
	public int get_2ReaisOnMachine();
	public void set_2ReaisOnMachine(int _2ReaisOnMachine);
	public int get_5ReaisOnMachine();
	public void set_5ReaisOnMachine(int _5ReaisOnMachine);
	public int get_10ReaisOnMachine();
	public void set_10ReaisOnMachine(int _10ReaisOnMachine);
	
	public boolean hasMoney();
	
}
