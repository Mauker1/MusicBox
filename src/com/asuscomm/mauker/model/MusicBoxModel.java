package com.asuscomm.mauker.model;

import java.util.List;
import java.util.Vector;

import com.asuscomm.mauker.data.Musica;
import com.asuscomm.mauker.exceptions.NotEnoughMoneyException;

public class MusicBoxModel implements MusicBoxModelInterface {

	private int totalMoney;
	private int _25CentsInserted;
	private int _50CentsInserted;
	private int _1RealInserted;
	private int _2ReaisInserted;
	private int _5ReaisInserted;
	private int _10ReaisInserted;
	
	private int totalMoneyOnMachine;
	private int _25CentsOnMachine;
	private int _50CentsOnMachine;
	private int _1RealOnMachine;
	private int _2ReaisOnMachine;
	private int _5ReaisOnMachine;
	private int _10ReaisOnMachine;
	
	private int totalChange;
	
	private boolean _hasMoneyInserted;
	
	private List<Musica> musics;
	
	public MusicBoxModel(){
		reset();
	}

	@Override
	public void insert25Cents() {
		totalMoney += 25;
		_25CentsInserted++;
		_hasMoneyInserted = true;
	}

	@Override
	public void insert50Cents() {
		totalMoney += 50;
		_50CentsInserted++;
		_hasMoneyInserted = true;
	}

	@Override
	public void insert1Real() {
		totalMoney += 100;
		_1RealInserted++;
		_hasMoneyInserted = true;
	}

	@Override
	public void insert2Reais() {
		totalMoney += 200;
		_2ReaisInserted++;
		_hasMoneyInserted = true;
		
	}

	@Override
	public void insert5Reais() {
		totalMoney += 500;
		_5ReaisInserted++;
		_hasMoneyInserted = true;
	}

	@Override
	public void insert10Reais() {
		totalMoney += 1000;
		_10ReaisInserted++;
		_hasMoneyInserted = true;
	}
	

	@Override
	public void calculateChange(String music) throws NotEnoughMoneyException {
		// TODO Pegar o valor da musica.
		int musicValue = 0;
		
		totalChange = totalMoney - musicValue;
		
		if (totalChange < 0){
			throw new NotEnoughMoneyException("Favor inserir mais dinheiro."); // Não tem dinheiro o suficiente para tocar a música.
		}
		
		
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
		_hasMoneyInserted = false;
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

	
	@Override
	public int getTotalChange() {
		return totalChange;
	}
	
	@Override
	public boolean hasMoney() {
		return _hasMoneyInserted;
	}
	
	// Valor anteriormente depositado na máquina.

	public int getTotalMoneyOnMachine() {
		return totalMoneyOnMachine;
	}

	public void setTotalMoneyOnMachine(int totalMoneyOnMachine) {
		this.totalMoneyOnMachine = totalMoneyOnMachine;
	}

	
	@Override
	public int get_25CentsOnMachine() {
		return _25CentsOnMachine;
	}
	
	@Override
	public void set_25CentsOnMachine(int _25CentsOnMachine) {
		// TODO: Modificar isso para pegar o valor do banco.
		this._25CentsOnMachine = _25CentsOnMachine;
	}
	
	@Override
	public int get_50CentsOnMachine() {
		return _50CentsOnMachine;
	}

	@Override
	public void set_50CentsOnMachine(int _50CentsOnMachine) {
		this._50CentsOnMachine = _50CentsOnMachine;
	}

	@Override
	public int get_1RealOnMachine() {
		return _1RealOnMachine;
	}

	@Override
	public void set_1RealOnMachine(int _1RealOnMachine) {
		this._1RealOnMachine = _1RealOnMachine;
	}

	@Override
	public int get_2ReaisOnMachine() {
		return _2ReaisOnMachine;
	}

	@Override
	public void set_2ReaisOnMachine(int _2ReaisOnMachine) {
		this._2ReaisOnMachine = _2ReaisOnMachine;
	}

	@Override
	public int get_5ReaisOnMachine() {
		return _5ReaisOnMachine;
	}

	@Override
	public void set_5ReaisOnMachine(int _5ReaisOnMachine) {
		this._5ReaisOnMachine = _5ReaisOnMachine;
	}

	@Override
	public int get_10ReaisOnMachine() {
		return _10ReaisOnMachine;
	}

	@Override
	public void set_10ReaisOnMachine(int _10ReaisOnMachine) {
		this._10ReaisOnMachine = _10ReaisOnMachine;
	}

	@Override
	public Object[] getMusicsTree() {
		Vector<Object[]> tree;
		
		// TODO
		
		return null;
	}
} // Fim da classe.
