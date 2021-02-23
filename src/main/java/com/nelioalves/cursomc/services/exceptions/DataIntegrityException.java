package com.nelioalves.cursomc.services.exceptions;

public class DataIntegrityException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DataIntegrityException(String msg) {
		super(msg);//chamando superclasse (RuntimeException nesse caso)
	}

	public DataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
