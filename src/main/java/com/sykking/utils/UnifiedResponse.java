package com.sykking.utils;

/**
 * 统一响应前端信息
 */
public class UnifiedResponse {
    private Integer code;
    private String message;
    private Object object;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public UnifiedResponse(Integer code, String message, Object object) {
        this.code = code;
        this.message = message;
        this.object = object;
    }
}
