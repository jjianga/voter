package org.jjianga.voter.interceptor;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import org.jjianga.voter.exception.MyException;
import org.jjianga.voter.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * 状态检测拦截器
 * 这个拦截器会在AppConfiguration中调用
 */
@Component
public class StatusIntercepter implements HandlerInterceptor {
    @Autowired
    RedisUtils redisUtils;
    
    List<String> userS = null;

    //拦截判断
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse response, Object o) throws Exception {
        //向下执行的逻辑
        System.out.println("httpUrl = " + httpServletRequest.getRequestURI() +
                            "-----param = " + JSONObject.toJSONString(httpServletRequest.getParameterMap()));
        String token = httpServletRequest.getParameter("userToken");
        String updateFile = httpServletRequest.getParameter("updateFile");
        if (token == null || token.length() <= 0) throw new MyException("userToken不能为空", -1);
        if(userS == null || updateFile != null) {
        	try {
        		userS = Files.readAllLines(Paths.get("file.txt"), StandardCharsets.UTF_8);
        	}catch (Exception e) {
        		e.printStackTrace();
			}
        }
        for (int i = 0; i < userS.size(); i++) {
			if(userS.get(i).equals(token)) {
				return true; 
			}
		}
        throw new MyException("登录错误！",-1);
//        UserInfo user = redisUtils.getRedisUser(token);
//        if (user == null) {}
//            throw new MyException("登录失效",-1);
//        httpServletRequest.setAttribute("userId", "errrr");
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
    		ModelAndView modelAndView) throws Exception {
    	HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
    		throws Exception {
    	HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}
