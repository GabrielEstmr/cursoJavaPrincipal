package com.nelioalves.cursomc.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;
	
	//OBS: nao precisou do import pois está no mesmo pacote/pasta
	private List<FieldMessage> list = new ArrayList<>();
	
	
	//Construtores
	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
		// TODO Auto-generated constructor stub
	}


	//Getters and Setters
	//getError > ai o atributo no JSON fica ERRORS > getList > List e assim por iante ({ "Errors": "exemplo" })
	public List<FieldMessage> getErrors() {
		return list;
	}


	public void addError(String fieldName, String message) {
		list.add(new FieldMessage(fieldName, message));
	}
	
	
	

}
