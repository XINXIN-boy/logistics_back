package com.itqf.interceptor;

import com.itqf.commen.Constent;
import com.itqf.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/1011:26
 * description:
 */

public class MyInterceptor implements HandlerInterceptor {

    //进入controller方法之前调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("※※※拦截到的请求是:" + request.getRequestURI());
        //获取session
        HttpSession session = request.getSession();
        //获取session中的用户信息
        User user = (User)session.getAttribute(Constent.LOGIN_USER);
        //判断用户信息是否存在！
        if (user == null) {
            response.sendRedirect(request.getContextPath()+"/login.html");
        }
        return true;
    }

    //调用完controller之后，视图渲染之前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //页面跳转之后，整个流程执行之后，一般用于资源清理操作
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}