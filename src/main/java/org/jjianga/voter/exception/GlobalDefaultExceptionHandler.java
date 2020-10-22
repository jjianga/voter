package org.jjianga.voter.exception;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public HashMap<String, Object> defaultErrorHandler(HttpServletRequest request, HttpServletResponse response,Exception e) {
//        e.printStackTrace();
    	response.setStatus(500);
        return backError(4, e.getMessage());
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public HashMap<String, Object> myErrorHandler(HttpServletRequest request, HttpServletResponse response,MyException e) throws Exception {
        e.printStackTrace();
        return backError(e.getCode(), e.getMsg());
    }

    private HashMap<String, Object> backError(int code, String msg) {
        HashMap<String, Object> errorMap = new HashMap<>();
        errorMap.put("ret", code);
        errorMap.put("msg", msg);
        return errorMap;
    }
}
