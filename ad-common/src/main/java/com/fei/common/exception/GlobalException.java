package com.fei.common.exception;


import com.fei.common.CodeMsg;

public class GlobalException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private CodeMsg cm ;
	
	public GlobalException(CodeMsg cm) {
		this.cm = cm ; 
	}

	public CodeMsg getCm() {
		return cm;
	}

	public void setCm(CodeMsg cm) {
		this.cm = cm;
	}
	
	
}
