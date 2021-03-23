package com.calcolo.interesse.composto.model;

public class CalcoloInteresseCompostoModel {
	private double interesse;
	private int anni;
	private double capitaleIniziale;
	private double aggiunteMensili;
	
	

	public CalcoloInteresseCompostoModel() {
	}

	public CalcoloInteresseCompostoModel(double interesse, int anni, double capitaleIniziale) {
		this.interesse = interesse;
		this.anni = anni;
		this.capitaleIniziale = capitaleIniziale;
	}
	
	
	public double getAggiunteMensili() {
		return aggiunteMensili;
	}
	
	public void setAggiunteMensili(double aggiunteMensili) {
		this.aggiunteMensili = aggiunteMensili;
	}
	
	public double getInteresse() {
		return interesse;
	}
	public void setInteresse(double interesse) {
		this.interesse = interesse;
	}
	public int getAnni() {
		return anni;
	}
	public void setAnni(int anni) {
		this.anni = anni;
	}
	public double getCapitaleIniziale() {
		return capitaleIniziale;
	}
	public void setCapitaleIniziale(double capitaleIniziale) {
		this.capitaleIniziale = capitaleIniziale;
	}

	public double calcolaCapitale() {
		double capitale = this.capitaleIniziale;
		for(int i = this.anni; i>0; i--) {
			capitale+=12*this.aggiunteMensili;
			capitale += capitale * (this.interesse/100);
		}
		
		return capitale;
	}
	
	
}
