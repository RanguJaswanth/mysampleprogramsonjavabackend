package com.company.ems.filter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AuthFilter implements Filter {

    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            ((HttpServletResponse) response)
                .sendRedirect("login.jsp");
        } else {
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig filterConfig) {}
    public void destroy() {}
}
