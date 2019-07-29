package com.taoleg.serverweb.main.filter;

import com.taoleg.serverweb.main.common.BodyReaderHttpServletRequestWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@WebFilter(urlPatterns = "/*", filterName = "indexFilter")
public class BodyReaderFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        BodyReaderHttpServletRequestWrapper br = new BodyReaderHttpServletRequestWrapper((HttpServletRequest) request);
        chain.doFilter(br, response);
    }

    @Override
    public void destroy() {

    }
}