package edu.mum.food.controller;

import edu.mum.food.model.RegisterModel;

public class RegisterController {
	
	RegisterModel register = new RegisterModel();

	public RegisterModel getRegister() {
		return register;
	}

	public void setRegister(RegisterModel register) {
		this.register = register;
	}
	
	

}
