package com.kuaidan.intercetpor;


import com.alibaba.fastjson.JSON;
import com.kuaidan.utils.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        String token = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("kuaidanAdminToken")){
                    token = cookie.getValue();
                }
            }
        }
        if(StringUtils.isBlank(token)){
            token=request.getParameter("kuaidanAdminToken");
        }

		if(StringUtils.isNotBlank(token)){
			Result result  = restTemplate.getForEntity("http://micro-kuaidan-zuul-server/back-sso/v1/admins/token-check?token="+token,Result.class).getBody();
			if("0".equals(result.getCode())){
				return true;
			}else{
				PrintWriter writer = response.getWriter();
				writer.write(JSON.toJSONString(result));
				writer.flush();
				writer.close();
				return false;
			}
		}else{
			Result result = new Result();
			result.setMsg("未登录");
			result.setCode("-998");
			PrintWriter writer = response.getWriter();
			writer.write(JSON.toJSONString(result));
			writer.flush();
			writer.close();
			return false;
		}
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}
