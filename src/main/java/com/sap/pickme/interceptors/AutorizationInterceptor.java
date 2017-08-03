package com.sap.pickme.interceptors;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class AutorizationInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object controller) throws Exception {

        String uri = request.getRequestURI();
        if( uri.contains("homepage") ||
            uri.contains("resources") ||
            uri.endsWith("login") ||
            uri.endsWith("register") ||
                Objects.equals(uri, "/")){
            return true;
        }

        if(request.getSession().getAttribute("userLogged") != null) {
            return true;
        }

        response.sendRedirect("/");
        return false;
    }
}