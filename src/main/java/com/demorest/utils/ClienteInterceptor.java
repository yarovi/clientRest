/*
 * Copyright (c) 2021. Inditex
 */

package com.demorest.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yrosadov
 */


@Component
public class ClienteInterceptor implements HandlerInterceptor {

    final Logger log = LoggerFactory.getLogger(ClienteInterceptor.class);


    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
            throws Exception {
        this.log.info("ClienteInterceptor ..!");

        boolean flag = true;
        final String method = request.getMethod();
        // int contentLenght = request.getContentLength();

        if (method.equalsIgnoreCase("post") || method.equalsIgnoreCase("put")) {
            final String contentType = request.getContentType();
            if ((contentType != null) && !contentType.equalsIgnoreCase(("application/json"))) {
                flag = false;
            }
            /*
             * else if(contentLenght<=2) { flag=false; }
             */
        }
        if (!flag) {
            response.sendRedirect("/invalid");
        }

        // TODO Auto-generated method stub
        return flag;
    }

}
