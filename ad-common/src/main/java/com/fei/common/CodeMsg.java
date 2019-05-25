package com.fei.common;

public class CodeMsg {

	private int code;
	private String msg;
	
	//通用异常
	public static CodeMsg SUCCESS = new CodeMsg(0, "success");
	public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
	public static CodeMsg SERVER_BIND = new CodeMsg(500100, "参数校验出错:%s");

	//用户模块 5002XX
	public static CodeMsg NO_USER_NAME = new CodeMsg(500201,"用户名为空") ;
	public static final CodeMsg USER_HAS_CREATED = new CodeMsg(500202,"用户名已经被创建");

	
	
	private CodeMsg(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public CodeMsg bindArgs(Object... objs) {
	    int code = this.code ; 
		String msg = String.format(this.msg, objs) ; 
		return new CodeMsg(code, msg) ; 
	}
	
	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
}
