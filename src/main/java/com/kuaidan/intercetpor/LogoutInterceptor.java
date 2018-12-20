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

public class LogoutInterceptor implements HandlerInterceptor {
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        String adminToken = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("kuaidanAdminToken")){
                    adminToken = cookie.getValue();
                }
            }
        }
        if(StringUtils.isBlank(adminToken)){
            adminToken=request.getParameter("kuaidanAdminToken");
        }
        Result result  = restTemplate.getForEntity("http://micro-kuaidan-zuul-server/back-sso/v1/admins/logout?token="+adminToken,Result.class).getBody();
        PrintWriter writer = response.getWriter();
        writer.write(JSON.toJSONString(result));
        writer.flush();
        writer.close();
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
