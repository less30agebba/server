package com.taoleg.serverweb.main.filter;

import com.taoleg.serverweb.main.common.BodyReaderHttpServletRequestWrapper;
import org.apache.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(urlPatterns = "/*", filterName = "indexFilter")
public class BodyReaderFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        BodyReaderHttpServletRequestWrapper br = new BodyReaderHttpServletRequestWrapper((HttpServletRequest) request);
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        //允许请求方式
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        //用来指定本次预检请求的有效期，单位为秒，在此期间不用发出另一条预检请求
        response.setHeader("Access-Control-Max-Age", "3600");
        //请求包含的字段内容，如有多个可用哪个逗号分隔如下
        response.setHeader("Access-Control-Allow-Headers", "content-type,x-requested-with,Authorization, x-ui-request,lang");
        //访问控制允许凭据，true为允许
        response.setHeader("Access-Control-Allow-Credentials", "true");
        // 浏览器是会先发一次options请求，如果请求通过，则继续发送正式的post请求
        // 配置options的请求返回
        if (((HttpServletRequest) request).getMethod().equals("OPTIONS")) {
            response.setStatus(HttpStatus.SC_OK);
            response.getWriter().write("OPTIONS returns OK");
            return;
        }
        chain.doFilter(br, response);
    }

    @Override
    public void destroy() {

    }
}