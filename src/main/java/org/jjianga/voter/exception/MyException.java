package org.jjianga.voter.exception;

import org.slf4j.LoggerFactory;

public class MyException extends Exception {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int code;
    private String msg;

    public MyException(String message, int code) {
        super(message);
        this.code = code;
        this.msg = message;
        LoggerFactory.getLogger(this.getClass()).debug(message);
    }

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
}
