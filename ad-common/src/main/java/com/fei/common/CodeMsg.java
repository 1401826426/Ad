package com.fei.common;

public class CodeMsg {

	private int code;
	private String msg;
	
	//通用异常
	public static CodeMsg SUCCESS = new CodeMsg(0, "success");
	public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
	public static CodeMsg SERVER_BIND = new CodeMsg(500100, "参数校验出错:%s");
	public static CodeMsg PARAMETER_ERROR = new CodeMsg(500100, "参数校验出错");

	//用户模块 5002XX
	public static CodeMsg NO_USER_NAME = new CodeMsg(500201,"用户名为空") ;
	public static CodeMsg USER_HAS_CREATED = new CodeMsg(500202,"用户名已经被创建");
	public static CodeMsg NO_USER = new CodeMsg(500203,"没登陆,请先登陆") ;
	
	//计划模块 5003XX
	public static CodeMsg NO_PLAN_NAME = new CodeMsg(500303,"广告计划名字不能为空") ;
	public static CodeMsg HAS_PLAN = new CodeMsg(500304,"已经有了用户计划") ;
	public static CodeMsg ERROR_DATE = new CodeMsg(500305,"计划时间出错") ;
	public static final CodeMsg NO_PLAN_ID = new CodeMsg(500306,"没有计划id") ;
	public static final CodeMsg NO_PLAN = new CodeMsg(500307,"没有这个计划") ;
	public static final CodeMsg HAS_NO_RULE = new CodeMsg(500308,"没有权限") ;

	//计划单元模块 5004XX
	public static final CodeMsg NO_UNIT_NAME = new CodeMsg(500401,"没有单元名字");
	public static final CodeMsg ALREADY_HAS_UNIT_NAME = new CodeMsg(500402,"单元名字已经存在");
	public static final CodeMsg EXSIST_NO_UNIT_IDS = new CodeMsg(500403,"有不存在的id");
	public static final CodeMsg EXSIST_NO_CREATIVE_IDS = new CodeMsg(500404,"有不存在的id");

	//计划单元模块 5005XX
	public static final CodeMsg HAS_CREATIVE_NAME = new CodeMsg(500503,"名字已经存在");

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
