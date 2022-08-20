package ir.maktab74.view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "login-servlet" , urlPatterns = "/login-servlet")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html><head>" +
                "<link rel=\"styleSheet\" href=\"style.css\" type=\"text/css\"> " +
                "</head></html>");
        out.println("<body>\n" +
                "<div id=\"login-div\">\n" +
                "\n" +
                "    <form action=\"/auth-filter\" id=\"login-form\">\n" +
                "        <h1 id=\"login-form-title\">صفحه ورود کاربر</h1>\n" +
                "        <input type=\"text\" name=\"username\" placeholder=\"نام کاربری\" class=\"box\"><br>\n" +
                "        <input type=\"password\" name=\"password\" placeholder=\"گذرواژه\" class=\"box\"><br><br>\n" +
                "        <input type=\"submit\" value=\"ورود\" class=\"botton\"><br><br>\n" +
                "        <a href=\"google.com\" id=\"register\">ثبت نام</a>\n" +
                "    </form>\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "</body>>");
    }
}
