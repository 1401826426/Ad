package com.fei.common.exception;


import java.util.List;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fei.common.CodeMsg;
import com.fei.common.ResultVO;

@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=Exception.class)
	public ResultVO<String> exceptionHandler(Exception e){
		if(e instanceof BindException){
			BindException bindException = (BindException)e ; 
			List<ObjectError> errors = bindException.getAllErrors() ; 
			String msg = errors.get(0).getDefaultMessage() ; 
			return ResultVO.error(CodeMsg.SERVER_BIND.bindArgs(msg)) ;
 		}else if(e instanceof GlobalException){
 			e.printStackTrace();
 			GlobalException globalException = (GlobalException)e ; 
 			return ResultVO.error(globalException.getCm()) ;
 		}else {
 			e.printStackTrace();
			return ResultVO.error(CodeMsg.SERVER_ERROR) ;
		}
	}
	
}
