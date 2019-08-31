package com.what2e.eatwhat.entity;

/**
 * @author lumike
 * @version v1.0
 * @title RequestResult
 * @date 19-5-4 下午7:35
 * @Description 请求接口的返回类
 **/
public class ResponseResult {
    private String success; //调用成功为1否则为0
    private String code; //1000：成功 1001：参数不能为空 1002：查无数据 1003：系统异常
    private String msg;
    private Object result;

    public ResponseResult(String code,String msg,Object result) {
        this.success = "1";
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public ResponseResult(String success,String code,String msg,Object result) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public ResponseResult() {
        this.success = "1";
        this.code = "1001";
        this.msg = "";
        this.result = null;
    }

    public ResponseResult(String msg, Object result) {
        this.success = "1";
        this.code = "1000";
        this.msg = msg;
        this.result = result;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
