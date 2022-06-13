package com.uniovi.sdientrega173;

import com.uniovi.sdientrega173.services.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationFailure implements AuthenticationFailureHandler {
    @Autowired
    LogsService logsService;

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException exception)
            throws IOException, ServletException {

        logsService.loginErrorLog(request.getParameter("username"));
        response.sendRedirect("/login?error=");
    }
}