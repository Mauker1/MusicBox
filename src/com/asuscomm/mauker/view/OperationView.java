package com.asuscomm.mauker.view;

import com.asuscomm.mauker.control.OperationControlInterface;
import com.asuscomm.mauker.model.MusicBoxModelInterface;

public class OperationView {

	private OperationControlInterface control;
	private MusicBoxModelInterface model;
	
	public OperationView(OperationControlInterface control, MusicBoxModelInterface model){
		this.control = control;
		this.model = model;
	}
	
	public void createView(){
		
	}
	
	public void showGUI(){
		
	}
}
