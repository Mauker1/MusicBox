package com.asuscomm.mauker;

import com.asuscomm.mauker.control.OperationControl;
import com.asuscomm.mauker.control.OperationControlInterface;
import com.asuscomm.mauker.model.MusicBoxModel;
import com.asuscomm.mauker.model.MusicBoxModelInterface;



public class Main {
	
	public static void main(String args[]){
		MusicBoxModelInterface model = new MusicBoxModel();
		
		
		OperationControlInterface control = new OperationControl(model);
		control.init();
	}
}
