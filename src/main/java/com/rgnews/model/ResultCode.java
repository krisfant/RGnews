package com.rgnews.model;


import lombok.Getter;

//返回码
@Getter
public enum ResultCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    FORBIDDEN(501, "没有权限执行"),
    PARAMETER_ERROR(502, "传递参数有误~"),
    UNAUTHORIZED(503, "暂未登录或token已经过期");


    private Integer code;
    private String msg;

    ResultCode (Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }



}
