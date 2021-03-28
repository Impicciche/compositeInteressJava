package com.calcolo.interesse.composto.view;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;





public class CalcoloInteresseCompostoView extends JFrame implements ChangeListener{
	private static final long serialVersionUID = 1L;
	private final int percentualeInteresseInziale = 7;
	private JPanel panel;
	
	private JLabel labelAnni;
	private JLabel labelInteresse;
	private JLabel labelCapitaleIniziale;
	private JLabel labelAggiunteMensili;
	private JLabel labelCapitaleFinale;
	
	
	private JLabel labelErrorAnni;
	private JLabel labelErrorInteresse;
	private JLabel labelErrorCapitaleIniziale;
	private JLabel labelErrorAggiunteMensili;
	
	private JTextField textFieldAnni;
	private JTextField textFieldAggiunteMensili;
	private JTextField textFieldCapitaleIniziale;
	private JSlider progressInteresse;
	
	private JButton calcola;
	
	
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public int getPercentualeInteresseInziale() {
		return percentualeInteresseInziale;
	}



	public JPanel getPanel() {
		return panel;
	}



	public JLabel getLabelAnni() {
		return labelAnni;
	}



	public JLabel getLabelInteresse() {
		return labelInteresse;
	}



	public JLabel getLabelCapitaleIniziale() {
		return labelCapitaleIniziale;
	}



	public JLabel getLabelAggiunteMensili() {
		return labelAggiunteMensili;
	}



	public JLabel getLabelCapitaleFinale() {
		return labelCapitaleFinale;
	}



	public JTextField getTextFieldAnni() {
		return textFieldAnni;
	}



	public JTextField getTextFieldAggiunteMensili() {
		return textFieldAggiunteMensili;
	}



	public JTextField getTextFieldCapitaleIniziale() {
		return textFieldCapitaleIniziale;
	}



	public JSlider getProgressInteresse() {
		return progressInteresse;
	}



	public JButton getCalcola() {
		return calcola;
	}



	public void setTextFieldAnni(JTextField textFieldAnni) {
		this.textFieldAnni = textFieldAnni;
	}



	public void setTextFieldAggiunteMensili(JTextField textFieldAggiunteMensili) {
		this.textFieldAggiunteMensili = textFieldAggiunteMensili;
	}



	public void setTextFieldCapitaleIniziale(JTextField textFieldCapitaleIniziale) {
		this.textFieldCapitaleIniziale = textFieldCapitaleIniziale;
	}



	public void setProgressInteresse(JSlider progressInteresse) {
		this.progressInteresse = progressInteresse;
	}



	public CalcoloInteresseCompostoView() {
		super("Calcolo Interesse Composto");
		
		
		ImageIcon img = new ImageIcon("resources/images/bank.png");
		
		this.setIconImage(img.getImage());
		
		panel = new JPanel();
		labelAnni = new JLabel("Anni investimento");
		labelCapitaleIniziale = new JLabel("Capitale iniziale");
		labelAggiunteMensili = new JLabel("Aggiunte Mensili");
		labelInteresse = new JLabel(String.format("Percentuale d'investimento medio annuo %s %%",this.percentualeInteresseInziale));
		
		labelErrorAnni = new JLabel("");
		labelErrorCapitaleIniziale = new JLabel("");
		labelErrorAggiunteMensili = new JLabel("");
		labelErrorInteresse = new JLabel("");
		
		labelCapitaleFinale = new JLabel();
		
		textFieldAnni = new JTextField("10");
		textFieldAggiunteMensili = new JTextField("0");
		textFieldCapitaleIniziale= new JTextField("0");
		progressInteresse = new JSlider(JSlider.HORIZONTAL,0,100,this.percentualeInteresseInziale);
		
		calcola = new JButton("Calcola");
		
		labelCapitaleFinale.setVisible(false);
		
		
		textFieldAnni.setText("10");
		textFieldCapitaleIniziale.setText("0");
		progressInteresse.setValue(7);
		
		progressInteresse.addChangeListener(this);
		
		
		
		
		panel.add(labelAnni);
		panel.add(textFieldAnni);
		panel.add(labelErrorAnni);
		
		
		panel.add(labelCapitaleIniziale);
		panel.add(textFieldCapitaleIniziale);
		panel.add(labelErrorCapitaleIniziale);
		
		
		panel.add(labelAggiunteMensili);
		panel.add(textFieldAggiunteMensili);
		panel.add(labelErrorAggiunteMensili);
		
		
		panel.add(labelInteresse);
		panel.add(progressInteresse);
		panel.add(labelErrorInteresse);
		
		
		panel.add(calcola);
		
		panel.add(labelCapitaleFinale);
		
		panel.setLayout(new GridLayout(14,1));
		
		panel.setBorder(new EmptyBorder(10,10,10,10));
		
		this.add(panel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(400,450);
		this.setVisible(true);
	}



	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource()==this.progressInteresse) {
			this.labelInteresse.setText(
					String.format("Percentuale d'investimento medio annuo %s %%",this.progressInteresse.getValue())
					);
		}
		
	}
	
	public double getInteresseMedio() {
		return this.progressInteresse.getValue();
	}
	
	public double getCapitaleIniziale() {
		return Double.parseDouble(this.textFieldCapitaleIniziale.getText().replace(",","."));
	}
	
	public double getAggiunteMensili() {
		return Double.parseDouble(this.textFieldAggiunteMensili.getText().replace(",","."));
	}
	
	public int getAnni() {
		return Integer.parseInt(this.textFieldAnni.getText());
	}

	public JButton getCalcolaBtn() {
		return this.calcola;
	}
	
	public void setCapitaleFinale(double capitale) {
		this.labelCapitaleFinale.setVisible(true);
		this.labelCapitaleFinale.setText(String.format("Capitale finale %.2f €",capitale));
	}



	public JLabel getLabelErrorAnni() {
		return labelErrorAnni;
	}



	public void setLabelErrorAnni(JLabel labelErrorAnni) {
		this.labelErrorAnni = labelErrorAnni;
	}



	public JLabel getLabelErrorInteresse() {
		return labelErrorInteresse;
	}



	public void setLabelErrorInteresse(JLabel labelErrorInteresse) {
		this.labelErrorInteresse = labelErrorInteresse;
	}



	public JLabel getLabelErrorCapitaleIniziale() {
		return labelErrorCapitaleIniziale;
	}



	public void setLabelErrorCapitaleIniziale(JLabel labelErrorCapitaleIniziale) {
		this.labelErrorCapitaleIniziale = labelErrorCapitaleIniziale;
	}



	public JLabel getLabelErrorAggiunteMensili() {
		return labelErrorAggiunteMensili;
	}



	public void setLabelErrorAggiunteMensili(JLabel labelErrorAggiunteMensili) {
		this.labelErrorAggiunteMensili = labelErrorAggiunteMensili;
	}

}
