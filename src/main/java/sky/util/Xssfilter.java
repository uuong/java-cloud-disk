package sky.util;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * xss sql 注入防范
 * User: krny
 * Date: 2017/2/26 0026
 * Time: 15:40
 * To change this template use File | Settings | File Templates.
 */
public class Xssfilter implements Filter {
    private FilterConfig filterConfig = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        new XssWrapper((HttpServletRequest) servletRequest);
        filterChain.doFilter(new XssWrapper((HttpServletRequest) servletRequest), servletResponse);
    }

    public void destroy() {
        this.filterConfig = null;
    }
}
