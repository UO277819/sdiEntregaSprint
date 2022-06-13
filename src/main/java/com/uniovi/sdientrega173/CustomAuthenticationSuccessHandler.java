package com.uniovi.sdientrega173;

import com.uniovi.sdientrega173.services.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    LogsService logsService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logsService.loginLog(authentication.getName());
        response.sendRedirect("/user/list");
    }
}