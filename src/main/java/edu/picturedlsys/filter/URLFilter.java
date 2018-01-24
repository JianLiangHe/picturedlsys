package edu.picturedlsys.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * URL路径过滤器
 */
public class URLFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //类型转换
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;

        //获取URL
        String url = req.getParameter("url");
        PrintWriter out = resp.getWriter();
        if(url!=null&&url.length()>0){
            filterChain.doFilter(req,resp);
        }else{
            out.println("<script>alert('URL地址输入不正确!');history.back();</script>");
        }
        out.close();
        return;
    }



    @Override
    public void destroy() {

    }
}
