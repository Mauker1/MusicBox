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
			
			break;
		case Definitions._50CENTS:
			
			break;
		case Definitions._1REAL:
			
			break;
		}
		
	}

	@Override
	public void insertCash(int value) {
		switch (value){
		case Definitions._2REAIS:
			
			break;
		case Definitions._5REAIS:
			
			break;		
		case Definitions._10REAIS:
			
			break;
		}
		
	}

	@Override
	public String getTotalMoney() {
		StringBuilder sb = new StringBuilder();
		int reais;
		int centavos;
		int total = 0;
		
		// TODO: pegar total do model.
		
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
}
