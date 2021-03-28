package com.calcolo.interesse.composto.validator;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ValidatorField {
	private String regex;
	private JTextField field;
	private JLabel error;
	private String errorMsg;
	
	public ValidatorField(String regex, JTextField field, JLabel error, String errorMsg) {
		super();
		this.regex = regex;
		this.field = field;
		this.error = error;
		this.errorMsg = errorMsg;
	}

	public ValidatorField() {
		super();
	}

	public String getRegex() {
		return regex;
	}

	public ValidatorField setRegex(String regex) {
		this.regex = regex;
		return this;
	}

	public JTextField getField() {
		return field;
	}

	public ValidatorField setField(JTextField field) {
		this.field = field;
		return this;
	}

	public JLabel getError() {
		return error;
	}

	public ValidatorField setError(JLabel error) {
		this.error = error;
		return this;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public ValidatorField setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
		return this;
	}
	
	public boolean validate() {
		if(errorMsg.length()>0 && regex.length()>0 && error != null && field != null) {
			if(field.getText().matches(regex)) {
				return true;
			}
		}
		
		return false;
	}

	public ValidatorField setErrorMsg() {
		error.setText(errorMsg);
		return this;
		
	}
	
	public void resetErrorMsg() {
		error.setText("");
	}
	
}
