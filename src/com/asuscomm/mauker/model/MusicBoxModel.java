package com.asuscomm.mauker.model;

public class MusicBoxModel implements MusicBoxModelInterface {

	private int totalMoney;
	private int _25CentsInserted;
	private int _50CentsInserted;
	private int _1RealInserted;
	private int _2ReaisInserted;
	private int _5ReaisInserted;
	private int _10ReaisInserted;
	
	private boolean hasMoney;
	
	public MusicBoxModel(){
		reset();
	}

	@Override
	public void insert25Cents() {
		totalMoney += 25;
		_25CentsInserted++;
		
	}

	@Override
	public void insert50Cents() {
		totalMoney += 50;
		_50CentsInserted++;
	}

	@Override
	public void insert1Real() {
		totalMoney += 100;
		_1RealInserted++;
		
	}

	@Override
	public void insert2Reais() {
		totalMoney += 200;
		_2ReaisInserted++;
		
	}

	@Override
	public void insert5Reais() {
		totalMoney += 500;
		_5ReaisInserted++;
		
	}

	@Override
	public void insert10Reais() {
		totalMoney += 1000;
		_10ReaisInserted++;
		
	}

	@Override
	public void reset() {
		totalMoney = 0;
		_25CentsInserted = 0;
		_50CentsInserted = 0;
		_1RealInserted = 0;
		_2ReaisInserted = 0;
		_5ReaisInserted = 0;
		_10ReaisInserted = 0;
		
	}

	@Override
	public int getTotalAmount() {
		return totalMoney;
	}

	@Override
	public int getTotal25Cents() {
		return _25CentsInserted;
	}

	@Override
	public int getTotal50Cents() {
		return _50CentsInserted;
	}

	@Override
	public int getTotal1Real() {
		return _1RealInserted;
	}

	@Override
	public int getTotal2Reais() {
		return _2ReaisInserted;
	}

	@Override
	public int getTotal5Reais() {
		return _5ReaisInserted;
	}

	@Override
	public int getTotal10Reais() {
		return _10ReaisInserted;
	}
	
}
