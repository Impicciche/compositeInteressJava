package com.calcolo.interesse.composto.model;

public class CalcoloInteresseCompostoModel {
	private double interesse;
	private int anni;
	private double capitaleIniziale;
	private double aggiunteMensili;
	
	

	public CalcoloInteresseCompostoModel() {
	}

	public CalcoloInteresseCompostoModel(double interesse, int anni, double capitaleIniziale,double aggiunteMensili) {
		this.interesse = interesse;
		this.anni = anni;
		this.capitaleIniziale = capitaleIniziale;
		this.aggiunteMensili = aggiunteMensili;
	}
	
	
	public double getAggiunteMensili() {
		return aggiunteMensili;
	}
	
	public CalcoloInteresseCompostoModel setAggiunteMensili(double aggiunteMensili) {
		this.aggiunteMensili = aggiunteMensili;
		return this;
	}
	
	public double getInteresse() {
		return interesse;
	}
	public CalcoloInteresseCompostoModel setInteresse(double interesse) {
		this.interesse = interesse;
		return this;
	}
	public int getAnni() {
		return anni;
	}
	public CalcoloInteresseCompostoModel setAnni(int anni) {
		this.anni = anni;
		return this;
	}
	public double getCapitaleIniziale() {
		return capitaleIniziale;
	}
	public CalcoloInteresseCompostoModel setCapitaleIniziale(double capitaleIniziale) {
		this.capitaleIniziale = capitaleIniziale;
		return this;
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
