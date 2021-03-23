package com.calcolo.interesse.composto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.calcolo.interesse.composto.model.CalcoloInteresseCompostoModel;
import com.calcolo.interesse.composto.view.CalcoloInteresseCompostoView;

public class CalcoloInteresseCompostoController {
	private CalcoloInteresseCompostoModel model;
	private CalcoloInteresseCompostoView view;
	
	public CalcoloInteresseCompostoController(CalcoloInteresseCompostoModel model, 
			CalcoloInteresseCompostoView view) {
		this.model = model;
		this.view = view;
		
		this.view.getCalcolaBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CalcoloInteresseCompostoController parent = CalcoloInteresseCompostoController.this;
				
				parent.model.setAggiunteMensili(parent.view.getAggiunteMensili());
				parent.model.setCapitaleIniziale(parent.view.getCapitaleIniziale());
				parent.model.setAnni(parent.view.getAnni());
				parent.model.setInteresse(parent.view.getInteresseMedio());
				
				parent.view.setCapitaleFinale(parent.model.calcolaCapitale());
			}
			
		});
	}
}
