package com.kuaidan.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Result implements Serializable{
    private static final long serialVersionUID = 1083943599624728971L;

    private String code;

    private String msg;

    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
    public Result() {
    }

    public Result(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public Result(BindingResult bindingResult) {
        List<String> list = new ArrayList<>();
        List<FieldError> err = bindingResult.getFieldErrors();
        for (FieldError fe:err) {
            list.add(fe.getDefaultMessage());
        }
        this.code = "-600";
        this.msg = list.toString();
    }
}
