package com.itqf.commen;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/516:26
 * description:
 */
public class JsonMessage {

    private int code  ;
    private String msg ;
    private long count ;
    private Object data ;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
