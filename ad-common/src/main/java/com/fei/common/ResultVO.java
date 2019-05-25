package com.fei.common;

public class ResultVO<T> {

    private int status ;

    private String msg ;

    private T data ;

    public static <T> ResultVO<T> ok(T data) {
        return new ResultVO<>(data) ;
    }


    public static ResultVO<String> error(CodeMsg codeMsg) {
        ResultVO<String> result = new ResultVO<>(codeMsg.getCode(),codeMsg.getMsg()) ;
        return  result ;
    }
    public ResultVO(T data) {
        this.status = 0;
        this.data = data;
    }

    public ResultVO(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
