package com.asuscomm.mauker.control;

import javax.swing.SwingUtilities;

import com.asuscomm.mauker.Definitions;
import com.asuscomm.mauker.model.MusicBoxModelInterface;
import com.asuscomm.mauker.view.OperationView;

public class OperationControl implements OperationControlInterface {
	
	private MusicBoxModelInterface model;
	private OperationView view;
	
	public OperationControl(MusicBoxModelInterface model){
		this.model = model;
		
		view = new OperationView(this,this.model);
	}
	
	@Override
	public void init(){
		view.createView();
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				view.showGUI();
				
			}
		});
	}

	@Override
	public void insertCoin(int value) {
		switch (value){
		case Definitions._25CENTS:
			model.insert25Cents();
			break;
		case Definitions._50CENTS:
			model.insert50Cents();
			break;
		case Definitions._1REAL:
			model.insert1Real();
			break;
		}
		
	}

	@Override
	public void insertCash(int value) {
		switch (value){
		case Definitions._2REAIS:
			model.insert2Reais();
			break;
		case Definitions._5REAIS:
			model.insert5Reais();
			break;		
		case Definitions._10REAIS:
			model.insert10Reais();
			break;
		}
		
	}

	@Override
	public String getTotalMoney() {
		StringBuilder sb = new StringBuilder();
		int reais;
		int centavos;
		int total = 0;
		
		total = model.getTotalAmount();
		
		reais = total / 100;
		centavos = total % 100;
		
		sb.append(reais);	
		sb.append(",");
		
		if (centavos <= 9){
			sb.append("0");
		}
		
		sb.append(centavos);
		
		return sb.toString();
	}

	@Override
	public void doPlay(String music) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetJukebox() {
		model.reset();
	}
}
