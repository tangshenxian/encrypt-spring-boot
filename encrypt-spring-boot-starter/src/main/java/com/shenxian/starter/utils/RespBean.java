package com.shenxian.starter.utils;

/**
 * @author: shenxian
 * @date: 2022/1/19 9:49
 */
public class RespBean {

    private Integer code;
    private String message;
    private Object data;

    private RespBean() {}

    /**
     * 成功返回
     * @return
     */
    public static RespBean success() {
        RespBean respBean = new RespBean();
        respBean.setCode(200);
        respBean.setMessage("成功");
        return respBean;
    }

    /**
     * 失败返回
     * @return
     */
    public static RespBean error() {
        RespBean respBean = new RespBean();
        respBean.setCode(500);
        respBean.setMessage("失败");
        return respBean;
    }

    public RespBean code(Integer code) {
        this.code = code;
        return this;
    }

    public RespBean message(String message) {
        this.message = message;
        return this;
    }

    public RespBean data(Object data) {
        this.data = data;
        return this;
    }

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
