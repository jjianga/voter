package org.jjianga.voter.util;

/**
 * 数据返回   包装格式
 * @author Mails-002
 *
 * @param <T>
 */
public class BaseResultModel<T> {

    private int ret;
    private String msg;
    private T data;

    public BaseResultModel() {
        super();
    }
    /**
     * 
     * @param result 大于一万 为正确命令      小于40000为错误命令     抛弃正负 700以内的自由编码   其它为  警告提示码
     * @param data
     */
    public BaseResultModel(int result, T data) {
        this.ret = result;
        if (result > 10000) {
            this.msg = "success";
        } else if(result > -40000) {
            this.msg = "warn";
        } else {
            this.msg = "error";
        }

        this.data = data;
    }

    public BaseResultModel(int result, String msg, T data) {
        this.ret = result;
        this.msg = msg;
        this.data = data;
    }

    public BaseResultModel(T data) {
        this.data = data;
        this.ret = 1;
        this.msg = "success";
    }

    public int getRet() {
        return ret;
    }

    public BaseResultModel setRet(int result) {
        this.ret = result;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public BaseResultModel setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public BaseResultModel setData(T data) {
        this.data = data;
        return this;
    }
}
