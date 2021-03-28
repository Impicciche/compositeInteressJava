package com.calcolo.interesse.composto.controller;



import java.util.ArrayList;

import com.calcolo.interesse.composto.model.CalcoloInteresseCompostoModel;
import com.calcolo.interesse.composto.validator.ValidatorField;
import com.calcolo.interesse.composto.view.CalcoloInteresseCompostoView;

public class CalcoloInteresseCompostoController {
	private CalcoloInteresseCompostoModel model;
	private CalcoloInteresseCompostoView view;
	private ArrayList<ValidatorField> fieldsValidation;
	
	public CalcoloInteresseCompostoController(CalcoloInteresseCompostoModel model, 
			CalcoloInteresseCompostoView view) {
		this.model = model;
		this.view = view;
		
		this.view.getCalcolaBtn().addActionListener(e -> {
				CalcoloInteresseCompostoController parent = CalcoloInteresseCompostoController.this;
				
				if(validData()) {
					parent.model.setAggiunteMensili(parent.view.getAggiunteMensili())
					.setCapitaleIniziale(parent.view.getCapitaleIniziale())
					.setAnni(parent.view.getAnni())
					.setInteresse(parent.view.getInteresseMedio());
					
					parent.view.setCapitaleFinale(parent.model.calcolaCapitale());
					
				}
			}
			
		);
		
		fieldsValidation = new ArrayList<ValidatorField>();
		
		String msgError = "Inserisci un valore valido";
		
		fieldsValidation.add(new ValidatorField("[0-9]+", this.view.getTextFieldAnni(),
								this.view.getLabelErrorAnni(), msgError));
		fieldsValidation.add(new ValidatorField("[0-9]+((,|.)[0-9]+)?", this.view.getTextFieldAggiunteMensili(),
				this.view.getLabelErrorAggiunteMensili(), msgError));
		fieldsValidation.add(new ValidatorField("[0-9]+((,|.)[0-9]+)?", this.view.getTextFieldCapitaleIniziale(),
				this.view.getLabelErrorCapitaleIniziale(), msgError));
		
	}
	
	private boolean validData() {
		boolean result = true;
		for(ValidatorField field : fieldsValidation) {
			if(field.validate()) {
				field.resetErrorMsg();
			}
			else {
				field.getError().setText(field.getErrorMsg());
				result = false;
			}
		}
		return result;
	}
}
