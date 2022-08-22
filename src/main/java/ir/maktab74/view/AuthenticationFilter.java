package ir.maktab74.view;

import ir.maktab74.model.User;
import ir.maktab74.util.ApplicationContext;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "auth-filter", urlPatterns = "*.system")
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        if (session!=null){
            filterChain.doFilter(request,response);
        }else {
            response.setContentType("text/html");
            PrintWriter printWriter=response.getWriter();
            printWriter.println("<h1 style=\"background-color: gray\">You didn\'t login before.Please login</h1>");
        }
    }

    @Override
    public void destroy() {

    }
}
