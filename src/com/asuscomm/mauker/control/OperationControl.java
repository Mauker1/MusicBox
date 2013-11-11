package com.asuscomm.mauker.control;

import javax.swing.SwingUtilities;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertCash(int value) {
		// TODO Auto-generated method stub
		
	}
}
