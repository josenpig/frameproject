package com.xingji.frameproject.exception;



public class CustomError extends RuntimeException {
    //异常错误编码
    private int code ;
    //异常信息
    private String message;
    //异常类型
    private String codeType;

    private CustomError(){}

    public CustomError(CustomErrorType exceptionTypeEnum, String message) {
        this.code = exceptionTypeEnum.getCode();
        this.message = message;
        this.codeType=exceptionTypeEnum.getTypeDesc();
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getCodeType() {
        return codeType;
    }
}
